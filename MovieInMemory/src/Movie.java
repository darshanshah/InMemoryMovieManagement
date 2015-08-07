import java.io.Serializable;

public class Movie implements Serializable {

	private String name;
	private double price;
	private int quantity;
	public int uniqueId;

	public Movie(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Movie add() {
		return this;
	}

	public String printString() {
		return name + " " + price + " " + quantity + " " + uniqueId;
	}

	public void addExisting(int quantity) {
		this.quantity += quantity;
	}

	public void changeMoviePrice(double price) {
		this.price = price;
	}

	public String findMovie(int id, String name) {
		if (this.name == name || this.uniqueId == id) {
			return printString();
		} else {
			return null;
		}
	}

	public boolean isExits(String name) {
		if (this.name == name) {
			return true;
		} else {
			return false;
		}
	}

	public void sellMovie() {
		if (this.quantity != 0) {
			this.quantity--;
		}
	}
}
