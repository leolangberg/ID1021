public class ArrayPriorityQueue<T extends Comparable<T>> {

    int size;
    Object[] Heap;
    int first;
    int last;
    int cur;

    public ArrayPriorityQueue(int length) {
        size = length;
        Heap = new Object[size];
    }

    public boolean empty() {
        return (first == last);
    }

    public void add(T value) {
        cur = last;
        Heap[cur] = value;

        int evenparent = Math.max(0, ((cur - 2) / 2));
        int oddparent = Math.max(0, ((cur - 1) / 2));

        if (!empty()) {
            if (cur % 2 == 0) { // even
                while (((T) Heap[cur]).compareTo((T) Heap[evenparent]) < 0) {
                    swap(Heap, evenparent, cur);
                    cur = evenparent;
                    evenparent = Math.max(0, ((cur - 2) / 2));
                }
            } else { // odd
                while (((T) Heap[cur]).compareTo((T) Heap[oddparent]) < 0) {
                    swap(Heap, oddparent, cur);
                    cur = oddparent;
                    oddparent = Math.max(0, ((cur - 1) / 2));
                }
            }
        }

        last++;
    }

    public T remove() {
        if (empty())
            return null;

        last--;
        T returnee = (T) Heap[first];
        Heap[first] = Heap[last];
        Heap[last] = null;
        cur = first;
        removerecursion(cur);

        return returnee;
    }

    private void removerecursion(int cur) {
        int left = ((cur * 2) + 1); // odd
        int right = ((cur * 2) + 2); // even

        if (Heap[left] == null) {
            if (Heap[right] == null)
                return;
            else {
                if (((T) Heap[right]).compareTo((T) Heap[cur]) < 0) {
                    swap(Heap, right, cur);
                    cur = right;
                    removerecursion(cur);
                } else
                    return;
            }
        } else {
            if (Heap[right] == null)
                return;
            else {
                if (((T) Heap[left]).compareTo((T) Heap[cur]) < 0 && ((T) Heap[left]).compareTo((T) Heap[right]) < 0) {
                    swap(Heap, left, cur);
                    cur = left;
                    removerecursion(cur);
                } else if (((T) Heap[right]).compareTo((T) Heap[cur]) < 0 && ((T) Heap[right]).compareTo((T) Heap[left]) < 0) {
                    swap(Heap, right, cur);
                    cur = right;
                    removerecursion(cur);
                } else
                    return;
            }
        }
    }

    private void swap(Object[] Array, int a, int b) {
        Object c = Array[a];
        Array[a] = Array[b];
        Array[b] = c;
    }
}
