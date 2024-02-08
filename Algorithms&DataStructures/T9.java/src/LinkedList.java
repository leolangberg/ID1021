public class LinkedList {
    
    Cell first;

    private class Cell {

        String word;
        Cell next;

        public Cell(String word)
        {
            this.word = word;
            this.next = null;
        }
    }


    public void add( String word )
    {
        Cell a = new Cell(word);
        //System.out.println("List Add: " + word);
        if(first == null)
        {
            first = a;
        }
        else {
            Cell n = first;
            while( n.next != null)
            {
                n = n.next;
            }
            n.next = a;
        }
    }

    public void printlist() {

        Cell n = first;
        while( n != null)
        {
            System.out.println(n.word);
            n = n.next;
        }
    }

    public int length() {

        int length = 0;
        Cell n = first;
        while( n != null)
        {
            length++;
            n = n.next;
        }
        return length;
    }
}
