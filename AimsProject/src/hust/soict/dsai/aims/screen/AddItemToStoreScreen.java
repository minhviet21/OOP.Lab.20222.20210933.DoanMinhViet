package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart;
    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;
    protected JButton addButton;
	

	public Store getStore() {
		return this.store;
	}
	
	public Cart getCart() {
		return this.cart;
	}
	
    public AddItemToStoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        setTitle("Add Item Screen");
        setSize(1300, 700);
		setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
    
    JPanel createHeader() {
		
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		
		return header;
}
}