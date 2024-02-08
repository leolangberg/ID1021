import java.util.Random;

public class sortedclass {

    public static boolean search_unsorted(int[] array, int key) {
        for(int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }

    private static int[] sorted(int n) { //bara gör en random sorted array
    
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for(int i = 0; i < n; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

    public static boolean search_duplicates_linear( int[] a, int[] b) //boolean not int[]
    {
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < b.length; j++)
            {  
                if(a[i] == b[j])
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean search_duplicates_sorted_binary(int[] a, int[] b)
    {
        for(int i = 0; i < a.length; i++)
        {
            if(Binary.search(b, a[i]) == true)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean search_duplicates_ladder(int[]a, int[]b )
    {
        int a_pos = 0;
        int b_pos = 0;
        for(int i = 0; i < a.length; i++)
        {
            if(a[a_pos] > b[b_pos])
                b_pos++;
            else if(a[a_pos] < b[b_pos])
                a_pos++;
            else
                return true; //they are equal
        }
        return false;
    }







    public static int[] search_duplicates_ladder_array(int[]a, int[]b )
    {
        int[] duplicates = new int[0];
        int a_pos = 0;
        int b_pos = 0;
        for(int i = 0; i < a.length; i++)
        {
            if(a[a_pos] > b[b_pos])
                b_pos++;
            else if(a[a_pos] < b[b_pos])
                a_pos++;
            else
                duplicates = arrayextend(duplicates, b[b_pos]);
        }
        return duplicates;
    }
    public static int[] search_duplicates_unsorted_array( int[] a, int[] b) 
    {
        int[] duplicates = new int[0];
        
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < b.length; j++)
            {  
                if(a[i] == b[j])
                {
                    System.out.println("found duplicate " + a[i]);
                    duplicates = arrayextend(duplicates, a[i]);
                }
            }
        }
        return duplicates;   
    }
    private static int[] arrayextend( int[] a, int n)
    {
        int[] b = new int[a.length + 1];
        for(int i = 0; i < a.length; i++)
        {
            b[i] = a[i];
        }
        b[b.length - 1] = n;
        return b;
    }
    public static int[] search_duplicates_sorted_array(int[] a , int[] b)
    {
        int[] duplicates = new int[0];
        for(int i = 0; i < a.length; i++)
        {
            if(Binary.search(b, a[i]) == true)
            {
                System.out.println("found duplicate " + a[i]);
                duplicates = arrayextend(duplicates, a[i]);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

       int[] A = sorted(5);
       int[] B = sorted(5);

       int[] bbb = {1,2,3,4,5};
       int[] aaa = {3,4,5,6,7,8,9,10};
    
       int[] C = search_duplicates_ladder_array(aaa, bbb);
       for(int i = 0; i < C.length; i++)
            System.out.println(C[i]);
        
        boolean D = search_duplicates_ladder(aaa, bbb);
        System.out.println(D);
        boolean E = search_duplicates_sorted_binary(aaa, bbb);
        System.out.println("E " + E);
       

    }
}
