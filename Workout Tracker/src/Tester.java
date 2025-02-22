import java.util.Scanner;

public class Tester {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Welcome message
    System.out.println("=====================================");
    System.out.println("       Welcome to Workout Notebook   ");
    System.out.println("=====================================\n");
    System.out.println("💪 Get ready to track your workouts and improve your performance!");
    System.out.print("👉 Type 'C' to create a profile and get started: ");
    String response = scanner.nextLine().trim();

    Swimmer swimmer = null;

    // Profile creation
    if (response.equalsIgnoreCase("C")) {
      System.out.println("\n🎉 Let's create your profile!");
      System.out.print("📝 What's your name? ");
      String name = scanner.nextLine().trim();

      System.out.print("🗓️ How old are you? ");
      int age = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      swimmer = new Swimmer(name, age);

      System.out.println("\n✅ Profile created successfully!");
      System.out.println("=====================================\n");
    } else {
      System.out.println("\n👋 Thanks for stopping by. See you next time!");
      scanner.close();
      return;
    }

    // Main menu loop
    while (true) {
      System.out.println("=====================================");
      System.out.println("           Main Menu Options         ");
      System.out.println("=====================================");
      System.out.println("A) Record a swim workout 🏊‍♂️");
      System.out.println("B) Record a dryland workout 🏋️‍♂️");
      System.out.println("C) Record a new best time 🕒");
      System.out.println("D) Add a new event 🎯");
      System.out.println("E) Delete a workout ❌");
      System.out.println("F) Display workouts 📋");
      System.out.println("G) View all user data 📊");
      System.out.println("H) View all events 🗂️");
      System.out.println("I) View all workouts");
      System.out.println("J) Exit 🚪");
      System.out.print("👉 Select an option: ");
      response = scanner.nextLine().trim();

      switch (response.toUpperCase()) {
        case "A":
          System.out.println("\n🏊‍♂️ Recording a Swim Workout:");
          System.out.print("📅 Enter the date (MM/DD/YYYY): ");
          String date = scanner.nextLine().trim();
          System.out.print("⏰ Enter the start time (e.g., 5:00 PM): ");
          String startTime = scanner.nextLine().trim();
          System.out.print("⏰ Enter the end time (e.g., 6:00 PM): ");
          String endTime = scanner.nextLine().trim();
          System.out.print("📍 Enter the location: ");
          String location = scanner.nextLine().trim();
          System.out.print("🏋️ Warm-up set (comma-separated): ");
          String[] warmUp = scanner.nextLine().trim().split(",");
          System.out.print("🔥 Main set (comma-separated): ");
          String[] mainSet = scanner.nextLine().trim().split(",");
          System.out.print("🧘 Cool-down set (comma-separated): ");
          String[] coolDown = scanner.nextLine().trim().split(",");
          System.out.print("😊 How did you feel? ");
          String feeling = scanner.nextLine().trim();
          System.out.print("📏 Enter total distance (in meters): ");
          int totalDistance = scanner.nextInt();
          scanner.nextLine(); // Consume newline
          System.out.print("🎯 Enter workout goal: ");
          String goal = scanner.nextLine().trim();
          System.out.print("🎨 Enter workout color: ");
          String color = scanner.nextLine().trim();

          swimmer.recordSwim(date, startTime, endTime, location, warmUp, mainSet, coolDown, feeling,
              totalDistance, goal, color);
          System.out.println("\n✅ Swim workout recorded successfully!");
          break;

        case "B":
          System.out.println("\n🏋️‍♂️ Recording a Dryland Workout:");
          System.out.print("💪 Enter the muscle group worked: ");
          String muscleGroup = scanner.nextLine().trim();
          System.out.print("📅 Enter the date (MM/DD/YYYY): ");
          date = scanner.nextLine().trim();
          System.out.print("⏰ Enter the start time: ");
          startTime = scanner.nextLine().trim();
          System.out.print("⏰ Enter the end time: ");
          endTime = scanner.nextLine().trim();
          System.out.print("📍 Enter the location: ");
          location = scanner.nextLine().trim();
          System.out.print("🎯 Enter the workout goal: ");
          goal = scanner.nextLine().trim();
          System.out.print("🏋️ Warm-up set (comma-separated): ");
          warmUp = scanner.nextLine().trim().split(",");
          System.out.print("🔥 Main set (comma-separated): ");
          mainSet = scanner.nextLine().trim().split(",");
          System.out.print("🧘 Cool-down set (comma-separated): ");
          coolDown = scanner.nextLine().trim().split(",");
          System.out.print("😊 How did you feel? ");
          feeling = scanner.nextLine().trim();

          swimmer.recordDryland(muscleGroup, date, startTime, endTime, location, goal, warmUp,
              mainSet, coolDown, feeling);
          System.out.println("\n✅ Dryland workout recorded successfully!");
          break;

        case "C":
          System.out.println("\n🕒 Updating Best Time:");
          System.out.print("🏁 Enter the event name: ");
          String eventName = scanner.nextLine().trim();
          System.out.print("⏱️ Enter the new best time: ");
          String newTime = scanner.nextLine().trim();

          try {
            swimmer.updateTime(eventName, newTime);
            System.out.println("\n✅ Best time updated successfully!");
          } catch (IllegalArgumentException e) {
            System.out.println("\n❌ Error: " + e.getMessage());
          }
          break;

        case "D":
          System.out.println("\n🎯 Adding a New Event:");
          System.out.print("🏁 Enter the event name: ");
          eventName = scanner.nextLine().trim();
          System.out.print("⏱️ Enter the best time: ");
          String bestTime = scanner.nextLine().trim();

          try {
            swimmer.addEvents(eventName, bestTime);
            System.out.println("\n✅ Event added successfully!");
          } catch (IllegalArgumentException e) {
            System.out.println("\n❌ Error: " + e.getMessage());
          }
          break;

        case "E":
          System.out.println("\n❌ Deleting a Workout:");
          System.out.print("📅 Enter the date of the workout to delete: ");
          date = scanner.nextLine().trim();
          swimmer.remove(date);
          System.out.println("\n✅ Workout deleted successfully!");
          break;

        case "F":
          System.out.println("\n📋 Displaying Workouts:");
          System.out.print("👉 Type 'swim' for swim workouts or 'dryland' for dryland workouts: ");
          String type = scanner.nextLine().trim();
          if (type.equalsIgnoreCase("swim")) {
            System.out.print("🎨 Enter workout color to filter by (or leave blank for all): ");
            color = scanner.nextLine().trim();
            swimmer.displaySwimsByColor(color.isEmpty() ? "" : color);
          } else if (type.equalsIgnoreCase("dryland")) {
            System.out.print("💪 Enter muscle group to filter by (or leave blank for all): ");
            muscleGroup = scanner.nextLine().trim();
            swimmer.displayWorkoutsByMuscleGroup(muscleGroup.isEmpty() ? "" : muscleGroup);
          } else {
            System.out.println("❌ Invalid option.");
          }
          break;

        case "G":
          System.out.println("\n📊 User Data:");
          System.out.println(swimmer.toString());
          break;

        case "H":
          System.out.println("\n🗂️ Events:");
          if (swimmer.getEvents().isEmpty()) {
            System.out.println("  None available.");
          } else {
            for (Events event : swimmer.getEvents()) {
              System.out
                  .println("  - " + event.getEvent() + " (Best Time: " + event.getTime() + ")");
            }
          }
          break;
        case "I":
          System.out.println("Please select Swim or Dryland");
          String type1 = scanner.nextLine();
          try {
          swimmer.all(type1);
          }
          catch(IllegalArgumentException e )
          {
            System.out.println(e.getMessage());
          }
          break;

        case "J":
          System.out.println("\n👋 Thank you for using Workout Notebook. See you next time!");
          scanner.close();
          return;

        default:
          System.out.println("\n❌ Invalid option. Please try again.");
      }
    }
  }
}
