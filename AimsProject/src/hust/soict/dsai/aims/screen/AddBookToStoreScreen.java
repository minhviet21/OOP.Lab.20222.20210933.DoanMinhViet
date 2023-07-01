package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.DataConstraintsException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store,cart);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Add Book Screen");
        setSize(1300, 700);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    JPanel createCenter() {
        JPanel tfPanel = new JPanel();
        tfPanel.setLayout(new GridLayout(2, 2, 3, 3));
        tfPanel.setBorder(BorderFactory.createEmptyBorder(0, 25, 25, 25));
        Font font = new Font("MS Sans Serif", Font.BOLD, 50);
        Font font2 = new Font("MS Sans Serif", Font.PLAIN, 30);
        
        JLabel titleLabel = new JLabel("Title ");
        titleLabel.setFont(font);
        JLabel costLabel = new JLabel("Cost ");
        costLabel.setFont(font);
        JLabel categoryLabel = new JLabel("Category ");
        categoryLabel.setFont(font);
        JLabel authorsLabel = new JLabel("Authors ");
        authorsLabel.setFont(font);

        tfTitle = new JTextField(10);
        tfTitle.setFont(font2);
        tfCost = new JTextField(10);
        tfCost.setFont(font2);
        tfCategory = new JTextField(10);
        tfCategory.setFont(font2);
        tfAuthors = new JTextField(10);
        tfAuthors.setFont(font2);

        tfPanel.add(titleLabel);
        tfPanel.add(tfTitle);
        tfPanel.add(costLabel);
        tfPanel.add(tfCost);
        tfPanel.add(categoryLabel);
        tfPanel.add(tfCategory);
        tfPanel.add(authorsLabel);
        tfPanel.add(tfAuthors);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        addButton = new JButton("Add Book to Store");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ButtonListener btnListener = new ButtonListener();
        addButton.addActionListener(btnListener);

        mainPanel.add(tfPanel);
        mainPanel.add(addButton);

        return mainPanel;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            ArrayList<String> CDAuthorsList = new ArrayList<String>();

            for(int i=0; i < Arrays.asList(tfAuthors.getText().split("\\s*,\\s*")).size(); i++) {
                CDAuthorsList.add(new String(Arrays.asList(tfAuthors.getText().split("\\s*,\\s*")).get(i)));
            }

            if(button.equals("Add Book to Store")) {
                JOptionPane.showMessageDialog(null,"Book " + tfTitle.getText() + " is added successfully", "Add Book", JOptionPane.INFORMATION_MESSAGE);
                store.addMedia(new Book(tfTitle.getText(),
                        tfCategory.getText(),
                        Float.parseFloat(tfCost.getText()),
                        CDAuthorsList));
                tfTitle.setText("");
                tfCategory.setText("");
                tfCost.setText("");
                tfAuthors.setText("");
            }
        }
    }
}
