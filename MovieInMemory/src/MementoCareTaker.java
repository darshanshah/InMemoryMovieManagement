import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MementoCareTaker {
	private List<Memento> mementoList = new ArrayList<Memento>();

	private String commandFilePath = "E:\\Command.data";
	private String mementoFilePath = "E:\\Memento.data";

	// when we are making the new memento and save it to the file we will erase
	// all the command.
	public void add(Memento state) {
		mementoList.add(state.clone());
		writeMemento(mementoFilePath);
		File commandFile = new File(commandFilePath);
		commandFile.delete();
	}

	public Memento getMemento(int index) {
		return mementoList.get(index);
	}

	public void writeMemento(String path) {
		FileOutputStream fileOut = null;
		ObjectOutputStream out = null;
		try {
			fileOut = new FileOutputStream(path);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(mementoList.get(mementoList.size() - 1));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Memento readMemento(String path) {
		Memento memento = null;
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream input = new ObjectInputStream(fileIn);
			memento = (Memento) input.readObject();
			input.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return memento;
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			return memento;
		}
		return memento;
	}
}
