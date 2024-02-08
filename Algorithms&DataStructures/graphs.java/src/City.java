import java.util.ArrayList;

public class City {
    
    String name;
    ArrayList<Connection> neighbours;

    public City(String name)
    {
        this.name = name;
        neighbours = new ArrayList<>();
    }

    public void connect( City nxt, Integer dst)
    {
        neighbours.add(new Connection(nxt, dst));
        
    }
}
