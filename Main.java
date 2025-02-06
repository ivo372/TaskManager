import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1 - Add Task");
            System.out.println("2 - Remove Task");
            System.out.println("3 - Update Status");
            System.out.println("4 - Display Tasks");
            System.out.println("5 - Exit");
            
            int option = scanner.nextInt();
            scanner.nextLine(); // Clear the newLine character after nextInt()
            
            switch (option) {
                case 1:
                    System.out.println("What task would you like to add?");
                    manager.addTask(new Task(scanner));
                    break;
                case 2:
                    System.out.println("Enter the title of the task you would like to remove:");
                    String titleToRemove = scanner.nextLine();
                    manager.removeTask(titleToRemove);
                    break;
                case 3:
                    System.out.println("Enter the title of the task you would like to update:");
                    String titleToUpdate = scanner.nextLine();
                    System.out.println("Select status: 1- Pending, 2- OnGoing, 3- Completed");
                    int statusChoice = scanner.nextInt();
                    scanner.nextLine(); //Clear the buffer
                    
                    Status newStatus;
                    switch(statusChoice) {
                        case 1: newStatus = Status.Pending; break;
                        case 2: newStatus = Status.OnGoing; break;
                        case 3: newStatus = Status.Completed; break;
                        default:
                            System.out.println("Invalid choice.");
                            continue; //Skip the rest of the loop
                    }
                    manager.updateTaskStatus(titleToUpdate, newStatus);
                    break;
                case 4:
                    manager.displayTasks();
                    break;
                case 5:
                    System.out.println("Exiting the program!");
                    scanner.close();
                    return; // Leaves the loop and closes the program
                default:
                    System.out.println("Invalid option, please try again!");
            }
        }
        
    }

}
