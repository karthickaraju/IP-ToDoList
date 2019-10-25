package ToDoList;
import java.util.Date;

/* Task class represents task details */

public class Task {

	static private int taskIdCounter = 0;

	private int taskid;
	private String tasktitle;
	private Date duedate;
	private String status;
	private String project;
	private String dateInStr;
	
	public Task() {
		
	}

	public Task(String tasktitle, Date duedate, String project) {
		this.taskid = ++taskIdCounter;
		this.status = "Not Done";
		this.tasktitle = tasktitle;
		this.project = project;
		this.duedate = duedate;
	}
	
	public Task(String tasktitle,String date,String project,String status) {
		this.tasktitle = tasktitle;
		this.dateInStr = date;
		this.status = status;
		this.project = project;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

	public String getTasktitle() {
		return tasktitle;
	}

	public void setTasktitle(String tasktitle) {
		this.tasktitle = tasktitle;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getDateInStr() {
		return dateInStr;
	}

	public String toString() {

		return "Title ID: " + this.getTaskid() + " " + "Title: " + this.getTasktitle() + " " + "Duedate: "
				+ this.getDateInStr()+ " " + "Project: " + this.getProject();

	}

}
