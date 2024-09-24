package queue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.NoSuchElementException;

import org.junit.Test;

public class EvensAndOddsQueueTest {

    @Test
    public void testEvensAndOddsQueue_basicEnqueue_checkSizeGrowth() {
        EvensAndOddsQueue queue = new EvensAndOddsQueue();
        queue.enqueue(1);
        assertEquals(1, queue.size());

        queue.enqueue(2);
        assertEquals(2, queue.size());

        queue.enqueue(4);
        assertEquals(3, queue.size());
    }

    @Test
    public void testEvensAndOddsQueue_advancedEnqueue_queueALotOfItems() {
        // This does not have a time limit on it, but this should make it
        // obvious if you are not choosing to store your data in a way
        // that is conducive to ArrayList growth.

        // Note that ArrayLists have a default capacity of 10. This will
        // have to grow a few times to accommodate 100 elements.
        EvensAndOddsQueue queue = new EvensAndOddsQueue();
        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
        }
        assertEquals(100, queue.size());

        // dequeue some evens, and some odds.
        for (int i = 0; i < 15; i++) {
            assertEquals((Integer) (i * 2), queue.dequeueEven());
            assertEquals((Integer) ((i * 2) + 1), queue.dequeueOdd());
            assertEquals(100 - (2 * (i + 1)), queue.size());
        }
    }

    @Test
    public void testEvensAndOddsQueue_queueEvens_returnEvensUntilEmpty() {
        EvensAndOddsQueue queue = new EvensAndOddsQueue();
        
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);
        assertEquals(3, queue.size());

        assertEquals((Integer) 2, queue.dequeueEven());
        assertEquals((Integer) 4, queue.dequeueEven());
        assertEquals((Integer) 6, queue.dequeueEven());
        assertEquals(0, queue.size());

        // Try to dequeue another even, this should throw an exception
        assertThrows(NoSuchElementException.class, () -> queue.dequeueEven());
    }

    @Test
    public void testEvensAndOddsQueue_queueOdds_returnOddsUntilEmpty() {
        EvensAndOddsQueue queue = new EvensAndOddsQueue();
        
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(5);
        assertEquals(3, queue.size());

        assertEquals((Integer) 1, queue.dequeueOdd());
        assertEquals((Integer) 3, queue.dequeueOdd());
        assertEquals((Integer) 5, queue.dequeueOdd());
        assertEquals(0, queue.size());

        // Try to dequeue another odd, this should throw an exception
        assertThrows(NoSuchElementException.class, () -> queue.dequeueOdd());
    }

    @Test
    public void testEvensAndOddsQueue_queueBoth_dequeueAllEvens_ensureOddsRemain() {
        EvensAndOddsQueue queue = new EvensAndOddsQueue();
        
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(5);
        assertEquals(6, queue.size());

        assertEquals((Integer) 2, queue.dequeueEven());
        assertEquals((Integer) 4, queue.dequeueEven());
        assertEquals((Integer) 6, queue.dequeueEven());
        assertEquals(3, queue.size());

        // Try to dequeue another even, this should throw an exception
        assertThrows(NoSuchElementException.class, () -> queue.dequeueEven());

        // Check the size one last time.
        assertEquals(3, queue.size());
    }

    @Test
    public void testEvensAndOddsQueue_peekEven_returnFirstEven() {
        EvensAndOddsQueue queue = new EvensAndOddsQueue();
        
        queue.enqueue(2);
        queue.enqueue(4);

        assertEquals((Integer) 2, queue.peekEven());

        // Queue size does not change with a peek.
        assertEquals(2, queue.size());
    }

    @Test
    public void testEvensAndOddsQueue_peekEvenWithNoEvensInQueue_throwException() {
        EvensAndOddsQueue queue = new EvensAndOddsQueue();
        
        queue.enqueue(1);
        queue.enqueue(3);

        assertThrows(NoSuchElementException.class, () -> queue.peekEven());
    }

    @Test
    public void testEvensAndOddsQueue_peekOdd_returnFirstOdd() {
        EvensAndOddsQueue queue = new EvensAndOddsQueue();
        
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(11);

        assertEquals((Integer) 1, queue.peekOdd());

        // Queue size does not change with a peek.
        assertEquals(3, queue.size());
    }

    @Test
    public void testEvensAndOddsQueue_peekOddWithNoOddsInQueue_throwException() {
        EvensAndOddsQueue queue = new EvensAndOddsQueue();
        
        queue.enqueue(2);
        queue.enqueue(4);

        assertThrows(NoSuchElementException.class, () -> queue.peekOdd());
    }

    @Test
    public void testEvensAndOddsQueue_isEmpty_returnTrueWhenEmpty() {
        EvensAndOddsQueue queue = new EvensAndOddsQueue();
        assertEquals(true, queue.isEmpty());

        queue.enqueue(1);
        assertEquals(false, queue.isEmpty());

        queue.dequeueOdd();
        assertEquals(true, queue.isEmpty());
    }
}
