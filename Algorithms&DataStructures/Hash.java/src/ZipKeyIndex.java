import java.io.BufferedReader;
import java.io.FileReader;
import java.util.NoSuchElementException;

public class ZipKeyIndex {
    
    Node[] data;
    int min;
    int max;

    public class Node {

        Integer code;
        String name;
        Integer pop;

        public Node(Integer code, String name, Integer pop) {

            this.code = code; //not used now
            this.name = name;
            this.pop = pop;
        }

    }

    public ZipKeyIndex(String file) { //Makes long array of nodes
        
        data = new Node[100000];
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0; //first code
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
                i++;
            }
            min = 11115; //first code
            max = 98499; //last code
           //max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Node lookup( String code ) {

        Integer key = Integer.valueOf(code.replaceAll("\\s",""));
        return this.data[key];
        
    }

    


    public static void main(String[] args) {
        ZipKeyIndex A = new ZipKeyIndex( "postnummer.csv" );
        //System.out.println( A.data[28491].name );
        Node b = A.lookup( "284 91");
        System.out.println(b.name);
    }

}
