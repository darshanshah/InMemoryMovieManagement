
import java.io.Serializable;

public class AddExistingMovie implements CommandOperations, Serializable {
	private int id;
	private int quantity;

	@Override
	public void executeCommand(AbstractInventory inventory) {
		inventory.addExistingMovie(id, quantity);
	}

	public AddExistingMovie(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}
}