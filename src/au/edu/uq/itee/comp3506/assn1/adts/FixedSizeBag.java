package au.edu.uq.itee.comp3506.assn1.adts;

/**
 * A simple collection that holds items and provides access to each item.
 * There is an implied ordering of elements to allow iteration through the items in the bag,
 * but there is no guarantee that the order in which items are added will reflect the actual
 * order of how they are stored, or accessed during iteration through the collection.
 * <p>
 * The bag maintains a 'cursor' that is a reference to an element in the bag,
 * providing a mechanism to iterate over the collection via {@code firstItem} and {@code nextItem}.
 * </p>
 *
 * Memory Efficiency: O(n) - linear - This bag data structure implementation has a linear memory
 * efficiency because the memory it takes depends on the number of elements currently present
 * in the bag. The maximum size does not conform to memory efficiency because it is merely
 * a constraint in this implementation.
 *
 * @author ALi Nawaz Maan <a.maan@uqconnect.edu.au>
 *
 * @param <T> The type of element held in the bag.
 */
public class FixedSizeBag<T> implements RemovableBag<T> {
	private LinkedList<T> bag;
	private int maxItems;

	/**
	 * Create a FixedSizeBag with 0 elements.
	 *
	 * Runtime Efficiency: O(1) - constant - this is because this method only initializes a linked list
	 * object with no elements and also assigns a value to the class instance variable - size.
	 * These are all constant time operations. Initializing a LinkedList object is defined as constant time
	 * operation in the LinkedList CDT class.
	 *
	 * @param size Maximum number of items that can be contained in the bag.
	 */
	public FixedSizeBag(int size) {

		if (size <= 0) {
			throw new IllegalArgumentException("Bag size cannot be 0 or negative");
		}

		this.bag = new LinkedList<>();
		this.maxItems = size;
	}

	/**
	 * Remove the item from the bag.
	 *
	 * Runtime Efficiency: O(n) - linear - removing an element from the bag is linear time operation
	 * because the method has to find that particular element in the bag first and then remove it.
	 * This is related to LinkedList implementation as remove() method takes only constant time but find()
	 * method takes linear time.
	 *
	 * @param item The item to be removed.
	 * @return true if item is removed from the bag; false if item was not in bag.
	 */
	public boolean remove(T item) {
		if (this.bag.find(item)) {
			this.bag.remove();
			return true;
		}
		return false;

	}

	/**
	 * Move the internal cursor to the next item in the bag.
	 * If the internal cursor refers to the last item, do not move the cursor and return {@code null}.
	 *
	 * Runtime Efficiency: O(1) - constant - this is because the method returns only next element from
	 * the current pointer position. This is a constant time operation as it refers to the getNext() method
	 * in the LinkedList implementation which is of O(1) runtime efficiency.
	 *
	 * @return The next item or null if there is no next item.
	 */
	public T nextItem() {
		if (!this.bag.isLast()) {
			return this.bag.getNext();
		}
		return null;
	}

	/**
	 * Add an item to the bag.
	 *
	 * Runtime Efficiency: O(1) - constant - this is because the method refers to insertion method of
	 * LinkedList implementation. It is constant time operation as it only corrects the next and
	 * previous references in the linked structure. Inserting an element into the bag does not
	 * result in any iteration or shuffling of elements.
	 *
	 * @param item The item to be added.
	 * @return true if item is added to the bag; false if can't be added.
	 */
	public boolean add(T item) {
		if (this.bag.getSize() < maxItems) {
			this.bag.insert(item);
		}else {
			return false;
		}

		return this.bag.find(item);
	}

	/**
	 * Accessor method for size
	 *
	 * Runtime Efficiency: O(1) - constant - this method just return the value stored in the
	 * instance variable (size) of the LinkedList object. No extra operation is performed so it is a constant
	 * time operation.
	 *
	 * @return int size of the list
	 */

	public int size() {
		return this.bag.getSize();
	}

	/**
	 * Set the internal cursor to refer to the first item in the bag.
	 *
	 * Runtime Efficiency: O(1) - constant - this is because the method gets the first element in the bag and it can
	 * refer to it directly via LinkedList getFirst() method. That method is constant time operation so, bag's firstItem()
	 * method is also a constant time operation.
	 *
	 * @return The first item or null if bag is empty.
	 */
	public T firstItem() {
		return this.bag.getFirst();
	}

	/**
	 * Runtime Efficiency: O(1) - constant - this method conforms to the LinkedList implementation of the method
	 * isLast(). It is a constant time operation as it only checks whether the pointer is at the last element
	 * or not. Basically, it checks if the next node of the linked structure is null or not.
	 *
	 * @return true if the internal cursor is at the last item in the bag; false otherwise.
	 */
	public boolean isLast() {
		return this.bag.isLast();
	}
}


/*
 * Analysis:
 * The implementation the bag conforms to the implementation of LinkedList implementation as the structure
 * refers to the LinkedList object for its methods to work. The bag implementation in the game world requires
 * a data structure with optionally randomly accessed objects but also an implied internal ordering for
 * traversing through the elements of the structure. This implementation will suffice as it is efficient
 * in terms of both time and space.
 * The memory usage of this implementation is efficient because it will only take space relative to
 * the number of elements rather than its max elements. Hence, a large capacity empty bag will not take any more
 * space than a small capacity empty bag.
 * In terms of runtime efficiency, the player needs to get an item from the bag with speed and need to find the next
 * item available. This can happen very efficiently in this particular implementation as traversing through
 * the bag and finding the next element available is constant time operation.
 */