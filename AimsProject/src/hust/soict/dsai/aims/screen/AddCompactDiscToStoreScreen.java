package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist;
    private JTextField tfTrackList;
    private JTextField tfLength;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store,cart);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Add CD Screen");
        setSize(1300, 700);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    
    JPanel createCenter() {
        JPanel tfPanel = new JPanel();
        tfPanel.setLayout(new GridLayout(3, 1, 3, 3));
        tfPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        Font font = new Font("MS Sans Serif", Font.BOLD, 50);
        Font font2 = new Font("MS Sans Serif", Font.PLAIN, 30);
        
        JLabel titleLabel = new JLabel("Title ");
        titleLabel.setFont(font);
        JLabel costLabel = new JLabel("Cost ");
        costLabel.setFont(font);
        JLabel categoryLabel = new JLabel("Category ");
        categoryLabel.setFont(font);
        JLabel artistLabel = new JLabel("Artist ");
        artistLabel.setFont(font);
        JLabel trackListLabel = new JLabel("Tracks ");
        trackListLabel.setFont(font);
        JLabel lengthLabel = new JLabel("Length ");
        lengthLabel.setFont(font);

        tfTitle = new JTextField(10);
        tfTitle.setFont(font2);
        tfCost = new JTextField(10);
        tfCost.setFont(font2);
        tfCategory = new JTextField(10);
        tfCategory.setFont(font2);
        tfArtist = new JTextField(10);
        tfArtist.setFont(font2);
        tfTrackList = new JTextField(10);
        tfTrackList.setFont(font2);
        tfLength = new JTextField(10);
        tfLength.setFont(font2);

        tfPanel.add(titleLabel);
        tfPanel.add(tfTitle);
        tfPanel.add(costLabel);
        tfPanel.add(tfCost);
        tfPanel.add(categoryLabel);
        tfPanel.add(tfCategory);
        tfPanel.add(artistLabel);
        tfPanel.add(tfArtist);
        tfPanel.add(trackListLabel);
        tfPanel.add(tfTrackList);
        tfPanel.add(lengthLabel);
        tfPanel.add(tfLength);

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0,25,25,25));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
      
        addButton = new JButton("Add CD to Store");
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
            ArrayList<Track> CDTrackList = new ArrayList<>();

            for(int i=0; i < Arrays.asList(tfTrackList.getText().split("\\s*,\\s*")).size(); i++) {
                CDTrackList.add(new Track(Arrays.asList(tfTrackList.getText().split("\\s*,\\s*")).get(i), i));
            }

            if(button.equals("Add CD to Store")) {
                JOptionPane.showMessageDialog(null,"CD " + tfTitle.getText() + " is added successfully", "Add CD", JOptionPane.INFORMATION_MESSAGE);
                store.addMedia(new CompactDisc(tfTitle.getText(),
                        tfCategory.getText(),
                        tfArtist.getText(),"1",
                        Integer.parseInt(tfLength.getText()),
                        Float.parseFloat(tfCost.getText()),
                         CDTrackList));
                tfTitle.setText("");
                tfCategory.setText("");
                tfCost.setText("");
                tfTrackList.setText("");
                tfArtist.setText("");
                tfLength.setText("");
            }
        }
    }

}