package au.edu.uq.itee.comp3506.assn1.adts;

/**
 * A two-dimensional rectangular grid to hold items in a positional relationship to each other.
 * Implements Grid ADT class
 *
 * Memory efficiency: O(n) - linear - This is because the implementation resembles 2-dimensional array.
 * The number of elements in this grid will be x * y where x and y are number of rows and columns respectively.
 * So the memory efficiency is equal to number of elements stored in the grid. In the worst case when
 * the grid is gull, the number of elements will be number of rows multiplied by number of columns.
 *
 * @author ALi Nawaz Maan <a.maan@uqconnect.edu.au>
 * @param <T> The type of element held in the rectangular grid.
 */
public class RectangularGrid<T> implements Grid<T> {

    T[][] grid;


    /**
     * Constructor for Rectangular grid object
     *
     * Runtime Efficiency: O(n) - linear - this is because when creating this 2-dimensional grid,
     * java initializes every position of element with null. So initializing every element
     * conforms to runtime efficiency equal to order of number of elements which is the size of the grid
     * x * y.
     *
     * @param x number of columns in the rectangular grid
     * @param y number of rows in the rectangular grid
     * @throws IllegalArgumentException when column and row values are not positive integers
     */
    public RectangularGrid(int x, int y) {

        if (x > 0 && y > 0) {
            grid = (T[][]) new Object[y][x];
        }else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Place an item at a fixed position in the rectangular grid.
     * Overwrites whatever was at the position.
     *
     * Runtime Efficiency: O(1) - constant - this is because the grid is initialized with known size
     * and when placing an element onto a known coordinate location, java will directly access
     * that position under coordinates and write the element data in that particular memory location.
     *
     * @param item Item to be placed in the grid.
     * @param x X Coordinate of the position of the item.
     * @param y Y Coordinate of the position of the item.
     * @throws IndexOutOfBoundsException If x or y coordinates are out of bounds.
     */
    public void place(T item, int x, int y){

        if ((x < grid[0].length && x>=0) && (y < grid.length && y>=0)) {
            grid[y][x] = item;
        }else {
            throw new IndexOutOfBoundsException("Grid coordinates cannot be negative or out of grid size(coordinates)");
        }
    }

    /**
     * Return the item at the indicated position.
     *
     * Runtime Efficiency: O(1) - constant - This is same as {@code place()} because the grid is initialized with
     * known number of rows and columns. When retrieving an element from the grid with knows coordinate location,
     * java will refer that memory location directly and return the element in a constant time.
     *
     * @param x X Coordinate of the position of the item.
     * @param y Y Coordinate of the position of the item.
     * @return Item at this position or null.
     * @throws IndexOutOfBoundsException If x or y coordinates are out of bounds.
     */
    public T get(int x, int y) {

        if ((x <= grid[0].length && x>=0) && (y <= grid.length && y>=0)) {
            return grid[y][x];
        }else {
            throw new ArrayIndexOutOfBoundsException("These coordinates doesn't exist in the grid");
        }

    }
}

/*
 * Analysis
 * This is a trivial implementation of a 2-dimensional array. In terms of required operation of placing
 * and element and getting an element from the grid, it is very efficient in terms of runtime asymptotic
 * complexity. But in terms of memory and space, this implementation will be inefficient when the size
 * of the list increases.
 * This is specially the case with a very large sized empty grid declaration. As java initializes every
 * element of the array as null initially, and the element null also takes some space, initialization
 * takes time and the element collection takes space. That is why, it is not efficient for large sized
 * grid initialization with very few elements as the structure will take more space than it is required.
 * In general, it is not recommended to have such an implementation for game worlds because time and
 * space efficiency is the key to smoother game play. This space inefficiency will have a negative effect
 * on the overall experience and performance of the program.
 * Moreover, this 2 dimensional grid implementation is restricted by its size initialization. That means
 * it cannot be resized automatically when needed. So, whenever we need to resize the grid, we have to copy
 * the old grid elements into a new bigger sized grid. That is inefficient in terms of runtime complexity.[1]
 *
 * The alternate implementation to this in my point of view will be "Skip List". Visually, skip list resembles
 * multi-dimensional linked linked structure with right, left, up and down connections to nodes. But the skip
 * list data structure is implemented with arrays.
 * The efficient part of the structure is that although it represent a grid like structure, the space elements
 * may not be filled with anything rather just an empty space between rows and columns. The memory efficiency
 * for the data structure is known to be O(n) where n is the actual number of elements stored in the list at
 * any given time. Moreover, searching through the list and insertions has the efficiency of O(logn). (Goodrich, c2014)
 *
 * Another implementation might be a "Sparse Matrix" as a linked list representation. The sparse matrix array
 * representation is same as a 2-dimensional grid but the linked list implementation is quite efficient and
 * similar to "Skip List". Instead of giving a null or zero value to empty spaces in the grid, linked list
 * representation of a sparse matrix is far more memory efficient as the nodes contain reference to the
 * number of column, row, right, left, up and down nodes for determining the correct position of the element
 * in the grid. (Gupta, 2007)
 *
 * Both of these alternate implementations of a grid structure are memory efficient when it comes to a very large
 * sized grid with very few elements to store. Searching through the grid is done efficiently using skip list.
 * But insertion and deletion is efficient in sparse matrix when it comes to runtime efficiency.
 *
 *
 * Reference:
 *
 * Goodrich, M.T Tamassia, R & Goldwasser, M.H. (c2014). Fundamental Data Structures. in Data Structures & Algorithms in Java (pp. 132). United States: John Wiley & Sons, Inc.
 *
 * Gupta, P. Agarwal, V. Varshney, M. (2007). Arrays. In Data Structure Using C (pp. 31). New Dehli: Firewall Media.
 */
