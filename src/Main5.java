

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Main5 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel genderLabel;

    private JComboBox<String> genderComboBox;
    private JTextField firstNameField, lastNameField, dobField, genderField, addressField, gradeField;
    private JComboBox<String> courseComboBox;
    private JComboBox<String> courseComboBox1;
    private JButton addButton, assignButton, viewButton, addGradeButton, deleteButton, viewCoursesButton, clearButton;
    private Connection connection;
    private GridBagConstraints constraints_5;
    private JTabbedPane tabbedPane;
    private JPanel panel_1;
    private JPanel panel_2;

    public Main5() {
        courseComboBox = new JComboBox<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/school_db", "root", "");
            if (connection != null) {
                System.out.println("Η σύνδεση στη βάση δεδομένων ήταν επιτυχής!");
            } else {
                System.out.println("Η σύνδεση στη βάση δεδομένων απέτυχε.");
            }
            loadCourses();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        setTitle("School Management System");
        setSize(980, 1115);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        
        panel.setLayout(null);

        getContentPane().add(panel);
        
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 0, 869, 1061);
        panel.add(tabbedPane);
        
        panel_1 = new JPanel();
        panel_1.setForeground(Color.WHITE);
        panel_1.setBackground(Color.GRAY);
        tabbedPane.addTab("Add student", null, panel_1, "");
        tabbedPane.setBackgroundAt(0, Color.BLACK);
        tabbedPane.setForegroundAt(0, Color.RED);
        panel_1.setLayout(null);
        
                JLabel firstNameLabel = new JLabel("First Name:");
                firstNameLabel.setBounds(66, 220, 87, 19);
                panel_1.add(firstNameLabel);
                firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
                
                        firstNameField = new JTextField(20);
                        firstNameField.setBounds(206, 221, 166, 20);
                        panel_1.add(firstNameField);
                        
                                JLabel lastNameLabel = new JLabel("Last Name:");
                                lastNameLabel.setBounds(66, 271, 84, 19);
                                panel_1.add(lastNameLabel);
                                lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
                                
                                        lastNameField = new JTextField(20);
                                        lastNameField.setBounds(206, 272, 166, 20);
                                        panel_1.add(lastNameField);
                                        
                                        JLabel dobLabel = new JLabel("Date of Birth:");
                                        dobLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
                                        dobLabel.setBounds(66, 310, 100, 19); // Adjust the position as needed
                                        panel_1.add(dobLabel);

                                        dobField = new JTextField(20);
                                        dobField.setBounds(206, 311, 166, 20); // Adjust the position as needed
                                        panel_1.add(dobField);


                                                    
                                                        genderLabel = new JLabel("Gender:");
                                                        genderLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
                                                        genderLabel.setBounds(66, 360, 59, 19);
                                                        panel_1.add(genderLabel);

                                                        String[] genderOptions = {"Male", "Female"};
                                                        genderComboBox = new JComboBox<>(genderOptions);
                                                        genderComboBox.setPreferredSize(new Dimension(200, 20));
                                                        genderComboBox.setBounds(206, 361, 166, 20);
                                                        panel_1.add(genderComboBox);


                                                                        
                                                                                JLabel addressLabel = new JLabel("Address:");
                                                                                addressLabel.setBounds(66, 412, 65, 19);
                                                                                panel_1.add(addressLabel);
                                                                                addressLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
                                                                                
                                                                                        addressField = new JTextField(20);
                                                                                        addressField.setBounds(206, 411, 166, 20);
                                                                                        panel_1.add(addressField);
                                                                                        
                                                                                                addButton = new JButton("Add Student");
                                                                                                addButton.setBounds(542, 331, 166, 29);
                                                                                                panel_1.add(addButton);
                                                                                                addButton.setFont(new Font("Tahoma", Font.BOLD, 17));
                                                                                                
                                                                                                        clearButton = new JButton("Clear");
                                                                                                        clearButton.setBounds(542, 271, 94, 23);
                                                                                                        panel_1.add(clearButton);
                                                                                                        clearButton.setFont(new Font("Tahoma", Font.BOLD, 11));
                                                                                                        
                                                                                                        Label label = new Label("Add Student");
                                                                                                        label.setFont(new Font("Times New Roman", Font.BOLD, 20));
                                                                                                        label.setBounds(new Rectangle(5, 5, 5, 5));
                                                                                                        label.setForeground(Color.RED);
                                                                                                        label.setAlignment(Label.CENTER);
                                                                                                        label.setBackground(Color.GRAY);
                                                                                                        label.setBounds(311, 51, 178, 22);
                                                                                                        panel_1.add(label);
                                                                                                        
                                                                                                                clearButton.addActionListener(new ActionListener() {
                                                                                                                    @Override
                                                                                                                    public void actionPerformed(ActionEvent e) {
                                                                                                                        clearFields();
                                                                                                                    }
                                                                                                                });
                                                                                                                
                                                                                                                        addButton.addActionListener(new ActionListener() {
                                                                                                                            @Override
                                                                                                                            public void actionPerformed(ActionEvent e) {
                                                                                                                                addStudent();
                                                                                                                            }
                                                                                                                        });
                                                                                                                        
                                                                                                                        
                                                                                                                        
                                                                                                                        
                                                                                                                        
                                                                                                                        
                                                                                                                        
        
        panel_2 = new JPanel();
        panel_2.setBackground(Color.GRAY);
        panel_2.setForeground(Color.DARK_GRAY);
        tabbedPane.addTab("Manage Student", null, panel_2, null);
        tabbedPane.setBackgroundAt(1, Color.BLACK);
        tabbedPane.setForegroundAt(1, Color.BLUE);
                panel_2.setLayout(null);
        
                viewCoursesButton = new JButton("View Courses");
                viewCoursesButton.setBounds(534, 230, 131, 23);
                panel_2.add(viewCoursesButton);
                viewCoursesButton.setFont(new Font("Tahoma", Font.BOLD, 11));
                
                        viewButton = new JButton("View Grades");
                        viewButton.setBounds(534, 305, 131, 23);
                        panel_2.add(viewButton);
                        viewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
                        
                                deleteButton = new JButton("Delete Student");
                                deleteButton.setBounds(334, 256, 131, 39);
                                panel_2.add(deleteButton);
                                deleteButton.setFont(new Font("Tahoma", Font.BOLD, 11));
                                
                                        courseComboBox = new JComboBox<>();
                                        courseComboBox.setBounds(33, 195, 200, 20);
                                        panel_2.add(courseComboBox);
                                        courseComboBox.setPreferredSize(new Dimension(200, 20));
                                        
                                                assignButton = new JButton("Assign Course");
                                                assignButton.setBounds(66, 226, 125, 30);
                                                panel_2.add(assignButton);
                                                assignButton.setFont(new Font("Tahoma", Font.BOLD, 11));
                                                
                                                        addGradeButton = new JButton("Add Grade");
                                                        addGradeButton.setBounds(66, 323, 125, 30);
                                                        panel_2.add(addGradeButton);
                                                        addGradeButton.setFont(new Font("Tahoma", Font.BOLD, 11));
                                                        
                                                        gradeField = new JTextField(20);
                                                        gradeField.setBounds(22, 292, 226, 20);
                                                        panel_2.add(gradeField);
                                                        gradeField.setText("Add Grade");
                                                        gradeField.setToolTipText("Add Grade");
                                                        gradeField.setFont(new Font("Tahoma", Font.BOLD, 11));
                                                        gradeField.setHorizontalAlignment(SwingConstants.CENTER);
                                                        
                                                                Label label_1 = new Label("Manage Student");
                                                                label_1.setForeground(Color.BLUE);
                                                                label_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
                                                                label_1.setBounds(new Rectangle(5, 5, 5, 5));
                                                                label_1.setBackground(Color.GRAY);
                                                                label_1.setAlignment(Label.CENTER);
                                                                label_1.setBounds(317, 57, 178, 22);
                                                                panel_2.add(label_1);
                                                                
                                                                
                                                                
                                                                gradeField.addMouseListener(new MouseAdapter() {
                                                                    @Override
                                                                    public void mouseClicked(MouseEvent e) {
                                                                        if (e.getButton() == MouseEvent.BUTTON1) { // Check for left mouse click
                                                                            gradeField.setText(""); // Clear the text field
                                                                        }
                                                                    }
                                                                });
                                                                
                                                        
                                                                addGradeButton.addActionListener(new ActionListener() {
                                                                    @Override
                                                                    public void actionPerformed(ActionEvent e) {
                                                                        addGrade();
                                                                    }
                                                                });
                                                
                                                        assignButton.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                assignCourse();
                                                            }
                                                        });
                                
                                        deleteButton.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                deleteStudent();
                                            }
                                        });
                        
                                viewButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        viewGrades();
                                    }
                                });
                
                        viewCoursesButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                viewCourses();
                            }
                        });

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/school_db", "root", "");

            loadCourses();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadCourses() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT title FROM Courses");
            while (resultSet.next()) {
                String courseTitle = resultSet.getString("title");
                courseComboBox.addItem(courseTitle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addStudent() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String dob = dobField.getText();
        String gender = (String) genderComboBox.getSelectedItem(); // Get the selected gender
        String address = addressField.getText();

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dateOfBirth = LocalDate.parse(dob, formatter);

            // Connect to the MySQL database using the correct driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/school_db", "root", "");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO Students (first_name, last_name, date_of_birth, gender, address) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setDate(3, java.sql.Date.valueOf(dateOfBirth));
            statement.setString(4, gender);
            statement.setString(5, address);
            statement.executeUpdate();

            firstNameField.setText("");
            lastNameField.setText("");
            dobField.setText("");
            genderComboBox.setSelectedIndex(0); // Reset gender combo box
            addressField.setText("");

            JOptionPane.showMessageDialog(this, "Student added successfully!");
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Wrong date format. Please enter the date in the format dd-MM-yyyy.", "Date Format Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    private void assignCourse() {
        String studentID = JOptionPane.showInputDialog(null, "Enter Student ID:");
        String course = (String) courseComboBox.getSelectedItem();

        if (studentID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Student ID.");
            return;
        }

        try {
            // Check if the student exists
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Students WHERE student_id = ?");
            stmt.setString(1, studentID);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No Student Found with ID: " + studentID);
                return;
            }

            // Check if the course exists
            stmt = connection.prepareStatement("SELECT * FROM Courses WHERE title = ?");
            stmt.setString(1, course);
            rs = stmt.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No Course Found with Title: " + course);
                return;
            }

            // Check if the course is already assigned to the student
            stmt = connection.prepareStatement("SELECT * FROM student_courses WHERE student_id = ? AND course_id = (SELECT course_id FROM Courses WHERE title = ?)");
            stmt.setString(1, studentID);
            stmt.setString(2, course);
            rs = stmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Course is already assigned to the student.");
                return;
            }

            // Perform the course assignment
            stmt = connection.prepareStatement("INSERT INTO student_courses (student_id, course_id) VALUES (?, (SELECT course_id FROM Courses WHERE title = ?))");
            stmt.setString(1, studentID);
            stmt.setString(2, course);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Course Assigned Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Assign Course");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void viewGrades() {
        String selectedStudent = JOptionPane.showInputDialog(this, "Enter student ID:");
        int studentID = Integer.parseInt(selectedStudent);

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT Courses.title, Grades.grade FROM Courses INNER JOIN Grades ON Courses.course_id = Grades.course_id WHERE Grades.student_id = ?");
            statement.setInt(1, studentID);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder grades = new StringBuilder();
            while (resultSet.next()) {
                String courseTitle = resultSet.getString("title");
                int grade = resultSet.getInt("grade");
                grades.append(courseTitle).append(": ").append(grade).append("\n");
            }

            JOptionPane.showMessageDialog(this, grades.toString(), "Grades for Student ID " + studentID, JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addGrade() {
        String studentID = JOptionPane.showInputDialog(null, "Enter Student ID:");
        String course = (String) courseComboBox.getSelectedItem();
        String gradeText = gradeField.getText();

        if (studentID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Student ID.");
            return;
        }

        if (gradeText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a grade.");
            return;
        }

        int grade;
        try {
            grade = Integer.parseInt(gradeText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid grade. Please enter a numeric value.");
            return;
        }

        try {
            // Check if the student exists
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Students WHERE student_id = ?");
            stmt.setString(1, studentID);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "No Student Found with ID: " + studentID);
                return;
            }

            // Check if the course is assigned to the student
            stmt = connection.prepareStatement("SELECT * FROM student_courses WHERE student_id = ? AND course_id = (SELECT course_id FROM Courses WHERE title = ?)");
            stmt.setString(1, studentID);
            stmt.setString(2, course);
            rs = stmt.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "The course is not assigned to the student.");
                return;
            }

            // Check if the grade already exists and update it
            stmt = connection.prepareStatement("SELECT * FROM Grades WHERE student_id = ? AND course_id = (SELECT course_id FROM Courses WHERE title = ?)");
            stmt.setString(1, studentID);
            stmt.setString(2, course);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Grade already exists, update it
                int gradeID = rs.getInt("grade_id");
                stmt = connection.prepareStatement("UPDATE Grades SET grade = ? WHERE grade_id = ?");
                stmt.setInt(1, grade);
                stmt.setInt(2, gradeID);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Grade Updated Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to Update Grade");
                }
            } else {
                // Grade does not exist, insert it
                PreparedStatement insertStmt = connection.prepareStatement("INSERT INTO Grades (student_id, course_id, grade) VALUES (?, (SELECT course_id FROM Courses WHERE title = ?), ?)");
                insertStmt.setString(1, studentID);
                insertStmt.setString(2, course);
                insertStmt.setInt(3, grade);
                int rowsAffected = insertStmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Grade Added Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to Add Grade");
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteStudent() {
        String selectedStudent = JOptionPane.showInputDialog(this, "Enter student ID:");
        
        if (selectedStudent == null) {
            return; // Cancel button clicked, do nothing
        }
        
        int studentID;
        try {
            studentID = Integer.parseInt(selectedStudent);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid student ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            PreparedStatement deleteGradesStatement = connection.prepareStatement("DELETE FROM Grades WHERE student_id = ?");
            deleteGradesStatement.setInt(1, studentID);
            deleteGradesStatement.executeUpdate();

            PreparedStatement deleteCoursesStatement = connection.prepareStatement("DELETE FROM student_courses WHERE student_id = ?");
            deleteCoursesStatement.setInt(1, studentID);
            deleteCoursesStatement.executeUpdate();

            PreparedStatement deleteStudentStatement = connection.prepareStatement("DELETE FROM Students WHERE student_id = ?");
            deleteStudentStatement.setInt(1, studentID);
            int deletedRows = deleteStudentStatement.executeUpdate();

            if (deletedRows > 0) {
                JOptionPane.showMessageDialog(this, "Student deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Student not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void viewCourses() {
        String selectedStudent = JOptionPane.showInputDialog(this, "Enter student ID:");
        int studentID = Integer.parseInt(selectedStudent);

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT Courses.title FROM Courses INNER JOIN student_courses ON Courses.course_id = student_courses.course_id WHERE student_courses.student_id = ?");
            statement.setInt(1, studentID);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder courses = new StringBuilder();
            while (resultSet.next()) {
                String courseTitle = resultSet.getString("title");
                courses.append(courseTitle).append("\n");
            }

            JOptionPane.showMessageDialog(this, courses.toString(), "Courses for Student ID " + studentID, JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        dobField.setText("");
        genderComboBox.setSelectedIndex(0); 
        addressField.setText(""); 
      
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main5 school = new Main5();
                school.setVisible(true);
            }
        });
    }
}