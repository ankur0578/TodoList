package TaskHandler;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static  TaskManager taskManager;
    private List<Task> taskList;
    private int taskIdCounter = 1;

    private TaskManager() {
        taskList = new ArrayList<>();
        taskIdCounter = 1;
    }

    // Static method to get the single instance of TaskManager (Singleton Pattern)
    public static TaskManager getTaskManagerInstance(){
           if(taskManager == null){
               taskManager = new TaskManager();
           }

           return taskManager;
    }

    public void addTask(String description){
        Task newTask = new Task(taskIdCounter,description);
        taskList.add(newTask);
        taskIdCounter++;
        System.out.println("task inserted ");
    }

    public void removeTask(int id){
        taskList.removeIf(task -> task.getId() == id);
        System.out.println("task removed");
    }

    public void markTaskCompleted(int id){
        taskList.stream().forEach(task -> task.markCompleted());
        System.out.println("task marked as completed");
    }

    public void displayAllTask(){
        if(taskList.isEmpty()){
            System.out.println("there is not task");
        }else {
            for(Task task : taskList){
                System.out.println(task.toString());
            }
        }
    }
}
