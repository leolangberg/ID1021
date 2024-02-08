import java.util.Arrays;
import java.util.Iterator;
public class BinaryTreePriorityQueue implements Iterable<Integer>{

    int depth;
    
    private class Node {

        int prio;
        int size;
        Node left;
        Node right;

        private Node(int prio) {
            
            this.prio = prio;
            this.size = 1;
            this.left = null;
            this.right = null;

        }

        private void add(int pr) {
            
            this.size++;
            if(pr < prio) {
                int c = prio;
                prio = pr;
                pr = c;
            }
            if( left == null )
                left = new Node(pr);
            else {//this.left != null
                if(right == null)
                    right = new Node(pr);
                else { // case: both exist
                    if( left.size > right.size) //left subtree smaller
                        right.add(pr);
                    else // right subtree smaller
                        left.add(pr);
                }
            }
        }

        private int knuff( int curval ) {

            depth++;

            if(this.prio <= curval) { //notice "<=" 
                if( left == null )
                {
                    if(right != null)
                        curval = right.knuff( curval );
                    else {
                        //swap
                        int c = this.prio; 
                        this.prio = curval;
                        curval = c;
                        return curval;
                    }
                }    
                else { //left exists
                    if(right == null)
                        curval = left.knuff( curval );
                    else { // case: both exist
                        if( left.prio < right.prio ) 
                            curval = left.knuff( curval );
                        else 
                            curval = right.knuff( curval );
                    }
                }    
            }
            else {
                return curval;
            }
                //swap
            int c = this.prio;
            this.prio = curval;
            curval = c;

            return curval;

        }
            

        private Node remove() {
            if(this.size == 1) { //basecase
                return null;
            }
                
            size--;
            if(left == null) 
            {
                if(right == null) //Dead code since this is basecase
                    return null;
                else {
                    prio = right.prio;
                    right = right.remove();
                    return this;
                }
            }
            else //left exists
            {
                if(right == null) {
                    prio = left.prio;
                    left = left.remove();
                    return this;
                }
                else //left and right exists
                { 
                    if(right.prio < left.prio) {
                        prio = right.prio;
                        right = right.remove();
                        return this;
                    }
                    else {
                        prio = left.prio;
                        left = left.remove();
                        return this;
                    }    
                }
            }
        }
       
        private void push() {

            //depth++;

            if(this.left == null) {
                if(this.right != null && right.prio < prio) { //only right exists
                    int c = prio;
                    prio = right.prio;
                    right.prio = c;
                    this.right.push();
                }
                else
                    return; //both null
            }
            else { //left exists
                if(this.right == null && left.prio < prio) {
                    int c = prio;
                    prio = left.prio;
                    left.prio = c;
                    this.left.push();
                }
                else{ // left & right exists
                    if(left.prio <= right.prio && left.prio < prio ) { //Notice <= this is 
                        int c = prio;                                  //incase left == right
                        prio = left.prio;      
                        left.prio = c;
                        this.left.push();
                    }
                    else if(right.prio < left.prio && right.prio < prio) {
                        int c = prio;
                        prio = right.prio;
                        right.prio = c;
                        this.right.push();
                    }
                    else 
                        return;
                }
            }
        } 
        
        
        private int pushRecursive() {
            if (this == null) {
                return 0;
            }
        
            int leftDepth = 0;
            int rightDepth = 0;
        
            if (this.left != null && this.left.prio < this.prio) {
                int temp = this.prio;
                this.prio = this.left.prio;
                this.left.prio = temp;
                leftDepth = this.left.pushRecursive();
            }
        
            if (this.right != null && this.right.prio < this.prio) {
                int temp = this.prio;
                this.prio = this.right.prio;
                this.right.prio = temp;
                rightDepth = this.right.pushRecursive();
            }
        
            return Math.max(leftDepth, rightDepth) + 1;
        }


        public void breadth(Queuelist<Node> queue) {
           
            if(this.left != null) {
                queue.add(this.left);
            }
            if(this.right != null) {
                queue.add(this.right);
            }
        }     
    }

    //BINARYTREE FUNCTIONS#########################################

    Node root;

    public BinaryTreePriorityQueue() {
        root = null;
    }

    public void enqueue(int value ) {
         
        if(this.root == null) {
            root = new Node(value);
        }
        else
            root.add(value);
    }

    public int dequeue() { //takes item from removed node
        int c = root.prio;
        root.remove();
        return c;
    }

    public int push( Integer incr ) {

       int depth = 0;

        root.prio += incr; //root
        //depth = root.pushRecursive();
        //root.push( );

        return depth;
      
    }

    public int fiamedknuff( Integer incr ) {

        depth = 0;

        root.prio += incr;
        root.knuff(root.prio);

        return depth;
    }

    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }
    
    public void printer(BinaryTreePriorityQueue A) {

        int j = 0;
        int[] Array = new int[A.root.size];
        for (int i : A) 
        {
            Array[j] = i;
            j++;
        }

        System.out.println(Arrays.toString(Array));
            
    }

    //ITERATOR###########################################################

    class TreeIterator implements Iterator<Integer>  {
    
    
        private Node next;
        private Queuelist<Node> queue;
    
    
        public TreeIterator() {
        
            queue = new Queuelist<>();
            next = root;
            queue.add(next);
            
        }
    
        public boolean hasNext() {
            return (!queue.empty());
        }
    
        public Integer next() {
            
            if(!hasNext())
            return null;

            Node cur = queue.remove();
            cur.breadth(queue);
            Integer ret = cur.prio;

            return ret;
        }

    
        public void remove() {
            throw new UnsupportedOperationException();
        }
    
    }


    public static void main(String[] args) {

        BinaryTreePriorityQueue A = new BinaryTreePriorityQueue();
        A.enqueue(1);
        A.enqueue(2);
        A.enqueue(3);
        A.enqueue(4);
        A.enqueue(5);
        A.enqueue(6);
        A.enqueue(7);
        A.enqueue(8);
        A.enqueue(9);
        A.enqueue(10);
        A.enqueue(11);
        A.enqueue(12);
        A.enqueue(13);
        A.enqueue(14);
        A.enqueue(15);

        A.printer(A);
       // for (int i : A)
         ///   System.out.println("next value " + i);


        int d = A.fiamedknuff(96);

        A.printer(A);
       
        

        for (int i : A)
            System.out.println("next value " + i);


        
        System.out.println("TREE");
        System.out.println(d);
        /*
        System.out.println(A.root.prio);

        System.out.println(A.root.left.prio);
        System.out.println(A.root.right.prio);
        
        System.out.println(A.root.left.left.prio);
        //System.out.println(A.root.left.right.prio);
       System.out.println(A.root.right.left.prio);
       // System.out.println(A.root.right.right.prio);
        /*
        System.out.println(A.root.left.left.left.prio);
        System.out.println(A.root.left.left.right.prio);
        System.out.println(A.root.left.right.left.prio);
        System.out.println(A.root.left.right.right.prio);
        System.out.println(A.root.right.left.left.prio);
        System.out.println(A.root.right.left.left.prio);
        System.out.println(A.root.right.right.left.prio);
        System.out.println(A.root.right.right.right.prio);
        */
      
    }

}
