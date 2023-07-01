package hust.soict.dsai.aims.screen;
import java.awt.Window;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Store store;
	private Cart cart;
	
	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediacategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
	@FXML
	private ToggleGroup filterCategory;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;
	
	@FXML
    private TextField tfFilter;
	
	@FXML
    private RadioButton radioBtnFilterId;
	
    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    public Label btnTotalCost;
	private Window window;
	
	public CartScreenController(Store store, Cart cart) {
		super();
		this.store = store;
		this.cart = cart;
	}
	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
	    
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		btnTotalCost.setText(this.cart.totalCost() + "$");
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				if (newValue!=null) {
					updateButtonBar(newValue);
				}
			}	
		});
	}

	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}

	@FXML
	void btnRemoveAction(ActionEvent e) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		btnTotalCost.setText(this.cart.totalCost() + "$");
	}
	
	@FXML
	void btnPlayAction(ActionEvent e) throws PlayerException {
		Dialog<String> mediaplay = new Dialog<>();
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		mediaplay.setTitle("Playing");
		mediaplay.setContentText(((Playable) media).play());
		mediaplay.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		mediaplay.showAndWait();
	}
	
	@FXML 
	void btnPlaceOrderAction(ActionEvent e) {
		Dialog<String> order = new Dialog<>();
		order.setTitle("Place Order");
		if (cart.itemsOrdered.size() > 0) {
			order.setContentText("An order is created");
		}
		else {
			order.setContentText("The current cart is empty");
		}
		ButtonType done = new ButtonType("Ok", ButtonData.OK_DONE);
		order.getDialogPane().getButtonTypes().add(done);
		order.show();
	}
	
	@FXML
	void menuOptionAction(ActionEvent e) {
		MenuItem m = (MenuItem)e.getSource();
		if (m.getText().equals("Add Book")) {
			new AddBookToStoreScreen(store, cart);
			window.dispose();
		}
		else if (m.getText().equals("Add CD")) {
			new AddCompactDiscToStoreScreen(store, cart);
			window.dispose();
		}
		else if (m.getText().equals("Add DVD")) {
			new AddDigitalVideoDiscToStoreScreen(store, cart);
			window.dispose();
		}
		else if (m.getText().equals("View Store")) {
			new StoreScreen(store, cart);
			window.dispose();
		}
		else if (m.getText().equals("View Cart")) {
			new CartScreen(store,cart);
			window.dispose();
		}
	}

	public void setWindow(Window window) {
		this.window = window;
		
	}
	
	
}
