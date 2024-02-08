import java.util.Arrays;

public class ArrayPriorityQueue {
    

    int size;
    Integer[] Heap;
    int first;
    int last;
    int cur;


    public ArrayPriorityQueue( int length ) {

        size = length;
        Heap = new Integer[size];
    }

    public boolean empty() {

        return (first == last); //last before first pointer
    }

    public void add( Integer value ) {  

        cur = last;
        Heap[cur] = value;

        int evenparent = Math.max(0, ((cur - 2) / 2));
        int oddparent  = Math.max(0, ((cur - 1) / 2));

        if(empty() != true) //Case 0
        {

            if(cur % 2 == 0) //even
            {
                while( Heap[cur] < Heap[evenparent] )
                {
                    swap(Heap, evenparent, cur);
                    cur = evenparent; //((cur - 2) / 2);
                    evenparent = Math.max(0, ((cur - 2) / 2));
                }
            }
            else //odd
            {
                while( Heap[cur] < Heap[oddparent] )
                {
                    swap(Heap, oddparent, cur);
                    cur = oddparent;
                    oddparent  = Math.max(0, ((cur - 1) / 2));
                }
            }
        }

        last++;
        
        //System.out.println(Arrays.toString(Heap));
    }

    public Integer remove() {

        if(empty() == true)
            return null;

        last--;
        int returnee = Heap[first];    
        Heap[first] = Heap[last];
        Heap[last] = null;
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
        
        if(Heap[left] == null) //left doesnt exist
        {
            if(Heap[right] == null)
                return;
            else //right exists
            {
                if(Heap[right] < Heap[cur]) {  //right is smaller
                    swap(Heap, right, cur);
                    cur = right;
                    removerecursion(cur);
                }
                else
                    return;
            }
        }
        else //left exists
        {
            if(Heap[right] == null)
                return;
            else  //left & right exists
            {
                //System.out.println("both exist");
                if(Heap[left] < Heap[cur] && Heap[left] < Heap[right])
                {                
                    //System.out.println("go left");    
                    swap(Heap, left, cur);
                    cur = left;
                    removerecursion(cur);
                }
                else if(Heap[right] < Heap[cur] && Heap[right] < Heap[left])
                {
                    //System.out.println("go right");
                    swap(Heap, right, cur);
                    cur = right;
                    removerecursion(cur);
                }
                else 
                    return;
            }
        }
    }

    private void swap(Integer[] Array, int a, int b) {

        int c = Array[a];
        Array[a] = Array[b];
        Array[b] = c;
    }

    public Integer bubbleremove() {
        if (empty()) {
            return null;
        }
    
        int returnee = Heap[first];
        last--;
        Heap[first] = Heap[last];
        Heap[last] = null;
    
        cur = first;
       
        while (cur < last) {
            int left = (cur * 2) + 1;
            int right = (cur * 2) + 2;
        
            boolean LeftExists = left < last;
            boolean RightExists = right < last;
            boolean isCurrentGreaterThanLeft = LeftExists && Heap[cur] > Heap[left];
            boolean isRightSmallerThanLeft = RightExists && Heap[right] < Heap[left];
        
            if (isCurrentGreaterThanLeft && isRightSmallerThanLeft) {
                swap(Heap, cur, right);
                cur = right;
            } else if (isCurrentGreaterThanLeft) {
                swap(Heap, cur, left);
                cur = left;
            } else {
                break;
            }
        }
        System.out.println(Arrays.toString(Heap));
        return returnee;
    }
    

    

    public static void main( String[] args ) {

        ArrayPriorityQueue A = new ArrayPriorityQueue(10);
        A.add(1);
        A.add(2);
        A.add(4);
        A.add(6);
        A.add(7);
        A.add(8);
        A.add(3);
        A.add(10);
        A.remove();
        A.remove();
        A.remove();
        A.remove();
        A.remove();
        A.remove();
        A.remove();
        A.remove();
        //A.bubbleremove();
      
    }

}
