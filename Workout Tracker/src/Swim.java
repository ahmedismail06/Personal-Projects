import java.util.ArrayList;
import java.util.List;

public class Swim {
  private String date;
  private String startTime;
  private String endTime;
  private String location;
  private String workoutGoal;
  private String[] warmUp;
  private String[] mainSet;
  private String[] coolDown;
  private String howYouFelt;
  private int totalDistance; // in meters
  private String color; // Color property to filter swims

  public Swim(String date, String startTime, String endTime, String location, String[] warmup,
      String[] mainSet, String[] coolDown, String feeling, int totalDistance, String goal,
      String color) {
    this.date = date;
    this.startTime = startTime;
    this.endTime = endTime;
    this.location = location;
    this.warmUp = warmup;
    this.mainSet = mainSet;
    this.coolDown = coolDown;
    this.howYouFelt = feeling;
    this.totalDistance = totalDistance;
    this.workoutGoal = goal;
    this.color = color; // Assign color
  }

  public String getColor() {
    return color;
  }

  public String getDate() {
    return this.date;
  }

  public String[] getMainSet() {
    return this.mainSet;
  }



  // Method to filter swims by color
  public static List<Swim> filterByColor(List<Swim> swims, String targetColor) {
    List<Swim> filteredSwims = new ArrayList<>();
    for (Swim swim : swims) {
      if (swim.getColor().equalsIgnoreCase(targetColor)) {
        filteredSwims.add(swim);
      }
    }
    return filteredSwims;
  }

  public static StringBuilder getSwims(ArrayList<Swim> swims) {
    if (swims.isEmpty()) {
      throw new IllegalArgumentException("No swim workouts found");
    }

    // Aggregate all Swim workouts into a single StringBuilder
    StringBuilder result = new StringBuilder();
    for (Swim swim : swims) {
      result.append(swim.printSwim()).append("\n\n"); // Append each workout with spacing
    }

    return result;
  }

  public StringBuilder printSwim() {
    StringBuilder string = new StringBuilder();
    string.append("Warm-Up: ").append(java.util.Arrays.toString(this.warmUp)).append("\n");
    string.append("Main Set: ").append(java.util.Arrays.toString(this.mainSet)).append("\n");
    string.append("Cool Down: ").append(java.util.Arrays.toString(this.coolDown)).append("\n");
    string.append("Total Distance: ").append(this.totalDistance).append(" meters");
    return string;
}


}


