package hust.soict.dsai.aims.disc;
import java.util.Objects;
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String directory;
	private int length;
	private float cost;
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs ++;
		this.id = nbDigitalVideoDiscs;
	}	
	public DigitalVideoDisc(String category, String title, float cost) {
		super();
		this.category = category;
		this.title = title;
		this.cost = cost;
		nbDigitalVideoDiscs ++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String directory, String category, String title , float cost) {
		super();
		this.directory = directory;
		this.category = category;
		this.title = title;
		this.cost = cost;
		nbDigitalVideoDiscs ++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs ++;
		this.id = nbDigitalVideoDiscs;
	}

	public boolean equalsto(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DigitalVideoDisc other = (DigitalVideoDisc) obj;
		return Objects.equals(category, other.category)
				&& Float.floatToIntBits(cost) == Float.floatToIntBits(other.cost)
				&& Objects.equals(directory, other.directory) && length == other.length
				&& Objects.equals(title, other.title);
	}

    @Override
    public String toString() {
    	return (". DVD - "+getTitle()+" - "+getCategory()+" - "+getDirectory()+" - "+getLength()+": "+getCost());
    }
    
	public boolean isMatch(String title) {
		if (title == null || title.length() == 0) {
		    return false;
		}
		String[] words = title.toLowerCase().split("\\s+");
		for (String word : words) {
			if (this.title.toLowerCase().contains(word)) {
		    	return true;
		    }
		}
		return false;
	}
	
	public boolean isMatch(int id) {
		if (getId() == id) {
			return true;
		}
		return false;
	}
}			