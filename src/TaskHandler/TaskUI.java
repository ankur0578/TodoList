package TaskHandler;

import java.util.Scanner;

public class TaskUI {
    private TaskManager taskManager;
    private Scanner scanner;

    public TaskUI(){
        taskManager = TaskManager.getTaskManagerInstance();
        scanner= new Scanner(System.in);
    }

    public void addTask(){
        System.out.println("enter task description");
        String description = scanner.nextLine();
        taskManager.addTask(description);
    }

    public void removetask(){
        System.out.println("enter task id");
        int id = scanner.nextInt();
        taskManager.removeTask(id);
    }

    public void displayAllTask(){
        taskManager.displayAllTask();
    }

    public void markCompleteTask(){
        System.out.println("enter task id");
        int id = scanner.nextInt();
        taskManager.markTaskCompleted(id);
    }

    public void run(){
        boolean exit = false;
        while (!exit){
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    addTask();
                    break;
                case 2:
                    removetask();
                    break;
                case 3:
                    markCompleteTask();
                    break;
                case 4:
                    displayAllTask();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice: please enter corect choice");
                    exit = true;

            }
        }
    }

    public void displayMenu(){
        System.out.println("\nTo-Do List Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Display Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
}
