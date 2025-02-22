import java.util.ArrayList;
import java.util.List;

public class Dryland {

    private String muscleWorked;
    private String date;
    private String startTime;
    private String endTime;
    private String location;
    private String workoutGoal;
    private String[] warmUp;
    private String[] mainSet;
    private String[] coolDown;
    private String howYouFelt;

    // Constructor
    public Dryland(String muscleWorked, String date, String startTime, String endTime, String location, 
                   String workoutGoal, String[] warmUp, String[] mainSet, String[] coolDown, String howYouFelt) {
        this.muscleWorked = muscleWorked;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.workoutGoal = workoutGoal;
        this.warmUp = warmUp;
        this.mainSet = mainSet;
        this.coolDown = coolDown;
        this.howYouFelt = howYouFelt;
    }

    public String getMuscleWorked() {
        return muscleWorked;
    }
    public String[] getMainSet()
    {
      return this.mainSet;
    }

    public String getDate() {
        return this.date;
    }

    // Method to filter workouts by muscle group
    public static List<Dryland> filterByMuscleGroup(List<Dryland> workouts, String targetMuscle) {
      List<Dryland> filteredWorkouts = new ArrayList<>();
      for (Dryland workout : workouts) {
          System.out.println("Checking workout with muscle group: " + workout.getMuscleWorked());
          if (workout.getMuscleWorked().equalsIgnoreCase(targetMuscle)) {
              filteredWorkouts.add(workout);
          }
      }
      return filteredWorkouts;
  }
    
    public static StringBuilder getDrylands(ArrayList<Dryland> drylands) {
      if (drylands.isEmpty()) {
          throw new IllegalArgumentException("No Dryland workouts found");
      }

      // Use a StringBuilder to aggregate all the `printLift` results
      StringBuilder result = new StringBuilder();
      for (Dryland dryland : drylands) {
          result.append(dryland.printLift()).append("\n\n"); // Append each `printLift` with spacing
      }

      return result;
  }

    public StringBuilder printLift() {
      StringBuilder string = new StringBuilder();
      string.append("Date: ").append(this.date).append("\n");
      string.append("Warm-Up: ").append(java.util.Arrays.toString(this.warmUp)).append("\n");
      string.append("Main Set: ").append(java.util.Arrays.toString(this.mainSet)).append("\n");
      string.append("Cool Down: ").append(java.util.Arrays.toString(this.coolDown));
      return string;
  }


    
}
