package au.edu.uq.itee.comp3506.assn1.adts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import au.edu.uq.itee.comp3506.assn1.gameworld.GameObject;

/**
 * Test driver for the LinkedList.
 * @author Ali Nawaz Maan <a.maan@uqconnect.edu.au>
 */

public class MyLinkedListTest {
	private LinkedList<GameObject> list;

	/**
	 * Create an empty linked list structure
	 */
	@Before
	public void createEmptyLinkedList() {
		list = new LinkedList<GameObject>();
	}

	/**
	 * Try to remove an element from an empty list
	 * @exception IndexOutOfBoundsException There is no element to be removed from the LinkedList
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidRemoval() {
		list.remove();
	}

	/**
	 * Adding one item to the end of the LinkedList
	 * The item added must be first and last item in the list
	 * The size of the list must be 1
	 */
	@Test
	public void addOneItem() {
		GameObject itemToAdd = new GameObject("Item to be Added");
		list.addToEnd(itemToAdd);
		assertThat("Adding an item resulted in an empty list.", list.isEmpty(), is(equalTo(false)));
		assertThat("Adding one item did not result in it being the last item.", list.isLast(), is(equalTo(true)));
		assertThat("The only item added to the list is not the first item in the list.",
				list.getFirst(), is(equalTo(itemToAdd)));
		assertThat("The only item added to the list is not the last item in the list.",
				list.getLast(), is(equalTo(itemToAdd)));
		assertThat("The size of the list is not 1",
				list.getSize(), is(equalTo(1)));
	}

	/**
	 * Inserting one item into the start of the LinkedList
	 * The item added must be first and last item in the list.
	 * The size of the list must be 1
	 */
	@Test
	public void insertOneItem() {
		GameObject itemToInsert = new GameObject("Item to be Inserted");
		list.insert(itemToInsert);
		assertThat("Inserting an item resulted in an empty list.", list.isEmpty(), is(equalTo(false)));
		assertThat("Inserting one item did not result in it being the last item.", list.isLast(), is(equalTo(true)));
		assertThat("The only item inserted into the list is not the first item in the list.",
				list.getFirst(), is(equalTo(itemToInsert)));
		assertThat("The only item inserted into the list is not the last item in the list.",
				list.getLast(), is(equalTo(itemToInsert)));
		assertThat("The size of the list is not 1",
				list.getSize(), is(equalTo(1)));
	}

	/**
	 * Adding two items to the end of the LinkedList
	 * The first item added will be first item in the list and last one will be the last.
	 * The pointer must be at the last position in the list.
	 * The size of the list must be 2
	 */
	@Test
	public void addTwoItems() {
		GameObject item1ToAdd = new GameObject("Item 1");
		GameObject item2ToAdd = new GameObject("Item 2");
		list.addToEnd(item1ToAdd);
		list.addToEnd(item2ToAdd);
		assertThat("Adding multiple items to end of list did not result in the last one being the last item.",
				list.isLast(), is(equalTo(true)));
		assertThat("The first item added to the list is not the first item in the list.",
				list.getFirst(), is(equalTo(item1ToAdd)));
		assertThat("The last item added to the list is not the last item in the list.",
				list.getLast(), is(equalTo(item2ToAdd)));
		assertThat("The size of the list is not 2",
				list.getSize(), is(equalTo(2)));
	}

	/**
	 * Inserting two items at the start of the LinkedList
	 * The first item added will be last item in the list and last one will be the first.
	 * The pointer must not be at the first position in the list.
	 * The size of the list must be 2
	 */
	@Test
	public void insertTwoItems() {
		GameObject item1ToInsert = new GameObject("Item 1");
		GameObject item2ToInsert = new GameObject("Item 2");
		list.insert(item1ToInsert);
		list.insert(item2ToInsert);
		assertThat("Inserting multiple items into an empty list resulted in the cursor refering to the end of the list.",
				list.isLast(), is(equalTo(false)));
		assertThat("The first item inserted into an empty list is not the last item in the list.",
				list.getLast(), is(equalTo(item1ToInsert)));
		assertThat("The last item inserted into the list is not the first item in the list.",
				list.getFirst(), is(equalTo(item2ToInsert)));
		assertThat("The size of the list is not 2",
				list.getSize(), is(equalTo(2)));
	}

	/**
	 * Add three items at the end of the LinkedList
	 * The first item added will be first item in the list and last one will be the last.
	 * The middle item will be previous to the last and next to the first item in the list.
	 * The size of the list must be 3
	 */
	@Test
	public void addThreeItems() {
		GameObject item1ToAdd = new GameObject("Item 1");
		GameObject item2ToAdd = new GameObject("Item 2");
		GameObject item3ToAdd = new GameObject("Item 3");
		list.addToEnd(item1ToAdd);
		list.addToEnd(item2ToAdd);
		list.addToEnd(item3ToAdd);
		assertThat("Adding multiple items to end of list did not result in the last one being the last item.",
				list.isLast(), is(equalTo(true)));
		assertThat("The first item added to the list is not the first item in the list.",
				list.getFirst(), is(equalTo(item1ToAdd)));
		assertThat("The last item added to the list is not the last item in the list.",
				list.getLast(), is(equalTo(item3ToAdd)));
		assertThat("The second item added to the list is not the previous item of the pointer.",
				list.getPrevious(), is(equalTo(item2ToAdd)));
		assertThat("The first item added to the list is not the previous item of the pointer at middle position.",
				list.getPrevious(), is(equalTo(item1ToAdd)));
		assertThat("The second item added to the list is not the next item of the pointer at root position.",
				list.getNext(), is(equalTo(item2ToAdd)));
		assertThat("The size of the list is not 3",
				list.getSize(), is(equalTo(3)));
	}

	/**
	 * Insert three items at the start of the LinkedList
	 * The first item added will be last item in the list and last one will be the first.
	 * The middle item will be next to the first.
	 * The pointer position is confirmed when calling the next method at the end of the list.
	 * The size of the list must be 3
	 */
	@Test
	public void insertThreeItems() {
		GameObject item1ToInsert = new GameObject("Item 1");
		GameObject item2ToInsert = new GameObject("Item 2");
		GameObject item3ToInsert = new GameObject("Item 3");
		list.insert(item1ToInsert);
		list.insert(item2ToInsert);
		list.insert(item3ToInsert);
		assertThat("Inserting multiple items into an empty list resulted in the cursor refering to the end of the list.",
				list.isLast(), is(equalTo(false)));
		assertThat("The first item inserted into an empty list is not the last item in the list.",
				list.getLast(), is(equalTo(item1ToInsert)));
		assertThat("The last item inserted into the list is not the first item in the list.",
				list.getFirst(), is(equalTo(item3ToInsert)));
		assertThat("The second item inserted into the list is not the next item to the pointer.",
				list.getNext(), is(equalTo(item2ToInsert)));
		assertThat("The first item inserted into the list is not the next item to the pointer.",
				list.getNext(), is(equalTo(item1ToInsert)));
		assertThat("Pointer is not at the last item position",
				list.getNext(), is(equalTo(item1ToInsert)));
		assertThat("The size of the list is not 3",
				list.getSize(), is(equalTo(3)));
	}

	/**
	 * Insert an element into somewhere middle of the list
	 * The element inserted must be next to the previous position of the pointer.
	 * Pointer position must be at the newly inserted item.
	 * The size of the list must be 4
	 */
	@Test
	public void insertIntoMiddle() {
		GameObject item1ToInsert = new GameObject("Item 1");
		GameObject item2ToInsert = new GameObject("Item 2");
		GameObject item3ToInsert = new GameObject("Item 3");
		GameObject item4ToInsert = new GameObject("Item 4");
		list.insert(item1ToInsert);
		list.insert(item2ToInsert);
		list.insert(item3ToInsert);
		assertThat("Inserting multiple items into an empty list resulted in the cursor refering to the end of the list.",
				list.isLast(), is(equalTo(false)));
		assertThat("The first item inserted into an empty list is not the last item in the list.",
				list.getLast(), is(equalTo(item1ToInsert)));
		assertThat("The last item inserted into the list is not the first item in the list.",
				list.getFirst(), is(equalTo(item3ToInsert)));
		assertThat("The second item inserted into the list is not the next item to the pointer.",
				list.getNext(), is(equalTo(item2ToInsert)));

		list.insert(item4ToInsert);

		assertThat("The fourth item inserted into the list is not after the root.",
				list.getPrevious(), is(equalTo(item3ToInsert)));
		assertThat("The fourth item inserted into the list is not after the root.",
				list.getNext(), is(equalTo(item4ToInsert)));
		assertThat("The size of the list is not 4",
				list.getSize(), is(equalTo(4)));
	}

	/**
	 * Removing an inserted object from the list.
	 * The pointer next and previous must be null after removal
	 */
	@Test (expected = NullPointerException.class)
	public void removals1() {
		GameObject item1ToInsert = new GameObject("Item 1");
		list.insert(item1ToInsert);
		assertThat("Pointer is not at the root position",
				list.getPrevious(), is(equalTo(item1ToInsert)));

		list.remove(); // Removal

		assertThat("Next item of the pointer is not null",
				list.getNext(), is(equalTo(NullPointerException.class)));
		assertThat("Prev item of the pointer is not null",
				list.getPrevious(), is(equalTo(NullPointerException.class)));

	}

	/**
	 * Removing an object from the middle of the list.
	 * The next and previous nodes in the list must be properly
	 * connected after removing the object.
	 * The size of the list must be 3 after removal
	 */
	@Test
	public void removals2() {
		GameObject item1ToInsert = new GameObject("Item 1");
		GameObject item2ToInsert = new GameObject("Item 2");
		GameObject item3ToInsert = new GameObject("Item 3");
		GameObject item4ToInsert = new GameObject("Item 4");
		list.insert(item1ToInsert);
		list.insert(item2ToInsert);
		list.insert(item3ToInsert);
		list.insert(item4ToInsert);
		assertThat("Pointer is not at the root position",
				list.getPrevious(), is(equalTo(item4ToInsert)));
		assertThat("The third item added to the list is not the next item to the pointer",
				list.getNext(), is(equalTo(item3ToInsert)));
		assertThat("The size of the list is not 4",
				list.getSize(), is(equalTo(4)));

		list.remove();

		assertThat("First item inserted into the list is not next to pointer",
				list.getNext(), is(equalTo(item1ToInsert)));
		assertThat("2nd item inserted into the list is not the previous item from the last or pointer",
				list.getPrevious(), is(equalTo(item2ToInsert)));
		assertThat("The root (4th item) is not previous to 2nd item or pointer",
				list.getPrevious(), is(equalTo(item4ToInsert)));
		assertThat("2nd Item is not next to the root or pointer",
				list.getNext(), is(equalTo(item2ToInsert)));
		assertThat("The size of the list is not 3",
				list.getSize(), is(equalTo(3)));
	}

	/**
	 * Testing the pointer position and references after removal of an object
	 * from the list. First and last elements must be null.
	 */
	@Test
	public void removals3() {
		GameObject item1ToInsert = new GameObject("Item 1");
		list.insert(item1ToInsert);
		list.remove();
		assertThat("First item of the list is not null",
				list.getFirst(), is(equalTo(null)));
		assertThat("Last item of the list is not null",
				list.getLast(), is(equalTo(null)));
		assertThat("Pointer is at the last position of an empty list",
				list.isLast(), is(equalTo(false)));

	}

	/**
	 * Finding an element in the list.
	 * The cursor must be at the element position after finding.
	 * The method must be able to find the element wherever in the list
	 * regardless of the pointer position.
	 */
	@Test
	public void findItem() {
		GameObject item1ToInsert = new GameObject("Item 1");
		GameObject item2ToInsert = new GameObject("Item 2");
		GameObject item3ToInsert = new GameObject("Item 3");
		GameObject item4ToInsert = new GameObject("Item 4");
		list.insert(item1ToInsert);
		list.insert(item2ToInsert);
		list.insert(item3ToInsert);
		list.insert(item4ToInsert);
		assertThat("Item is not found",
				list.find(item1ToInsert), is(equalTo(true)));
		assertThat("Pointer is not iat the last position",
				list.isLast(), is(equalTo(true)));
		assertThat("2nd item is not the previous item to the last item in the list or pointer",
				list.getPrevious(), is(equalTo(item2ToInsert)));
		assertThat("Item previous to the pointer is not found",
				list.find(item3ToInsert), is(equalTo(true)));

	}
}
