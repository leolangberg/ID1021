import java.util.NoSuchElementException;

public class PriorityQueue<T extends Comparable<T>> { //Low to high Priority

    Node first;
    Node last;

    private class Node {

        T value;
        Node next;
        Node prev;

        private Node(T value, Node next, Node prev) {
            
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public PriorityQueue() {
        first = null;
        last = null;
    }

    public void add( T value ) { //push

        Node n = new Node(value, null, null);
        if(first == null) {
            first = n;
            last = n;
        }
        else {
            n.next = first;
            first.prev = n;
            first = n;
        }
    }

    public T remove() { //pop priority

        if(first == null)
            throw new NoSuchElementException();

        Node lo = first;
        Node n = first;
        while(n != null)
        {
            if(n.value.compareTo(lo.value) < 0)
                lo = n;
            n = n.next;
        }
        T loval = lo.value;

        if(lo == first) {  //ALL CORNERCASES
            if(last == first) {
                first = null;
                last = null;
                lo = null;
            }
            else {
                lo.next.prev = null;
                first = lo.next;
            }
        }
        else if(lo == last) {
            lo.prev.next = null;
            last = lo.prev;
        }
        else {
            lo.prev.next = lo.next;
            lo.next.prev = lo.prev;
        }
        return loval;
    }

    public boolean empty() {
        if(first == null)
            return true;
        else 
            return false;
    }
    
    

  

    
}
