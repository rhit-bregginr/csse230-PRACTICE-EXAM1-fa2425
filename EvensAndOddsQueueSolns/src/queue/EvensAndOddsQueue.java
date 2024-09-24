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
        items = new ArrayList<Integer>();
        // Realize: This is going to be a little bit weird.
        // Anytime we insert an odd item, the ArrayList will shift the odds down another one.
        // (This happens as a consequence of calling insert with a
        // particular index, everything shifts to the right one)
        oddStartIndex = 0;
        evenStartIndex = -1;
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
        if (element % 2 == 0) {
        	// even element. Add where we expect it (will be the end of the list)
        	
        	// initialization edge case (I'm lazy):
        	if (evenStartIndex == -1) {
        		items.add(element);
        		evenStartIndex = items.size() - 1;
        		evensSize++;
        		return;
        	}
        	items.add(evenStartIndex + evensSize, element);
        	evensSize++;
        } else {
        	// Odd element. We know where the odds start, and we know how many we have.
        	// We are just going to add at the end of that bunch of numbers.
        	// So if the odds start at index 1, and I have one odd item, then I add at index 2.
        	// Start at index 1, have 2 elements, I want to add at index 3.
        	items.add(oddStartIndex + oddsSize, element);
        	oddsSize++;
        	// bump the evens down one to mimic what happens with the ArrayList.
        	evenStartIndex++;
        }
    }

    /**
     * Tells you if the queue is empty or not.
     * @return True if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * @return The number of items (odds + evens) in the queue.
     */
    public int size() {
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
        if (evensSize == 0) { // No items to pull.
        	throw new NoSuchElementException();
        }
        // since we pull from the START of our even indices, we need to increment
        // the pointer to reflect our dequeue.
        evensSize--;
        Integer item = items.get(evenStartIndex);
        evenStartIndex++; // Note that not resetting this could be really bad for memory,
        // I'm not stressing about that right now. But creative solutions here are good.
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
    	if (oddsSize == 0) { // No items to pull.
        	throw new NoSuchElementException();
        }
        // since we pull from the START of our odd indices, we need to increment
        // the pointer to reflect our dequeue.
        oddsSize--;
        Integer item = items.get(oddStartIndex);
        oddStartIndex++; // Note that not resetting this could be really bad for memory,
        // I'm not stressing about that right now. But creative solutions here are good.
        return item;
    }

    /**
     * Peeks at the first even number in the queue.
     * If there are no even numbers in the queue, throw a NoSuchElementException.
     * @return The first even number in the queue.
     * @throws NoSuchElementException If there are no even numbers in the queue.
     */
    public Integer peekOdd() throws NoSuchElementException {
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
    	if (evensSize == 0) {
        	throw new NoSuchElementException();
        }
        return items.get(evenStartIndex);
    }
}
