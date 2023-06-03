package hust.soict.dsai.aims.media;
import java.util.Comparator;
public abstract class Media {
	protected int id;
	private String title;
	private String category;
	private float cost;
	protected static int nbMedia = 0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbMedia ++;
		this.id = nbMedia;
	}
	public boolean isMatch(String title) {
		if (title == null || title.length() == 0) {
		    return false;
		}
		String[] words = title.toLowerCase().split("\\s+");
		for (String word : words) {
			if (this.getTitle().toLowerCase().contains(word)) {
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
	@Override
	public boolean equals(Object o) {
		if (o instanceof Media) {
			Media m = (Media) o;
			return getTitle() == m.getTitle();
		}
		return false;
	}
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}