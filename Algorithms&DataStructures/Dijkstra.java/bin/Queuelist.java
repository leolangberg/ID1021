public class Queuelist<T> {
    
    Node<T> first;
    Node<T> last; //last

    private class Node<T> {
        T item;
        Node<T> next;
        Integer index;

        private Node( T item, Node<T> next, Integer index)
        {
            this.item = item;
            this.next = next;
            this.index = index;
        }
    }

    public Queuelist() {
        first = null;
        last = null;
    }

    public void add( T item) {
        Node<T> n = new Node<>(item, null, null);
        //System.out.println(n.item);
        if( last != null)
            last.next = n;
        else //if(first == null)
            first = n;
        last = n;
        
    }

    public T remove() { //take out
        if(empty() == true)
            return null;

        else if (first == last)
        {
            T ret = first.item;
            first = null;
            last = null;
            return ret;
        }
        else {
            T ret = first.item;
            first = first.next;
            return ret;
        }
    }

    public boolean empty() {
        return (first == null);
    }

    private int compare( Node n )
    {

    }
}
