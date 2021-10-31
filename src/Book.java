//creates book object 

public class Book {
	private int ISBN;
	private String BookType;
	private String title;
	private String language;
	private String genre;
	private String date;
	private String price;
	private int quantity;
	private String additionalinfo1;
	private String additionalinfo2;
	public Book(int ISBN, String BookType, String title, String language, String genre, String date, String price, int quantity, String additionalinfo1, String additionalinfo2) {
		this.ISBN = ISBN;
		this.BookType = BookType;
		this.title = title;
		this.language = language;
		this.genre = genre;
		this.date = date;
		this.price = price;
		this.quantity = quantity;
		this.additionalinfo1 = additionalinfo1;
		this.additionalinfo2 = additionalinfo2;
	}
	public int getISBN() {
		return(ISBN);
	}
	public String getBookType() {
		return(BookType);
	}
	public String getTitle() {
		return(title);
	}
	public String getLanguage() {
		return(language);
	}
	public String getGenre() {
		return(genre);
	}
	public String getDate() {
		return(date);
	}
	public String getPrice() {
		return(price);
	}
	public int getQuantity() {
		return(quantity);
	}
	public String getAdditionalInfo1() {
		return(additionalinfo1);
	}
	public String getAdditionalInfo2() {
		return(additionalinfo2);
	}
	@Override
	public String toString() {
		return "ISBN=" + ISBN + ", BookType=" + BookType + ", title=" + title + ", language=" + language
				+ ", genre=" + genre + ", date=" + date + ", price=" + price + ", quantity=" + quantity
				+ ", additionalinfo1=" + additionalinfo1 + ", additionalinfo2=" + additionalinfo2;
	}

}
