package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.disc.*;
public class TestPassingParameter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Viet"); 
		
		dvd3.setTitle(dvd1.getTitle());
		dvd1.setTitle(dvd2.getTitle());
		dvd2.setTitle(dvd3.getTitle());
		
		dvd3.setCategory(dvd1.getCategory());
		dvd1.setCategory(dvd2.getCategory());
		dvd2.setCategory(dvd3.getCategory());
		
		dvd3.setDirectory(dvd1.getDirectory());
		dvd1.setDirectory(dvd2.getDirectory());
		dvd2.setDirectory(dvd3.getDirectory());
		
		dvd3.setLength(dvd1.getLength());
		dvd1.setLength(dvd2.getLength());
		dvd2.setLength(dvd3.getLength());

		dvd3.setCost(dvd1.getCost());
		dvd1.setCost(dvd2.getCost());
		dvd2.setCost(dvd3.getCost());
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(title);
	}

}
