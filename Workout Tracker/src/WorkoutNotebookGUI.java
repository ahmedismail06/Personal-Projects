import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class WorkoutNotebookGUI extends JFrame {
    private Swimmer swimmer;
    private JTextField nameField, ageField;
    private JTabbedPane mainTabbedPane;
    private JPanel swimWorkoutPanel, drylandWorkoutPanel, eventsPanel;

    public WorkoutNotebookGUI() {
        setTitle("Workout Notebook");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initial profile creation dialog
        createProfileDialog();
    }

    private void createProfileDialog() {
        JDialog profileDialog = new JDialog(this, "Create Profile", true);
        profileDialog.setLayout(new GridLayout(4, 2, 10, 10));
        profileDialog.setSize(300, 200);
        profileDialog.setLocationRelativeTo(this);

        profileDialog.add(new JLabel("Name:"));
        nameField = new JTextField();
        profileDialog.add(nameField);

        profileDialog.add(new JLabel("Age:"));
        ageField = new JTextField();
        profileDialog.add(ageField);

        JButton createProfileButton = new JButton("Create Profile");
        createProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText().trim();
                    int age = Integer.parseInt(ageField.getText().trim());
                    
                    if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(profileDialog, 
                            "Please enter a name", 
                            "Invalid Input", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    swimmer = new Swimmer(name, age);
                    profileDialog.dispose();
                    initializeMainGUI();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(profileDialog, 
                        "Please enter a valid age", 
                        "Invalid Input", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        profileDialog.add(createProfileButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> System.exit(0));
        profileDialog.add(cancelButton);

        profileDialog.setVisible(true);
    }

    private void initializeMainGUI() {
        mainTabbedPane = new JTabbedPane();

        // Swim Workout Panel
        swimWorkoutPanel = createSwimWorkoutPanel();
        mainTabbedPane.addTab("Swim Workout", swimWorkoutPanel);

        // Dryland Workout Panel
        drylandWorkoutPanel = createDrylandWorkoutPanel();
        mainTabbedPane.addTab("Dryland Workout", drylandWorkoutPanel);

        // Events Panel
        eventsPanel = createEventsPanel();
        mainTabbedPane.addTab("Events", eventsPanel);

        add(mainTabbedPane);
        setVisible(true);
    }

    private JPanel createSwimWorkoutPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        
        // Date input
        panel.add(new JLabel("Date (MM/DD/YYYY):"));
        JTextField dateField = new JTextField();
        panel.add(dateField);

        // Start Time
        panel.add(new JLabel("Start Time:"));
        JTextField startTimeField = new JTextField();
        panel.add(startTimeField);

        // End Time
        panel.add(new JLabel("End Time:"));
        JTextField endTimeField = new JTextField();
        panel.add(endTimeField);

        // Location
        panel.add(new JLabel("Location:"));
        JTextField locationField = new JTextField();
        panel.add(locationField);

        // Warm-up Set
        panel.add(new JLabel("Warm-up Set (comma-separated):"));
        JTextField warmUpField = new JTextField();
        panel.add(warmUpField);

        // Main Set
        panel.add(new JLabel("Main Set (comma-separated):"));
        JTextField mainSetField = new JTextField();
        panel.add(mainSetField);

        // Cool Down
        panel.add(new JLabel("Cool-down Set (comma-separated):"));
        JTextField coolDownField = new JTextField();
        panel.add(coolDownField);

        // Feeling
        panel.add(new JLabel("How did you feel?"));
        JTextField feelingField = new JTextField();
        panel.add(feelingField);

        // Total Distance
        panel.add(new JLabel("Total Distance (meters):"));
        JTextField distanceField = new JTextField();
        panel.add(distanceField);

        // Workout Goal
        panel.add(new JLabel("Workout Goal:"));
        JTextField goalField = new JTextField();
        panel.add(goalField);

        // Color
        panel.add(new JLabel("Workout Color:"));
        JTextField colorField = new JTextField();
        panel.add(colorField);

        // Record Swim Workout Button
        JButton recordSwimButton = new JButton("Record Swim Workout");
        recordSwimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    swimmer.recordSwim(
                        dateField.getText(), 
                        startTimeField.getText(), 
                        endTimeField.getText(), 
                        locationField.getText(), 
                        warmUpField.getText().split(","), 
                        mainSetField.getText().split(","), 
                        coolDownField.getText().split(","), 
                        feelingField.getText(), 
                        Integer.parseInt(distanceField.getText()), 
                        goalField.getText(), 
                        colorField.getText()
                    );
                    JOptionPane.showMessageDialog(panel, "Swim Workout Recorded Successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, 
                        "Error Recording Swim Workout: " + ex.getMessage(), 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(recordSwimButton);

        return panel;
    }

    private JPanel createDrylandWorkoutPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        
        // Muscle Group
        panel.add(new JLabel("Muscle Group:"));
        JTextField muscleGroupField = new JTextField();
        panel.add(muscleGroupField);

        // Date input
        panel.add(new JLabel("Date (MM/DD/YYYY):"));
        JTextField dateField = new JTextField();
        panel.add(dateField);

        // Start Time
        panel.add(new JLabel("Start Time:"));
        JTextField startTimeField = new JTextField();
        panel.add(startTimeField);

        // End Time
        panel.add(new JLabel("End Time:"));
        JTextField endTimeField = new JTextField();
        panel.add(endTimeField);

        // Location
        panel.add(new JLabel("Location:"));
        JTextField locationField = new JTextField();
        panel.add(locationField);

        // Workout Goal
        panel.add(new JLabel("Workout Goal:"));
        JTextField goalField = new JTextField();
        panel.add(goalField);

        // Warm-up Set
        panel.add(new JLabel("Warm-up Set (comma-separated):"));
        JTextField warmUpField = new JTextField();
        panel.add(warmUpField);

        // Main Set
        panel.add(new JLabel("Main Set (comma-separated):"));
        JTextField mainSetField = new JTextField();
        panel.add(mainSetField);

        // Cool Down
        panel.add(new JLabel("Cool-down Set (comma-separated):"));
        JTextField coolDownField = new JTextField();
        panel.add(coolDownField);

        // Feeling
        panel.add(new JLabel("How did you feel?"));
        JTextField feelingField = new JTextField();
        panel.add(feelingField);

        // Record Dryland Workout Button
        JButton recordDrylandButton = new JButton("Record Dryland Workout");
        recordDrylandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    swimmer.recordDryland(
                        muscleGroupField.getText(),
                        dateField.getText(), 
                        startTimeField.getText(), 
                        endTimeField.getText(), 
                        locationField.getText(), 
                        goalField.getText(),
                        warmUpField.getText().split(","), 
                        mainSetField.getText().split(","), 
                        coolDownField.getText().split(","), 
                        feelingField.getText()
                    );
                    JOptionPane.showMessageDialog(panel, "Dryland Workout Recorded Successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, 
                        "Error Recording Dryland Workout: " + ex.getMessage(), 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(recordDrylandButton);

        return panel;
    }

    private JPanel createEventsPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        
        // Add Event Section
        panel.add(new JLabel("Event Name:"));
        JTextField eventNameField = new JTextField();
        panel.add(eventNameField);

        panel.add(new JLabel("Best Time:"));
        JTextField bestTimeField = new JTextField();
        panel.add(bestTimeField);

        JButton addEventButton = new JButton("Add Event");
        addEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    swimmer.addEvents(
                        eventNameField.getText(), 
                        bestTimeField.getText()
                    );
                    JOptionPane.showMessageDialog(panel, "Event Added Successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, 
                        "Error Adding Event: " + ex.getMessage(), 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(addEventButton);

        // Update Event Section
        panel.add(new JLabel("Update Event Name:"));
        JTextField updateEventNameField = new JTextField();
        panel.add(updateEventNameField);

        panel.add(new JLabel("New Best Time:"));
        JTextField newTimeField = new JTextField();
        panel.add(newTimeField);

        JButton updateTimeButton = new JButton("Update Best Time");
        updateTimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    swimmer.updateTime(
                        updateEventNameField.getText(), 
                        newTimeField.getText()
                    );
                    JOptionPane.showMessageDialog(panel, "Best Time Updated Successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, 
                        "Error Updating Time: " + ex.getMessage(), 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(updateTimeButton);

        // View Events Button
        JButton viewEventsButton = new JButton("View All Events");
        viewEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (swimmer.getEvents().isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "No events available.");
                } else {
                    StringBuilder eventsList = new StringBuilder();
                    for (Events event : swimmer.getEvents()) {
                        eventsList.append(event.getEvent())
                                  .append(" (Best Time: ")
                                  .append(event.getTime())
                                  .append(")\n");
                    }
                    JOptionPane.showMessageDialog(panel, eventsList.toString(), "Events", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        panel.add(viewEventsButton);

        return panel;
    }

    public static void main(String[] args) {
        // Use SwingUtilities to ensure thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WorkoutNotebookGUI();
            }
        });
    }
}