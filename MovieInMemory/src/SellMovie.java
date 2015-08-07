import java.io.Serializable;

public class SellMovie implements CommandOperations, Serializable {

	private int id;

	@Override
	public void executeCommand(AbstractInventory inventory) {
		inventory.sellMovie(id);
	}

	public SellMovie(int id) {
		this.id = id;
	}
}
