
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<Boolean> completed = new ArrayList<>();

        // Load saved tasks
        try (BufferedReader br = new BufferedReader(
                new FileReader("tasks.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|", 2);
                if (parts.length == 2) {
                    tasks.add(parts[1]);
                    completed.add(parts[0].equals("true"));
                }
            }
        } catch (IOException e) {
            System.out.println("Starting with an empty task list.");
        }

        while (true) {
            System.out.println("\n=== Student Task Manager ===");
            System.out.println("Manage your daily tasks by priority!");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Mark Task Completed");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter task: ");
                tasks.add(sc.nextLine());
                completed.add(false);
                System.out.println("Task added!");

            } else if (choice == 2) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks available.");
                }
                for (int i = 0; i < tasks.size(); i++) {
                    String status = completed.get(i)
                            ? "[Completed]" : "[Pending]";
                    System.out.println((i + 1) + ". "
                            + tasks.get(i) + " " + status);
                }

            } else if (choice == 3) {
                System.out.print("Task number to delete: ");
                int n = sc.nextInt();
                sc.nextLine();
                if (n >= 1 && n <= tasks.size()) {
                    tasks.remove(n - 1);
                    completed.remove(n - 1);
                    System.out.println("Task deleted!");
                } else {
                    System.out.println("Invalid task number.");
                }

            } else if (choice == 4) {
                System.out.print("Task number to complete: ");
                int n = sc.nextInt();
                sc.nextLine();
                if (n >= 1 && n <= tasks.size()) {
                    completed.set(n - 1, true);
                    System.out.println("Task completed!");
                } else {
                    System.out.println("Invalid task number.");
                }

            } else if (choice == 5) {
                // Save tasks before exiting
                try (PrintWriter pw = new PrintWriter(
                        new FileWriter("tasks.txt"))) {
                    for (int i = 0; i < tasks.size(); i++) {
                        pw.println(completed.get(i) + "|"
                                + tasks.get(i));
                    }
                    System.out.println("Tasks saved successfully!");
                } catch (IOException e) {
                    System.out.println("Error saving tasks.");
                }
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
