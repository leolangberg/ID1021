
public class Bench {

   public static void benchmark(int amount, int tries, Stack stack)
    {
        long medel = 0;
        long[] median = new long[1024];
        int medianindex = 0;

        for(int i = 0; i < tries; i++)
        {
            long Start = System.nanoTime();
            for(int j = 0; j < amount; j++)
            {
                stack.push(1);
            }
            for(int j = 0; j < amount; j++)
            {
                stack.pop();
            }
            long stop = System.nanoTime();
            long Resulttime = stop - Start;
            //System.out.println("time (microsec): " + (Resulttime / 1000));

            //median
            median[medianindex] = Resulttime;
            medianindex++;

            //medelvärde
            medel = medel + Resulttime;

        }
        long medelvärde = medel / tries;
        System.out.println();
       // System.out.println("medelvärde:      " + (medelvärde / 1000));
        long medianresult = median(medianindex, median);
        System.out.println("median:          " + (medianresult / 1000));

    }

    public static long median( int a, long[] b)
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
                        long e = b[i];
                        b[i] = b[m];
                        b[m] = e;
                    }
                }
            }

        a = (a / 2);
        long c = b[a];
        return c;
    }
    
    public static void main(String[] args) {
        
       // Stack stat = new Stack.staticstack();
        Stack dyna = new Stack.DynamicStack();

        int tries = 1000;
        int amount = 3000;

        System.out.println();
      //  System.out.println("static: ");
       // benchmark(amount, tries, stat);

        System.out.println();
        System.out.println("dynamic: ");
        benchmark(amount, tries, dyna);

    }
}   
