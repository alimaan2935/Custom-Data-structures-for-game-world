package au.edu.uq.itee.comp3506.assn1.adts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import au.edu.uq.itee.comp3506.assn1.gameworld.GameObject;

import java.util.ArrayList;


/**
 * Test driver for the FixedSizeBag.
 * @author Ali Nawaz Maan <a.maan@uqconnect.edu.au>
 *
 */
public class MyFixedSizeBagTest {
	private FixedSizeBag<GameObject> bag;

	@Before
	public void setupFixedSizeBag() {
		bag = new FixedSizeBag<GameObject>(5);
	}

	@Test
	public void newBagIsEmpty() {
		assertThat("A newly created bag does not have a size of 0.", bag.size(), is(equalTo(0)));
	}

	@Test
	public void addOneItem() {
		GameObject itemToAdd = new GameObject("Item to be Added");
		assertThat("Item not successfully added to an empty bag.", bag.add(itemToAdd), is(equalTo(true)));
		assertThat("Bag size is not 1 after adding 1 item.", bag.size(), is(equalTo(1)));
		assertThat("The only item added to the bag is not the first item in the bag.",
				bag.firstItem(), is(equalTo(itemToAdd)));
		assertThat("Cursor position in the bag is not at the last position",
				bag.isLast(), is(equalTo(true)));
	}

	@Test
	public void addMultipleItems() {
		GameObject item1ToAdd = new GameObject("Item 1 to be Added");
		GameObject item2ToAdd = new GameObject("Item 2 to be Added");
		GameObject item3ToAdd = new GameObject("Item 3 to be Added");
		bag.add(item1ToAdd);
		bag.add(item2ToAdd);
		bag.add(item3ToAdd);
		assertThat("Bag size is not 3 after adding 3 items.", bag.size(), is(equalTo(3)));
	}

	@Test
	public void overFillBag() {
		GameObject item1ToAdd = new GameObject("Item 1 to be Added");
		GameObject item2ToAdd = new GameObject("Item 2 to be Added");
		GameObject item3ToAdd = new GameObject("Item 3 to be Added");
		GameObject item4ToAdd = new GameObject("Item 4 to be Added");
		GameObject item5ToAdd = new GameObject("Item 5 to be Added");
		GameObject itemTooManyToAdd = new GameObject("Item that should not be Added");
		bag.add(item1ToAdd);
		bag.add(item2ToAdd);
		bag.add(item3ToAdd);
		bag.add(item4ToAdd);
		bag.add(item5ToAdd);
		assertThat("Added more items than maximum size of bag.", bag.add(itemTooManyToAdd), is(equalTo(false)));
		assertThat("Bag size is not 5 after over filling a bag with a maximum size of 5.", bag.size(), is(equalTo(5)));
	}

	@Test
	public void removals1() {
		GameObject item1ToAdd = new GameObject("Item 1 to be Added");
		GameObject item2ToAdd = new GameObject("Item 2 to be Added");
		GameObject item3ToAdd = new GameObject("Item 3 to be Added");
		GameObject item4ToAdd = new GameObject("Item 4 to be Added");
		bag.add(item1ToAdd);
		bag.add(item2ToAdd);
		bag.add(item3ToAdd);
		bag.add(item4ToAdd);
		assertThat("Item 2 was not removed from the bag", bag.remove(item2ToAdd), is(equalTo(true)));
		assertThat("Item 2 was not removed from the bag previously", bag.remove(item2ToAdd), is(equalTo(false)));
	}

	@Test
	public void nextItems() {
		GameObject item1ToAdd = new GameObject("Item 1 to be Added");
		GameObject item2ToAdd = new GameObject("Item 2 to be Added");
		GameObject item3ToAdd = new GameObject("Item 3 to be Added");
		GameObject item4ToAdd = new GameObject("Item 4 to be Added");
		ArrayList<GameObject> list = new ArrayList<>(4);
		list.add(item1ToAdd);
		list.add(item2ToAdd);
		list.add(item3ToAdd);
		list.add(item4ToAdd);

		bag.add(item1ToAdd);
		bag.add(item2ToAdd);
		bag.add(item3ToAdd);
		bag.add(item4ToAdd);
		assertThat("Item found was not in the list", list.contains(bag.firstItem()), is(equalTo(true)));
		assertThat("Item found was not in the list", list.contains(bag.nextItem()), is(equalTo(true)));
		assertThat("Item found was not in the list", list.contains(bag.nextItem()), is(equalTo(true)));
		assertThat("Item found was not in the list", list.contains(bag.nextItem()), is(equalTo(true)));
		assertThat("Item found was found in the list", list.contains(bag.nextItem()), is(equalTo(false)));

	}
}
