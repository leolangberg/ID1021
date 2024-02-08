import java.util.PriorityQueue;

public class Dijkstra {
  
    private Path[] done;
    //private BinaryTreePriorityQueue<Path> queue; //använd heap istället så det blir log(n)
    private PriorityQueue<Path> queue;
    private Map map;

    private class Path implements Comparable<Path> {    // O(n*logn) 

        private City city;
        private City prev;
        private Integer dist;
        private Integer index;

        private Path(City city, City prev, Integer dist) {

            //this.city = city;
            //prev = null;
            //dist = 0;

            this.city = city;
            this.prev = prev;
            this.dist = dist;
        }
    }

    public Dijkstra( Map map) {
        int n = map.size(); //how many cities
        done = new Path[n];
        queue = new PriorityQueue<>();
    }

    public Integer dist(City city) {
        if( city != null && done[city.id] != null)
            return done[city.id].dist;
        else 
         //
    }

    public City from(City city) {
        return done[city.id].prev;
    }

    public void search( City from, City dest ) {
        Path ex = new Path(from, null, 0);
        queue.add(ex);
        shortest(dest);
    }

    public void shortest(City dest) {

        while(!queue.isEmpty()) {
            Path entr = queue.remove();
        

            City city = entr.city;
            if(done[city.id] == null) {
                done[city.id] = entr;
            }

            //
            Integer sofar = entr.dist;

            for(Connection conn : city.neighbours) {
                City to = conn.city;
                if(done[to.id] == null) {
                    Path ex = new Path(to, city, (sofar + conn.distance));
                    queue.add(ex);
                }
            }
        } 
    }

    public int compareTo( Path pt) {

    }
}
