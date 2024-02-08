import java.util.Arrays;

public class quicksortlinkedlist {
    
    Node first;
    Node last;

    private class Node {
        int value;
        Node next;

        private Node(int value, Node next) {

            this.value =  value;
            this.next = next;
        }
    }

    public quicksortlinkedlist() {
        first = null;
        last = null;
    }

    public void add(int value) {
        Node a = new Node(value, null);
        if( last != null)
            last.next = a;
        else 
            first = a;
        last = a;
    }

    public void print() {
        Node a = first;
        int length = 0;
        while(a != null)
        {
            length++;
            a = a.next;
        }
        int[] printer = new int[length];
        Node b = first;
        int i = 0;
        while(b != null)
        {
            printer[i] = b.value;
            b = b.next;
            i++;
        }
        System.out.println(Arrays.toString(printer));
    }

    public void addNode( Node a)
    {
        Node b = new Node(a.value, null);

        if( last != null)
        last.next = b;
        else {
            first = b;
        }
        last = b;  
        
       
    }

    public void quicksortlist() {

        this.print();

        if(this.first == null || this.first.next == null)
            return;
        
        quicksortlinkedlist lower = new quicksortlinkedlist();
        quicksortlinkedlist higher = new quicksortlinkedlist();
        
        Node i  = this.first;
        Node piv = this.last; 
        this.first = piv;
    
        partititon(i, piv, lower, higher);
        
        lower.quicksortlist();
        higher.quicksortlist();

        this.join(lower, higher);
    }

    private void join( quicksortlinkedlist lower, quicksortlinkedlist higher) {
        
        if(lower.last != null) {      
            lower.last.next = this.first;
            this.first = lower.first;
        }
        if(higher.first != null) {
            this.last.next = higher.first;
            this.last = higher.last;
        } 
    }


    private void partititon(Node i, Node piv, quicksortlinkedlist lower, quicksortlinkedlist higher)
    {
        int pivot = piv.value;
        
        while(i != piv) 
        {
            if( pivot > i.value) {
                lower.addNode(i);
            }
            else {
                higher.addNode(i);
            }
                i = i.next;   
        }
    }
    

    


    

   public static void main( String[] args ) {

    quicksortlinkedlist A = new quicksortlinkedlist();
    A.add(2);
    A.add(4);
    A.add(5);
    A.add(1);
    A.add(3);
    A.add(9);
    A.add(8);
    A.add(7);
    A.add(6);
    A.print();

    A.quicksortlist();

    System.out.println("end");
    A.print();


   }

   
}
