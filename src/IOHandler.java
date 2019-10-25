import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class IOHandler {
	
	private File file;
	
	/* writeToFile method write the content in to the .txt file */

	
	public void writeToFile(List<Task> taskList) {

		try {
			// Create new file

			DateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy");

			String path = "/Users/karthickaraju/IndividualProject/Read.txt";
			File file = new File(path);

			// If file doesn't exists, then create it

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			// Write in file
			//bw.write(task.getTaskid());
			
			for(Task task:taskList)
			{	
				
	        // Date date = task.getDuedate();
	        // String dateStr = DateFor.format(date);
				
			bw.write(task.getTasktitle());
			bw.append("\t");

            // bw.write(dateStr);
			
			bw.write(task.getDateInStr());
			bw.append("\t");

			bw.write(task.getProject());
			bw.append("\t");

			bw.write(task.getStatus());
			bw.append("\n");
			}
			
			// Close connection
			
			bw.close();
		}   catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
	}
	
	/* readFromFile reads the content from the file and display in the console */

	public ArrayList<Task> readFromFile() {

			ArrayList<Task> filecontent = new ArrayList<Task>();

			final String FILENAME = "/Users/karthickaraju/IndividualProject/Read.txt";

			try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

				String strCurrentLine = null;
			

				while ((strCurrentLine = br.readLine()) != null) {

					String[] arr = strCurrentLine.split("\t");
					
					System.out.println("arr size" + arr.length);
					if (arr.length > 0) {
						System.out.println("title:"+arr[0]);
						System.out.println("date "+arr[1].length()+" type is ");
						System.out.println("project:"+arr[2]);
						System.out.println("status:"+arr[3]);
						String title=arr[0];
						String date=arr[1];
						String project=arr[2];
						String status=arr[3];
						Task task=new Task(title,date,project,status);
						filecontent.add(task);
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			return filecontent;
	}  	
	 
}
