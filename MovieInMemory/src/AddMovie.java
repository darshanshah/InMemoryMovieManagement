import java.io.Serializable;

public class AddMovie implements CommandOperations, Serializable {
	private String name;
	private double price;
	private int quantity;

	@Override
	public void executeCommand(AbstractInventory inventory) {
		inventory.addMovie(name, price, quantity);
	}

	public AddMovie(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
}
