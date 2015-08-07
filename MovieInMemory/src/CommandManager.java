import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommandManager implements Serializable {
	private List<CommandOperations> commands = new ArrayList<CommandOperations>();
	private AbstractInventory inventory;

	public CommandManager(AbstractInventory inventory) {
		this.inventory = inventory;
	}

	public void takeOrder(CommandOperations inventory) {
		commands.add(inventory);
	}

	// Place Order to execute the command and write the command into file.
	public void placeOrders(String path) {
		for (int i = commands.size() - 1; i >= 0; i--) {
			CommandOperations videoInventory = commands.get(i);
			writeCommand(path, commands.get(i));
			videoInventory.executeCommand(inventory);

		}
		commands.clear();
	}

	// write the command to the file
	public void writeCommand(String path, CommandOperations videoInventory) {
		FileOutputStream fileOut = null;
		ObjectOutputStream outputStream = null;
		File commandFile = new File(path);
		if (commandFile.exists()) {
			try {
				fileOut = new FileOutputStream(path, true);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				outputStream = new NoHeaderObjectOutputStream(fileOut);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				fileOut = new FileOutputStream(path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				outputStream = new ObjectOutputStream(fileOut);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			outputStream.writeObject(videoInventory);
			outputStream.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Read command from the file and execute the command one by one.
	public List<CommandOperations> readAndExecuteCommand(String path) {
		CommandOperations command;
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInput input = new ObjectInputStream(fileIn);
			while ((command = (CommandOperations) input.readObject()) != null) {
				command.executeCommand(inventory);
			}
		} catch (IOException i) {
			i.printStackTrace();
			return commands;
		} catch (ClassNotFoundException c) {
			System.out.println("Video Inventory class not found");
			c.printStackTrace();
			return commands;
		}
		return commands;

	}
}
