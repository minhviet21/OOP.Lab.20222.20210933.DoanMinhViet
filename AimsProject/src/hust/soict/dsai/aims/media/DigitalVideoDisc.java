package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;
public class DigitalVideoDisc extends Disc implements Playable {	
	public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
		super(title,category,directory,length,cost);
		nbMedia ++;
		this.id = nbMedia;
	}
	public String play(){
	    return "Playing DVD: " + this.getTitle() +"\n" + "DVD length: " + this.getLength();
	}
	
    @Override
    public String toString() {
    	return ("DVD - "+getTitle()+" - "+getCategory()+" - "+getDirector()+" - "+getLength()+" - "+getCost());
    }
}	
		