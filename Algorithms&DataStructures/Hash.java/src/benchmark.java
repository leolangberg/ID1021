import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Random;
public class benchmark {

    public static void main(String[] args) {

        benchZipKeyIndex();
    }
    

    public static void benchsearchesZip() {

        System.out.println("Zip no keys");
        String searchA = "111 15"; //first
        String searchB = "984 99"; //last

        Zip postnummer = new Zip("postnummer.csv");

        double[] timestampsAlinear = new double[1000];
        for(int i = 0; i < 1000; i++)
        {
            long t0 = System.nanoTime();
            postnummer.lookuplinear(searchA);
            long t1 = System.nanoTime();
            double searchAlinear = t1 - t0;
            timestampsAlinear[i] = searchAlinear;
        }

        double[] timestampsBlinear = new double[1000];
        for(int i = 0; i < 1000; i++)
        {
            long t3 = System.nanoTime();
            postnummer.lookuplinear(searchB);
            long t4 = System.nanoTime();
            double searchBlinear = t4 - t3;
            timestampsBlinear[i] = searchBlinear;
        }

        double[] timestampsAbinary = new double[1000];
        for(int i = 0; i < 1000; i++)
        {
            long t5 = System.nanoTime();
            postnummer.lookupbinary(searchA);
            long t6 = System.nanoTime();
            double searchAbinary = t6 - t5;
            timestampsAbinary[i] = searchAbinary;
        }
        
        double[] timestampsBbinary = new double[1000];
        for(int i = 0; i < 1000; i++)
        {
            long t7 = System.nanoTime();
            postnummer.lookupbinary(searchB);
            long t8 = System.nanoTime();
            double searchBbinary = t8 - t7;
            timestampsBbinary[i] = searchBbinary;
        }

        System.out.println(timestampsBlinear[0] / 1000);
        double medianAlinear = median(timestampsAlinear);
        double medianBlinear = median(timestampsBlinear);
        double medianAbinary = median(timestampsAbinary);
        double medianBbinary = median(timestampsBbinary);

        System.out.println("time in us: '111 15': " + "linear: " + medianAlinear/1000 + "  binary: " +  medianAbinary/1000);
        System.out.println("time in us: '984 99': " + "linear: " + medianBlinear/1000 + "  binary: " + medianBbinary/1000);
    }

    public static void benchsearchesZipInteger() {


        System.out.println("Zip Integers");
        Integer searchA = 11115; //first
        Integer searchB = 98499; //last

        ZipInteger postnummer = new ZipInteger("postnummer.csv");

        double[] timestampsAlinear = new double[1000];
        for(int i = 0; i < 1000; i++)
        {
            long t0 = System.nanoTime();
            postnummer.lookuplinear(searchA);
            long t1 = System.nanoTime();
            double searchAlinear = t1 - t0;
            timestampsAlinear[i] = searchAlinear;
        }

        double[] timestampsBlinear = new double[1000];
        for(int i = 0; i < 1000; i++)
        {
            long t3 = System.nanoTime();
            postnummer.lookuplinear(searchB);
            long t4 = System.nanoTime();
            double searchBlinear = t4 - t3;
            timestampsBlinear[i] = searchBlinear;
        }

        double[] timestampsAbinary = new double[1000];
        for(int i = 0; i < 1000; i++)
        {
            long t5 = System.nanoTime();
            postnummer.lookupbinary(searchA);
            long t6 = System.nanoTime();
            double searchAbinary = t6 - t5;
            timestampsAbinary[i] = searchAbinary;
        }
        
        double[] timestampsBbinary = new double[1000];
        for(int i = 0; i < 1000; i++)
        {
            long t7 = System.nanoTime();
            postnummer.lookupbinary(searchB);
            long t8 = System.nanoTime();
            double searchBbinary = t8 - t7;
            timestampsBbinary[i] = searchBbinary;
        }

        System.out.println(timestampsBlinear[0] / 1000);
        double medianAlinear = median(timestampsAlinear);
        double medianBlinear = median(timestampsBlinear);
        double medianAbinary = median(timestampsAbinary);
        double medianBbinary = median(timestampsBbinary);

        System.out.println("time in us: '111 15': " + "linear: " + medianAlinear/1000 + "  binary: " +  medianAbinary/1000);
        System.out.println("time in us: '984 99': " + "linear: " + medianBlinear/1000 + "  binary: " + medianBbinary/1000);
    }

    public static void benchZipKeyIndex() {

        String searchA = "111 15"; //first
        String searchB = "984 99"; //last

        ZipKeyIndex postnum = new ZipKeyIndex("postnummer.csv");

        double[] timestampsAlinear = new double[1000];
        for(int i = 0; i < 1000; i++)
        {
            long t0 = System.nanoTime();
            postnum.lookup(searchA);
            long t1 = System.nanoTime();
            double searchAlinear = t1 - t0;
            timestampsAlinear[i] = searchAlinear;
        }

        double[] timestampsBlinear = new double[1000];
        for(int i = 0; i < 1000; i++)
        {
            long t3 = System.nanoTime();
            postnum.lookup(searchB);
            long t4 = System.nanoTime();
            double searchBlinear = t4 - t3;
            timestampsBlinear[i] = searchBlinear;
        }

        double[] timestampsAbinary = new double[1000];
        for(int i = 0; i < 1000; i++)
        {
            long t5 = System.nanoTime();
            postnum.lookup(searchA);
            long t6 = System.nanoTime();
            double searchAbinary = t6 - t5;
            timestampsAbinary[i] = searchAbinary;
        }
        
        double[] timestampsBbinary = new double[1000];
        for(int i = 0; i < 1000; i++)
        {
            long t7 = System.nanoTime();
            postnum.lookup(searchB);
            long t8 = System.nanoTime();
            double searchBbinary = t8 - t7;
            timestampsBbinary[i] = searchBbinary;
        }

        System.out.println(timestampsBlinear[0] / 1000);
        double medianAlinear = median(timestampsAlinear);
        double medianBlinear = median(timestampsBlinear);
        double medianAbinary = median(timestampsAbinary);
        double medianBbinary = median(timestampsBbinary);

        System.out.println("time in us: '111 15': " + "linear: " + medianAlinear/1000 + "  binary: " +  medianAbinary/1000);
        System.out.println("time in us: '984 99': " + "linear: " + medianBlinear/1000 + "  binary: " + medianBbinary/1000);
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
