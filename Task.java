import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private Status status;
    
    public Task(Scanner scanner) {
        System.out.println("Enter the name of the task: ");
        this.title = scanner.nextLine();
        
        System.out.println("Enter the description of the task: ");
        this.description = scanner.nextLine();
        
        System.out.println("Enter the due date (YYYY-MM-DD): ");
        while (true) {
            try {
                this.dueDate = LocalDate.parse(scanner.nextLine());
                break; // Exit the loop if the date is valid
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format.Please enter again (YYYY-MM-DD): ");
            }
        }
        this.status = Status.Pending; // default Status
    }
    //Getters
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getDate() {
        return dueDate;
    }
    public String getStatus() {
        return status.name();
    }
    //Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setdate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public String toString() {
        return "Title: " + title + ", Description: " + description +
                ", Due Date: " + dueDate + ", Status: " + status;
    }
}