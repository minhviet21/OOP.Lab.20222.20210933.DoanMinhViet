import java.util.Objects;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String directory;
	private int length;
	private float cost;
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirectory() {
		return directory;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc(String category, String title, float cost) {
		super();
		this.category = category;
		this.title = title;
		this.cost = cost;
	}
	public DigitalVideoDisc(String directory, String category, String title , float cost) {
		super();
		this.directory = directory;
		this.category = category;
		this.title = title;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.length = length;
		this.cost = cost;
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
}