import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class InventoryDecoratorTest extends TestCase {

	@Test
	public void test() {
		InventoryDecorator inventoryDecorator = new InventoryDecorator();
		inventoryDecorator.addMovie("Spiderman", 29.29, 3);
		String resultValue = inventoryDecorator.findMoviesById(1);
		assertEquals("Spiderman 18.19 7 1", resultValue);

		inventoryDecorator.addExistingMovie(1, 3);
		resultValue = inventoryDecorator.findMoviesById(1);
		assertEquals("Spiderman 29.29 6 1", resultValue);

		inventoryDecorator.changeMoviePrice(1, 18.19);
		resultValue = inventoryDecorator.findMoviesById(1);
		assertEquals("Spiderman 18.19 6 1", resultValue);

		inventoryDecorator.sellMovie(1);
		resultValue = inventoryDecorator.findMoviesById(1);
		assertEquals("Spiderman 18.19 5 1", resultValue);

		inventoryDecorator.addMovie("Batman", 4.5, 3);
		resultValue = inventoryDecorator.findMoviesById(2);
		assertEquals("Batman 4.5 3 2", resultValue);

		inventoryDecorator.addExistingMovie(2, 3);
		resultValue = inventoryDecorator.findMoviesById(2);
		assertEquals("Batman 4.5 6 2", resultValue);

		inventoryDecorator.changeMoviePrice(2, 9.7);
		resultValue = inventoryDecorator.findMoviesById(2);
		assertEquals("Batman 9.7 6 2", resultValue);

		inventoryDecorator.sellMovie(2);
		resultValue = inventoryDecorator.findMoviesById(2);
		assertEquals("Batman 9.7 5 2", resultValue);

	}

}
