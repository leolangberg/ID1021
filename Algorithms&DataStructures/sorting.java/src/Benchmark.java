import java.util.Random;
public class Benchmark {
    
    public static void main(String[] args) {
        
        Sort a = new Sort();
        a.type = SortType.SELECTIONSORT;

        Sort b = new Sort();
        b.type = SortType.INSERTIONSORT;

       // benchmark1000(a);
       // benchmark1000(b);
        
        int k = 100;
        System.out.println("goober select merge standard");
        for( int i = 0; i < 10; i++)
        {
            gooberbench(k, 1000);
            k += 100;
        }

       
    }

    public static void benchmark1000 (Sort typeofsort) {

        int length = 100;
        int tries = 1000;
        System.out.println("\n method: " + typeofsort.type);
        System.out.println("   median in micros: ");
        for( int i = 0; i < 10; i++)
        {
            bench(length, tries, typeofsort);
            length += 100;
        }
    }
    public static void bench(int length, int tries, Sort typeofsort) {

        double[] timestamps = new double[tries];

        for(int i = 0; i < tries; i++)
        {
            int [] array = createrandomarray(length);
            long t0 = 0;
            long t1 = 0;
            double time = 0;
            switch(typeofsort.type()) {

                case SELECTIONSORT : {
                    t0 = System.nanoTime();
                    sorting.selection_sort(array);
                    t1 = System.nanoTime();
                }

                case INSERTIONSORT : {
                    t0 = System.nanoTime();
                    sorting.insertion_sort(array);
                    t1 = System.nanoTime();
                }
            }
            time = t1 - t0;
            timestamps[i] = time;
        }

        double medianresult = median(tries, timestamps);
        System.out.println("length: " + length +  "   us: " + medianresult / 1000);
    }

    public static void gooberbench( int length, int tries) {
        
        double [] timestamps = new double[tries];

        for(int i = 0; i < tries; i++) {
            int[] array = createrandomarray(length);
            long t0 = System.nanoTime();
            quicksort.quick_sort(array);
            long t1 = System.nanoTime();
            double time = t1 - t0;
            timestamps[i] = time;
        }
        double medianresult = median(tries, timestamps);
        System.out.println("length: " + length +  "   us: " + medianresult / 1000);

    }

    public static int[] createrandomarray(int length)
    {
        int[] a = new int[length];
        Random b = new Random();
        for(int i = 0; i < length; i++)
        {
            int nxt = b.nextInt(length * 5);
            a[i] = nxt;
        }

        return a;
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
