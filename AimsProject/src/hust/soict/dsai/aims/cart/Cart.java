package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.*;
public class Cart {	
    private static int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrder[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
    public void addDigitalVideoDisc(DigitalVideoDisc disc){	
    	if (qtyOrdered < MAX_NUMBERS_ORDERED) {
    		itemsOrder[qtyOrdered] = disc;    			
    		qtyOrdered += 1;
    		System.out.println("The disc has been added");
    	}
    	else {
    		System.out.println("The cart is almost full");
    	}
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
    	if (dvdList.length + qtyOrdered <= MAX_NUMBERS_ORDERED) {
    		for (int i = 0; i < dvdList.length; i++) {
    			itemsOrder[qtyOrdered + i] = dvdList[i]; 
    		}
    		qtyOrdered += dvdList.length;
    		System.out.println("The discs have been added");
    	}
    	else {
    		System.out.println("Too much discs. Can not add all of them");
    	}
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
    	if (qtyOrdered +2 <= MAX_NUMBERS_ORDERED) { 
    		itemsOrder[qtyOrdered] = dvd1; 
    		itemsOrder[qtyOrdered + 1] = dvd2; 
    		qtyOrdered += 2;
    		System.out.println("The discs have been added");
    	}
    	else {
    		System.out.println("Too much discs. Can not add all of them");
    	}
    }
    
	public float totalCost() { 	
		float cost = 0; 
		for (int i = 0; i < qtyOrdered; i++) {
			cost += itemsOrder[i].getCost();
		}
		return cost;
    } 
	
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    	for (int i = 0; i < qtyOrdered; i++) {
    		if (itemsOrder[i].equalsto(disc)) {
    			for (int j = i; j < qtyOrdered-1;j++) {
    				itemsOrder[j] = itemsOrder[j+1];
    			    System.out.println("The disc has been removed");
    			}
    			itemsOrder[qtyOrdered-1] = null;
    			break;
    		}
    	}
    	qtyOrdered -= 1;
    }
    
    public void print() {
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	for (int i = 0; i < qtyOrdered; i++) {
    		System.out.println((i+1) + itemsOrder[i].toString());
    	}
    	System.out.println("Total cost: "+ totalCost());
    	System.out.println("***************************************************");
    }
    
    public void search(String title) {
    	int searchResult = 0;
    	System.out.println("Searching result:");
    	for (int i = 0; i < qtyOrdered; i++) {
    		if (itemsOrder[i].isMatch(title)) {
    			searchResult++;
    			System.out.println(searchResult + itemsOrder[i].toString());
    		}
    	}
    	if (searchResult == 0) {
    		System.out.print("No match is found");
    	}
    }
    
    public void search(int id) {
    	int searchResult = 0;
    	System.out.println("Searching result:");
    	for (int i = 0; i < qtyOrdered; i++) {
    		if (itemsOrder[i].isMatch(id)) {
    			searchResult++;
    			System.out.println(searchResult + itemsOrder[i].toString());
    		}
    	}
    	if (searchResult == 0) {
    		System.out.print("No match is found");
    	}
    }
}
