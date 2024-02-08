import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class benchmarkgpt {
    

    public static void main(String[] args) {
        Random rand = new Random();
        List<Long> addMedians = new ArrayList<>();
        List<Long> lookupMedians = new ArrayList<>();

        for(int n = 10; n <= 10000; n *= 10)
        {
            List<Long> addRuntimes = new ArrayList<>();
            List<Long> lookupRuntimes = new ArrayList<>();

            for( int run = 0; run < 1000; run++)
            {
                BinaryTree tree = new BinaryTree();

                long addStartTime = System.nanoTime();
                for( int i = 0; i < n; i++)
                {
                    Integer key = rand.nextInt(10000);
                    tree.add(key, key);
                }
                long addEndTime = System.nanoTime();
                addRuntimes.add(addEndTime - addStartTime);

                long lookupStartTime = System.nanoTime();
                for(int i = 0; i < n; i++)
                {
                    Integer key = rand.nextInt(10000);
                    tree.lookup(key);
                }
                long lookupEndTime = System.nanoTime();
                lookupRuntimes.add(lookupEndTime - lookupStartTime);
            }

            Collections.sort(addRuntimes);
            Collections.sort(lookupRuntimes);

            addMedians.add(addRuntimes.get(500));
            lookupMedians.add(lookupRuntimes.get(500));

            System.out.println("For n = " + n + ":");
            System.out.println("add ns: " + addMedians.get(addMedians.size() - 1));
            System.out.println("lookup ns: " + lookupMedians.get(lookupMedians.size() - 1));
        }
    }
}
