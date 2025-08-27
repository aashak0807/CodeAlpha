import java.util.ArrayList;
import java.util.Scanner;

// Class to store student data
class Student {
    String name;
    double score;

    Student(String name, double score) {
        this.name = name;
        this.score = score;
    }
}

// Main class with main method
public class StudentGradeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Manager ===");

        int n = 0;
        while (true) {
            System.out.print("Enter number of students: ");
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Input student details
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            
            System.out.print("Name: ");
            String name = scanner.nextLine();

            double score = -1;
            while (true) {
                System.out.print("Score (0 to 100): ");
                try {
                    score = Double.parseDouble(scanner.nextLine());
                    if (score < 0 || score > 100) {
                        System.out.println("Score must be between 0 and 100.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid score. Please enter a number.");
                }
            }

            students.add(new Student(name, score));
        }

        // Calculate average, highest, and lowest
        double total = 0, highest = Double.MIN_VALUE, lowest = Double.MAX_VALUE;
        for (Student s : students) {
            total += s.score;
            if (s.score > highest) highest = s.score;
            if (s.score < lowest) lowest = s.score;
        }

        double average = total / students.size();

        // Display summary
        System.out.println("\n=== Summary Report ===");
        for (Student s : students) {
            System.out.printf("Name: %-15s | Score: %.2f%n", s.name, s.score);
        }

        System.out.printf("\nAverage Score: %.2f\n", average);
        System.out.printf("Highest Score: %.2f\n", highest);
        System.out.printf("Lowest Score : %.2f\n", lowest);

        scanner.close();
    }
}
