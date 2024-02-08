public class PathsDynamicMax {
    
    City[] path;
    int sp; //stackpointer 

    public PathsDynamicMax() {

        path = new City[133];
        sp = 0;

    }

    private Integer shortest(City from, City to, Integer max) {
        
         //System.out.println("cur: " + from.name + "  max: " + max);
        
        if( max != null && max < 0 ) {
            return null;
        }
        if(from == to) { //Arrived 
            return 0;
        }

        Integer shrt = null;

        for(int i = 0; i < sp; i++)
        {
            if( path[i] == from ) {
               // System.out.println("path already traversed: " + from.name);
                return null;
            }
        }

        path[sp++] = from;
        for(int j = 0; j < from.neighbours.size(); j++)
        {
            Connection conn = from.neighbours.get(j);
            Integer dist;

            if(max == null) {
                dist = shortest(conn.city, to, max);
            } else {
                dist = shortest(conn.city, to, (max - conn.distance));
            }

            if(dist != null) {
                if( (shrt == null) || (shrt > dist + conn.distance)) { //best result
                        shrt = dist + conn.distance;  
                        max = shrt;
                }
                
            }
        }
        path[sp--] = null;
        return shrt;
    }
    

    public static void main(String[] args ) {
       
        Map A = new Map("europe.csv");
        PathsDynamicMax B = new PathsDynamicMax();
        City one = A.finder("Malmö");
        City two = A.finder("Oslo");
        System.out.println("From: " + one.name + "  To: " + two.name);
        
        
        long t0 = System.nanoTime();
        Integer max = null;
        Integer dist = B.shortest( one, two, max);
        long time = (System.nanoTime() - t0) / 1_000_000;
        System.out.println("shortest: " + dist + " min (" + time + " ms)");

    }
}
