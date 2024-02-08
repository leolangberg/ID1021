import java.util.Arrays;

public class quicksort {
    
    
    public static void quick_sort( int[] array)
    {
        if(array.length == 0)
            return;
        int lo = 0;
        int hi = array.length - 1;

        quick_sort(array, lo, hi);

    }
    private static void quick_sort(int [] array, int lo, int hi)
    {
        if(lo < hi)
        {
            int index = split(array, lo, hi);

            quick_sort(array, lo, index - 1); //lower array
            quick_sort(array, index + 1, hi); //higher array
        }
    }

    private static int split( int[] array, int lo, int hi)
    {
        int pivot = array[hi]; //end as pivot
        for(int i = lo; i < hi; i++)
        {     
            if(pivot > array[i])
            {
                swap(array, lo, i);  
                lo++;
            }
        }
        swap(array, hi, lo);
        return lo;  //will return middle (partition) point
    }

    private static void swap( int[] array, int i, int c) {
        int tmp = array[i];
        array[i] = array[c];
        array[c] = tmp;
    }

    private static int partitionprofessor( int[] array, int min, int max)
    {
        int piv = array[min];
        
        int i = min;
        int j = max;

        while( i != j)
        {
            while( array[j] > piv && j > i)
            {
                j--;
            }
            while( array[i] <= piv && i < j)
            {
                i++;
            }
            swap(array, i, j);
        }
        swap(array, min, j);

        return j;
        
    }

    public static void main( String[] args) {
        int[] testarray = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(testarray));
        
        quick_sort(testarray);
        System.out.println(Arrays.toString(testarray));


    }

}
