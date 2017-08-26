package au.edu.uq.itee.comp3506.assn1.adts;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import au.edu.uq.itee.comp3506.assn1.gameworld.GameObject;


/**
 * Test driver for the RectangularGrid.
 * @author Ali Nawaz Maan <a.maan@uqconnect.edu.au>
 */
public class MyRectangularGridTest {
	private RectangularGrid<GameObject> grid1;


	/**
	 * Create multiple RectangularGrid objects to be used for testing.
	 * The grid is 3 cells in length and 4 cells in width.
	 */
	@Before
	public void setupRectangularGrid() {
		grid1 = new RectangularGrid<GameObject>(3, 4);

	}

	@Test (expected = IllegalArgumentException.class)
	public void invalidConstruction1() {
		new RectangularGrid<GameObject>(0, 0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void invalidConstruction2() {
		new RectangularGrid<GameObject>(-1, -1);
	}

	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void invalidGridAccess1() {
		grid1.get(4, 3);
	}
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void invalidGridAccess2() {
		grid1.get(-1, 3);
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGridPlacement() {
		GameObject itemToInsert = new GameObject("Item to Place");
		grid1.place(itemToInsert, 10, 10);
		grid1.place(itemToInsert, -1, 0);
		grid1.place(itemToInsert, 3, 4);
	}

	@Test
	public void validGridAccess() {
		GameObject itemToInsert1 = new GameObject("Item to Insert");
		GameObject itemToInsert2 = new GameObject("Item to Insert");
		GameObject item1Retrieved;
		GameObject item2Retrieved;
		grid1.place(itemToInsert1, 0, 0);
		grid1.place(itemToInsert2, 2, 3);

		item1Retrieved = grid1.get(0, 0);
		item2Retrieved = grid1.get(2, 3);
		assertThat("Item retrieved does not match item inserted at the same position",
				itemToInsert1, is(equalTo(item1Retrieved)));
		assertThat("Item retrieved does not match item inserted at the same position",
				itemToInsert2, is(equalTo(item2Retrieved)));
	}
}
