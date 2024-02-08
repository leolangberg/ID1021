import java.io.BufferedReader;
import java.io.FileReader;
import java.util.NoSuchElementException;

public class Zip {
    
    Node[] data;
    int max;

    public class Node {

        String code;
        String name;
        Integer pop;

        public Node(String code, String name, Integer pop) {

            this.code = code;
            this.name = name;
            this.pop = pop;
        }

    }

    public Zip(String file) { //Makes long array of nodes
        
        data = new Node[10000];
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Node lookuplinear( String code ) {

        int i = 0;
        while(!this.data[i].code.equals(code)) //not equal
        {
            i++;
        }
        return this.data[i];
        
    }

    public Node lookupbinary( String code ) {

        int lo = 0;
        int hi = max; //this.data.length - 1

        while(true)
        {
            if(hi < lo)
               throw new NoSuchElementException();

            int mid = (lo + hi) / 2;

            if(this.data[mid].code.compareTo(code) > 0) //this < code
            {
                hi = mid - 1;
            }
            else if(this.data[mid].code.compareTo(code) < 0)
            {
                lo = mid + 1;
            }
            else 
                return this.data[mid];
        }
    }


    public static void main(String[] args) {
        Zip A = new Zip( "postnummer.csv" );
        //System.out.println( A.data[0].code );
        Node b = A.lookupbinary("984 99");
        System.out.println(b.name);
    }

}
