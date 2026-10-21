
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Student Task Manager ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter task: ");
                String task = sc.nextLine();

                tasks.add(task);
                System.out.println("Task added successfully!");

            } else if (choice == 2) {
                System.out.println("\nYour Tasks:");

                if (tasks.isEmpty()) {
                    System.out.println("No tasks added yet.");
                } else {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(
                            (i + 1) + ". " + tasks.get(i)
                        );
                    }
                }

            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
