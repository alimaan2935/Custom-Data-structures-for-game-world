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
 * 1: Quad Tree
 * 2: Skip List
 * 3: Sparse Array
 */
