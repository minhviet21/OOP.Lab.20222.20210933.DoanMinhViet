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
	private int[] frameSize = {1024, 768};

    public int[] getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(int[] frameSize) {
        this.frameSize = frameSize;
    }
	
	public StoreScreen(Store store, Cart cart2) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1300, 700);
		setLocationRelativeTo(null);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	JMenuBar createMenuBar() {
		Store store = this.store;
		Cart cart = this.cart;
		JMenu menu = new JMenu("Options");
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBookScreen = new JMenuItem("Add Book");
		addBookScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddBookToStoreScreen(store, cart);
				dispose();
			}			
		});
		smUpdateStore.add(addBookScreen);
		JMenuItem addCDScreen = new JMenuItem("Add CD");
		addCDScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCompactDiscToStoreScreen(store, cart);
				dispose();
			}			
		});
		smUpdateStore.add(addCDScreen);
		JMenuItem addDVDScreen = new JMenuItem("Add DVD");
		addDVDScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddDigitalVideoDiscToStoreScreen(store, cart);
				dispose();
			}			
		});
		smUpdateStore.add(addDVDScreen);
		menu.add(smUpdateStore);
		JMenuItem viewStoreScreen = new JMenuItem("View Store");
		viewStoreScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StoreScreen(store, cart);
				dispose();
			}			
		});
		menu.add(viewStoreScreen);
		JMenuItem viewCartScreen = new JMenuItem("View Cart");
		viewCartScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CartScreen(store, cart);
				dispose();
			}			
		});
		menu.add(viewCartScreen);
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
		
		JButton viewCart = new JButton("View cart");
		viewCart.setPreferredSize(new Dimension(100, 50));
		viewCart.setMaximumSize(new Dimension(100, 50));
		viewCart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CartScreen(store, cart);
				dispose();				
			}			
		});
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(viewCart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(4,5));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
			center.add(cell);
		}
		
		return center;
	}

	
	

}


