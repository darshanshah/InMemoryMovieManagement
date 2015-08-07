/* Q-5 Instead of creating decorator(s) you might be tempted to make the Inventory class create
the commands, execute the commands and save them. Why is the decorator a better idea.

- It makes Inventory simple and clean so that only has to deal with basic operation.

- It will allow Inventory to perform basic operations efficiently without extra overhead
  of other task

- As we are assigning extra responsibility to create, invoke and save command for the
  operations that change state if an object, in short we are extending functionality 
  of a certain object at runtime. this should be done efficiently by applying decorator 
  pattern in our projecct.


 */
public class InventoryDecorator extends AbstractDecorator {

	private String commandFilePath = "E:\\Command.data";
	private String mementoFilePath = "E:\\Memento.data";

	// Decorator will help us to fetch the last saved state of the inventory if
	// system crashed.
	public InventoryDecorator() {
		this.inventory = new Inventory();
		MementoCareTaker careTaker = new MementoCareTaker();
		Memento memento = null;
		memento = careTaker.readMemento(mementoFilePath);
		if (memento != null) {
			inventory = memento.getState();
		}
		CommandManager broker1 = new CommandManager(inventory);
		broker1.readAndExecuteCommand(commandFilePath);
	}

	@Override
	public void addMovie(String name, double price, int quantity) {
		AddMovie addMovie = new AddMovie(name, price, quantity);
		CommandManager broker = new CommandManager(inventory);
		broker.takeOrder(addMovie);
		broker.placeOrders(commandFilePath);

	}

	@Override
	public void addExistingMovie(int id, int quantity) {
		AddExistingMovie addExisting = new AddExistingMovie(id, quantity);
		CommandManager broker = new CommandManager(inventory);
		broker.takeOrder(addExisting);
		broker.placeOrders(commandFilePath);

	}

	@Override
	public void sellMovie(int id) {
		SellMovie sellMovie = new SellMovie(id);
		CommandManager broker = new CommandManager(inventory);
		broker.takeOrder(sellMovie);
		broker.placeOrders(commandFilePath);

	}

	@Override
	public void changeMoviePrice(int id, double changedPrice) {
		ChangeMoviePrice changeMoviePrice = new ChangeMoviePrice(id,
				changedPrice);
		CommandManager broker = new CommandManager(inventory);
		broker.takeOrder(changeMoviePrice);
		broker.placeOrders(commandFilePath);

	}

	@Override
	public String findMoviesById(int id) {
		return inventory.findMoviesById(id);
	}

	@Override
	public String findMoviesByName(String name) {
		return inventory.findMoviesByName(name);
	}

}
