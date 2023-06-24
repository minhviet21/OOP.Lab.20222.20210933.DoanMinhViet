package hust.soict.dsai.aims;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.store.*;
import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
public class Aims {
	public Store store;
	public Cart cart;
	public String num;
	public String title;
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}	 
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	public static void updateStoreMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add media to store");
		System.out.println("2. Remove media in store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	public static void filterMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by ID");
		System.out.println("2. Filter by title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	public static void sortMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	
	public static void filterById(Cart cart) {
		while (true) {
			System.out.println("Please enter an Id");
			Scanner scanner = new Scanner(System.in);
			int id = scanner.nextInt();
	    	System.out.println("");
	    	int count = 0;
	    	for (Media media : cart.getItemsOrdered()) {
	    		if (media.getId() == id) {
	    			System.out.println(media.toString());
	    			System.out.println("--------------------------------");
	    		    count ++;
	    			break;
	    		}
	    	}
	    	if (count == 0) { System.out.println("No media has this id"); }
	    	else { break; }
		}
	}
	public static void filterByTilte(Cart cart) {
		while (true) {
			System.out.println("Please enter a title");
			Scanner scanner = new Scanner(System.in);
			String title = scanner.nextLine();
	    	System.out.println("");
	    	int count = 0;
	    	for (Media media : cart.getItemsOrdered()) {
	    		if (media.getTitle().equals(title)) {
	    			System.out.println(media.toString());
	    			System.out.println("--------------------------------");
	    		    count ++;
	    			break;
	    		}
	    	}
	    	if (count == 0) { System.out.println("No media has this title"); }
	    	else { break; }
		}
	}
	public static void sortByTitle(Cart cart) {		
		Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST );
		System.out.println("Sort by title:");
		System.out.println("--------------------------------");
		for (Media media : cart.getItemsOrdered()) {
			System.out.println(media.getTitle()+" - "+media.getCost());
		}
		System.out.println("--------------------------------");
	}
	public static void sortByCost(Cart cart) {
		Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE );
		System.out.println("Sort by cost:");
		System.out.println("--------------------------------");
		for (Media media : cart.getItemsOrdered()) {
			System.out.println(media.getTitle()+" - "+media.getCost());
		}
		System.out.println("--------------------------------");
	}
	public static void addToCart(Media media, Cart cart) throws LimitExceededException {
		cart.addMedia(media);
		System.out.println("--------------------------------");
	}
	public static void play(Media media) {
		if (media instanceof DigitalVideoDisc) {
		    DigitalVideoDisc dvd =  (DigitalVideoDisc) media;
		    dvd.play();
		    System.out.println("--------------------------------");
	    }
	    else if (media instanceof CompactDisc) {
		    CompactDisc cd = (CompactDisc) media;
		    cd.play();
		    System.out.println("--------------------------------");
	    }
	    else {
		    System.out.println("Only DVD and CD and play");
	    }
	}
	
	public static void seeAMediaDetail(Cart cart, Store store) throws LimitExceededException {	
		while (true) {
			System.out.println("Please enter a title");
			Scanner scanner = new Scanner(System.in);
			String title = scanner.nextLine();
	    	System.out.println("");
	    	int count = 0;
	    	for (Media media : store.itemsInStore) {
	    		if (media.getTitle().equals(title)) {
	    			while (true) {
	    				System.out.println("Media's details:");
		    			System.out.println(media.toString());
		    			System.out.println("--------------------------------");
		    			mediaDetailsMenu();
		    			String num = scanner.nextLine();
		            	System.out.println("");
		            	if (num.equals("0")) { break; }
		        		else if (num.equals("1")) { addToCart(media, cart); }		   
		        		else if (num.equals("2")) { play(media); }
		        		else {
		        			System.out.println("Invalid! Please choose a number: 0-1-2-3");
		    			    num = scanner.nextLine();
		    			    System.out.println("");
		        		}
	    			}
	    			count ++;
	    		}
	    	}
	    	if (count == 0) { System.out.println("No media has this title"); }
	    	else { break; }
	   
		}
	}
	public static void addAMediaToCart(Cart cart, Store store) throws LimitExceededException {
		while (true) {
			System.out.println("Please enter a title");
			Scanner scanner = new Scanner(System.in);
			String title = scanner.nextLine();
	    	System.out.println("");
	    	int count = 0;
	    	for (Media media : store.itemsInStore) {
	    		if (media.getTitle().equals(title)) {
	    			cart.addMedia(media);
	    			System.out.println("--------------------------------");
	    		    count ++;
	    			break;
	    		}
	    	}
	    	if (count == 0) { System.out.println("No media has this title"); }
	    	else { break; }
		}
	}
	public static void playAMediaInStore(Cart cart, Store store) {
		while (true) {
			System.out.println("Please enter a title");
			Scanner scanner = new Scanner(System.in);
			String title = scanner.nextLine();
	    	System.out.println("");
	    	int count = 0;
	    	for (Media media : store.itemsInStore) {
	    		if (media.getTitle().equals(title)) {
	    			if (media instanceof DigitalVideoDisc) {
	    			    DigitalVideoDisc dvd =  (DigitalVideoDisc) media;
	    			    dvd.play();
	    			    System.out.println("--------------------------------");
	    		    }
	    		    else if (media instanceof CompactDisc) {
	    			    CompactDisc cd = (CompactDisc) media;
	    			    cd.play();
	    			    System.out.println("--------------------------------");
	    		    }
	    		    else {
	    			    System.out.println("Only DVD and CD and play");
	    		    }
	    		    count ++;
	    			break;
	    		}
	    	}
	    	if (count == 0) { System.out.println("No media has this title"); }
	    	else { break; }
		}
	}
	public static void seeCurrentCart(Cart cart, Store store) {
		while (true) {
			int count = 0;
	    	System.out.println("Current cart:");

	    	for (Media media : cart.getItemsOrdered()) {
	    		System.out.println(media.getTitle()+" - "+media.getCost());
	    		count ++;
	    	}
	    	if (count == 0) { System.out.println("No media in the cart"); }
	    	System.out.println("--------------------------------");	
	    	cartMenu();
	    	Scanner scanner = new Scanner(System.in);
    		String num = scanner.nextLine();
        	System.out.println("");
    		if (num.equals("0")) { break; }
    		else if (num.equals("1")) { filterMediasInCart(cart); }		   
    		else if (num.equals("2")) { sortMediasInCart(cart); }
    		else if (num.equals("3")) { removeMediasFromCart(cart); }
    		else if (num.equals("4")) { playAMediaInStore(cart,store); }
    		else if (num.equals("5")) { placeOrder(cart); }
    		else {
    			System.out.println("Invalid! Please choose a number: 0-1-2-3-4-5");
			    num = scanner.nextLine();
			    System.out.println("");
    		}
		}
	}
	
	public static void addMediaToStore(Store store) {
			
	}
	public static void removeMediaInStore(Store store) {
		while (true) {
			System.out.println("Please enter a title");
			Scanner scanner = new Scanner(System.in);
			String title = scanner.nextLine();
	    	System.out.println("");
	    	int count = 0;
	    	for (Media media : store.itemsInStore) {
	    		if (media.getTitle().equals(title)) {
	    			store.removeMedia(media);
	    			System.out.println("--------------------------------");
	    		    count ++;
	    			break;
	    		}
	    	}
	    	if (count == 0) { System.out.println("No media in the store has this title"); }
	    	else { break; }
		}
	}
	
	public static void filterMediasInCart(Cart cart) {
		while (true) {
			filterMenu();
			Scanner scanner = new Scanner(System.in);
			String num = scanner.nextLine();
			System.out.println("");
			if (num.equals("0")) { break; 	}
			else if (num.equals("1")) { filterById(cart); 	}
			else if (num.equals("2")) { filterByTilte(cart); }
			else { 
	    	    System.out.println("Invalid! Please choose a number: 0-1-2");
		        num = scanner.nextLine();
		        System.out.println("");
			}
		}
	}
	public static void sortMediasInCart(Cart cart) {
		while (true) {
			sortMenu();
			Scanner scanner = new Scanner(System.in);
			String num = scanner.nextLine();
			System.out.println("");
			if (num.equals("0")) { break; 	}
			else if (num.equals("1")) { sortByTitle(cart); 	}
			else if (num.equals("2")) { sortByCost(cart); }
			else { 
	    	    System.out.println("Invalid! Please choose a number: 0-1-2");
		        num = scanner.nextLine();
		        System.out.println("");
			}
		}
	}
	public static void removeMediasFromCart(Cart cart) {
		while (true) {
			System.out.println("Please enter a title");
			Scanner scanner = new Scanner(System.in);
			String title = scanner.nextLine();
	    	System.out.println("");
	    	int count = 0;
	    	for (Media media : cart.getItemsOrdered()) {
	    		if (media.getTitle().equals(title)) {
	    			cart.removeMedia(media);
	    			System.out.println("--------------------------------");
	    		    count ++;
	    			break;
	    		}
	    	}
	    	if (count == 0) { System.out.println("No media in the cart has this title"); }
	    	else { break; }
		}
	}
	public static void playAMediaInCart(Cart cart) {
		while (true) {
			System.out.println("Please enter a title");
			Scanner scanner = new Scanner(System.in);
			String title = scanner.nextLine();
	    	System.out.println("");
	    	int count = 0;
	    	for (Media media : cart.getItemsOrdered()) {
	    		if (media.getTitle().equals(title)) {
	    			if (media instanceof DigitalVideoDisc) {
	    			    DigitalVideoDisc dvd =  (DigitalVideoDisc) media;
	    			    dvd.play();
	    			    System.out.println("--------------------------------");
	    		    }
	    		    else if (media instanceof CompactDisc) {
	    			    CompactDisc cd = (CompactDisc) media;
	    			    cd.play();
	    			    System.out.println("--------------------------------");
	    		    }
	    		    else {
	    			    System.out.println("Only DVD and CD and play");
	    		    }
	    		    count ++;
	    			break;
	    		}
	    	}
	    	if (count == 0) { System.out.println("No media has this title"); }
	    	else { break; }
		}
	}
    public static void placeOrder(Cart cart) {
    	for (Media media : cart.getItemsOrdered()) {
    		cart.removeMedia(media);
    	System.out.println("An order is created and empty the current cart");
    	}
	}
	
	public static void viewStore(Cart cart, Store store) throws LimitExceededException {
    	while (true) {
    		System.out.println("All medias in store:");
        	System.out.println("--------------------------------");
    		for (Media media : store.itemsInStore) {
    			System.out.println(media.getTitle()+" - "+media.getCost());
    		}
    		System.out.println("--------------------------------");
    		storeMenu();
    		Scanner scanner = new Scanner(System.in);
    		String num = scanner.nextLine();
        	System.out.println("");
    		if (num.equals("0")) { break; }
    		else if (num.equals("1")) { seeAMediaDetail(cart, store); }		   
    		else if (num.equals("2")) { addAMediaToCart(cart, store); }
    		else if (num.equals("3")) { playAMediaInStore(cart, store); }
    		else if (num.equals("4")) { seeCurrentCart(cart, store); }
    		else {
    			System.out.println("Invalid! Please choose a number: 0-1-2-3-4");
			    num = scanner.nextLine();
			    System.out.println("");
    		}
		}
	}
	public static void updateStore(Cart cart, Store store) {
		while (true) {
			updateStoreMenu();
    		Scanner scanner = new Scanner(System.in);
    		String num = scanner.nextLine();
        	System.out.println("");
    		if (num.equals("0")) { break; }
    		else if (num.equals("1")) { addMediaToStore(store); }		   
    		else if (num.equals("2")) { removeMediaInStore(store); }
    		else {
    			System.out.println("Invalid! Please choose a number: 0-1-2-3");
			    num = scanner.nextLine();
			    System.out.println("");
    		}
		}
	}
	public static void main(String[] arg) throws LimitExceededException {
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 9.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Jurassic Park", "Science fiction/Adventure", "Steven Spielberg", 127, 12.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Jaws", "Thriller", "Steven Spielberg", 124, 7.99f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Forrest Gump", "Comedy-drama", "Robert Zemeckis", 142, 8.99f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Silence of the Lambs", "Thriller", "Jonathan Demme", 118, 11.99f);
		store.itemsInStore.add(dvd1);
		store.itemsInStore.add(dvd2);
		store.itemsInStore.add(dvd3);
		store.itemsInStore.add(dvd4);
		store.itemsInStore.add(dvd5);
		store.itemsInStore.add(dvd6);
		store.itemsInStore.add(dvd7);
		Cart cart = new Cart();
		while (true) {
			showMenu();
			Scanner scanner = new Scanner(System.in);
			String num = scanner.nextLine();
			System.out.println("");
			if (num.equals("0")) { break; 	}
			else if (num.equals("1")) { viewStore(cart, store); 	}
			else if (num.equals("2")) { updateStore(cart, store); }
			else if (num.equals("3")) { seeCurrentCart(cart, store);}
			else { 
	    	    System.out.println("Invalid! Please choose a number: 0-1-2-3");
		        num = scanner.nextLine();
		        System.out.println("");
			}
		}
	}
}