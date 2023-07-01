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

import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;
	JButton btnPlay = new JButton("Play");
	JButton btnAdd = new JButton("Add to cart");

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
		container.add(btnAdd);
		btnAdd.addActionListener(btnListener);
		if (media instanceof Playable) {
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
					try {
						cart.addMedia(media);
					} catch (LimitExceededException e1) {
						e1.printStackTrace();
					}
				
	        }
	        else if (e.getActionCommand().equals("Play") ) {
	        	JDialog plays = new JDialog();
	        	JTextArea label = new JTextArea(((Playable) media).play());
	        	plays.setLayout(new FlowLayout());
	        	plays.setTitle("Playing");
	        	plays.add(label);
		
				plays.add(new JLabel());
				plays.pack();
				plays.setVisible(true);
	        }
	    }
	}

}
