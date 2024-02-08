
public class Node {

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

    public Node delete( Integer k) {
        if(key == k) { //jobbig jävel 
            //längst till vänster == minsta nummer
            /*Node promoted = this.right.promote()
             * promoted.left = this.left
             * return promoted;
             */
        }
        if (key > k ) 
            if( left != null) 
                left = left.delete(k);
        else
            if( right != null)
                right = right.delete(k);
        return this;    
    }

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

    public void leftrecursion (Stack b)
    {
        if(this.left != null)
        {
            b.push(this);
            this.left.leftrecursion(b);
        }
    }
        
}
