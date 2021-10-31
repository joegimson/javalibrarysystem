import java.util.Comparator;
//used in ReadBooks to sort price in ascending order
public class PriceCompare implements Comparator<Book> {
	@Override
	public int compare(Book o1, Book o2) {
		return Float.compare(Float.parseFloat(o1.getPrice()), Float.parseFloat(o2.getPrice()));
	}
}
