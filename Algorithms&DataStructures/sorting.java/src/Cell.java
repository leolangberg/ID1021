public class Cell<K,V> {

    K key;
    V value;
    Cell<K,V> next;

    public Cell(K a, V v, Cell<K,V> tl)
    {
        key = a;
        value = v;
        next = tl;

    }
  
}
