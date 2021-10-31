import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
//used to check if ISBN admin inputs to be added is already in the database or not.
public class intlist {
	public static List<Integer> getISBNlist() throws FileNotFoundException {
	List<Integer> ISBNList = ReadBooks.test().stream().map(Book::getISBN).collect(Collectors.toList());
	return ISBNList;
	}

}
