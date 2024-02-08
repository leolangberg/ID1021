import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class ZipBucket {
    
    Bucket[] data;
   // int min;
    int max;
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

    public class Bucket {

        Node[] Nodelocal /*  = new Node[1]  */; //should only be initialized 

        public Bucket(Node zipnode) {

            Nodelocal = new Node[1];
            Nodelocal[0] = zipnode;
        }

        public void Arrayincrease(Node a)
        {
            Node[] extended = new Node[this.Nodelocal.length + 1];
    
            for(int i = 0; i < this.Nodelocal.length; i++)
            {
                extended[i] = Nodelocal[i];
            }
            extended[Nodelocal.length] = a;
            Nodelocal = extended;
        }
    }

    public ZipBucket(String file) { //Makes long array of nodes
        
        data = new Bucket[13513];
        collisionpos = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0; //first code
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                Node c = new Node(code, row[1], Integer.valueOf(row[2]));

                Hashset(code,c);
                
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
        
        if (this.data[key] == null) 
            return null;
        
        else {
            for(int i = 0; i < this.data[key].Nodelocal.length; i++)
            {
                if(this.data[key].Nodelocal[i].code.equals(StringToInt(code)))
                    return this.data[key].Nodelocal[i];
            }
            return null;
        }
    }

    public static Integer hash(Integer code) {

        int m = 13513;
        
        code = (code % m);
        return code;
    }

    public void Hashset(Integer code, Node c) {

        //same function as hash but scan for collisions
        Integer hashcode = hash(code);

        if(this.data[hashcode] != null)
        {
            this.data[hashcode].Arrayincrease(c);
            collisionpos++;
        }
        else
            this.data[hashcode] = new Bucket(c);

    }
   
    public Integer StringToInt( String code ) {

        Integer ret = Integer.valueOf(code.replaceAll("\\s",""));

        return ret;
    }




    public static void main(String[] args) {
        ZipBucket A = new ZipBucket( "postnummer.csv" );
        //System.out.println( A.data[hash(92193)].Nodelocal[0].name );  //STOCKHOLM LYCKSELE
        //111 15 STOCKHOLM  == 921 93 LYCKSELE
        Node b = A.lookup( "921 93");
        System.out.println(b.name);
        System.out.println(A.collisionpos);

       // System.out.println(A.data[hash(11115)].Nodelocal[0].name);
       // System.out.println(A.data[hash(11115)].Nodelocal[1].name);
    }

}