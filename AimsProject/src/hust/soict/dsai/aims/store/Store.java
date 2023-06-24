package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.List;
import hust.soict.dsai.aims.media.*;
public class Store {
	public List<Media> itemsInStore = new ArrayList<Media>();
	public void addMedia(Media media) {	
		int i = 0;
		for(Media me : itemsInStore) {
			if (me.equals(media)) {
				i++;
			    System.out.println("Media is already in the list");
			    break;
			}
		}
		if (i == 0) {
			itemsInStore.add(media);
			System.out.println("Added successfully");
		}
	}
	public void removeMedia(Media media) {
		int i = 0;
		for(Media me : itemsInStore) {
			if (me.equals(media)) {
				i++;
				itemsInStore.remove(media);
			    System.out.println("Removed successfully");
			    break;
			}
		}
		if (i == 0) {
			System.out.println("Media is not in the list");
		}
    }
	public ArrayList<Media> getItemsInStore() {
		return (ArrayList<Media>) itemsInStore;
	}
	
    public void showFilteredMedia(String newValue) {
    	
    }
}