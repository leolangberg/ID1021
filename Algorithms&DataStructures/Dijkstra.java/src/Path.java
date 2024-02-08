public class Path{

    public City city;
    public City prev;
    public Integer dist;
    public Integer index; 


    public Path(City city, City prev, Integer dist, Integer index) {

        this.city = city;
        this.prev = prev;
        this.dist = dist;
        this.index = index;

    }

    public int comparator( Path p )
    {
        if(this.dist < p.dist) //compares distances between paths
            return -1;
        else if( this.dist > p.dist)
            return 1;
        else
            return 0;
    }
}
