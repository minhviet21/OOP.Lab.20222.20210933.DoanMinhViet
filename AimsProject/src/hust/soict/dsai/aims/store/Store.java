package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.*;
public class Store {
	private static int MAX_NUMBERS_ITEMS = 20;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[10000];
	private int qtyItems = 0;
	
	public void addDVD(DigitalVideoDisc dvd) {	
	    if (qtyItems < MAX_NUMBERS_ITEMS) {
	    		itemsInStore[qtyItems] = dvd;    			
	    		qtyItems += 1;
	    		System.out.println("The dvd has been added");
	    	}
	    else {
	    	System.out.println("The store is almost full");
	    }
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
    	for (int i = 0; i < qtyItems; i++) {
    		if (itemsInStore[i].equalsto(dvd)) {
    			for (int j = i; j < qtyItems-1;j++) {
    				itemsInStore[j] = itemsInStore[j+1];
    			    System.out.println("The disc has been removed");
    			}
    			itemsInStore[qtyItems-1] = null;
    			break;
    		}
    	}
    	qtyItems -= 1;
    }

}