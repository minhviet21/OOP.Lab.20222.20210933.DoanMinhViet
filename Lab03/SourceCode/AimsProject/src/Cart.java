public class Cart {
	
    private static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrder[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
    public void addDigitalVideoDisc(DigitalVideoDisc disc){	
    	if (qtyOrdered < MAX_NUMBERS_ORDERED) {
    		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
    			if (itemsOrder[i] == null)  {
    				itemsOrder[i] = disc;
    				break;
    			}
    		}
    		qtyOrdered += 1;
    		System.out.println("The disc has been added");
    	}
    	else {
    		System.out.println("The cart is almost full");
    	}
    }
    
	public float totalCost() { 	
		float cost = 0; 
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrder[i] != null)  {
				cost += itemsOrder[i].getCost();
			}
		}
		return cost;
    } 
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    	for (int i = 0; i < qtyOrdered; i++) {
    		if (itemsOrder[i].equalsto(disc)) {
    			itemsOrder[i] = null;
    			qtyOrdered -= 1;
    			System.out.println("The disc has been removed");
    			break;
    		}
    	}
    }
}
