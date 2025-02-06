import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks; // The core atribute to store tasks
    
    public TaskManager() {
        tasks = new ArrayList<>(); // initialize the list
    }
    
    // Add a new task
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added successfully!");
    }
    //Remove a task by its title
    public void removeTask(String title) {
        boolean removed = tasks.removeIf(task -> task.getTitle().equalsIgnoreCase(title));
        if (removed) {
            System.out.println("Task remove successfully!");    
        } else {
            System.out.println("Task not found.");
        }
    }
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
    //Update the status of a task
    public void updateTaskStatus(String title, Status newStatus) {
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                task.setStatus(newStatus);
                System.out.println("Status uptaded!");
                return;
            }
        }
        System.out.println("Task not found.");
    }
}
