import java.util.Scanner;

public class Task_2_StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter the number of subjects
        System.out.print("Enter the number of subjects: ");
        int SubjectNum = sc.nextInt();

        // Initialize an array to store the marks for each subject
        int[] marks = new int[SubjectNum];
        int totalMarks = 0;

        // Loop to get marks for each subject
        for (int i = 0; i < SubjectNum; i++) {
            // Input validation to ensure marks are between 0 and 100
            int mark;
            do {
                System.out.print("Enter the marks (out of 100) for subject " + (i + 1) + ": ");
                mark = sc.nextInt();
                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid input. Please enter marks between 0 and 100.");
                }
            } while (mark < 0 || mark > 100);

            // Store the valid mark in the array and add to totalMarks
            marks[i] = mark;
            totalMarks += mark;
        }

        // Calculate the average marks
        float averageMarks = (float) totalMarks / SubjectNum;

        // Determine the grade based on average marks
        char grade;
        if (averageMarks >= 90) {
            grade = 'A';
        } else if (averageMarks >= 80) {
            grade = 'B';
        } else if (averageMarks >= 70) {
            grade = 'C';
        } else if (averageMarks >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display the total marks, average marks, and grade
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Marks: " + averageMarks);
        System.out.println("Grade: " + grade);

        // Display the individual subject marks
        System.out.println("\nMarks for each subject:");
        for (int i = 0; i < SubjectNum; i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);
        }

        // Close the scanner to avoid resource leaks
        sc.close();
    }
}
