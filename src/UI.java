
import java.util.*;

    public class UI {
	
	/* This method gives the header to the TaskList*/
    	
	public void printHeader() {
		
        System.out.println("Task ID  Tasks            Due Date     Project     Status");
    }
	
	
    private String fixLengthString(String start, int length) {
    	
        if (start.length() >= length) {
            return start.substring(0, length);
        } else {
            while (start.length() < length) {
                start += " ";
            }
            return start;
        }
    }
    
    /* prints the details in the task */
    
    public void printTask(Task task) {
    	
        String taskIdString = String.valueOf(task.getTaskid());
        String taskDateString = String.valueOf(task.getDateInStr());
        String taskStatusString = String.valueOf(task.getStatus());
        System.out.println(fixLengthString(taskIdString, 7) + "  " + fixLengthString(task.getTasktitle(), 15) + "  "
                                   + fixLengthString(taskDateString, 11) + "  " + fixLengthString(task.getProject(), 12)
                                   + fixLengthString(taskStatusString, 10));
    }
    
    /* A method to print the taskList */
    
    public void printTaskList(List<Task> allTaskList) {
    	
        for (Task task : allTaskList) {
            if (task != null) {
                printTask(task);
            }
        }
    }
}
