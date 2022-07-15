import java.util.*;
public class DequeArray <Item> implements Iterable<Item> {
    public Node first,last;
    private int count;
    public class Node{
        Item data;
        Node prev,next;
    } 
    // construct an empty deque
    public DequeArray(){
        first=last=null;
        size = 0;
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
            if (first == null)
                last = first = newNode;
            else{
                newNode.next = first;
                //front.prev = newNode;
                first = newNode;
            }
            count++;
        }
    }
    // add the item to the back
    public void addLast(Item item){
        if (item == null){
            throw new IllegalArgumentException();
        }else{
            Node newNode = new Node();
            newNode.data = item;
            if (last == null)
                first = last = newNode;
            else{
                newNode.prev = last;
                last = newNode;
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
        last = last.prev;
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
        DequeArray dq = new DequeArray();
        System.out.println(dq.isEmpty());
        dq.addFirst(33);
        dq.addLast(22);
        dq.addFirst(11);
        dq.addLast(14);
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