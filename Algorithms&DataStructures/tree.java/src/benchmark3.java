import java.util.Random;
public class benchmark3 {
    

 
    public static void main(String[] args) {
        // Define the range of tree sizes to test
        int[] treeSizes = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};

        for (int size : treeSizes) {
            BinaryTree binaryTree = new BinaryTree();
            Random random = new Random();

            // Add elements to the binary tree
            long startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                int key = random.nextInt(size * 10); // Generate random keys
                int value = key; // Use the key as the value for simplicity
                binaryTree.add(key, value);
            }
            long endTime = System.nanoTime();
            long addTime = endTime - startTime;

            // Perform lookups on the binary tree
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                int key = random.nextInt(size * 10); // Generate random keys
                binaryTree.lookup(key);
            }
            endTime = System.nanoTime();
            long lookupTime = endTime - startTime;

            System.out.println("Tree Size: " + size + " Add Time (ns): " + (addTime/1000 ));
            
            //System.out.println("Lookup Time (ns): " + (lookupTime/1000 ));
            //System.out.println();
        }
    }
}
