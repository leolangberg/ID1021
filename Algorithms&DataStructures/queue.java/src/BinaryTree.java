import java.util.Iterator;
import java.util.Stack;

public class BinaryTree implements Iterable<Integer> {
    
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(Integer key, Integer value) {
        if(root == null)
            root = new Node(key, value);
        else
            root.add( key, value );
    }

    public Integer lookup( Integer k ) {
        if(root != null) 
            return root.lookup(k);
        else 
            return null;
    }

   /*  public void delete( Integer key) {
        if(root != null)
            root = root.delete(key);
    }
    */

    public void print( BinaryTree n) {
        n.root.print();
    }

    public Iterator<Integer> iterator() {
        return new TreeIterator();
    } 

     
    private class Node {

        Integer key;
        Integer value;
        Node left;
        Node right;
    
        public Node(Integer k, Integer v) {
    
            this.key = k;
            this.value = v;
            left = null;
            right = null;
        } 
    
        public void add( Integer key, Integer value) {   //rekursion of add 
            if(this.key == key) {
                this.value = value;
            }
            else if( key < this.key)
            {
                if(this.left == null)
                    this.left = new Node(key, value);
                else
                    this.left.add(key, value);    
            }
            else //key > this.key
            {
                if(this.right == null)
                    this.right = new Node(key, value);
                else
                    this.right.add(key, value);
            } 
        }
    
        public Integer lookup( Integer  k ) {
            if(key == k) 
                return value;
            else if(key > k) 
                if(left != null)    //(left != null)
                    return left.lookup(k);
                else 
                    return null;
            else
                if(right != null)
                    return right.lookup(k);
                else 
                    return null;
        }
        /* 
        public Node delete( Integer k) {
            if(key == k) { //jobbig jävel 
                //längst till vänster == minsta nummer
                /*Node promoted = this.right.promote()
                 * promoted.left = this.left
                 * return promoted;
                 *
            }
            if (key > k ) 
                if( left != null) 
                    left = left.delete(k);
            else
                if( right != null)
                    right = right.delete(k);
            return this;    
        }
         */
    
        public void print() {
            if(left != null)
            left.print();
                System.out.println(" key: " + key + "\tvalue: " + value);
            if(right != null)
                right.print();
        }
    
        private int max() {
            int ml  =0;
            int mr = 0;
            if( left != null)
                ml = left.max();
            if( right != null)
                ml = right.max();
            return Math.max(ml, mr) + 1;
        }
        
        public void traversal() {
                if(left != null)
                    left.traversal();
                System.out.println(" key: " + key + "\tvalue: " + value);
                    if(right != null)
                right.traversal();
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
            Integer ret = cur.value;

            return ret;
        }

    
        public void remove() {
            throw new UnsupportedOperationException();
        }
    
    }



    public static void main( String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.add(5,105);
        tree.add(2,102);
        tree.add(7,107);
        tree.add(1,101);
        tree.add(8,108);
        tree.add(6,106);
        tree.add(3,103);

        


        for (int i : tree)
            System.out.println("next value " + i);
    }
}




