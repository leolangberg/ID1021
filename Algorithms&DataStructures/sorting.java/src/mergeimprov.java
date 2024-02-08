import java.util.Arrays;

public class mergeimprov {

    public static void improvedmerge( int[] org ) {
        if(org.length == 0)
            return;
        int[] aux = new int [org.length];
        for( int i = 0; i < org.length; i++)
            aux[i] = org[i];

        merge_sort(org, aux, 0, org.length - 1);
    }
    private static void merge_sort(int[] org, int[] aux, int lo, int hi) {
        if ( lo != hi ) {
            int mid = (lo + hi) / 2;

            merge_sort(aux, org, lo, mid);    //org & aux switch places
            merge_sort(aux, org, (mid+1), hi); // org & aux switch places 

            merge( org, aux, lo, mid, hi);
        }
    }
    private static void merge( int[] org, int[] aux, int lo, int mid, int hi) {

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
    }
    
    public static void main(String[] args) {
        
        int [] testarray = {2,1,6,5,4,3};
        System.out.println("before: " + Arrays.toString(testarray));
        improvedmerge(testarray);
        System.out.println("After: " + Arrays.toString(testarray));
    }
    
}
