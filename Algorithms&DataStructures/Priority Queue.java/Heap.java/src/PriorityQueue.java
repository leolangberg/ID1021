import java.util.Arrays;
import java.util.NoSuchElementException;
public abstract class PriorityQueue {

    abstract void add( int value );
    abstract int remove();
    abstract void printlist();

    Node first;
    Node last;

    private class Node {

        int value;
        Node next;
        Node prev;

        private Node(int value, Node next, Node prev) {
            
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    static class lowlist extends PriorityQueue { //Low to high Priority


        public lowlist() {
            first = null;
            last = null;
        }

        public void add( int value ) { //push

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

        public int remove() { //pop priority

            if(first == null)
                throw new NoSuchElementException();

            Node lo = first;
            Node n = first;
            while(n != null)
            {
                if(n.value < lo.value)
                    lo = n;
                n = n.next;
            }
            int loval = lo.value;

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

        public void printlist() {

            Node a = first;
            Node b = last;
        

            int length = 0;
            Node n = first;
            while(n != null) {
                n = n.next;
                length++;
            }
            
            int i = 0;
            int[] forward = new int[length];
            int[] backward = new int[length];

            while(a != null) {
                forward[i] = a.value;
                a = a.next;
                backward[i] = b.value;
                b = b.prev;
                i++;
            }

            //System.out.println("FORWARDS: " + Arrays.toString(forward));
            System.out.println("BACKWARDS: " + Arrays.toString(backward));

        }
    }
    static class highlist extends PriorityQueue {

        public highlist() {
            first = null;
            last = null;
        }

        public void add( int value ) { //push

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

        public int remove() { //pop priority

            if(first == null)
                throw new NoSuchElementException();
    
            Node lo = first;
            Node n = first;
            while(n != null)
            {
                if(n.value > lo.value)
                    lo = n;
                n = n.next;
            }
            int loval = lo.value;
    
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

        public void printlist() {

            Node a = first;
            Node b = last;
            
    
            int length = 0;
            Node n = first;
            while(n != null) {
                n = n.next;
                length++;
            }
                
            int i = 0;
            int[] forward = new int[length];
            int[] backward = new int[length];
    
            while(a != null) {
                forward[i] = a.value;
                a = a.next;
                backward[i] = b.value;
                b = b.prev;
                i++;
            }

            System.out.println("FORWARDS: " + Arrays.toString(forward));
            System.out.println("BACKWARDS: " + Arrays.toString(backward));
        }
    }  
    public static void main( String[] args) {
        PriorityQueue A  = new PriorityQueue.highlist();
        
        A.add(5);
        A.add(4);
        A.add(3);
        A.add(2);
        A.add(1);

       
        A.printlist();

        A.remove();

        A.printlist();
    }
}