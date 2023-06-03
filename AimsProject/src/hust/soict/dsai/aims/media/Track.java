package hust.soict.dsai.aims.media;
public class Track implements Playable{
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title, int length) {
		this.length = length;
		this.title = title;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	@Override
	public boolean equals(Object o) {
		if (o instanceof Track) {
			Track t = (Track) o;
			return getTitle() == t.getTitle() && getLength() == t.getLength();
		}
		return false;
	}
}
