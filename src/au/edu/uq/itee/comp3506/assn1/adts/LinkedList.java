package au.edu.uq.itee.comp3506.assn1.adts;

/**
 * An ordered sequential list of items.
 * Maintains a 'cursor' that is a reference to an element in the list, providing a mechanism to iterate over the list.
 * The cursor is the position at which non-fixed-positioning operations on the list occur
 * (e.g. insert, remove, getNext, getPrevious).
 *
 * Memory Efficiency: O(n) - linear - this is because the implementation is a linked structure with number of links
 * equal to current size of the structure. There is just one extra node called pointer which has no significant
 * contribution in the space consumption. So, the space consumed by the data structure is equal to number
 * of nodes which is n - linear.
 *
 * @author ALi Nawaz Maan <a.maan@uqconnect.edu.au>
 *
 * @param <T> The type of element held in the linked list.
 */
public class LinkedList<T> implements GameList<T> {

	private Node root;
	private Node last;
	private Node pointer;
	private int size;

	/**
	 * Constructor for Linked list object
	 * Takes no parameter
	 * Initialize the list with a null node and 0 size
	 * Pointer pointing towards the root node
	 * Root and last node are the same
	 *
	 * Runtime Efficiency: O(1) - constant - this is because the linked structure is initialized with
	 * just 3 elements - root node, last node and pointer. This is a constant time operation
	 * because the initialization does not depend on number of elements or size.
	 *
	 */
	public LinkedList () {
		Node node = new Node();
		this.pointer = node;
		this.root = node;
		this.last = node;
		size = 0;
	}

	/**
	 * Accessor method for size
	 *
	 * Runtime Efficiency: O(1) - constant - this method just return the value stored in the
	 * instance variable (size) of the class. No extra operation is performed so it is a constant
	 * time operation.
	 *
	 * @return int size of the list
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Add an item to the end of the list.
	 * The cursor will refer to the newly added item.
	 * If the list is empty {@code item} becomes the first and last item in the list.
	 *
	 * Runtime Efficiency: O(1) - constant - this is because the method just gets the last node
	 * from class instance variables and links the last to the new node in a way that new node
	 * becomes the last node and pointer refers to new node (last node). This is a constant
	 * time operation as no structure is disrupted or no element is iterated over.
	 *
	 * @param item The item to be added to the list.
	 */
	public void addToEnd (T item) {

		Node newNode = new Node();
		newNode.setData(item);
		if (size == 0) {
			root = newNode;
			last = newNode;
			pointer = root;
			size++;
		}else if (size == 1) {
			root.setNextNode(newNode);
			newNode.setPrevNode(root);
			pointer = newNode;
			last = newNode;
			size++;

		} else {
			newNode.setPrevNode(last);
			last.setNextNode(newNode);
			last = newNode;
			pointer = newNode;
			size++;
		}
	}

	/**
	 * Insert an item in front of the current cursor position in the list.
	 * The cursor will refer to the newly inserted item.
	 * If the list is empty {@code item} becomes the first and last item in the list.
	 *
	 * Runtime Efficiency: O(1) - constant - this is because the item is inserted on current
	 * pointer position. The linked structure just corrects the next and previous references of 3 elements -
	 * (pointer element, previous element and the new node inserted). No shifting of elements is performed
	 * and no iteration is performed. So it is constant time operation.
	 *
	 * @param item The item to be inserted into the list.
	 */
	public void insert (T item) {

		Node newNode = new Node();
		newNode.setData(item);

		if (size == 0) {
			root = newNode;
			last = newNode;
			pointer = root;
			size++;
		}else if (size == 1) {
			root = newNode;
			root.setNextNode(last);
			last.setPrevNode(root);
			pointer = root;
			size++;
		}else if (pointer.getPrevNode() == null) {
			pointer.getNextNode().getPrevNode().setPrevNode(newNode);
			newNode.setNextNode(pointer.getNextNode().getPrevNode());
			root = newNode;
			pointer = root;
			size++;
		}else {
			Node next = pointer.getPrevNode().getNextNode();
			Node prev = pointer.getPrevNode();
			newNode.setNextNode(next);
			newNode.setPrevNode(prev);
			next.setPrevNode(newNode);
			prev.setNextNode(newNode);
			pointer = newNode;
			size++;
		}
	}

	/**
	 * Removes the item, at the current cursor position, from the list.
	 * Ensures that the previous item is correctly connected to the next item.
	 * After the removal the cursor will refer to the next item in the list.
	 * If the removed item was the last element in the list, then the cursor will
	 * refer to the previous element, which is now the last item in the list.
	 *
	 * Runtime Efficiency: O(1) - constant - this is because removing an element from this linked structure
	 * means reassigning the next and previous references of a elements next and previous to
	 * the pointer position, hence, no extra operation is needed here. That is why, it is constant
	 * time operation.
	 *
	 * @throws IndexOutOfBoundsException If an attempt is made to remove an element from an empty list.
	 */
	public void remove () {

		if (size == 0) {
			throw new IndexOutOfBoundsException("List is empty");
		}else if (size == 1) {
			root = root.getPrevNode();
			last = last.getPrevNode();
			pointer = pointer.getPrevNode();
			size--;
		}else {
			pointer.getPrevNode().setNextNode(pointer.getNextNode());
			pointer.getNextNode().setPrevNode(pointer.getPrevNode());
			pointer = pointer.getNextNode();
			size--;
		}
	}

	/**
	 * Move the internal cursor to the first element in the list.
	 *
	 * Runtime Efficiency: O(1) - constant - because the method refers to only class instance
	 * variable - root and gets the data. Also, it changes the pointer reference to the root element.
	 * This is a constant time operation as no iteration or shuffling is needed.
	 *
	 * @return The item at the first position in the list; null if the list is empty.
	 */
	public T getFirst() {

		if (size >0) {
			pointer = root;
			return root.getData();
		}
		return null;
	}

	/**
	 * Move the internal cursor to the next element in sequential order in the list.
	 * If the cursor is at the end of the list it remains at that position, and returns the item at that position.
	 *
	 * Runtime Efficiency: O(1) - constant - this is because the method only refers to next node
	 * from the pointer position. This is a constant time operation.
	 *
	 * @return The item at the new cursor position; null if the list is empty.
	 */
	public T getNext() {

		if (pointer.equals(last)) {
			return pointer.getData();
		}
		pointer = pointer.getNextNode();
		return pointer.getData();

	}

	/**
	 * Move the internal cursor to the last element in the list.
	 *
	 * Runtime Efficiency: O(1) - constant - this is because the method refers to class instance
	 * variable - last and get th data. Also, it changes the reference of pointer to the last node.
	 * This is a constant time operation.
	 *
	 * @return The item at the last position in the list; null if the list is empty.
	 */
	public T getLast () {

		if (size > 0){
			pointer = last;
			return last.getData();
		}
		return null;

	}

	/**
	 * Move the internal cursor to the previous element in sequential order in the list.
	 * If the cursor is at the beginning of the list it remains at that position, and returns the item at that position.
	 *
	 * Runtime Efficiency: O(1) - constant - this is because the method only refers to previous node
	 * from the pointer position. This is a constant time operation.
	 *
	 * @return The item at the new cursor position; null if the list is empty.
	 */
	public T getPrevious() {
		if (pointer ==  root) {
			return pointer.getData();
		}
		pointer = pointer.getPrevNode();
		return pointer.getData();
	}

	/**
	 * Finds an item in the list, moving the cursor to the item's position in the list.
	 * Starts searching from the beginning of the list, and stops when it finds the first instance of the item in the list.
	 * If the item is not found the cursor remains at the end of the list.
	 *
	 * Runtime Efficiency: O(n) - linear - this is because the method traverses through each node
	 * in the structure starting at the root node. So the runtime efficiency conforms to the
	 * number of elements in the list in the worst case as the element to be found may be the last one
	 * or may not be in the list altogether.
	 *
	 * @param item The item to be found.
	 * @return true if the item has been found in the list; false otherwise.
	 */
	public boolean find (T item) {

		Node thisNode = root;

		while (thisNode != null) {
			if (thisNode.getData().equals(item)) {
				pointer.setPrevNode(thisNode.getPrevNode());
				pointer.setNextNode(thisNode.getNextNode());
				return true;
			}
			thisNode = thisNode.getNextNode();
			pointer = thisNode;
		}
		return false;
	}

	/**
	 * Indicates if the list is empty or not.
	 *
	 * Runtime Efficiency: O(1) - constant - this is because the method only checks the
	 * class instance variable - size and gives thr result. This is a constant time operation.
	 *
	 * @return true if the list is empty (has no elements); false otherwise.
	 */
	public boolean isEmpty () {
		return size <= 0;

	}

	/**
	 * Indicates if the cursor is at the last element in the list.
	 * Will return false if the list is empty.
	 *
	 * Runtime Efficiency: O(1) - constant - this is because the method only checks for the next node of
	 * the pointer and makes the decision if the next element is null or not. If it is null,
	 * method returns true and false otherwise. This is a constant time operation because
	 * it performs only one operation by checking one element in the linked structure.
	 *
	 * @return true if the cursor position is the last element in the list; false otherwise.
	 */
	public boolean isLast () {
		if (isEmpty()) {
			return false;

		}else if (pointer.getNextNode() == null) {
			return true;
		}
		return false;

	}


	/**
	 * Node helper class for the Main LinkedList class
	 */
	private class Node {
		private T data;
		private Node nextNode;
		private Node prevNode;

		//Constructor
		private Node () { }

		// Getters and Setters
		private T getData() {
			return data;
		}

		private void setData(T data) {
			this.data = data;
		}

		private Node getNextNode() {
			return nextNode;
		}

		private void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		private Node getPrevNode() {
			return prevNode;
		}

		private void setPrevNode(Node prevNode) {
			this.prevNode = prevNode;
		}
	}
}

/*
 * Analysis
 */
