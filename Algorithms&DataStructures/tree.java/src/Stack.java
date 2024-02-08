import java.util.NoSuchElementException;

import javax.lang.model.util.ElementScanner14;

public abstract class Stack<T> {
    
    abstract  Node pop();
    abstract void push(Node n);

    static class Linkedstack extends Stack {

        private Nätverk first;

        private class Nätverk {
            Node value;
            Nätverk next;

            private Nätverk(Node val)
            {
                this.value = val;
                next = null;
            }
        }

        public Linkedstack() {
            first = null;
        }

        public void push( Node item ) {
            System.out.println("push" + item.value);
            Nätverk a = new Nätverk( item );
            a.next = first;
            first = a;
        }

        public Node pop() {
            if(first == null)
                throw new NoSuchElementException("empty stack");
            Node number = first.value;
            System.out.println("pop" + number.value);
            first = first.next;
            return number;
        }

       
    }
}