import java.util.Arrays;
import java.util.Random;
public class Benchmark {
    
    public static void main(String[] args) {
    
        int size = 1000;
        for(int i = 0; i < 10; i++)
        {    
            bench(size);
            size += 1000;
        }

        

    }

    public static void bench(int size) {
        
        double[] timestampslist = new double[size];
        double[] timestampsarray = new double[size];
        

        for(int j = 0; j < size; j++)
        {
            int[] valueArray = randomArray(size);
            int[] valueArrayCopy = valueArray.clone();

            quicksortlinkedlist list = new quicksortlinkedlist();
            for(int i = 0; i < valueArray.length; i++)
            {
                list.add(valueArray[i]);
            }
            long t0list = System.nanoTime();
            list.quicksortlist();
            long t1list = System.nanoTime();
            double timelist = t1list - t0list;
            timestampslist[j] = timelist;

            long t0array = System.nanoTime();
            quicksort.quick_sort(valueArrayCopy);
            long t1array = System.nanoTime();
            double timearray = t1array - t0array;
            timestampsarray[j] = timearray;
        }

        double medianlist = median(timestampslist);
        double medianarray = median(timestampsarray);

        System.out.println("size:" + size + "  QS: array us: " + (medianarray / 1000) + "  list us: " + (medianlist / 1000));

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

