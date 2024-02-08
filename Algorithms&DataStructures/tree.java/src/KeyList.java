import java.util.Iterator;
public class KeyList<K extends Comparable<K>,V> implements Iterable<V>{
    
    Cell<K,V> first; 
    Integer length;

    public KeyList() {
        first = null;
    }

    public void add(K key, V name) {
        first = new Cell<>(key, name, first);
        length++;
    }

    V lookup(K k )
    {
        for( Cell<K,V> cur = first; cur != null; cur = cur.next) {
            if(cur.key.equals(k) ) {
                return cur.value;
            }
        }
        return null;
    }
   
    public void remove( K k)
    {
        Cell<K,V> prv = null;

        for( Cell<K,V> cur = first; cur != null; cur = cur.next) {
            if(cur.key == k ) {
                if(prv != null)
                    prv.next = cur.next;
                else
                    first = cur.next;
                return;
            }
            prv = cur;
        }
    }


    private static void print(KeyList<String,String> map, String[] keys ) {
        for(String k : keys) {
            System.out.println(" key: " + k + " value: " + map.lookup(k));
        }
    }

    private static void pront(KeyList<String,String> map) { 
        for( String v : map) {
            System.out.println(" found " + value );
        }

    }
    public static void main(String[] args) {
        KeyList<String,String> map = new KeyList<>();

        map.add("åtta ", "eight");
        map.add("sex ", "six");
        map.add("tre ","three");
        map.add("fyra ", "four");
        
        Integer[] keys = {3,4,6,8};

       // pront(map, keys);

    }



    public Iterator<V> iterator() {
        return new ValueIterator();
    }

    private class ValueIterator implements Iterator<V> {
        
        private Cell<K,V> cur;

        public ValueIterator() {
            cur = first;
        }

        public boolean hasNext() {
            return (cur != null);
        }

        public V next() {
            if( cur == null)
                return null;
            
            V ret = cur.value;
            cur = cur.next;

            return ret;
        }
    }
}

