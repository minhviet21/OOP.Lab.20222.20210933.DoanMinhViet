package hust.soict.dsai.aims.media;
import java.util.List;
import java.util.ArrayList;
public class Book extends Media{
	private ArrayList<String> authors = new ArrayList<String>();
	public Book(String title, String category, float cost, List<String> authors) {	
		super(title, category, cost);
		this.authors = (ArrayList<String>) authors;
		nbMedia ++;
		this.id = nbMedia;
	}
	public ArrayList<String> getAuthors() {
		return authors;
	}
	public void addAuthor(String authorName) {
		authors.add(authorName);
	}
	public void removeAuthor(String authorName) {
		authors.remove(authorName);
	}
	@Override
	public String toString() {
		return ("Book - "+getTitle()+" - "+getCategory()+" - "+getAuthors()+" - "+getCost());
	}
}
