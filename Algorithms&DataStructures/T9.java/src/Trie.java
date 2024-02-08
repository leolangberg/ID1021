import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.KeyStore.LoadStoreParameter;



public class Trie implements T9{

    Node root;

    private class Node {

        public Node[] next;
        public boolean valid;

        public Node() {

            next = new Node[27];
            valid = false;
        }

        private void add( char[] letterbox, int pos ) { //WORKS
            
            if( pos >= letterbox.length) {  //basecase
                this.valid = true;
                return;
            }
            else {
                int value = code(letterbox[pos]);
                if(this.next[value] == null) {
                    this.next[value] = new Node();
                }
                
                pos++;
                this.next[value].add(letterbox, pos);
            }
        } 

        private void collect(LinkedList possiblewords, String path, char[] letterbox, int pos) {

            if(pos >= letterbox.length) //BASECASE (entire word is traversed)
            {
                if(this.valid == true) 
                {
                    possiblewords.add(path); //adds correct word
                    return;
                }
                else
                    return;
            }
            
            int index = (CharToIndex(letterbox[pos]));
            pos++;
            
            for(int m = 0; m < 3; m++)
            {
                String curpath = path;
                int curval = ( index * 3 )  +  m ;

                if(this.next[curval] != null) {
                    curpath += uncode(curval); 
                    this.next[curval].collect(possiblewords, curpath, letterbox, pos);
                }
            }
            pos--;
            return;
            
        }



    }
  

    public void decode(String key ) {

        char[] letterbox = StringToChar(key);
        LinkedList possiblewords = new LinkedList();
        String path = "";
        
        //DECODE MATH
        int pos = 0;
        root.collect(possiblewords, path, letterbox, pos);
        possiblewords.printlist();

    }

    public void add( String word ) {
        
        char[] letterbox = StringToChar(word);
        int pos = 0;
        root.add( letterbox, pos );
    }


    public Trie() {

        this.root = new Node();
        String[] lexicon = LexiconReader.dataArray(); //String Array of all words
        for (int i = 0; i < lexicon.length; i++) {
            add(lexicon[i]);
        }

    }

    private static int code( char symbol ) {

        switch (symbol) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            case 'i':
                return 8;
            case 'j':
                return 9;
            case 'k':
                return 10;
            case 'l':
                return 11;
            case 'm':
                return 12;
            case 'n':
                return 13;
            case 'o':
                return 14;
            case 'p':
                return 15;
            //'q'
            case 'r':
                return 16;
            case 's':
                return 17;
            case 't':
                return 18;
            case 'u':
                return 19;
            case 'v':
                return 20;
            //w
            case 'x':
                return 21;
            case 'y':
                return 22;
            case 'z':
                return 23;            
            case 'å':
                return 24;
            case 'ä':
                return 25;
            case 'ö':
                return 26;
        
            default:
                return -1;
        }
    }

    private static char uncode( int num )
    {
        switch(num) { //q = -1 error
            case 0:
                return 'a';
            case 1:
                return 'b';
            case 2:
                return 'c';
            case 3:
                return 'd';
            case 4:
                return 'e';
            case 5:
                return 'f';
            case 6:
                return 'g';
            case 7:
                return 'h';
            case 8:
                return 'i';
            case 9:
                return 'j';
            case 10:
                return 'k';
            case 11:
                return 'l';
            case 12:
                return 'm';
            case 13:
                return 'n';
            case 14:
                return 'o';
            case 15:
                return 'p';
            case 16:
                return 'r';
            case 17:
                return 's';
            case 18:
                return 't';
            case 19:
                return 'u';
            case 20:
                return 'v';
            case 21:
                return 'x';
            case 22:
                return 'y';
            case 23:
                return 'z';
            case 24:
                return 'å';
            case 25:
                return 'ä';
            case 26:
                return 'ö';
            default:
                return 'q';

            
        }
    }

    private static char[] StringToChar( String word ) {

        char[] letterbox = new char[word.length()];
        for(int i = 0; i < word.length(); i++)
        {
            letterbox[i] = word.charAt(i);
        }
        return letterbox;
    }

    private static int CharToIndex( char num ) {

            return (Character.getNumericValue(num) - 1);
    }

    public static String uncodeString( String key )
    {
        char[] letters = StringToChar(key);
        String s = "";
        for(int i = 0; i < letters.length; i++)
        {
            s += code(letters[i]);
            s += " ";
        }
        return s;
    }
    

    public static void main(String[] args) {

        Trie A = new Trie();
        A.decode("225");
        //System.out.println(A.root.next[0].next[13].next[3].next[16].next[0].valid); //A N D R A
        System.out.println(A.uncodeString("andra"));
    }
   
        //System.out.println("char: " + keychar[i] + "  i: " + i + "  index: " + index);
        //System.out.println("path: " + path);
   
    
    
    
}
   



