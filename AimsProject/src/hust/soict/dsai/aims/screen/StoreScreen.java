package hust.soict.dsai.aims.screen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
	private Store store;
	static Cart cart = new Cart();
	
	public StoreScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		JMenu smUpdateStore = new JMenu("Update Store");
		
		JMenuItem mnAddBook = new JMenuItem("Add Book");
		mnAddBook.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            AddBookToStoreScreen addBookScreen = new AddBookToStoreScreen(store);
	            /*addBookScreen.setVisible(true);*/
	        }
	    });
		
		JMenuItem mnAddCD = new JMenuItem("Add CD");
		JMenuItem mnAddDVD = new JMenuItem("Add DVD");
		smUpdateStore.add(mnAddBook);
		smUpdateStore.add(mnAddCD);
		smUpdateStore.add(mnAddDVD);
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("View cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
			center.add(cell);
		}
		
		return center;
	}

	
	public static void main(String[] args) {
		Store store = new Store();
		
		Book book1 = new Book("The Great Gatsby", "Classic", 12.99f, Arrays.asList("F. Scott Fitzgerald"));
		Book book2 = new Book("The Chronicles of Narnia", "Fantasy", 20.99f, Arrays.asList("C.S. Lewis"));
		Book book3 = new Book("Pride and Prejudice", "Romance", 14.99f, Arrays.asList("Jane Austen"));
		CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", "John Landis", 42, 14.99f,
				new ArrayList<>(Arrays.asList(new Track("Wanna Be Startin' Somethin'", 6),
						new Track("Thriller", 5),
						new Track("Beat It", 4),
						new Track("Billie Jean", 5))));
		CompactDisc cd2 = new CompactDisc("Back in Black", "Rock", "AC/DC", "Robert John 'Mutt' Lange", 42, 13.99f,
				new ArrayList<>(Arrays.asList(new Track("Hells Bells", 5),
						new Track("Shoot to Thrill", 5),
						new Track("Back in Black", 5),
						new Track("You Shook Me All Night Long", 4))));
		CompactDisc cd3 = new CompactDisc("1989", "Pop", "Taylor Swift", "Joseph Kahn", 48, 15.99f,
				new ArrayList<>(Arrays.asList(new Track("Welcome to New York", 3),
				new Track("Blank Space", 4),
				new Track("Style", 4),
				new Track("Shake It Off", 4))));
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 12.99f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 9.99f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Jurassic Park", "Science Fiction", "Steven Spielberg", 127, 8.99f);
		
		store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        new StoreScreen(store);
        new CartScreen(cart);
    
	}
}
