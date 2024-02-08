import java.util.ArrayList;

public class City {
    
    String name;
    Integer id;
    ArrayList<Connection> neighbours;

    public City(String name, Integer id)
    {
        this.name = name;
        this.id = id;
        neighbours = new ArrayList<>();
    }

    public void connect( City nxt, Integer dst)
    {
        //Connection c = new Connection(nxt, dst);
        neighbours.add(new Connection(nxt, dst));
        
    }
}
