package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;

	public MediaStore(Media media, Cart cart) {		
		this.media = media;
		this.cart = cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		ButtonListener btnListener = new ButtonListener();
		JButton btnAdd = new JButton("Add to cart");
		container.add(btnAdd);
		btnAdd.addActionListener(btnListener);
		if (media instanceof Playable) {
			JButton btnPlay = new JButton("Play");
			container.add(btnPlay);
			btnPlay.addActionListener(btnListener);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private class ButtonListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        if (e.getActionCommand().equals("Add to cart")) {
				cart.addMedia(media);
	        }
	        else if (e.getActionCommand().equals("Play") ) {
	            ((Playable) media).play();
	        }
	    }
	}
	
	public static void main(String[] args) {
		Cart cart = new Cart();
		CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", "John Landis", 42, 14.99f,
				new ArrayList<>(Arrays.asList(new Track("Wanna Be Startin' Somethin'", 6),
						new Track("Thriller", 5),
						new Track("Beat It", 4),
						new Track("Billie Jean", 5))));
		MediaStore ms = new MediaStore(cd1, cart);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(ms, BorderLayout.CENTER);
		frame.setVisible(true);
	}

}
