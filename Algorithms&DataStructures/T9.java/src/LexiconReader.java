import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class LexiconReader {

    public static void main(String[] args) {
        //List<String> A = datalist();
        //for (String item : A) {
         //   System.out.println(item);
       // }

      // String[] A = dataArray();
       //for(int i = 0; i < 8262; i++) // max = 8262
       //{
       // System.out.println(A[i]);
       //}

        Trie A = new Trie();

    }

    public LexiconReader() {

        List lexicon = datalist();
    }

    public static List<String> datalist() {
        List<String> words = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("lexicon.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception, e.g., print an error message
        }
        return words;
    }

    public static String[] dataArray() {

        String[] words = new String[8262]; //10000
        int i = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("lexicon.txt" , StandardCharsets.UTF_8));
            String line;
            while ((line = reader.readLine()) != null) {
                words[i] = line;
                i++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        return words;
    }

    
    
}

