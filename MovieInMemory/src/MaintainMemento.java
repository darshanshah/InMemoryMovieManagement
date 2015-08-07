public class MaintainMemento {
	private AbstractInventory inventoryState;

	public void setState(AbstractInventory state) {
		this.inventoryState = state;
	}

	public AbstractInventory getState() {
		return inventoryState;
	}

	public Memento saveStateToMemento() {
		return new Memento(inventoryState);
	}

	public void getStateFromMemento(Memento Memento) {
		inventoryState = Memento.getState();
	}
}
