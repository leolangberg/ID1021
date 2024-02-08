import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Map {

    City[] cities;
    private final int mod = 541;
    int collisions;
   
    private Integer hash(String name) {
        int hash = 0;
        
        for(int i = 0; i < name.length(); i++) {
            hash = (hash*31 % mod) + name.charAt(i);
        }

        return hash % mod;
    }

    public Map(String file) {

        cities = new City[mod]; //length 541

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] row = line.split(",");             
                City one = HashMapper(row[0]);
                City two = HashMapper(row[1]);
                Integer distance = Integer.valueOf(row[2]);  
                one.connect(two, distance);
                two.connect(one, distance);
            }
         
            
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

                //LOOKUP
    public City HashMapper(String name) {
        Integer hashcode = hash(name);

        while(cities[hashcode] != null)
        {
            if(cities[hashcode].name.equals(name))
                return cities[hashcode];
            else {
                hashcode = (hashcode + 1) % mod;
                collisions++;
            }
        }
        City ShantyTown = new City(name);
        cities[hashcode] = ShantyTown;
        return ShantyTown;
    }

    public City finder(String name)
    {
        Integer hashcode = hash(name);
        while(cities[hashcode] != null)
        {
            if(cities[hashcode].name.equals(name))
                return cities[hashcode];
            else
                hashcode = hashcode + 1;
        }
        return null; //case: not found
    }

    public static void main(String[] args) {

        Map A = new Map("trains.csv");
        System.out.println("collision: " + A.collisions);
        //System.out.println(Arrays.toString(A.cities));
        /* 
        for(int i = 0; i < 541; i++)
        {
            if(A.cities[i] == null)
                System.out.println(0);
            else {
                System.out.println(A.cities[i].name);
                for(int j = 0; j < A.cities[i].neighbours.size(); j++)
                {
                    System.out.print(A.cities[i].neighbours.get(j).city.name + " ");
                }
                System.out.println();
            }
        }
        
        /* 
        
        City b = A.finder("Lund");
        Connection bb = b.neighbours.get(0);
        System.out.println(b.name);
        System.out.println(bb.city.name);
        System.out.println(bb.distance);
        */

        City b = A.finder("Malmö");
        //System.out.println(b.neighbours.get(0).city.neighbours.get(1).city.name);

        
    }
}
