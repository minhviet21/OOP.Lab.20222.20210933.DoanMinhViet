package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfLength;
    private JTextField tfDirector;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store,cart);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Add DVD Screen");
        setSize(1300, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createCenter() {
        JPanel tfPanel = new JPanel();
        tfPanel.setLayout(new GridLayout(3, 1, 3, 3));
        tfPanel.setBorder(BorderFactory.createEmptyBorder(0, 25, 25, 25));
        Font font = new Font("MS Sans Serif", Font.BOLD, 50);
        Font font2 = new Font("MS Sans Serif", Font.PLAIN, 30);

        JLabel titleLabel = new JLabel("Title ");
        titleLabel.setFont(font);
        JLabel costLabel = new JLabel("Cost ");
        costLabel.setFont(font);
        JLabel categoryLabel = new JLabel("Category ");
        categoryLabel.setFont(font);
        JLabel directorLabel = new JLabel("Director ");
        directorLabel.setFont(font);
        JLabel lengthLabel = new JLabel("Length ");
        lengthLabel.setFont(font);

        tfTitle = new JTextField(10);
        tfTitle.setFont(font2);
        tfCost = new JTextField(10);
        tfCost.setFont(font2);
        tfCategory = new JTextField(10);
        tfCategory.setFont(font2);
        tfDirector = new JTextField(10);
        tfDirector.setFont(font2);
        tfLength = new JTextField(10);
        tfLength.setFont(font2);

        tfPanel.add(titleLabel);
        tfPanel.add(tfTitle);
        tfPanel.add(costLabel);
        tfPanel.add(tfCost);
        tfPanel.add(categoryLabel);
        tfPanel.add(tfCategory);
        tfPanel.add(directorLabel);
        tfPanel.add(tfDirector);
        tfPanel.add(lengthLabel);
        tfPanel.add(tfLength);

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
 
        addButton = new JButton("Add DVD to Store");
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

            if(button.equals("Add DVD to Store")) {
                JOptionPane.showMessageDialog(null,"DVD " + tfTitle.getText() +  " is added successfully", "Add DVD", JOptionPane.INFORMATION_MESSAGE);

                store.addMedia(new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), tfDirector.getText(), Integer.parseInt(tfLength.getText()), Float.parseFloat(tfCost.getText())));
                tfTitle.setText("");
                tfCategory.setText("");
                tfCost.setText("");
                tfLength.setText("");
                tfDirector.setText("");
            }
        }
    }

}