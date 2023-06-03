package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.List;
public class Cart {	
	public List<Media> itemsOrder = new ArrayList<Media>();
	public void addMedia(Media media) {
		int i = 0;
		for(Media me : itemsOrder) {
			if (me.equals(media)) {
				i++;
			    System.out.println("Media is already in the list");
			    break;
			}
		}
		if (i == 0) {
			itemsOrder.add(media);
			System.out.println("Added successfully");
		}
	}
	public void removeMedia(Media media) {
		int i = 0;
		for(Media me : itemsOrder) {
			if (me.equals(media)) {
				i++;
				itemsOrder.remove(media);
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
		for (Media media : itemsOrder) {
			cost += media.getCost();
		}
		return cost;
    } 
    public void print() {
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	int i = 0;
    	for (Media media : itemsOrder) {
    		i++;
    		System.out.println((i) + media.toString());
    	}
    	System.out.println("Total cost: "+ totalCost());
    	System.out.println("***************************************************");
    }
    public void search(String title) {
    	int searchResult = 0;
    	System.out.println("Searching result:");
    	for (Media media : itemsOrder) {
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
    	for (Media media : itemsOrder) {
    		if (media.isMatch(id)) {
    			searchResult++;
    			System.out.println(searchResult + media.toString());
    		}
    	}
    	if (searchResult == 0) {
    		System.out.print("No match is found");
    	}
    }
}
