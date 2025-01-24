import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        int choice;

        System.out.println("Welcome to the Student Grade Tracker!");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Grade");
            System.out.println("2. Display All Grades");
            System.out.println("3. Calculate Average");
            System.out.println("4. Find Highest Grade");
            System.out.println("5. Find Lowest Grade");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the grade to add: ");
                    int grade = scanner.nextInt();
                    grades.add(grade);
                    System.out.println("Grade added successfully!");
                    break;

                case 2:
                    System.out.println("Grades: " + grades);
                    break;

                case 3:
                    if (!grades.isEmpty()) {
                        double average = calculateAverage(grades);
                        System.out.println("Average Grade: " + average);
                    } else {
                        System.out.println("No grades entered yet.");
                    }
                    break;

                case 4:
                    if (!grades.isEmpty()) {
                        int highest = findHighestGrade(grades);
                        System.out.println("Highest Grade: " + highest);
                    } else {
                        System.out.println("No grades entered yet.");
                    }
                    break;

                case 5:
                    if (!grades.isEmpty()) {
                        int lowest = findLowestGrade(grades);
                        System.out.println("Lowest Grade: " + lowest);
                    } else {
                        System.out.println("No grades entered yet.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    public static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public static int findHighestGrade(ArrayList<Integer> grades) {
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public static int findLowestGrade(ArrayList<Integer> grades) {
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
