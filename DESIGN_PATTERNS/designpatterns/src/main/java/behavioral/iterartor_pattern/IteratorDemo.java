package behavioral.iterartor_pattern;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;

class IntSet {

	private Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

    // 1. Design an internal "iterator" class for the "collection" class
    public static class Iterator {
        private IntSet set;
       private Enumeration<?> e;
        private Integer current;

        public Iterator(IntSet in) {
            set = in;
        }

        public void first() {
            e = set.ht.keys();
            next();
        }

        public boolean isDone() {
            return current == null;
        }

        public int currentItem() {
            return current;
        }

        public void  next() {
            try {
                current = (Integer)e.nextElement();
            } catch (NoSuchElementException e) {
                current = null;
            }
        }
    }

    public void add(int in) {
        ht.put(in, "null");
    }

    public boolean isMember(int i) {
        return ht.containsKey(i);
    }

    
	public Hashtable<Integer, String> getHashtable() {
        return ht;
    }

   
    public Iterator createIterator()  {
        return new Iterator(this);
    }
}

public class IteratorDemo {
    public static void main( String[] args ) {
        IntSet set = new IntSet();
        for (int i=2; i < 10; i += 2) set.add( i );
        for (int i=1; i < 9; i++)
            System.out.print( i + "-" + set.isMember( i ) + "  " );

        // 3. Clients ask the collection object to create many iterator objects
        IntSet.Iterator it1 = set.createIterator();
        IntSet.Iterator it2 = set.createIterator();

        // 4. Clients use the first(), isDone(), next(), currentItem() protocol
        System.out.print( "\nIterator:    " );
        for ( it1.first(), it2.first();  ! it1.isDone();  it1.next(), it2.next() )
            System.out.print( it1.currentItem() + " " + it2.currentItem() + "  " );

        // Java uses a different collection traversal "idiom" called Enumeration
        System.out.print( "\nEnumeration: " );
        for (Enumeration<Integer> e = set.getHashtable().keys(); e.hasMoreElements(); )
            System.out.print( e.nextElement() + "  " );
        System.out.println();
    }
}