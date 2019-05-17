import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class Queue<E> {
    private E[] elements = (E[]) new Object[10];
    private int top = -1;

    public void add(E value) {
        if (top >= elements.length - 1) {
            expandSize();
        }
        elements[++top] = value;
    }

    public E peek() {
        if (top < 0) {
            throw new NoSuchElementException();
        }
        return elements[0];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public E remove() {
        if (top < 0) {
            throw new NoSuchElementException();
        }
        E example = elements[0];
        remove(0);
        return example;
    }

    public void remove(int index) {
        if (index > top || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        top--;
    }

    public void removeAll(E value) {
        if (top < 0) {
            throw new NoSuchElementException();
        }
        for (int i = 0; i <= size() - 1; i++) {
            if (elements[i] == value) {
                remove(i);
                i--;
            }
        }
    }

    public void removeDuplicates() {
        Set<E> duplicate = new HashSet<>();
        for (int i = 0; i <= top - 1; i++) {
            if (!duplicate.contains(elements[i])) {
                duplicate.add(elements[i]);
            } else {
                remove(i);
            }
        }
    }

    public E get(int index) {
        if (top < index) {
            throw new IndexOutOfBoundsException();
        }

        return elements[index];
    }

    public int size() {
        return top + 1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Queue<?> && ((Queue<?>) obj).size() == this.size()) {
            for (int i = 0; i < size(); i++) {
                if (!((Queue<?>) obj).get(i).equals(elements[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public String toString() {
        return Arrays.toString(elements);
    }

    private void expandSize() {
        int increasedSize = elements.length * 2;
        elements = Arrays.copyOf(elements, increasedSize);
    }
}