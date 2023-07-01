package hust.soict.dsai.aims.screen;

import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class test {
	static Cart cart = new Cart();
	public static void main(String[] args) {
		Store store = new Store();
		Book book1 = new Book("The Great Gatsby", "Classic", 12.99f, new ArrayList<>(Arrays.asList("F. Scott Fitzgerald")));
		Book book2 = new Book("The Chronicles of Narnia", "Fantasy", 20.99f, new ArrayList<>(Arrays.asList("C.S. Lewis")));
		Book book3 = new Book("Pride and Prejudice", "Romance", 14.99f, new ArrayList<>(Arrays.asList("Jane Austen")));
		Book book4 = new Book("To Kill a Mockingbird", "Classic", 9.99f, new ArrayList<>(Arrays.asList("Harper Lee")));

		CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", "John Landis", 42, 14.99f,
				new ArrayList<>(Arrays.asList(new Track("Wanna Be Startin' Somethin'", 6),
						new Track("Thriller", 5),
						new Track("Beat It", 4),
						new Track("Billie Jean", 5))));
		CompactDisc cd2 = new CompactDisc("Back in Black", "Rock", "AC/DC", "Robert John 'Mutt' Lange", 42, 13.99f,
				new ArrayList<>(Arrays.asList(new Track("Hells Bells", 5),
						new Track("Shoot to Thrill", 5),
						new Track("Back in Black", 5),
						new Track("You Shook Me All Night Long", 4))));
		CompactDisc cd3 = new CompactDisc("1989", "Pop", "Taylor Swift", "Joseph Kahn", 48, 15.99f,
				new ArrayList<>(Arrays.asList(new Track("Welcome to New York", 3),
				new Track("Blank Space", 4),
				new Track("Style", 4),
				new Track("Shake It Off", 4))));
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 12.99f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 9.99f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Jurassic Park", "Science Fiction", "Steven Spielberg", 127, 8.99f);
		
		store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(book4);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        
        new StoreScreen(store, cart);
    
	}
}
