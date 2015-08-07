import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class InventoryTest extends TestCase {

	@Test
	public void test() {

		AbstractInventory inv = new Inventory();
		inv.addMovie("sky", 12.15, 3);
		inv.addMovie("da", 34.12, 5);
		inv.addMovie("AMC", 9.8, 7);
		inv.addMovie("socar", 3.5, 4);
		inv.changeMoviePrice(2, 10.5);
		String value = inv.findMoviesById(2);
		assertEquals("da 10.5 5 2", value);

		inv.addExistingMovie(1, 3);
		value = inv.findMoviesById(1);
		assertEquals("sky 12.15 6 1", value);

		inv.sellMovie(3);
		value = inv.findMoviesById(3);
		assertEquals("AMC 9.8 6 3", value);

	}

}
