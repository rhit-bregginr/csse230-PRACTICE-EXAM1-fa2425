import java.util.ArrayList;
import java.util.NoSuchElementException;

public class EvensAndOddsQueue {

    // Need more details? See the markdown file titled:
    //     codingPortionDetails.md
    
    // RESTRICTION: You may only use this ONE ArrayList to solve the problem.
    // You MAY use temporary ones in certain methods (hint hint, nudge nudge),
    // but you may NOT use additional ArrayList fields. This may need to grow!
    private ArrayList<Integer> items;
    
    // Add any additional fields you need to solve the problem here.
    

    /**
     * Creates an EvensAndOddsQueue object, initializing any fields as necessary.
     */
    public EvensAndOddsQueue() {
        // TODO: Implement me!
    }

    /**
     * Enqueues the given element.
     * Restriction:
     *     This must run in O(1) amortized time for both even AND odd numbers.
     *     Think carefully about how you should store the items, as you need
     *     the dequeueEven() and dequeueOdd() methods to also be O(1)*.
     * @param element The element to add.
     */
    public void enqueue(int element) {
        // TODO: Implement me!
    }

    /**
     * Tells you if the queue is empty or not.
     * @return True if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        // TODO: Implement me!
        return false;
    }

    /**
     * @return The number of items (odds + evens) in the queue.
     */
    public int size() {
        // TODO: Implement me!
        return 0;
    }

    /**
     * Dequeues the first even number in the queue.
     * Restriction:
     *     The code you write must be O(1), i.e. you may not iterate over the list.
     * 
     *     However, you are allowed things like ArrayList's remove(), which will make 
     *     this technically O(N).
     * @return The first even number in the queue.
     * @throws NoSuchElementException If there are no even numbers in the queue.
     */
    public Integer dequeueEven() throws NoSuchElementException {
        // TODO: Implement me!
        throw new NoSuchElementException();
    }

    /**
     * Dequeues the first odd number in the queue.
     * If there are no odd numbers in the queue, throw a NoSuchElementException.
     * Restriction:
     *     The code you write must be O(1), i.e. you may not iterate over the list.
     * 
     *     However, you are allowed things like ArrayList's remove(), which will make 
     *     this technically O(N).
     * @return The first odd number in the queue.
     * @throws NoSuchElementException If there are no odd numbers in the queue.
     */
    public Integer dequeueOdd() throws NoSuchElementException {
        // TODO: Implement me!
        throw new NoSuchElementException();
    }

    /**
     * Peeks at the first even number in the queue.
     * If there are no even numbers in the queue, throw a NoSuchElementException.
     * @return The first even number in the queue.
     * @throws NoSuchElementException If there are no even numbers in the queue.
     */
    public Integer peekOdd() throws NoSuchElementException {
        // TODO: Implement me!
        throw new NoSuchElementException();
    }

    /**
     * Peeks at the first odd number in the queue.
     * If there are no odd numbers in the queue, throw a NoSuchElementException.
     * @return The first odd number in the queue.
     * @throws NoSuchElementException If there are no odd numbers in the queue.
     */
    public Integer peekEven() throws NoSuchElementException {
        // TODO: Implement me!
        throw new NoSuchElementException();
    }
}
