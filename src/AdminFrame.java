import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;



public class AdminFrame extends JFrame {
	private DefaultTableModel booktablecol;
	private JTextField ISBNfield;
	private JTextField booktypefield;
	private JTextField titlefield;
	private JTextField langfield;
	private JTextField genrefield;
	private JTextField releasedatefield;
	private JTextField pricefield;
	private JTextField pagefield;
	private JTextField conditionfield;
	private JTextField quantityfield;
	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AdminFrame() {
		setTitle("Admin Menu");
		setBounds(0, 0, 1000, 427);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 973, 388);
		getContentPane().add(tabbedPane);
		
		JPanel viewbookpanel = new JPanel();
		tabbedPane.addTab("View Books", null, viewbookpanel, null);
		viewbookpanel.setLayout(null);
		
		JScrollPane Scrollpane = new JScrollPane();
		Scrollpane.setBounds(0, 0, 888, 360);
		viewbookpanel.add(Scrollpane);
		
		booktable = new JTable();
		Scrollpane.setViewportView(booktable);
		booktablecol = new DefaultTableModel();
		booktablecol.setColumnIdentifiers(new Object[] {"ISBN", "Book Type", "Title", "Language", "Genre", "Release Date", "Price", "Quantity", "Page Length or Duration", "Condition or File Format"} ); //columns of the table
		booktable.setModel(booktablecol);
		
		JButton viewBtn = new JButton("View");
		viewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (Book b: ReadBooks.test()) {
						Object[] rowdata = new Object[] {b.getISBN(), b.getBookType(), b.getTitle(), b.getLanguage(), b.getGenre(), b.getDate(), b.getPrice(), b.getQuantity(), b.getAdditionalInfo1(), b.getAdditionalInfo2()}; //puts each book into a seperate object
						booktablecol.addRow(rowdata);
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		viewBtn.setBounds(887, 11, 81, 23);
		viewbookpanel.add(viewBtn);
		JPanel addbookpanel = new JPanel();
		tabbedPane.addTab("Add Book(s)", null, addbookpanel, null);
		addbookpanel.setLayout(null); 
		
		JButton addbutton = new JButton("Add");
		addbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ISBN = Integer.parseInt(ISBNfield.getText());
				String price = pricefield.getText();
				String pageorlength = pagefield.getText();
					try {
						if (intlist.getISBNlist().contains(ISBN)) {
						System.out.println("Inputted ISBN already appears in stock database.");
						JOptionPane.showMessageDialog(frame, "Inputted ISBN already appears in stock database.","Error", JOptionPane.ERROR_MESSAGE);
						}
						else if (CheckifString.isNumeric(price) == false || CheckifString.isNumeric(pageorlength)  == false) {
							System.out.println("Price and Page Length / Duration must be numbers.");
							JOptionPane.showMessageDialog(frame, "Price and Page Length / Duration must be numbers","Error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							String booktype = booktypefield.getText().trim();
							String title = titlefield.getText().trim();
							String lang = langfield.getText().trim();
							String genre = genrefield.getText().trim();
							String date = releasedatefield.getText().trim();
							int quantity = Integer.parseInt(quantityfield.getText());
							String condition = conditionfield.getText().trim();
							Book newbk = new Book(ISBN, booktype, title, lang, genre, date, price, quantity, pageorlength, condition);
							String filename= "Stock.txt";
							FileWriter fw = new FileWriter(filename,true); //the true will append the new data
							fw.write(newbk.getISBN() + ", " + newbk.getBookType() + ", " + newbk.getTitle() + ", " + newbk.getLanguage() + ", " + newbk.getGenre() + ", " + newbk.getDate() + ", " + newbk.getPrice() + ", " + newbk.getQuantity() + ", " + newbk.getAdditionalInfo1() + ", " + newbk.getAdditionalInfo2() + "\n");//appends the string to the file
							fw.close();
							System.out.println("Book successfully added");
							JOptionPane.showMessageDialog(frame,"Book successfully added.","Alert",JOptionPane.WARNING_MESSAGE); 
						}
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
		});
		addbutton.setBounds(438, 161, 89, 23);
		addbookpanel.add(addbutton);
		
		JLabel ISBNlabel = new JLabel("ISBN:");
		ISBNlabel.setBounds(10, 21, 70, 28);
		addbookpanel.add(ISBNlabel);
		
		ISBNfield = new JTextField();
		ISBNfield.setBounds(40, 25, 86, 20);
		addbookpanel.add(ISBNfield);
		ISBNfield.setColumns(10);
		
		JLabel booktypelabel = new JLabel("Book type:");
		booktypelabel.setBounds(136, 23, 82, 24);
		addbookpanel.add(booktypelabel);
		
		booktypefield = new JTextField();
		booktypefield.setBounds(196, 25, 86, 20);
		addbookpanel.add(booktypefield);
		booktypefield.setColumns(10);
		
		JLabel titlelabel = new JLabel("Title:");
		titlelabel.setBounds(311, 28, 46, 14);
		addbookpanel.add(titlelabel);
		
		titlefield = new JTextField();
		titlefield.setBounds(360, 25, 113, 20);
		addbookpanel.add(titlefield);
		titlefield.setColumns(10);
		
		JLabel langlabel = new JLabel("Language:");
		langlabel.setBounds(10, 60, 70, 20);
		addbookpanel.add(langlabel);
		
		langfield = new JTextField();
		langfield.setBounds(80, 60, 86, 20);
		addbookpanel.add(langfield);
		langfield.setColumns(10);
		
		JLabel genrelable = new JLabel("Genre:");
		genrelable.setBounds(236, 63, 46, 14);
		addbookpanel.add(genrelable);
		
		genrefield = new JTextField();
		genrefield.setBounds(291, 60, 86, 20);
		addbookpanel.add(genrefield);
		genrefield.setColumns(10);
		
		JLabel releasedatelabel = new JLabel("Release Date (DD-MM-YYYY):");
		releasedatelabel.setBounds(10, 91, 175, 28);
		addbookpanel.add(releasedatelabel);
		
		releasedatefield = new JTextField();
		releasedatefield.setBounds(169, 95, 113, 20);
		addbookpanel.add(releasedatefield);
		releasedatefield.setColumns(10);
		
		JLabel pricelabel = new JLabel("Price:");
		pricelabel.setBounds(331, 98, 46, 14);
		addbookpanel.add(pricelabel);
		
		pricefield = new JTextField();
		pricefield.setBounds(387, 95, 86, 20);
		addbookpanel.add(pricefield);
		pricefield.setColumns(10);
		
		JLabel pagelabel = new JLabel("Number of Pages/Listening Length:");
		pagelabel.setBounds(10, 126, 243, 28);
		addbookpanel.add(pagelabel);
		
		pagefield = new JTextField();
		pagefield.setBounds(206, 130, 86, 20);
		addbookpanel.add(pagefield);
		pagefield.setColumns(10);
		
		JLabel conditionlabel = new JLabel("Condition/Format:");
		conditionlabel.setBounds(10, 165, 116, 14);
		addbookpanel.add(conditionlabel);
		
		conditionfield = new JTextField();
		conditionfield.setBounds(132, 162, 86, 20);
		addbookpanel.add(conditionfield);
		conditionfield.setColumns(10);
		
		JLabel quantitylabel = new JLabel("Quantity:");
		quantitylabel.setBounds(311, 133, 70, 14);
		addbookpanel.add(quantitylabel);
		
		quantityfield = new JTextField();
		quantityfield.setBounds(387, 130, 86, 20);
		addbookpanel.add(quantityfield);
		quantityfield.setColumns(10);
	}

	private JTable booktable;
}
