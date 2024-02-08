import java.util.PriorityQueue;

public class Dijkstra {
    
    Path[] done;
    PriorityQueue<Path> queue = new PriorityQueue<>();
    //ArrayPriorityQueue<Path> queue;
    //Map graph;

    public Dijkstra(Map graph) {

        done = new Path[graph.size()];
        queue = new PriorityQueue<>();
        //queue = new ArrayPriorityQueue<Path>(150);

    }

    private class Path implements Comparable<Path>{

        private City city;
        private City prev;
        private Integer dist;
        private Integer index; 
    
    
        public Path(City city, City prev, Integer dist, Integer index) {
    
            this.city = city;
            this.prev = prev;
            this.dist = dist;
            this.index = index;
    
        }
    
        public int compareTo( Path p )
        {
            if(this.dist < p.dist) //compares distances between paths
                return -1;
            else if( this.dist > p.dist)
                return 1;
            else
                return 0;
        }
    }

    public Integer Search( City from, City to) {

        Path start = new Path(from, null, 0, from.id); //Malmö
        queue.add(start);
        Integer shrt = Shortest(to);
        return shrt;
    }

    public Integer Shortest(City destination) {

        while(!queue.isEmpty()) 
        {
            Path curpath = queue.remove();
            Integer time = curpath.dist;

            if(done[curpath.city.id] == null) {
                done[curpath.city.id] = curpath;
           }

            if(curpath.city.equals(destination)) {
                return time;
            }
            else 
            {

                for(int i = 0; i < curpath.city.neighbours.size(); i++)
                {
                    Connection conn = curpath.city.neighbours.get(i);
                    if(done[conn.city.id] == null) {
                        Path potential = new Path(conn.city, curpath.city, time + conn.distance, null);
                            queue.add(potential);
                        
                    }
                }
            }   
        }
        
        return -1; //case: not found 
    }

    public int ElementsInDone() {

        int num = 0;
        for(int i = 0; i < done.length; i++)
        {
            if(done[i] != null)
                num++;
        }  
        return num; 
    }


    public static void main( String[] args ) {
       
        Map A = new Map("europe.csv");
        City one = A.finder("Malmö");
        City two = A.finder("Bukarest");
        Dijkstra dik = new Dijkstra(A);

        
        System.out.println("From: " + one.name + "  To: " + two.name);
        
        
        long t0 = System.nanoTime();
        Integer dist = dik.Search(one, two);
        long time = (System.nanoTime() - t0) / 1_000;
        System.out.println("shortest: " + dist + " min (" + time + " us)");
        System.out.println(dik.ElementsInDone());

    }
}
