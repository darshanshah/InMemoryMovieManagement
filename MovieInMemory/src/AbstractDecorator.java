public abstract class AbstractDecorator extends AbstractInventory {

	protected AbstractInventory inventory;

	public abstract void addMovie(String name, double price, int quantity);

	public abstract void addExistingMovie(int id, int quantity);

	public abstract void sellMovie(int id);

	public abstract void changeMoviePrice(int id, double changedPrice);

	public abstract String findMoviesById(int id);

	public abstract String findMoviesByName(String name);

}
