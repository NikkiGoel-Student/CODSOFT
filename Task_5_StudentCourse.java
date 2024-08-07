
import java.util.*;

// Class to represent a Course
class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    int enrolled;
    String schedule;

    // Constructor to initialize course details
    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolled = 0;
        this.schedule = schedule;
    }

    // Method to check if course has available slots
    public boolean hasAvailableSlot() {
        return enrolled < capacity;
    }

    // Method to enroll a student in the course
    public void enrollStudent() {
        if (hasAvailableSlot()) {
            enrolled++;
        } else {
            System.out.println("Course is full.");
        }
    }

    // Method to drop a student from the course
    public void dropStudent() {
        if (enrolled > 0) {
            enrolled--;
        }
    }

    // Method to display course details
    public void displayCourse() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Capacity: " + capacity);
        System.out.println("Enrolled: " + enrolled);
        System.out.println("Schedule: " + schedule);
    }
}

// Class to represent a Student
class Student {
    long studentID;
    String name;
    List<Course> registeredCourses;

    // Constructor to initialize student details
    public Student(long studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    // Method to register a course for the student
    public void registerCourse(Course course) {
        if (course.hasAvailableSlot()) {
            course.enrollStudent();
            registeredCourses.add(course);
            System.out.println("Registered for course: " + course.title);
        } else {
            System.out.println("Course " + course.title + " is full.");
        }
    }

    // Method to drop a course for the student
    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            course.dropStudent();
            registeredCourses.remove(course);
            System.out.println("Dropped course: " + course.title);
        } else {
            System.out.println("Not registered for course: " + course.title);
        }
    }

    // Method to display student details
    public void displayStudent() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Registered Courses:");
        for (Course course : registeredCourses) {
            System.out.println("- " + course.title);
        }
    }
}



// Main class to run the system
public class Task_5_StudentCourse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long studentID;
        String courseCode;
        Student student;
        
        // Create some courses
        Course course1 = new Course("21CS3003", "Computer Networks", "Basic concepts of Computer Networking.", 3, "Mon, Wed, Fri 10-11am");
        Course course2 = new Course("21CS3001", "Compiler Design", "About compilation", 4, "Tue, Thu 9-10:30am");
        Course course3 = new Course("21CS2010", "Java Programming", "Programming to Java", 6, "Mon, Wed, Fri 11-12am");
        Course course4 = new Course("21CS2006", "Operating System", "Introduction to OS", 5, "Tues, Thurs, Fri 11:30-12:30am");



        // List of courses
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);

        // Create some students
        Student student1 = new Student(1032210034, "Nishant");
        Student student2 = new Student(1032210072, "Mishru");
        Student student3 = new Student(1032210115, "Nicks");

        // List of students
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);


        // Menu-driven interface
        while (true) {
            System.out.println("1. List all courses");
            System.out.println("2. Register student for a course");
            System.out.println("3. Drop student from a course");
            System.out.println("4. Display student details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Courses:");
                    for (Course course : courses) {
                        course.displayCourse();
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    studentID = sc.nextLong();
                    System.out.print("Enter course code: ");
                    courseCode = sc.next();

                    student = findStudentByID(students, studentID);
                    Course course = findCourseByCode(courses, courseCode);


                    if (student != null && course != null) {
                        student.registerCourse(course);
                    } else {
                        System.out.println("Invalid student ID or course code.");
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    studentID = sc.nextLong();
                    System.out.print("Enter course code: ");
                    courseCode = sc.next();

                    student = findStudentByID(students, studentID);
                    course = findCourseByCode(courses, courseCode);
                    
                    

                    if (student != null && course != null) {
                        student.dropCourse(course);
                    } else {
                        System.out.println("Invalid student ID or course code.");
                    }
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    studentID = sc.nextLong();

                    student = findStudentByID(students, studentID);

                    if (student != null) {
                        student.displayStudent();
                    } else {
                        System.out.println("Invalid student ID.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static Student findStudentByID(List<Student> students, long studentID) {
        for (Student student : students) {
            if (student.studentID == studentID)
                return student;
        }
        return null;
    }

    // Method to find a course by code
    public static Course findCourseByCode(List<Course> courses, String courseCode) {
        for (Course course : courses) {
            if (course.courseCode.equals(courseCode))
                return course;
        }
        return null;
    }
}
