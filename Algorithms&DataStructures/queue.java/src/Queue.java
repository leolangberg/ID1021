public class Queue <T> {

    Node queue;
    Node last;

    private class Node {
        T item;
        Node next;

        private Node(T itm, Node nxt) {
            this.item = itm;
            this.next = nxt;
        }
    }

    public void enqueue( T itm ) {
        Node n = new Node(itm, null);
        if( last != null)
            last.next = n;
        else //if(first == null)
            queue = n;
        last = n;

    }

    public T dequeue() {
        if( this.queue == null)
            return null;
        Node prv = null;
        Node nxt = this.queue;
        while(nxt.next != null)
        {
            prv = nxt;
            nxt = nxt.next;
        }
        if( prv == null)
            this.queue = null;
        else 
            prv.next = null;
        
        return nxt.item;
    }



}
