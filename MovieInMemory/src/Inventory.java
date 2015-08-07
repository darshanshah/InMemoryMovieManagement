import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Inventory extends AbstractInventory implements Serializable {
	private int size;
	List<Movie> movies = new ArrayList<>();

	// Add moive to the inventory and after the 5 movies added System will
	// create the memento. Originator will help to keep update the memento.
	public void addMovie(String name, double price, int quantity) {
		size++;
		if (!isMovieExists(name)) {
			Movie movie = new Movie(name, price, quantity);
			movie.uniqueId = size;
			movies.add(movie);
		}
		if (size % 5 == 0) {
			MaintainMemento originator = new MaintainMemento();
			MementoCareTaker careTaker = new MementoCareTaker();
			originator.setState(this);
			careTaker.add(originator.saveStateToMemento());
		}
	}

	public boolean isMovieExists(String name) {
		boolean isExits = false;
		for (int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			if (movie.isExits(name)) {
				isExits = true;
			}
		}
		return isExits;
	}

	public void addExistingMovie(int id, int quantity) {
		for (int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			if (movie.uniqueId == id) {
				movie.addExisting(quantity);
			}
		}
	}

	public void sellMovie(int id) {
		for (int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			if (movie.uniqueId == id) {
				movie.sellMovie();
			}
		}
	}

	public void changeMoviePrice(int id, double changedPrice) {
		for (int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			if (movie.uniqueId == id) {
				movie.changeMoviePrice(changedPrice);
			}
		}

	}

	public String findMoviesById(int id) {
		return findMovies(id, null);
	}

	public String findMoviesByName(String name) {
		return findMovies(0, name);
	}

	private String findMovies(int id, String name) {
		String value = "";
		for (int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			value = movie.findMovie(id, name);
			if (value != null) {
				return value;
			}
		}
		return value;

	}

}
