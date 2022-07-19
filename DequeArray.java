import java.util.*;
public class DequeArray < Item > implements Iterable < Item > {
    private static final int Max = 10;

    private Item[] arr; // queue elements
    private int size; // number of elements on queue
    private int first; // index of first element of queue
    private int rear; // index of next available slot

    public DequeArray() {
        arr = (Item[]) new Object[Max];
        size = 0;
        first = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // resize the underlying array
    private void resize(int capacity) {
        assert capacity >= size;
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = arr[(first + i) % arr.length];
        }
        arr = copy;
        first = 0;
        rear = size;
    }

    public void addFirst(Item item) {
        if (size == arr.length) resize(2 * arr.length); // double size of array if necessary
        //Memory usage si higher and Time Complexity is in o👎
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = item;
        rear++;
        size++;
    }

    public void addLast(Item item) {
        if (size == arr.length) resize(2 * arr.length); // double size of array if necessary
        arr[rear++] = item; // add item
        if (rear == arr.length) rear = 0; // wrap-around
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item temp = arr[first];
        arr[first] = null; // to avoid loitering
        size--;
        first++;
        //rear--;
        if (first == arr.length) first = 0; // wrap-around
        // shrink size of array if necessary
        if (size > 0 && size == arr.length / 4) resize(arr.length / 2);
        return temp; 
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = arr[rear];
        while (item == null){
            item = arr[rear--];
        }
        size--;
        // shrink size of array if necessary
        if (size > 0 && size == arr.length / 4) resize(arr.length / 2);
        return item;
    }

    public Iterator < Item > iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator < Item > {
        private int i = 0;
        public boolean hasNext() {
            return i < size;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = arr[(i + first) % arr.length];
            i++;
            return item;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DequeArray dq = new DequeArray();
        dq.addFirst(11);
        dq.addLast(12);
        dq.addFirst(13);
        dq.addLast(14);
        dq.addFirst(15);
        dq.addLast(16);
        System.out.println(Arrays.toString(dq.arr));
        System.out.println(dq.size());
        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
        System.out.print(dq.size());
    }
}