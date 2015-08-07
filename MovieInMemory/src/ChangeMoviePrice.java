import java.io.Serializable;

public class ChangeMoviePrice implements CommandOperations, Serializable {
	private int id;
	private double price;

	@Override
	public void executeCommand(AbstractInventory inventory) {
		inventory.changeMoviePrice(id, price);
	}

	public ChangeMoviePrice(int id, double price) {
		this.id = id;
		this.price = price;
	}
}
