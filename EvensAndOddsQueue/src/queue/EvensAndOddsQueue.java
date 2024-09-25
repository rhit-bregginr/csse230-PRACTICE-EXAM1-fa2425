package queue;
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
    int oddStartIndex;
    int evenStartIndex;
    int evensSize = 0;
    int oddsSize = 0;

    /**
     * Creates an EvensAndOddsQueue object, initializing any fields as necessary.
     */
    public EvensAndOddsQueue() {
        // DONE: Implement me!
    	items = new ArrayList<Integer>();
    }

    /**
     * Enqueues the given element.
     * Restriction:
     *     This must run in O(N) time for both even AND odd numbers.
     *     Think carefully about how you should store the items, as you need
     *     the dequeueEven() and dequeueOdd() methods to also be O(1)*.
     * @param element The element to add.
     */
    public void enqueue(int element) {
        // DONE: Implement me!
        if (element % 2 == 0) { // even elements + expected location
        	
        	if (evenStartIndex == -1) { // edge case
        		items.add(element);
        		evenStartIndex = items.size() - 1;
        		evensSize++;
        		return;
        	}
        	
        	items.add(evenStartIndex + evensSize, element);
        	evensSize++;
        	
        } else { // odd elements
        	items.add(oddStartIndex + oddsSize, element);
        	oddsSize++;
        	evenStartIndex++;
        }
    }

    /**
     * Tells you if the queue is empty or not.
     * @return True if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        // DONE: Implement me!
    	return size() == 0;
    }

    /**
     * @return The number of items (odds + evens) in the queue.
     */
    public int size() {
        // DONE: Implement me!
    	return evensSize + oddsSize;
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
        // DONE: Implement me!
        if (evensSize == 0) { // No items to pull.
        	throw new NoSuchElementException();
        }
        evensSize--; // change even #
        Integer item = items.get(evenStartIndex);
        evenStartIndex++;
        return item;
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
        // DONE: Implement me!
    	if (oddsSize == 0) { // No items to pull.
        	throw new NoSuchElementException();
        }
    	
        oddsSize--;
        Integer item = items.get(oddStartIndex);
        oddStartIndex++;
        return item;
    }

    /**
     * Peeks at the first even number in the queue.
     * If there are no even numbers in the queue, throw a NoSuchElementException.
     * @return The first even number in the queue.
     * @throws NoSuchElementException If there are no even numbers in the queue.
     */
    public Integer peekOdd() throws NoSuchElementException {
        // DONE: Implement me!
        if (oddsSize == 0) {
        	throw new NoSuchElementException();
        }
        return items.get(oddStartIndex);
    }

    /**
     * Peeks at the first odd number in the queue.
     * If there are no odd numbers in the queue, throw a NoSuchElementException.
     * @return The first odd number in the queue.
     * @throws NoSuchElementException If there are no odd numbers in the queue.
     */
    public Integer peekEven() throws NoSuchElementException {
        // DONE: Implement me!
    	if (evensSize == 0) {
        	throw new NoSuchElementException();
        }
        return items.get(evenStartIndex);
    }
}
