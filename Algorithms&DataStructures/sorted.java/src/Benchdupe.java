import java.util.Random;
public class Benchdupe {
    
    public static void main( String[] args ) {

            int[]test = sorted(0);
            for(int i = 0; i < test.length; i++)
            {
                System.out.println(test[i]);
            }
            System.out.println();

            int length = 1000;
            System.out.println("length: " + length);
            Benchmark_sort_linear(1000, length);
            Benchmark_sort_binary(1000, length);
            Benchmark_sort_ladder(1000, length);
        
    }

    private static int[] sorted(int n) {
        Random rnd = new Random();	
        int[] array = new int[n];
        int nxt = rnd.nextInt(1000);
    
        for (int i = 0; i < n ; i++) {
            array[i] = nxt;
            nxt += rnd.nextInt(1000) + 1 ;
        }	
        return array;
        }

    public static void Benchmark_sort_linear(int tries,int length) {
        
        double[] timestamps = new double[tries];
        int timepos = 0;
        for(int i = 0; i < tries; i++)
        {
        
            int [] array1 = sorted(length);
            int [] array2 = sorted(length);
            long t0 = System.nanoTime();
            sortedclass.search_duplicates_linear(array1, array2);
            long t1 = System.nanoTime();
            double t = (t1 - t0);

            timestamps[timepos] = t;
            timepos++;
        }

        double result = median(timepos, timestamps);
        System.out.println("median linear in micros: " + result / 1000);

    }
    public static void Benchmark_sort_binary(int tries, int length) {
        
        double[] timestamps = new double[tries];
        int timepos = 0;
        for(int i = 0; i < tries; i++)
        {
        
            int [] array1 = sorted(length);
            int [] array2 = sorted(length);
            long t0 = System.nanoTime();
            sortedclass.search_duplicates_sorted_binary(array1, array2);
            long t1 = System.nanoTime();
            double t = (t1 - t0);

            timestamps[timepos] = t;
            timepos++;
        }

        double result = median(timepos, timestamps);
        System.out.println("median binary in micros: " + result / 1000);

    }
    public static void Benchmark_sort_ladder(int tries, int length) {
        
        double[] timestamps = new double[tries];
        int timepos = 0;  
        for(int i = 0; i < tries; i++)
        {
        
            int [] array1 = sorted(length);
            int [] array2 = sorted(length);
            long t0 = System.nanoTime();
            sortedclass.search_duplicates_ladder(array1, array2);
            long t1 = System.nanoTime();
            double t = (t1 - t0);

            timestamps[timepos] = t;
            timepos++;
        }

        double result = median(timepos, timestamps);
        System.out.println("median ladder in micros: " + result / 1000);

    }



    public static double median( int a, double[] b)
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

        a = (a / 2);
        double c = b[a];
        return c;
    }
}
