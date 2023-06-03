package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc implements Playable{	
	public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
		super(title,category,directory,length,cost);
		nbMedia ++;
		this.id = nbMedia;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		}
    @Override
    public String toString() {
    	return ("DVD - "+getTitle()+" - "+getCategory()+" - "+getDirector()+" - "+getLength()+" - "+getCost());
    }
}			