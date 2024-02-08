import java.util.Arrays;

public class QueueArray {
    
    int size;
    Integer[] queue;   //amortized cost is constant 
    int first;         //if first and last are far apart they will no longer be in the cache at same time
    int last;


    public QueueArray() {

        size = 4;
        queue = new Integer[size];
    }

    public boolean empty() {
        return ( first == last );
    }

    public void enqueue( Integer itm ) {  //O(1) until copy --> O(n)

        queue[last] = itm;
        last = (last + 1) % size;
        if( last == first)
        {
            Integer[] copy = new Integer[size*2];
            int pos = 0;
            for(int i = first; i < size; i++) //first half
            {
                copy[pos] = queue[i];
                pos++;
            }
            for( int i = 0; i < last; i++) //second half
            {
                copy[pos] = queue[i];
                pos++;
            }
            size = size*2;
            first = 0;
            last = pos;
            queue = copy;
        }
    }

    public Integer dequeue() {
        Integer ret = queue[first];
        queue[first] = null;
        first = (first + 1) % size; 
        if ((last - first + size) % size < (size / 4))
        {
            Integer[] copy = new Integer[size/2];
            int pos = 0;
            for(int i = first; i < last; i++)
            {
                copy[pos] = queue[i];
            }
            size = size/2;
            first = 0;
            last = pos;
            queue = copy;
        }
        return ret;
    }

    public void printarray() {
            System.out.println(Arrays.toString(queue) + "f: " + first + "L:" + last);
    }

}
