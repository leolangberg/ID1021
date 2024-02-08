import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class ZipKeyHash {
    
    Node[] data;
   // int min;
    int max;
    Node[] collisiondata;
    int[] collisionkey;
    int collisionpos;

    
    

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

    public ZipKeyHash(String file) { //Makes long array of nodes
        
        data = new Node[13513];
        collisiondata = new Node[2288];
        collisionkey = new int[2288];
        collisionpos = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0; //first code
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[collisions(code)] = new Node(code, row[1], Integer.valueOf(row[2]));
                i++;
            }
            //min = 11115; //first code
           // max = 98499; //last code
           max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Node lookup( String code ) {

        Integer key = Integer.valueOf(code.replaceAll("\\s",""));
        key = hash(key);
        
        if (this.data[key] == null) 
            return null;
        else
            return this.data[key];
        
    }

    public static Integer hash(Integer code) {

        int m = 13513;
        
        code = (code % m);
        return code;
    }

    public Integer collisions(Integer code) {

        //same function as hash but scan for collisions
        Integer hashcode = hash(code);


        if(this.data[hashcode] != null)
        {
            collisiondata[collisionpos] = this.data[hashcode];
            collisionkey[collisionpos] = hashcode;
            collisionpos++;
        }

        return hashcode;
    }
   




    public static void main(String[] args) {
        ZipKeyHash A = new ZipKeyHash( "postnummer.csv" );
        System.out.println( A.data[hash(11115)].name );
        Node b = A.lookup( "111 15");
        System.out.println(b.name);
        System.out.println(A.collisionpos);
    }

}