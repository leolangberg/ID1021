import java.util.Arrays;

public class sorting {
    
    public static void selection_sort(int [] array) {
        
        for(int i = 0; i < array.length - 1; i++)
        {
            int candidate = i;
            for( int j = i; j < array.length; j++ )
            {
                if(array[j] < array[candidate])
                    candidate = j;

            }
            int storage = array[candidate];
            array[candidate] = array[i];
            array[i] = storage;
        }
    }
    
    public static void insertion_sort (int [] array) {

        for(int i = 0; i < array.length; i++)
        {
            for(int j = i; j > 0 && array[j-1] > array[j]; j--)
                swap2(array, (j-1), j);
        }
    }

    private static void swap ( int[] array, int i, int j) {
        int e = array[j-1];
        array[j-1] = array[j];
        array[j] = e;
    }
    private static void swap2( int[] array, int i, int c) {
        int tmp = array[i];
        array[i] = array[c];
        array[c] = tmp;
    }


    public static void merge_sort( int[] org ) {
        if(org.length == 0)
            return;
        int[] aux = new int [org.length];
        merge_sort(org, aux, 0, org.length - 1);
    }
    private static void merge_sort(int[] org, int[] aux, int lo, int hi) {
        //System.out.println("merge_sort initialized: ");
        if ( lo != hi ) {
            int mid = (lo + hi) / 2;
            //sort items for lo to mid
            merge_sort(org, aux, lo, mid);
            //sort items from mid+1 to hi
            merge_sort(org, aux, (mid+1), hi);

            merge(org, aux, lo, mid, hi);
        }
    }
    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        for( int h = lo; h <= hi; h++)
            aux[h] = org[h];
    
        int i = lo;
        int j = mid + 1;

        for(int k = lo; k <= hi; k++)
        {
            if( i > mid )
                org[k] = aux[j++];
            else if( j > hi )
                org[k] = aux[i++];
            else if( aux[i] < aux[j] )
                org[k] = aux[i++];
            else
                org[k] = aux[j++];   
        }
        /*
            System.out.println("merge");
            System.out.println("lo: " + lo + "  hi: " + hi + "  mid: " + mid);
            System.out.println("aux: " + Arrays.toString(aux));
            System.out.println("org: " + Arrays.toString(org));
            System.out.println();
        */ 
    }

   

    
        
    public static void main(String[] args) throws Exception {
       
        int [] testarray = {2,1,6,5,4,3};

        for(int i = 0; i < testarray.length; i++)
        {
            System.out.println(testarray[i]);
        }
        //selection_sort(testarray);
        merge_sort(testarray);
        System.out.println();
        for(int i = 0; i < testarray.length; i++)
        {
            System.out.println(testarray[i]);
        }

    }
}
