import java.io.BufferedReader;
import java.io.FileReader;
import java.util.NoSuchElementException;

public class ZipInteger {
    
    Node[] data;
    int max;

    public class Node {

        Integer code;
        String name;
        Integer pop;

        public Node(Integer code, String name, Integer pop) {

            this.code = code;
            this.name = name;
            this.pop = pop;
        }

    }

    public ZipInteger(String file) { //Makes long array of nodes
        
        data = new Node[10000];
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Node lookuplinear( Integer code ) {

        int i = 0;
        while(!this.data[i].code.equals(code)) //not equal
        {
            i++;
        }
        return this.data[i];
        
    }

    public Node lookupbinary( Integer code ) {

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
        ZipInteger A = new ZipInteger( "postnummer.csv" );
        //System.out.println( A.data[0].code );
        Node b = A.lookupbinary( 28491);
        System.out.println(b.name);
    }

}
