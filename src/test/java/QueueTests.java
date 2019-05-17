import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class QueueTests {

    @Test
    public void addAndRemoveFirstElement() {
        Queue<String> queue = new Queue<>();
        queue.add("hello");

        assertEquals("hello", queue.remove());
    }

    @Test
    public void addTwoElementsRemoveOne() {
        Queue<String> queue = new Queue<>();
        queue.add("hello");
        queue.add("world");

        assertEquals("hello", queue.remove());
    }

    @Test
    public void addAndRemoveTwoElements() {
        Queue<String> queue = new Queue<>();
        queue.add("hello");
        queue.add("world");
        queue.remove();

        assertEquals("world", queue.remove());
    }

    @Test(expected = NoSuchElementException.class)
    public void removeFromEmptyQueue() {
        Queue<String> queue = new Queue<>();
        queue.remove();
    }

    @Test
    public void emptyQueue() {
        Queue<Integer> queue = new Queue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void nonEmptyQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.add(42);

        assertFalse(queue.isEmpty());
    }

    @Test
    public void queueReturnToEmpty() {
        Queue<Integer> queue = new Queue<>();
        queue.add(42);
        queue.remove();

        assertTrue(queue.isEmpty());
    }

    @Test(expected=NoSuchElementException.class)
    public void peekEmptyQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.peek();
    }

    @Test
    public void peekReturnsFirstElement() {
        Queue<String> queue = new Queue<>();
        queue.add("hello");
        queue.add("world");

        assertEquals("hello", queue.peek());
    }

    @Test
    public void peekDoesNotRemoveElement() {
        Queue<String> queue = new Queue<>();
        queue.add("hello");
        queue.peek();

        assertEquals("hello", queue.remove());
    }

    @Test
    public void removeIndex() {
        Queue<String> queue = new Queue<>();
        queue.add("hello");
        queue.add("beautiful");
        queue.add("world");
        queue.remove(1);

        String[] expected = {"hello", "world"};
        String[] output = {queue.remove(), queue.remove()};
        assertArrayEquals(expected, output);
    }

    @Test
    public void removeLastIndex() {
        Queue<String> queue = new Queue<>();
        queue.add("hello");
        queue.add("beautiful");
        queue.add("world");
        queue.remove(2);

        String[] expected = {"hello", "beautiful"};
        String[] output = {queue.remove(), queue.remove()};
        assertArrayEquals(expected, output);
    }

    @Test
    public void removeFirstIndex() {
        Queue<String> queue = new Queue<>();
        queue.add("hello");
        queue.add("beautiful");
        queue.add("world");
        queue.remove(0);

        String[] expected = {"beautiful", "world"};
        String[] output = {queue.remove(), queue.remove()};
        assertArrayEquals(expected, output);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeNegativeIndex() {
        Queue<String> queue = new Queue<>();
        queue.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeHighIndex() {
        Queue<String> queue = new Queue<>();
        queue.remove(42);
    }

    @Test
    public void removeAll() {
        Queue<String> queue = new Queue<>();
        queue.add("hello");
        queue.add("hello");
        queue.add("hello");
        queue.removeAll("hello");

        assertTrue(queue.isEmpty());
    }

    @Test
    public void removeAllDoesNotAffectNonMatches() {
        Queue<String> queue = new Queue<>();
        queue.add("world");
        queue.removeAll("hello");

        assertEquals("world", queue.remove());
    }

    @Test
    public void removeDuplicates() {
        Queue<String> queue = new Queue<>();
        queue.add("hello");
        queue.add("world");
        queue.add("hello");
        queue.add("beautiful");
        queue.add("world");
        queue.removeDuplicates();

        String[] expected = {"hello", "world", "beautiful"};
        String[] output = {queue.remove(), queue.remove(), queue.remove()};
        assertArrayEquals(expected, output);
    }

    @Test
    public void emptyQueuesAreEqual() {
        Queue<String> q1 = new Queue<>();
        Queue<String> q2 = new Queue<>();

        assertEquals(q1, q2);
    }

    @Test
    public void equalQueues() {
        Queue<String> q1 = new Queue<>();
        Queue<String> q2 = new Queue<>();

        q1.add("hello");
        q2.add("hello");
        q1.add("world");
        q2.add("world");

        assertEquals(q1, q2);
    }

    @Test
    public void unevenQueues() {
        Queue<String> q1 = new Queue<>();
        Queue<String> q2 = new Queue<>();

        q1.add("hello");
        q2.add("hello");
        q1.add("world");

        assertNotEquals(q1, q2);
    }

    @Test
    public void unequalQueues() {
        Queue<String> q1 = new Queue<>();
        Queue<String> q2 = new Queue<>();

        q1.add("hello");
        q2.add("hello");
        q1.add("world");
        q2.add("beautiful");

        assertNotEquals(q1, q2);
    }
}