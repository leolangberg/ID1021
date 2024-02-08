public interface T9 {
    
    void decode( String key);
     //lookup?

    void add(String word);

    public static void main(String[] args )
    {
        T9 A = new Trie();
        A.decode("517");
    }
}
