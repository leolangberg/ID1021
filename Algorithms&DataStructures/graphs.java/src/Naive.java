import java.util.ArrayList;

public class Naive {

    public static void main( String[] args ) {
       
        Map A = new Map("trains.csv");
        City one = A.finder("Umeå");
        City two = A.finder("Göteborg");
        Integer maxtime = 710;
        System.out.println("From: " + one.name + "  To: " + two.name);
        
        
        long t0 = System.nanoTime();
        Integer dist = shortest( one, two, maxtime);
        long time = (System.nanoTime() - t0) / 1_000_000;
        System.out.println("shortest: " + dist + " min (" + time + " ms)");

    }
    
    private static Integer shortest( City from, City to, int max) {
       // System.out.println("Enter");
       // System.out.println(" from.name: " + from.name + "  to.name: " +  to.name + "  max: " + max);       
        
        if(max < 0) {  //BASECASE  (time runs out)
            return null;
        }
        if(from == to) { //Arrived 
            return 0;
        }
        Integer shrt = null;
        
        for(int i = 0; i < from.neighbours.size(); i++)
        {
            if(from.neighbours.get(i) != null)
            {
                Connection conn = from.neighbours.get(i); //[i]
               // System.out.println(" conn.city: " + conn.city.name  +  "  conn.dist: " + conn.distance);
                Integer dist = shortest( conn.city, to, (max - conn.distance));
                if(dist != null) {
                    if( (shrt == null) || (shrt > dist + conn.distance)) { //best result
                        shrt = dist + conn.distance;
                        //System.out.println(shrt);
                    }
                }
            }         
        }
       // System.out.println(shrt);
        return shrt;
    }

}
