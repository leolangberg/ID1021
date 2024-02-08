import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

public class Benchmark {
    
    public static void main(String[] args) {

            /*
            bb(100);
            bb(200);
            bb(300);
            bb(400);
            bb(500);
            bb(600);
            bb(700);
            bb(800);
            bb(900);
            bb(1000);
            */
             int b = 100;
            for(int i = 0; i < 10; i++)
            {
                bb(b);
                b += 100;
            }
            
            
            int a = 100;
            for(int i = 0; i < 10; i++)
            {
                bbarrays(a);
                a += 100;
            }
            System.out.println();

            int c = 100;
            for(int i = 0; i < 10; i++)
            {
                bblinkedlist(c);
                c += 100;
            }
            

            //bbarrays();
        
      

    }


    public static void bb( int a) {

        int N = a;

        double[] timestampsknuff = new double[N];
        double[] timestamps = new double[N];

        for(int j = 0; j < N; j++)
        {
            BinaryTreePriorityQueue A = new BinaryTreePriorityQueue();
            BinaryTreePriorityQueue B = new BinaryTreePriorityQueue();

            int[] randomnums = randomArray2(N);
            for(int i = 0; i < N-1; i++)
            {
                A.enqueue(randomnums[i]);
                B.enqueue(randomnums[i]);
            }
            //2 likadana binary tree
            int[] keys = randomArray(N);
            //System.out.println("keys: " + Arrays.toString(keys));
            //int[] depth = new int[N];

            long t0 = System.nanoTime();
            for(int i = 0; i < N; i++)
            {
                B.fiamedknuff(keys[i]);
            }
            long t1 = System.nanoTime();
            double resultknuff = t1 - t0;
            timestampsknuff[j] = resultknuff;

            
            long t3 = System.nanoTime();
            for(int i = 0; i < N; i++)
            {
                int tmp = A.dequeue();
                A.enqueue((tmp + keys[i])); // incr
            }
            long t4 = System.nanoTime();
            double resulttime = t4 - t3;
            timestamps[j] = resulttime;

            //int avgdepth = average(depth);
            //int mediandepth = medianint(depth);
            
        }

        double medianknuff = median(timestampsknuff);
        double mediantime = median(timestamps);
        //System.out.println("size: " + N + "   add/remove us: " + resulttime/1000 + "   knuff us: " + (resultknuff/1000) + "  avg depth: " + avgdepth + "   median depth: " + mediandepth);
        System.out.println("size: " + N + "   add/remove us: " + mediantime/1000 + "   knuff us: " + (medianknuff/1000));
    }

    public static void bbarrays(int a) {

        int N = a;
        double[] timestamps = new double[N];

        for(int j = 0; j < N; j++)
        {
            ArrayPriorityQueue A = new ArrayPriorityQueue(10000);

            int[] randomnums = randomArray2(N);
            for(int i = 0; i < N; i++)
            {
                //System.out.println("signal: " + i);
                A.add(randomnums[i]);
            }
            //2 likadana binary tree
            int[] keys = randomArray(N);
            //System.out.println("keys: " + Arrays.toString(keys));
            //int[] depth = new int[N];

            
            long t3 = System.nanoTime();
            for(int i = 0; i < N; i++)
            {
                int tmp = A.remove();
                tmp = ((tmp + keys[i]));
                A.add( tmp ); // incr
            }
            long t4 = System.nanoTime();
            double resulttime = t4 - t3;
            timestamps[j] = resulttime;

            //int avgdepth = average(depth);
            //int mediandepth = medianint(depth);
            A = null;
        }

        //double medianknuff = median(timestampsknuff);
        double mediantime = median(timestamps);
        //System.out.println("size: " + N + "   add/remove us: " + resulttime/1000 + "   knuff us: " + (resultknuff/1000) + "  avg depth: " + avgdepth + "   median depth: " + mediandepth);
        System.out.println("size: " + N + "   array add/remove us: " + mediantime/1000 );
    }
    
    public static void bblinkedlist(int a) {

        int N = a;
        double[] timestamps = new double[N];

        for(int j = 0; j < N; j++)
        {
            PriorityQueue A = new PriorityQueue.lowlist();

            int[] randomnums = randomArray2(N);
            for(int i = 0; i < N; i++)
            {
                //System.out.println("signal: " + i);
                A.add(randomnums[i]);
            }
            //2 likadana binary tree
            int[] keys = randomArray(N);
            //System.out.println("keys: " + Arrays.toString(keys));
            //int[] depth = new int[N];

            
            long t3 = System.nanoTime();
            for(int i = 0; i < N; i++)
            {
                int tmp = A.remove();
                tmp = ((tmp + keys[i]));
                A.add( tmp ); // incr
            }
            long t4 = System.nanoTime();
            double resulttime = t4 - t3;
            timestamps[j] = resulttime;

            //int avgdepth = average(depth);
            //int mediandepth = medianint(depth);
            A = null;
        }

        //double medianknuff = median(timestampsknuff);
        double mediantime = median(timestamps);
        //System.out.println("size: " + N + "   add/remove us: " + resulttime/1000 + "   knuff us: " + (resultknuff/1000) + "  avg depth: " + avgdepth + "   median depth: " + mediandepth);
        System.out.println("size: " + N + "   linkedlist add/remove us: " + mediantime/1000 );
    }



    public static int average ( int[] array )
    {
        int average = 0;
        for(int i = 0; i < array.length; i++)
        {
            average += array[i];
        }
        average = (average / array.length);
        return average;
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
    public static int[] randomArray2( int bound) {
        
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

    public static int medianint( int[] b)
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
                        int e = b[i];
                        b[i] = b[m];
                        b[m] = e;
                    }
                }
            }

        int a = (b.length / 2);
        int c = b[a];
        return c;
    }



    
}
