package topsJDBC;

import java.util.*;

class Course {
    String id;
    String name;
    double fees;
    String duration;
    String details;

    Course(String id, String name, double fees, String duration, String details) {
        this.id = id;
        this.name = name;
        this.fees = fees;
        this.duration = duration;
        this.details = details;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Fees: $" + fees);
        System.out.println("Duration: " + duration);
        System.out.println("Details: " + details);
        System.out.println("------------------------");
    }
}

public class CourseManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static HashMap<String, Course> courses = new HashMap<>();

    public static void main(String[] args) 
    {

        int choice;

        do {
            System.out.println("\n--- Course Management System ---");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Search Course");
            System.out.println("4. Edit Course");
            System.out.println("5. Delete Course");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: addCourse(); break;
                case 2: viewCourses(); break;
                case 3: searchCourse(); break;
                case 4: editCourse(); break;
                case 5: deleteCourse(); break;
                case 6: System.out.println("Exiting program..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    static void addCourse() {
        System.out.print("Course ID: ");
        String id = sc.nextLine();

        if (courses.containsKey(id)) {
            System.out.println("Course already exists!");
            return;
        }

        System.out.print("Course Name: ");
        String name = sc.nextLine();

        System.out.print("Course Fees: ");
        double fees = Double.parseDouble(sc.nextLine());

        System.out.print("Course Duration: ");
        String duration = sc.nextLine();

        System.out.print("Course Details: ");
        String details = sc.nextLine();

        courses.put(id, new Course(id, name, fees, duration, details));
        System.out.println("Course added successfully!");
    }

    static void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course c : courses.values()) {
            c.display();
        }
    }

    static void searchCourse() {
        System.out.print("Enter Course ID: ");
        String id = sc.nextLine();

        Course c = courses.get(id);
        if (c != null) {
            c.display();
        } else {
            System.out.println("Course not found.");
        }
    }

    static void editCourse() {
        System.out.print("Enter Course ID: ");
        String id = sc.nextLine();

        Course c = courses.get(id);
        if (c == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.print("New Name: ");
        c.name = sc.nextLine();

        System.out.print("New Fees: ");
        c.fees = Double.parseDouble(sc.nextLine());

        System.out.print("New Duration: ");
        c.duration = sc.nextLine();

        System.out.print("New Details: ");
        c.details = sc.nextLine();

        System.out.println("Course updated successfully!");
    }

    static void deleteCourse() {
        System.out.print("Enter Course ID: ");
        String id = sc.nextLine();

        if (courses.remove(id) != null) {
            System.out.println("Course deleted successfully!");
        } else {
            System.out.println("Course not found.");
        }
    }
}
