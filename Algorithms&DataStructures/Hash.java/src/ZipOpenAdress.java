import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class ZipOpenAdress {
    
    Node[] data;
   // int min;
    int max;
    int elementscanned = 0;

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

    public ZipOpenAdress(String file) { //Makes long array of nodes
        
        data = new Node[13513];
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0; //first code
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                Node c = new Node(code, row[1], Integer.valueOf(row[2]));
                Hashset(code, c);
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

        Integer key = StringToInt(code);
        key = hash(key);
        
        elementscanned = 0;
        while(this.data[key] != null)
        {
            elementscanned++;
            if(this.data[key].code.equals(StringToInt(code))) {
                System.out.println(elementscanned);
                return this.data[key];
            }
            else 
                key++;
        }
       
        //not found
        return null;
        
    }

    public static Integer hash(Integer code) {

        int m = 13513;
        
        code = (code % m);
        return code;
    }

    public void Hashset(Integer code, Node c) {

        Integer hashcode = hash(code);

            while(this.data[hashcode] != null)
            {
                hashcode = hashcode + 1;
            }
            this.data[hashcode] = c; // new Node
    }

    public Integer StringToInt( String code ) {

        Integer ret = Integer.valueOf(code.replaceAll("\\s",""));

        return ret;
    }




    public static void main(String[] args) {
        ZipOpenAdress A = new ZipOpenAdress( "postnummer.csv" );
        //System.out.println( A.data[1].name );
        System.out.println( A.data[hash(11115)].name ); //LYKSELE
        System.out.println( A.data[hash(92193)].name ); //LYKSELE

        
        Node b = A.lookup( "111 15");
        System.out.println("LOOKUP: " + b.name);

        Node d = A.lookup("921 93");
        System.out.println("LOOKUP: " + d.name);

        Node c = A.lookup("284 91");
        System.out.println("LOOKUP: " + c.name);


        //System.out.println(A.elementscanned);
    }

}