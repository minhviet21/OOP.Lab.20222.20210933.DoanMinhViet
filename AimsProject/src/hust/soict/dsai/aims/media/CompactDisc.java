package hust.soict.dsai.aims.media;
import java.util.ArrayList;
public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks =  new ArrayList<Track>();
	public CompactDisc(String title, String category, String artist, String director, 
			int length, float cost, ArrayList<Track> tracks) {
		super(title,category,director,length,cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	public String getArtist() {
		return artist;
	}
	public void addTrack(Track track) {
		int i = 0;
		for(Track tr : tracks) {
			if (tr.equals(track)) {
				i++;
			    System.out.println("Track is already in the list");
			    break;
			}
		}
		if (i > 0) {
			tracks.add(track);
			System.out.println("Added successfully");
		}
	}
	public void removeTrack(Track track) {
		int i = 0;
		for(Track tr : tracks) {
			if (tr.equals(track)) {
				i++;
				tracks.remove(track);
			    System.out.println("Removed successfully");
			    break;
			}
		}
		if (i > 0) {
			System.out.println("Track is not in the list");
		}
	}
	public void play() {
		for (Track track: tracks) {
			track.play();
		}
	}
	@Override
    public String toString() {
    	return ("DVD - "+getTitle()+" - "+getCategory()+" - "+getDirector()+" - "+getLength()+": "+getCost());
    }
}

