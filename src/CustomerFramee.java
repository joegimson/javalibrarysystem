import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerFramee extends JFrame {
	private DefaultTableModel booktablecol;
	private int columnselected;
	private int newquantity;
	private Object ISBNval;
	private Object Quantityval;
	private Object Titleval;
	private Object Priceval;
	private Object Langval;
	private Object Genreval;
	private Object Dateval;
	private Object AddInfoval;
	private Object AddInfo2val;
	private Object BookTypeval;
	private JPanel contentPane;
	private JTable booktable;
	private JTextArea textArea;
	private ArrayList<String> ISBNlist;
	private ArrayList<String> quantitylist;
	private ArrayList<String> pricelist;
	private ArrayList<Float> totalpricelist;
	private ArrayList<String> Titlelist;
	private ArrayList<String> Langlist;
	private ArrayList<String> Genrelist;
	private ArrayList<String> Datelist;
	private ArrayList<String> newquantlist;
	private ArrayList<String> AddInfolist;
	private ArrayList<String> AddInfo2list;
	private ArrayList<String> BookTypelist;
	private ArrayList<String> oldquantlist;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFramee frame = new CustomerFramee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerFramee() {
		setTitle("Customer Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1065, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		booktablecol = new DefaultTableModel();
		booktablecol.setColumnIdentifiers(new Object[] {"ISBN", "Book Type", "Title", "Language", "Genre", "Release Date", "Price", "Quantity", "Page Length or Duration", "Condition or File Format"} );
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1049, 335);
		contentPane.add(tabbedPane);
		
		JPanel viewpanel = new JPanel();
		tabbedPane.addTab("View Books", null, viewpanel, null);
		viewpanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 903, 307);
		viewpanel.add(scrollPane);
		
		booktable = new JTable();
		scrollPane.setViewportView(booktable);
		
		JButton viewbooksbtn = new JButton("View Books");
		viewbooksbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (Book b: ReadBooks.test()) {
						Object[] rowdata = new Object[] {b.getISBN(),b.getBookType(), b.getTitle(), b.getLanguage(), b.getGenre(), b.getDate(), b.getPrice(), b.getQuantity(), b.getAdditionalInfo1(), b.getAdditionalInfo2()};
						booktablecol.addRow(rowdata);
}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		viewbooksbtn.setBounds(913, 23, 121, 54);
		viewpanel.add(viewbooksbtn);
		
		ISBNlist = new ArrayList<String>();
		quantitylist = new ArrayList<String>();
		pricelist = new ArrayList<String>();
		totalpricelist = new ArrayList<Float>();
		Titlelist = new ArrayList<String>();
		Langlist = new ArrayList<String>();
		Genrelist = new ArrayList<String>();
		Datelist = new ArrayList<String>();
		newquantlist = new ArrayList<String>();
		AddInfolist = new ArrayList<String>();
		AddInfo2list = new ArrayList<String>();
		BookTypelist = new ArrayList<String>();
		oldquantlist = new ArrayList<String>();
		
		JButton addtocartbtn = new JButton("Add to Cart");
		addtocartbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				columnselected = booktable.getSelectedRow();
				ISBNval = booktablecol.getValueAt(columnselected, 0);
				BookTypeval = booktablecol.getValueAt(columnselected, 1);
				Titleval = booktablecol.getValueAt(columnselected, 2);
				Langval = booktablecol.getValueAt(columnselected, 3);
				Genreval = booktablecol.getValueAt (columnselected, 4);
				Dateval = booktablecol.getValueAt(columnselected, 5);
				Priceval = booktablecol.getValueAt(columnselected, 6);
				Quantityval = booktablecol.getValueAt(columnselected, 7);
				AddInfoval = booktablecol.getValueAt(columnselected, 8);
				AddInfo2val = booktablecol.getValueAt(columnselected, 9);
				int quantnum = (Integer)Quantityval;
				JFrame frame = new JFrame();
				String result = JOptionPane.showInputDialog(frame, "Enter Quantity:");
				Float pricenum = Float.parseFloat((String) Priceval);
				Float pricetotal = pricenum * Integer.parseInt(result);
				if(Integer.parseInt(result)  == 0) {
					System.out.println("Quantity must be more than 0.");
					JOptionPane.showMessageDialog(frame, "Quantity must be more than 0.","Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (Integer.parseInt(result) >  quantnum) {
					System.out.println("Cannot input a quantity more than what is in stock.");
					JOptionPane.showMessageDialog(frame, "Cannot input a quantity more than what is in stock.","Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (ISBNlist.contains(ISBNval.toString())) {
					System.out.println("Cannot have the same book ISBN appear twice in your cart.");
					JOptionPane.showMessageDialog(frame, "Cannot have the same book ISBN appear twice in your cart.","Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					//when a book is added to the cart all of its fields are added to different arraylists
				newquantity = quantnum - Integer.parseInt(result);
				newquantlist.add(Integer.toString(newquantity));
				Titlelist.add(Titleval.toString());
				quantitylist.add(result);
				BookTypelist.add(BookTypeval.toString());
				Genrelist.add(Genreval.toString());
				Langlist.add(Langval.toString());
				Datelist.add(Dateval.toString());
				AddInfolist.add(AddInfoval.toString());
				AddInfo2list.add(AddInfo2val.toString());
				pricelist.add(Priceval.toString());
				ISBNlist.add(ISBNval.toString());
				totalpricelist.add(pricetotal);
				oldquantlist.add(Quantityval.toString());
				//updating cart
				textArea.append(ISBNval.toString() + "              " +   Titleval.toString() + "             "  +pricetotal + "                " +  result +   "\n");
				}
			}
		});
		addtocartbtn.setBounds(913, 121, 121, 54);
		viewpanel.add(addtocartbtn);
		booktable = new JTable();
		scrollPane.setViewportView(booktable);
		booktable.setModel(booktablecol);
		JPanel cartpanel = new JPanel();
		tabbedPane.addTab("Cart", null, cartpanel, null);
		cartpanel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 5, 854, 302);
		cartpanel.add(scrollPane_1);
		
		textArea = new JTextArea("ISBN                       Title                                           Price               Quantity \n");
		scrollPane_1.setViewportView(textArea);
		
		JButton checkoutcardbtn = new JButton("Checkout with Credit Card");
		checkoutcardbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = ISBNlist.size();
				float tot = SumOfPrice.get(totalpricelist, count);
				JTextField cardno = new JTextField();
				JTextField code = new JTextField();
				Object[] message = {
				    "Enter Card Number:", cardno,
				    "Enter Security Code:", code
				};
				int option = JOptionPane.showConfirmDialog(null, message, tot +  " paid using Credit Card", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					if (cardno.getText().isEmpty() || code.getText().isEmpty() || Integer.parseInt(cardno.getText()) == 0 || Integer.parseInt(code.getText()) == 0) {
						System.out.println("Both fields must be an integer and be more than 0.");
						JOptionPane.showMessageDialog(frame, "Both fields must be an integer and be more than 0.","Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
						for (int i = 0; i < count; i++) {
						String pattern = "dd-MM-yyyy";
						String dateInString =new SimpleDateFormat(pattern).format(new Date());
						try {
							WriteToStocks.main(ISBNlist.get(i), BookTypelist.get(i), Titlelist.get(i), Langlist.get(i), Genrelist.get(i), Datelist.get(i), pricelist.get(i), AddInfolist.get(i), AddInfo2list.get(i), oldquantlist.get(i), newquantlist.get(i));
							WriteToActivityLog.main(Mainframe.userno, Mainframe.postcode, ISBNlist.get(i), pricelist.get(i), quantitylist.get(i), "purchased", "Credit Card", dateInString);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
						System.out.println("Book(s) successfully checked out");
						totalpricelist.clear();
						BookTypelist.clear();
						Titlelist.clear();
						Langlist.clear();
						Genrelist.clear();
						Datelist.clear();
						AddInfolist.clear();
						AddInfo2list.clear();
						oldquantlist.clear();
						newquantlist.clear();
						ISBNlist.clear();
						pricelist.clear();
						quantitylist.clear();
						textArea.setText("ISBN                       Title                                           Price               Quantity \n");
						JOptionPane.showMessageDialog(frame,"Book(s) successfully checked out.","Alert",JOptionPane.WARNING_MESSAGE); 
					}
				}
			}
		});
		checkoutcardbtn.setBounds(864, 23, 170, 64);
		cartpanel.add(checkoutcardbtn);
		
		JButton emptycartbtn = new JButton("Empty Cart");
		emptycartbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = ISBNlist.size();
				for (int i = 0; i < count; i++) {
					//iterates through the lists
				String pattern = "dd-MM-yyyy";
				String dateInString =new SimpleDateFormat(pattern).format(new Date());
				try {
					WriteToActivityLog.main(Mainframe.userno, Mainframe.postcode, ISBNlist.get(i), pricelist.get(i), quantitylist.get(i), "cancelled", "", dateInString);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				System.out.print("Cart successfully emptied.");
				totalpricelist.clear();
				BookTypelist.clear();
				Titlelist.clear();
				Langlist.clear();
				Genrelist.clear();
				Datelist.clear();
				AddInfolist.clear();
				AddInfo2list.clear();
				oldquantlist.clear();
				newquantlist.clear();
				ISBNlist.clear();
				pricelist.clear();
				quantitylist.clear();
				textArea.setText("ISBN                       Title                                           Price               Quantity \n");
				JOptionPane.showMessageDialog(frame,"Cart successfully emptied.","Alert",JOptionPane.WARNING_MESSAGE); 
			}
		});
		emptycartbtn.setBounds(864, 230, 170, 53);
		cartpanel.add(emptycartbtn);
		
		JButton checkoutpaypalbtn = new JButton("Checkout with PayPal");
		checkoutpaypalbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = ISBNlist.size();
				float tot = SumOfPrice.get(totalpricelist, count);
				JFrame frame = new JFrame();
				frame.setTitle("ASD");
				String pattern = "dd-MM-yyyy";
				String dateInString =new SimpleDateFormat(pattern).format(new Date());
				String email = JOptionPane.showInputDialog(frame, "Enter E-Mail:", tot + " paid using PayPal", JOptionPane.INFORMATION_MESSAGE);
				if (email.isEmpty()) {
					System.out.print("Email cannot be blank");
					JOptionPane.showMessageDialog(frame, "Email Cannot Be Blank!","Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
				for (int i = 0; i < count; i++) {
					try {
						WriteToActivityLog.main(Mainframe.userno, Mainframe.postcode, ISBNlist.get(i), pricelist.get(i), quantitylist.get(i), "purchased", "PayPal", dateInString);
						WriteToStocks.main(ISBNlist.get(i), BookTypelist.get(i), Titlelist.get(i), Langlist.get(i), Genrelist.get(i), Datelist.get(i), pricelist.get(i), AddInfolist.get(i), AddInfo2list.get(i), oldquantlist.get(i), newquantlist.get(i));
						} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						}
					}
				System.out.println("Book(s) successfully checked out");
				totalpricelist.clear();
				BookTypelist.clear();
				Titlelist.clear();
				Langlist.clear();
				Genrelist.clear();
				Datelist.clear();
				AddInfolist.clear();
				AddInfo2list.clear();
				oldquantlist.clear();
				newquantlist.clear();
				ISBNlist.clear();
				pricelist.clear();
				quantitylist.clear();
				textArea.setText("ISBN                       Title                                           Price               Quantity \n");
				JOptionPane.showMessageDialog(frame,"Book(s) successfully checked out.","Alert",JOptionPane.WARNING_MESSAGE); 
				}
					}
		});
		checkoutpaypalbtn.setBounds(864, 98, 170, 64);
		cartpanel.add(checkoutpaypalbtn);
	}
}
