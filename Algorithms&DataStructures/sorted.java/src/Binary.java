import java.util.Random;
public class Binary {
    
    public static boolean search(int[] array, int key)
    {
        int first = 0;
        int last = array.length - 1;   
        

        while (true) {

            int index = ((first + last) / 2);  
            if(array[index] == key ) { 
                return true;
            }
            if(array[index] < key && index < last) {  

                first = index + 1;     
                continue;          
            }
            if(array[index] > key && index > first) {   

                last = index - 1;
                continue;
            }

            if( (key > array[last]) || (key < array[first]) ) {    
                return false;
            }
            if( first > last ) {    
                return false;
                 
            }     
        }
    }

    public static void main( String[] args) {
        int[] testarray = sorted(16);
        
        for(int i = 0; i < 17; i++)
        search(testarray, i);
        System.out.println("all");
        
    }
    private static int[] sorted(int n) {
    
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for(int i = 0; i < n; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }
}
