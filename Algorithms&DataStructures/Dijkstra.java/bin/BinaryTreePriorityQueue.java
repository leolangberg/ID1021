import java.util.Arrays;
import java.util.Iterator;

public class BinaryTreePriorityQueue<T extends Comparable<T>> implements Iterable<T> {

    int depth;

    private class Node {

        T prio;
        int size;
        Node left;
        Node right;

        private Node(T prio) {
            this.prio = prio;
            this.size = 1;
            this.left = null;
            this.right = null;
        }

        private void add(T pr) {
            this.size++;
            if (pr.compareTo(prio) < 0) {
                T temp = prio;
                prio = pr;
                pr = temp;
            }
            if (left == null)
                left = new Node(pr);
            else {
                if (right == null)
                    right = new Node(pr);
                else {
                    if (left.size > right.size)
                        right.add(pr);
                    else
                        left.add(pr);
                }
            }
        }

        private T knuff(T curval) {
            depth++;
            if (prio.compareTo(curval) <= 0) {
                if (left == null) {
                    if (right != null)
                        curval = right.knuff(curval);
                    else {
                        T temp = prio;
                        prio = curval;
                        curval = temp;
                        return curval;
                    }
                } else {
                    if (right == null)
                        curval = left.knuff(curval);
                    else {
                        if (left.prio.compareTo(right.prio) < 0)
                            curval = left.knuff(curval);
                        else
                            curval = right.knuff(curval);
                    }
                }
            } else {
                return curval;
            }
            T temp = prio;
            prio = curval;
            curval = temp;
            return curval;
        }

        private Node remove() {
            if (this.size == 1) {
                return null;
            }
            size--;
            if (left == null) {
                if (right == null) {
                    return null;
                } else {
                    prio = right.prio;
                    right = right.remove();
                    return this;
                }
            } else {
                if (right == null) {
                    prio = left.prio;
                    left = left.remove();
                    return this;
                } else {
                    if (right.prio.compareTo(left.prio) < 0) {
                        prio = right.prio;
                        right = right.remove();
                        return this;
                    } else {
                        prio = left.prio;
                        left = left.remove();
                        return this;
                    }
                }
            }
        }

        private void push() {
            if (this.left == null) {
                if (this.right != null && right.prio.compareTo(prio) < 0) {
                    T temp = prio;
                    prio = right.prio;
                    right.prio = temp;
                    this.right.push();
                } else {
                    return;
                }
            } else {
                if (this.right == null && left.prio.compareTo(prio) < 0) {
                    T temp = prio;
                    prio = left.prio;
                    left.prio = temp;
                    this.left.push();
                } else {
                    if (left.prio.compareTo(right.prio) <= 0 && left.prio.compareTo(prio) < 0) {
                        T temp = prio;
                        prio = left.prio;
                        left.prio = temp;
                        this.left.push();
                    } else if (right.prio.compareTo(left.prio) < 0 && right.prio.compareTo(prio) < 0) {
                        T temp = prio;
                        prio = right.prio;
                        right.prio = temp;
                        this.right.push();
                    } else {
                        return;
                    }
                }
            }
        }

        private int pushRecursive() {
            if (this == null) {
                return 0;
            }

            int leftDepth = 0;
            int rightDepth = 0;

            if (this.left != null && this.left.prio.compareTo(this.prio) < 0) {
                T temp = this.prio;
                this.prio = this.left.prio;
                this.left.prio = temp;
                leftDepth = this.left.pushRecursive();
            }

            if (this.right != null && this.right.prio.compareTo(this.prio) < 0) {
                T temp = this.prio;
                this.prio = this.right.prio;
                this.right.prio = temp;
                rightDepth = this.right.pushRecursive();
            }

            return Math.max(leftDepth, rightDepth) + 1;
        }

        public void breadth(Queuelist<Node> queue) {
            if (this.left != null) {
                queue.add(this.left);
            }
            if (this.right != null) {
                queue.add(this.right);
            }
        }
    }

    Node root;

    public BinaryTreePriorityQueue() {
        root = null;
    }

    public void enqueue(T value) {
        if (this.root == null) {
            root = new Node(value);
        } else {
            root.add(value);
        }
    }

    public T dequeue() {
        T c = root.prio;
        root.remove();
        return c;
    }

    public int push(T incr) {
        int depth = 0;
        root.prio = incr; // root
        // depth = root.pushRecursive();
        // root.push( );
        return depth;
    }

    public int fiamedknuff(T incr) {
        depth = 0;
        root.prio = incr;
        root.knuff(root.prio);
        return depth;
    }

    public Iterator<T> iterator() {
        return new TreeIterator();
    }

    public void printer(BinaryTreePriorityQueue<T> A) {
        int j = 0;
        T[] Array = (T[]) new Comparable[A.root.size];
        for (T i : A) {
            Array[j] = i;
            j++;
        }
        System.out.println(Arrays.toString(Array));
    }

    public boolean empty() {
        return this.root == null;
    }

    class TreeIterator implements Iterator<T> {

        private Node next;
        private Queuelist<Node> queue;

        public TreeIterator() {
            queue = new Queuelist<>();
            next = root;
            queue.add(next);
        }

        public boolean hasNext() {
            return !queue.empty();
        }

        public T next() {
            if (!hasNext())
                return null;

            Node cur = queue.remove();
            cur.breadth(queue);
            T ret = cur.prio;
            return ret;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        BinaryTreePriorityQueue<Integer> A = new BinaryTreePriorityQueue<>();
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
    }
}
       
