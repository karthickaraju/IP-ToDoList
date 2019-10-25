package ToDoList;

import java.util.Scanner;

/* A method to display the options to the users */

public class Main {
	
	public static  IOHandler iohandler = new IOHandler() ;
	private static TaskRegister taskList1;
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		taskList1 = new TaskRegister();
		UI as = new UI();

		boolean quit = false;
		mainMenu();
		while (!quit) {
			System.out.println("Enter your choice");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				addTask();
				break;
			case 2:
				listTask();
				break;
			case 3:
				editTask();
				break;
			case 4:
				remove();
				break;
			case 5: 
				searchTask();
				break;
			case 6:
				showMainMenu();
				break;
			case 7:
				iohandler.writeToFile(taskList1.getTaskList()); //save
				quit = true; //quit 
				System.out.println("Exited from the Main Menu");
				break;
			}
		}

	}

	public static void mainMenu() {

		System.out.println("ToDoList Menu: \n1 - Add New Task." + "\n2 - List Task" + "\n3 - Edit Task."
				+ "\n4 - Remove." + "\n5 - Search." + "\n6 - Show Main Menu." + "\n7 - Save and Quit.");

	}

	/* A method to add the task */
	
	public static void addTask() {
		taskList1.createtask();
		System.out.println("Would you like to add a new task? (Yes/No)");
		Scanner input = new Scanner(System.in);
		String answer = input.next();

		while (answer.equals("yes")) {

			taskList1.createtask();
			System.out.println("Task details are added successfully");
			System.out.println("Would you like to add another task? (yes/no");
			answer = input.next();
		}
	}

	/* A method to list the taskList */
	
	public static void listTask() {

		System.out.println("Press 1 to list the task by Duedate");
		System.out.println("Press 2 to list the task by Project");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			taskList1.sortByDuedate();
			System.out.println("TaskList displayed by DueDate");
			break;
		case 2:
			taskList1.sortByProject();
			System.out.println("TaskList displayed by Project");
			break;
		}
	}

	/* This method calls updateTask method from other class */
	
	public static void editTask() {

		taskList1.updateTask();

	}
	
	/* This method calls mainMenu method from same class */

	public static void showMainMenu() {

		mainMenu();
	}
	
	/* This method calls remove method from other class */
	
	public static void remove() {
		
		taskList1.remove(0);
	}
	
	/* This method calls searchTask2 method from other class */
	
	public static void searchTask() {
		
		taskList1.searchTask2();
	}
}
