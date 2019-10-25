
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


/* TaskRegister class is responsible for all operations on tasks and projects */


public class TaskRegister {

	IOHandler iohandler = new IOHandler () ;
	private ArrayList<Task> taskList = new ArrayList<Task>();
	UI ui = new UI();
    Scanner scan = new Scanner(System.in);
	Scanner scan1 = new Scanner(System.in);

	public TaskRegister() {
		taskList = iohandler.readFromFile() ;
	}

	public ArrayList<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(ArrayList<Task> taskList) {
		this.taskList = taskList;
	}

	
	public void createtask() {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the Task Title: ");
		String taskTitle = scan.next();

		System.out.println("Enter the Project Name: ");
		String projectName = scan.next();

		DateFormat dft = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Enter the Due date in the format (MM/dd/yyyy): ");
		String dateStr = scan.next();			
		Date date = null;

		try {
			date = dft.parse(dateStr);

		} catch (ParseException e) {
			e.printStackTrace();
		}
         
		Task task = new Task(taskTitle, date, projectName);
		taskList.add(task);

	}
	
     /* searches the task by its id */
	
	 public Task searchTask(int taskid) {
		 
		 
		for (Task tsk : taskList) {
			
			if (tsk.getTaskid() == (taskid)) {
				return tsk;
			}
		}
		return null;
	} 
	
	public Task searchTask2( ) {
		System.out.println("Enter the new title for the task: ");
		String title = scan.nextLine();
		scan.next();
		
		Task tmptsk = null ;
		for (Task tsk : taskList) {
			if (tsk.getTasktitle().equals(title)) {
				tmptsk  = tsk;
			}
		}
            return tmptsk ;
	}
	 /* remove an existing task from task list */
	
	public void remove(int taskid) {

		Task tmpTask;
		tmpTask = this.searchTask(taskid);
		taskList.remove(tmpTask);

	}

	/* Updates the title, date, project and status of the task */ 
	
	public void updateTask() {

		ArrayList<String> filecontent = new ArrayList<String>();

		// filecontent = readFromFile();
		
		System.out.println("Enter the task title to be updated :");
		String taskName = scan1.next();
        Task tasktobeUPdated = searchTask2(); // add taskname if required
        System.out.println("HEERREE!!" + tasktobeUPdated.getTasktitle());
		
		System.out.println("What would you like to update in the required Task? Choose below: ");
		System.out.println("*****************************************************************");
		System.out.println(
				"1. Update Task Title\n2. Update the Due date\n3. Update the Project Title\n4. Update the status of the Task");

		int caseNum = scan.nextInt();
		switch (caseNum) {
		case 1:
			System.out.println("Enter the new title for the task: ");
			String title = scan.nextLine();
			scan.next();
			break;
			
		case 2:
			System.out.println("Enter the new date for the task: ");
			String date = scan.next();
			break;
			
		case 3: 
			System.out.println("Enter the new project title: ");
			String projecttitle = scan.next();
			break;
			
		case 4: 
			System.out.println("Enter the new status for the task: ");
			String status = scan.next();

			break;
		}
	}
	
	    
	    /* Compares the task by project */ 
	    
	 Comparator<Task> compareByproject = new Comparator<Task>() {
		@Override
		public int compare(Task t1, Task t2) {
			return t1.getProject().compareTo(t2.getProject());
		}
	};
	
        /* Compares the task by dueDate */ 

	Comparator<Task> compareByDuedate = new Comparator<Task>() {
		@Override
		public int compare(Task t1, Task t2) {
			return t1.getDateInStr().compareTo(t2.getDateInStr());
		}
	};
 
	 /* A method to sort tasks as per the project related to */   

	public void sortByProject() {
		
		List<Task> taskList = iohandler.readFromFile();
		Collections.sort(taskList, compareByproject);
		printTasks(taskList);
	}
    
	/* A method to sort tasks according to the due date associated with */

	public void sortByDuedate() {
		
		ArrayList<Task> filecontent = iohandler.readFromFile();
		for(Task task: filecontent) {
			System.out.println(task.getDateInStr());
		}
		Collections.sort(filecontent, compareByDuedate);
		printTasks(filecontent);
	}

	/* A method to print the taskList */
	
	public void printTasks(List<Task> taskList) {
		System.out.println("TaskList displayed below ");
		ui.printTaskList(taskList);

	} 
	
}
