import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Swimmer {
  private String name;
  private int age;
  private ArrayList<Events> events;
  private ArrayList<Swim> swims;
  private ArrayList<Dryland> dryland;

  public Swimmer(String name, int age) {
    this.name = name;
    this.age = age;
    this.events = new ArrayList<>();
    this.swims = new ArrayList<>();
    this.dryland = new ArrayList<>();
  }

  public void addEvents(String name, String time) {
    for (Events eve : events) {
      if (eve.getEvent().equalsIgnoreCase(name)) {
        throw new IllegalArgumentException("Event already exists for the swimmer: " + name);
      }
    }
    events.add(new Events(name, time));
  }

  public void updateTime(String name, String newTime) {
    for (Events event : events) {
      if (event.getEvent().equals(name)) {
        if (event.getTime().equals(newTime)) {
          throw new IllegalArgumentException("Your best time is the same");
        } else {
          event.updateTime(newTime);
          break;
        }
      } else {
        throw new IllegalArgumentException("Event not found");
      }
    }
  }

  public void recordSwim(String date, String startTime, String endTime, String location,
      String[] warmup, String[] mainSet, String[] coolDown, String feeling, int totalDistance,
      String goal, String color) {
    // Check if a swim already exists for this date
    boolean swimExists = false;
    for (Swim swim : swims) {
      if (swim.getDate().equals(date)) {
        swimExists = true;
        break;
      }
    }

    if (swimExists) {
      System.out.println("A swim workout is already recorded on " + date + ".");
      System.out.println("Do you want to add another workout for this day? (yes/no):");

      Scanner scanner = new Scanner(System.in);
      String response = scanner.nextLine().trim().toLowerCase();

      if (response.equals("yes")) {
        swims.add(new Swim(date, startTime, endTime, location, warmup, mainSet, coolDown, feeling,
            totalDistance, goal, color));
        System.out.println("Additional swim workout added for " + date + ".");
      } else {
        System.out.println("No additional workout added for " + date + ".");
      }
      scanner.close();
    } else {
      swims.add(new Swim(date, startTime, endTime, location, warmup, mainSet, coolDown, feeling,
          totalDistance, goal, color));
      System.out.println("Swim workout recorded for " + date + ".");
    }
  }

  public void displaySwimsByColor(String color) {
    List<Swim> filteredSwims = Swim.filterByColor(swims, color);
    System.out.println("Swims with color " + color + ":");
    for (Swim swim : filteredSwims) {
      System.out.println("Logged on: " + swim.getDate());
      System.out.println("Main set: " + java.util.Arrays.toString(swim.getMainSet()));
    }
  }


  public void recordDryland(String muscleWorked, String date, String startTime, String endTime,
      String location, String workoutGoal, String[] warmUp, String[] mainSet, String[] coolDown,
      String howYouFelt) {
    boolean exists = false;
    for (Dryland work : dryland) {
      if (work.getDate().equals(date)) {
        exists = true;
        break;
      }
    }

    if (exists) {
      System.out.println("A dryland workout is already recorded on " + date + ".");
    } else {
      Dryland newWorkout = new Dryland(muscleWorked, date, startTime, endTime, location,
          workoutGoal, warmUp, mainSet, coolDown, howYouFelt);
      dryland.add(newWorkout);
      System.out.println("Dryland workout recorded for " + date + ": " + muscleWorked);
    }
  }


  public void displayWorkoutsByMuscleGroup(String muscleGroup) {
    List<Dryland> filteredWorkouts = Dryland.filterByMuscleGroup(dryland, muscleGroup);
    if (filteredWorkouts.isEmpty()) {
      System.out.println("No dryland workouts found targeting " + muscleGroup + ".");
    } else {
      System.out.println("Dryland workouts targeting " + muscleGroup + ":");
      for (Dryland workout : filteredWorkouts) {
        System.out.println("Logged on: " + workout.getDate());
        System.out.println("Main set: " + java.util.Arrays.toString(workout.getMainSet()));
      }
    }
  }

  public void remove(String date) {
    Scanner scanner = new Scanner(System.in);
    boolean found = false;

    Iterator<Swim> swimIterator = swims.iterator();
    while (swimIterator.hasNext()) {
      Swim swim = swimIterator.next();
      if (swim.getDate().equals(date)) {
        found = true;
        System.out.println("Would you like to delete this swim workout on this date?"
            + swim.printSwim() + "(yes/no)");
        String response = scanner.nextLine().trim().toLowerCase();
        if (response.equalsIgnoreCase("yes")) {
          swims.remove(swim);

        } else {
          System.out.println("Swim workout was not deleted");
        }
      }
    }

    Iterator<Dryland> workoutIterator = dryland.iterator();
    while (workoutIterator.hasNext()) {
      Dryland workout = workoutIterator.next();
      if (workout.getDate().equals(date)) {
        found = true;
        System.out.println("Would you like to delete this swim workout on this date? "
            + workout.printLift() + "(yes/no)");
        String response = scanner.nextLine().trim().toLowerCase();

        if (response.equalsIgnoreCase("yes")) {
          dryland.remove(workout);
          System.out.println("Work out removed");
        } else {
          System.out.println("Dryland workout was not deleted");
        }
      }
    }
    scanner.close();
    
    if(!found)
    {
      System.out.println("No workouts were found for this date: " + date);
    }
  }
  
  public void all(String type)
  {
    if(type.equalsIgnoreCase("Swim"))
    {
      System.out.println(Swim.getSwims(swims).toString());
    }
    else if(type.equalsIgnoreCase("Dryland"))
    {
      System.out.println(Dryland.getDrylands(dryland).toString());
    }
  }
  

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("Swimmer Details:\n");
    result.append("Name: ").append(name).append("\n");
    result.append("Age: ").append(age).append("\n");
    

    result.append("Events:\n");
    if (events.isEmpty()) {
      result.append("  None\n");
    } else {
      for (Events event : events) {
        result.append("  - ").append(event.getEvent()).append(" (Best Time: ")
            .append(event.getTime()).append(")\n");
      }
    }
    return result.toString();
  }

  public ArrayList<Events> getEvents() {
    return events;
  }

}
