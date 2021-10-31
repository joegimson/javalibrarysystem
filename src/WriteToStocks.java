import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//used to update quantity of book(s) checked out to the stock text file
public class WriteToStocks {
	   public static void main(String isbn, String booktype, String title, String lang,  String genre, String date, String price, String addinfo, String addinfo2, String oldquant, String newquant)   throws IOException {
		      //Instantiating the File class
		      String filePath = "Stock.txt";
		      //Instantiating the Scanner class to read the file
		      Scanner sc = new Scanner(new File(filePath));
		      //instantiating the StringBuffer class
		      StringBuffer buffer = new StringBuffer();
		      //Reading lines of the file and appending them to StringBuffer
		      while (sc.hasNextLine()) {
		         buffer.append(sc.nextLine()+System.lineSeparator());
		      }
		      String fileContents = buffer.toString();
		      //System.out.println("Contents of the file: "+fileContents);
		      //closing the Scanner object
		      sc.close();
		      String oldLine = isbn + ", " + booktype + ", " + title + ", " + lang + ", " + genre + ", " + date + ", " + price + ", " + oldquant + ", " + addinfo + ", " + addinfo2; //finding old line of file
		      String newLine = isbn + ", " + booktype + ", " + title + ", " + lang + ", " + genre + ", " + date + ", " + price + ", " + newquant + ", " + addinfo + ", " + addinfo2; //updating line with new quantity
		      //System.out.println(oldLine);
		      //System.out.println(newLine);
		      //Replacing the old line with new line
		      fileContents = fileContents.replaceAll(oldLine, newLine);
		      FileWriter writer = new FileWriter(filePath);
		      //System.out.println("");
		      //System.out.println("new data: "+fileContents);
		      writer.append(fileContents);
		      writer.flush();
		      writer.close();
		   }
}
