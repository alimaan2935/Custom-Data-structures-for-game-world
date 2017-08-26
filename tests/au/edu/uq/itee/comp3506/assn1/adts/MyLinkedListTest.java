package au.edu.uq.itee.comp3506.assn1.adts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import au.edu.uq.itee.comp3506.assn1.gameworld.GameObject;

import org.junit.Test;

public class MyLinkedListTest {
	private LinkedList<GameObject> list;

	@Before
	public void createEmptyLinkedList() {
		list = new LinkedList<GameObject>();
	}

	@Test
	public void newListIsEmpty() {
		assertThat("A newly created list is not empty.", list.isEmpty(), is(equalTo(true)));
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidRemoval() {
		list.remove();
	}

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

	@Test (expected = NullPointerException.class)
	public void removals1() {
		GameObject item1ToInsert = new GameObject("Item 1");
		list.insert(item1ToInsert);
		assertThat("Pointer is not at the root position",
				list.getPrevious(), is(equalTo(item1ToInsert)));
		list.remove();
		assertThat("Next item of the pointer is not null",
				list.getNext(), is(equalTo(NullPointerException.class)));
		assertThat("Prev item of the pointer is not null",
				list.getPrevious(), is(equalTo(NullPointerException.class)));

	}

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

	@Test
	public void removals3() {
		GameObject item1ToInsert = new GameObject("Item 1");
		list.insert(item1ToInsert);
		list.remove();
		assertThat("First item of the list is not null",
				list.getFirst(), is(equalTo(null)));
		assertThat("Last item of the list is not null",
				list.getLast(), is(equalTo(null)));
		assertThat("Last item of the list is not null",
				list.isLast(), is(equalTo(false)));

	}

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
