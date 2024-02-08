import javax.lang.model.util.ElementScanner14;

public class TreeNoRecursion {  //Tree<K,V>
        Node root;

        private class Node {
            
            Integer key;
            Integer value;
            Node left;
            Node right;

            private Node(Integer k, Integer val)
            {
                this.key = k;
                this.value = val;
                left = null;
                right = null;
            }

            private void add( Integer k, Integer v) {
                if(key == k) {
                    value = v;
                }
                else if( k < key) {  //left side
                    if(this.left != null)
                        this.left.add(k, v);
                    else
                        this.left = new Node(k, v);
                }
                else { //right side
                    if(this.right != null)
                        this.right.add(k,v);
                    else
                        this.right = new Node(k, v);
                }
            }
        }

        public void add_inc(Integer k, Integer val) {
            if(root != null) {
                Node cur = root;
                while( cur != null)
                {
                    if(cur.key == k)
                        cur.value = val;
                    else if ( cur.key > k)
                        cur = cur.left;
                    else
                        cur = cur.right;  
                }
                root.add(k, val);
            }
            else
                root = new Node(k, val);
    
        }

        public void add(Integer k, Integer val)
        {
            if(root != null) {
                root.add(k, val);
            }
            else {
                root = new Node(k, val);
            }
        }

        public Integer lookup(Integer key ) {   //O(log(n))   worst case: O(n)
            Node cur = this.root;
    
            while( cur != null) {
                if(cur.key.equals(key)) 
                    return cur.value;
                if(cur.key.compareTo(key) < 0)
                    cur = cur.right;
                else
                    cur = cur.left;
            }
            return null;
        }

        

     
}
