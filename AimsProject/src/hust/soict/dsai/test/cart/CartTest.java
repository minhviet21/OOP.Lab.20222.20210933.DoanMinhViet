package hust.soict.dsai.test.cart;
import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
public class CartTest {
	public static void main(String[] args) throws LimitExceededException {
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		
		cart.print();
		System.out.println(dvd2.isMatch("3"));
		cart.search("3");
		
	}
}