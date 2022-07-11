public class Deque<Item> implements Iterable<Item> {
    public Node first,last;
    private int count;

    public class Node{
        Item data;
        Node next;
    }
    
    // construct an empty deque
    public Deque()
    {
        first=null;
        last=null;
        count=0;
    }

    // is the deque empty?
    public boolean isEmpty()
    {
        return count==0;
    }

    // return the number of items on the deque
    public int size()

    // add the item to the front
    public void addFirst(Item item)

    // add the item to the back
    public void addLast(Item item)

    // remove and return the item from the front
    public Item removeFirst()

    // remove and return the item from the back
    public Item removeLast()

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()

    // unit testing (required)
    public static void main(String[] args)

}

