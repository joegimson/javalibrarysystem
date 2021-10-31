import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
//writes to the top of activitylog user activity
public class WriteToActivityLog {
	public static void main(String userno, String post, String isbn ,String price, String amount, String status, String paymenttype, String date) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get("ActivityLog.txt")));
		try
		{
		    String filename= "ActivityLog.txt";
		    FileWriter fw = new FileWriter(filename);
		    fw.write("");
		    fw.write(userno + ", " + post  + ", " + isbn + ", " + price + ", " + amount + ", " + status + ", " + paymenttype + ", " + date + "\n");
		    fw.write(content);//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
}
