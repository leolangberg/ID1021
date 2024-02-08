public class ArrayPrio {
    
    Path[] heap;
    int size;
    
    int cur;
    int last;
    int first;

    //int pathindex;

    public ArrayPrio() {

        size = 50;
        heap = new Path[size];
    }

    public boolean empty() {

        return (heap[first] == null);
    }

    public void add( Path path ) {

        cur = last;
        heap[cur] = path;

        int evenparent = Math.max(0, ((cur - 2) / 2));
        int oddparent  = Math.max(0, ((cur - 1) / 2));

        if(empty() != true)
        {
            if(cur % 2 == 0)
            {
                while(heap[cur].dist < heap[oddparent].dist)
                {
                    swap(heap, evenparent, cur);
                    cur = evenparent;
                    evenparent = Math.max(0, ((cur - 2) / 2));
                }
            }
            else 
            {
                while( heap[cur].dist < heap[oddparent].dist)
                {
                    swap(heap, evenparent, cur);
                    cur = oddparent;
                    oddparent = Math.max(0, ((cur - 1) / 2));
                }
            }
        }

        last++;
    }

    public Path remove() {

        if(empty() == true)
            return null;

        last--;
        Path returnee = heap[first];    
        heap[first] = heap[last];
        heap[last] = null;
        cur = first;
        removerecursion(cur);

        //System.out.println(Arrays.toString(Heap));
        return returnee;
    }

    private void removerecursion(int cur) {

        int left  = ((cur * 2) + 1); //odd
        int right = ((cur * 2) + 2); //even

        //System.out.println("cur: " + cur + "  left: " + left + "  right: " +right);
        //System.out.println("Heap[cur]: " + Heap[cur] + "  Heap[left]: " + Heap[left] + "  Heap[right]: " + Heap[right]);
        
        if(heap[left] == null) //left doesnt exist
        {
            if(heap[right] == null)
                return;
            else //right exists
            {
                if(heap[right].comparator(heap[cur]) < 0) {  //right is smaller
                    swap(heap, right, cur);
                    cur = right;
                    removerecursion(cur);
                }
                else
                    return;
            }
        }
        else //left exists
        {
            if(heap[right] == null)
                return;
            else  //left & right exists
            {
                //System.out.println("both exist");
                if((heap[left].comparator(heap[cur]) < 0) && (heap[left].comparator(heap[right]) < 0))
                {                
                    //System.out.println("go left");    
                    swap(heap, left, cur);
                    cur = left;
                    removerecursion(cur);
                }
                else if((heap[right].comparator(heap[cur]) < 0 ) && (heap[right].comparator(heap[left]) < 0))
                {
                    //System.out.println("go right");
                    swap(heap, right, cur);
                    cur = right;
                    removerecursion(cur);
                }
                else 
                    return;
            }
        }
    }

    private void swap(Path[] Array, int a, int b) {

        Path c = Array[a];
        Array[a] = Array[b];
        Array[b] = c;
    }

    

}
