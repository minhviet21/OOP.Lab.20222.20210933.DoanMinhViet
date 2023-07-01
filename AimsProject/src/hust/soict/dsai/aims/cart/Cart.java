package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.naming.LimitExceededException;

public class Cart {	
	public ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	private int MAX_NUMBERS_ORDERED = 20;
	public void addMedia(Media media) throws LimitExceededException{
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			int i = 0;
		    for(Media me : itemsOrdered) {
			    if (me.equals(media)) {
				    i++;
			        System.out.println("Media is already in the list");
			        break;
			    }
		    }
		    if (i == 0) {
			    itemsOrdered.add(media);
			    System.out.println("Added successfully");
		    }
		}
		else {
			throw new LimitExceededException("ERROR: the number of medias exceeds cart's limit");
		}
	}
	public void removeMedia(Media media) {
		int i = 0;
		for(Media me : itemsOrdered) {
			if (me.equals(media)) {
				i++;
				itemsOrdered.remove(media);
			    System.out.println("Removed successfully");
			    break;
			}
		}
		if (i == 0) {
			System.out.println("Media is not in the list");
		}
	}
	public float totalCost() { 	
		float cost = 0; 
		for (Media media : itemsOrdered) {
			cost += media.getCost();
		}
		return cost;
    } 
    public void print() {
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	int i = 0;
    	for (Media media : itemsOrdered) {
    		i++;
    		System.out.println((i) + media.toString());
    	}
    	System.out.println("Total cost: "+ totalCost());
    	System.out.println("***************************************************");
    }
    public void search(String title) {
    	int searchResult = 0;
    	System.out.println("Searching result:");
    	for (Media media : itemsOrdered) {
    		if (media.isMatch(title)) {
    			searchResult++;
    			System.out.println(searchResult + media.toString());
    		}
    	}
    	if (searchResult == 0) {
    		System.out.print("No match is found");
    	}
    }
    public void search(int id) {
    	int searchResult = 0;
    	System.out.println("Searching result:");
    	for (Media media : itemsOrdered) {
    		if (media.isMatch(id)) {
    			searchResult++;
    			System.out.println(searchResult + media.toString());
    		}
    	}
    	if (searchResult == 0) {
    		System.out.print("No match is found");
    	}
    }
    public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
}
