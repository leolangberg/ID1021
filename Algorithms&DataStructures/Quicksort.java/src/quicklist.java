public class quicklist<T extends Comparable<T>> {

    Node first;
    Node last;

    private class Node {
        T item;
        Node next;

        private Node( T itm, Node nxt) {
            
            this.item = itm;
            this.next = nxt;
        }
    }

    public quicklist() {
        this.first = null;
        this.last = null;
    }

    public quicklist(T[] arr) {
        if(arr.length == 0) {
            this.first = null;
            this.last = null;
        }
        //Code:

        //
    }

    public void append(quicklist<T> tail) {
        if(tail != null) {
            if(this.last != null)
                this.last.next = tail.first;
            else 
                this.first = tail.first;
            if(tail.last != null)  //might be unnecessary
                this.last = tail.last;
            tail.first = null;
            tail.last = null;
        }
    }

    public void prepend(quicklist<T> front) {
        if(front != null)
        {
            if(front.last != null)
                front.last.next = this.first;
            if(this.last == null)
                this.last = front.last;
            if(front.first != null)
                this.first = front.first;
        }
    } 

    private void cons(Node nd) {
        if(this.last == null)
            this.last = nd;
        nd.next = this.first;
        this.first = nd;
    }

    public void sort() {
        if(this.first == null || this.first.next == null)
            return;
        
        quicklist<T> smaller = new quicklist<T>();
        quicklist<T> larger = new quicklist<T>();

        Node pivot = this.first;
        Node cur = pivot.next;
        pivot.next = null;

        //pivot is now the only element in this linked list
        this.last = pivot;
        T p = pivot.item;

        //This is the partition operation

        while( cur != null) {
             Node nxt = cur.next;
            if( p.compareTo(cur.item) > 0) {
                 smaller.cons(cur);
            } else {
                larger.cons(cur);
            }
             cur = nxt;
        }
        smaller.sort();
        larger.sort();
        //this holds pivot
        this.append(larger);
        this.append(smaller);
    }

    public static void main(String[] args) {

        quicklist<Integer> A  = new quicklist<>();
        
        
    }
    
}