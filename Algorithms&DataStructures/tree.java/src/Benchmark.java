import java.util.Arrays;
import java.util.Random;
public class Benchmark {

    
    public static void main(String[] args) {
        BinaryTree A = new BinaryTree();
        int bounds = 100;
        for(int i = 0; i < 10; i++)
        {
            bench(A, bounds);
            bounds += 10;
        }
   
    }

    public static void bench(BinaryTree A, int bounds)
    {
        double [] timestampsadd = new double[bounds];
        double [] timestampslookup = new double[bounds];

        for(int j = 0; j < bounds; j++ )
        {
            int[] randomArray = randomArray(bounds);
            long t0add = System.nanoTime();
            for( int i = 0; i < bounds; i++)
            {
                A.add(randomArray[i], randomArray[i]);
            }
            long t1add = System.nanoTime();
            double resulttimeadd  = t1add - t0add;
            timestampsadd[j] = resulttimeadd;

            int[] keyarray = randomArray(bounds);
            long t0lookup = System.nanoTime();
            for(int i = 0; i < bounds; i++)
            {
                A.lookup(keyarray[i]);
            }
            long t1lookup = System.nanoTime();
            double resulttimelookup = t1lookup - t0lookup;
            timestampslookup[j] = resulttimelookup;
        }

        double medianadd = median(timestampsadd);
        double medianlookup = median(timestampslookup);

        System.out.println("tree: " + bounds + " add us: " + (medianadd/1000) + " lookup ns: " + (medianlookup/1000));
        
       
    }

    public static int[] randomArray( int bound) {
        
        Random rnd = new Random();
        int[] RndnumArray = new int[bound];
        for(int i = 0; i < bound; i++)
        {  
            int nxt = rnd.nextInt(bound);
            RndnumArray[i] = nxt;
        }
        return RndnumArray;
        
    }

    private static int[] sorted(int n) {
        Random rnd = new Random();	
        int[] array = new int[n];
        int nxt = rnd.nextInt(10);
    
        for (int i = 0; i < n ; i++) {
            array[i] = nxt;
            nxt += rnd.nextInt(10) + 1 ;
        }	
        return array;
    }

    public static double median( double[] b)
    {
    
            int m = 0;
            for(int i = 0; i < b.length - 1; i++)
            {
                m = i;
                for(int j = i + 1; j < b.length; j++)
                {
                    if(b[j] > (b[m]))
                        m = j;
        
                    if(m!= i)
                    {
                        double e = b[i];
                        b[i] = b[m];
                        b[m] = e;
                    }
                }
            }

        int a = (b.length / 2);
        double c = b[a];
        return c;
    }



    
}
