import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//reads stock text file and puts it into an arraylist containing each book as an object Book
public class ReadBooks { 
	public static List<Book> test() throws FileNotFoundException   {
	Scanner input = new Scanner(new File("Stock.txt"));
	Book bk = null;
	List<Book> listBook = new ArrayList<Book>();
	while(input.hasNextLine()) {
		String[] details = input.nextLine().split(",");
	    bk = new Book(Integer.parseInt(details[0].trim()), details[1].trim(), details[2].trim(), details[3].trim(), details[4].trim(), details[5].trim(),details[6].trim(), Integer.parseInt(details[7].trim()), details[8].trim(), details[9].trim());
	    listBook.add(bk);
	    listBook.sort(new PriceCompare());
   }
	return listBook;
	}
}



