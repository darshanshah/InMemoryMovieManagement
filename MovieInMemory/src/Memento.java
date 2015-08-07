import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Memento implements Serializable {
	private AbstractInventory inventoryState;

	public Memento(AbstractInventory state) {
		this.inventoryState = state;
	}

	public AbstractInventory getState() {
		return inventoryState;
	}

	// clone is used to dereference the object from the original object. as if
	// we will not make it then when we change the state of the inventory will
	// automatically change in the inventory.
	@Override
	public Memento clone() {
		AbstractInventory clonnedInventory = new Inventory();
		ObjectInputStream objectInputStream = null;
		try {
			ByteArrayOutputStream byreOutputStream = new ByteArrayOutputStream();

			ObjectOutputStream outputStream = new ObjectOutputStream(
					byreOutputStream);
			outputStream.writeObject(inventoryState);

			byte[] bytes = byreOutputStream.toByteArray();
			objectInputStream = new ObjectInputStream(new ByteArrayInputStream(
					bytes));

			clonnedInventory = (AbstractInventory) objectInputStream
					.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Memento(clonnedInventory);

	}
}
