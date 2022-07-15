import java.util.*;
public class DequeArray <Item> implements Iterable<Item> {
    private static final int Max = 10;

    private Item[] arr; // queue elements
    private int count; // number of elements on queue
    private int first; // index of first element of queue
    private int last; // index of next available slot

    } 
    // construct an empty deque
    public DequeArray(){
        arr = (Item[]) new Object[Max];
        count = 0;
        first = 0;
        last = 0;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return count == 0;
    }

    // return the number of items on the deque
    public int size(){
        return count;
    }

    // add the item to the front
    public void addFirst(Item item){
        if (item == null){
            throw new IllegalArgumentException("cannot add null to the deque.");
        }else{
            Node newNode = new Node();
            newNode.data = item;
            if (front == null)
                rear = front = newNode;
            else{
                newNode.next = front;
                //front.prev = newNode;
                front = newNode;
            }
            size++;
        }
    }
    // add the item to the back
    public void addLast(Item item){
        if (item == null){
            throw new IllegalArgumentException();
        }else{
            Node newNode = new Node();
            newNode.data = item;
            if (rear == null)
                front = rear = newNode;
            else{
                newNode.prev = rear;
                rear = newNode;
            }
            size++;
        }
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if (size == 0) throw new NoSuchElementException();
        Item temp = front.data;
        front = front.next; 
        size--;
        return temp;
    }

    // remove and return the item from the back
    public Item removeLast(){
        if (size == 0) throw new NoSuchElementException(); 
        Item temp = rear.data;
        rear = rear.prev;
        size--;
        return temp; 
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new isIterator();
    }

    public class isIterator implements Iterator<Item>{
        Node temp = front;

        public boolean hasNext(){
            return temp != null;
        }

        public Item next(){
            if(!hasNext())throw new NoSuchElementException();
            Item temp1 = temp.data;
            temp = temp.next;
            return temp1; 
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args){
        DequeArray dq = new DequeArray();
        System.out.println(dq.isEmpty());
        dq.addFirst(11);
        dq.addLast(12);
        dq.addFirst(13);
        dq.addLast(14);
        dq.addFirst(15);
        dq.addLast(16);
        System.out.println(dq.isEmpty());
        System.out.println(dq.size());
        System.out.println(dq.removeLast());
        System.out.println(dq.removeFirst());
        System.out.println(dq.size());
        System.out.println(dq.removeLast());
        System.out.println(dq.removeFirst());
        System.out.println(dq.isEmpty());

    }

}