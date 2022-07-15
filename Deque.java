import java.util.Iterator;
import java.util.NoSuchElementException;

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
    {
        return count=0;
    }

    // add the item to the front
    public void addFirst(Item item)
    {
        if(item == null){
            throw new IllegalArgumentException("cannot add null to the deque");
        }else{
            Node newone = new Node();
            newone.data = item;
            if(first == null){
                first = last = newone;
            }
            else{
                newone.next = first;
                first = newone;
            }
            count++;
        }
    }

    // add the item to the back
    public void addLast(Item item)
    {
        if (item == null){
            throw new IllegalArgumentException();
        }else{
        Node newone=new Node();
        newone.data=item;
        if(last==null)
        {
            last=first=newone;
        }
        else{
            newone.next=last;
            last=newone;
        }
        count++;
    }
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if (count == 0) throw new NoSuchElementException(); 
        Item temp = first.data;
        first = first.next; 
        count--;
        return temp;
    }

    // remove and return the item from the back
    public Item removeLast(){
        if (count == 0) throw new NoSuchElementException(); 
        Item temp = last.data;
        last = last.next;
        count--;
        return temp; 
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new isIterator();
    }
    public class isIterator implements Iterator<Item>{
        Node temp = first;

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
        Deque<Integer> de=new Deque<Integer>();
        de.addFirst(564);
        de.addFirst(291);
        de.addLast(24);
        de.addLast(14);
        System.out.println(de.isEmpty());
        System.out.println(de.size());
        System.out.println(de.removeLast());
        System.out.println(de.removeFirst());
        System.out.println(de.size());
        System.out.println(de.removeLast());
        System.out.println(de.removeFirst());
        System.out.println(de.isEmpty());

    }

}

