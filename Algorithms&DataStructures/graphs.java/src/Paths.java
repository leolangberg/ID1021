public class Paths {
    
    City[] path;
    int sp; //stackpointer 

    public Paths() {

        path = new City[54];
        sp = 0;

    }

    private Integer shortest(City from, City to) {
        //System.out.println("current " + from.name);
        if(from == to) { //Arrived 
            //System.out.println("Arrived");
            return 0;
        }
        Integer shrt = null;

        for(int i = 0; i < sp; i++)
        {
            if( path[i] == from ) {
                //System.out.println("path already traversed: " + from.name);
                return null;
            }
        }
        path[sp++] = from;
        for(int j = 0; j < from.neighbours.size(); j++)
        {
            Connection conn = from.neighbours.get(j);
            Integer dist = shortest(conn.city, to);

            if(dist != null) {
                if( (shrt == null) || (shrt > dist + conn.distance)) { //best result
                        shrt = dist + conn.distance;
                }
            }
        }
        path[sp--] = null;
        return shrt;
    }
    

    public static void main(String[] args ) {
       
        Map A = new Map("trains.csv");
        Paths B = new Paths();
        City one = A.finder("Umeå");
        City two = A.finder("Göteborg");
        System.out.println("From: " + one.name + "  To: " + two.name);
        
        
        long t0 = System.nanoTime();
        Integer dist = B.shortest( one, two);
        long time = (System.nanoTime() - t0) / 1_000_000;
        System.out.println("shortest: " + dist + " min (" + time + " ms)");

    }
}

