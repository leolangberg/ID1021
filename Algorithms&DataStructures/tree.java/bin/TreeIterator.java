import java.util.Iterator;
import java.util.Stack;

public class TreeIterator extends BinaryTree  implements Iterator<Integer>  {
    
    
    private Node next;
    private Stack stack;


    public TreeIterator( Node root) {
        
        System.out.println("TreeIterator");
        stack = new Stack.Linkedstack();
        next = root;
        //leftmost(next);
    }

    public boolean hasNext() {
        boolean a = (next != null);
        System.out.println("hasnext boolean: " + a);
        return ((next != null) || stack.isEmpty());
    }

    public Integer next() {
        System.out.println("Next");
        if(hasNext() == false)
        {
            System.out.println("hasNext() == false");
            return null;
        }
        Node cur = stack.pop();
        Integer ret = cur.value;
        
        if(cur.right != null) {
            leftmost(cur.right);;
        }

        return ret;
    }

   


    public void leftmost(Node a )
    {
        System.out.println("leftmost");
        while(a != null)
        {
            stack.push(a);
            a = a.left;
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
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

        

        System.out.println("Print");
        tree.print(tree);
        System.out.println();

        for (int i : tree)
            System.out.println("LOOPSTAGE next value " + i);

    }
}
