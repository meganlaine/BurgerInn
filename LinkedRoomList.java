import java.util.*;

/**
 * Class LinkedRoomList can be used to store a values of type Room. It has a reference to 
 * the first Room in the list, the last Room in the list, and knows how many Rooms are in 
 * the list.
 * 
 * @author Megan Laine
 * @version 4 Mar 2019 CSC 143 
 */
public class LinkedRoomList implements Iterable<ListRoomNode>
{
    private ListRoomNode front;  // first Room
    private ListRoomNode back;   // last Room
    private int size;            // number of Rooms in this LinkedRoomList

    /**
     * LinkedRoomList Constructor (default 1/2) constructs a LinkedRoomList that is 'empty' 
     * (it has no ListRoomNodes in it).
     */
    public LinkedRoomList()
    {
        // instantiate the front and back; point both to NULL
        front = new ListRoomNode(null);
        back = new ListRoomNode(null);
        
        // clear method helps set size to zero
        clear();
    }
    
    /**
     * LinkedRoomList Constructor (2/2) constructs a LinkedRoomList with a given Room as the 
     * front node; there is no back node. This is similar to using the add method. 
     *
     * @param  r  (Room) a room object to add to the list
     */
    public LinkedRoomList( Room r )
    {
        // instantiate the front and back; point both to NULL
        front = new ListRoomNode(r);
        back = new ListRoomNode(null);
        
        // instantiate size
        size = 1;
    }

    /**
     * Returns an integer representing the size of the LinkedRoomList (how many Rooms are 
     * stored in the list).
     *
     * @return (int) the size of the list / how many Rooms are in the list.
     */
    public int size()
    {
        return this.size;
    }

    /**
     * Returns the Room at the given index in the LinkedRoomList; the index must be a legal 
     * index given the size of the LinkedRoomList
     * (otherwise: throw IndexOutOfBoundsException).
     *
     * @param index (int) the index of the list
     * @return (Room) the room object within the node at the given index.
     */
    public Room get( int index )
    {
        checkIndex( index );
        ListRoomNode current = nodeAt( index );
        
        // return the Room object in the current node
        return current.r;
    }

    /**
     * Method toString pverrides any inherited toString method and returns a String that 
     * contains a String version of the Rooms in the ListRoomNodes, separated by commas and 
     * within brackets.
     *
     * @return (String) a string display of Rooms in this LinkedRoomList
     */
    @Override
    public String toString()
    {
        String result = "[";
        
        if (size == 1)
        {
            result += front.r.toString();
        }
        else if (size > 1)
        {
            // add the first node's Room to result String
            result += front.r.toString() + ", ";
            
            // create a reference to the second node
            ListRoomNode current = front.next;
            
            // we'll only enter this while loop if size > 2
            while (current != back)
            {
                result += current.r.toString() + ", ";
                
                // advance to the next ListRoomNode
                current = current.next;
            }
            
            // add the last node's room
            result += back.r.toString();
        }
        
        // you also get here if size of list was 0
        return result + "]";
    }

    // post : returns the position of the first occurrence of the given Room
    //        value (-1 if not found)
    /**
     * Method indexOf returns the index of the FIRST Room instance in this LinkedRoomList; 
     * if there is no Room matching the search parameter (room number), then return -1.
     *
     * @param roomNumLookUp (String) the room number of interest
     * @return (int) the index of the first Room instance in this LinkedRoomList that matches
     */
    public int indexOf( String roomNumLookUp )
    {
        int index = 0;
        ListRoomNode current = front.next;
        
        while (current !=  back) {
            if (current.r.getRoomNumber().equals(roomNumLookUp)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    /**
     * Returns true if this LinkedRoomList's size is 0 (no Rooms = empty); false otherwise.
     *
     * @return (boolean) true if this LinkedRoomList's size is 0 and is empty.
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Returns true if this LinkedRoomList contains a Node that stores a Room whose roomNum
     * matches the roomNum of interest; false otherwise.
     *
     * @param roomNumLookUp (String) the room number of interest
     * @return (boolean) true if there is a Node in this List whose roomNum matches
     */
    public boolean contains( String roomNumLookUp )
    {
        return indexOf( roomNumLookUp ) >= 0;
    }
    
    /**
     * Adds the given Room to the END of this LinkedRoomList.
     *
     * @param r (Room) a room object to add
     */
    public void add( Room r )
    {
        add( size, r );
    }

    /**
     * Adds (Inserts, really) the given Room to the LinkedRoomList at the given index, if 
     * index is valid; shuffles all Rooms to the right of insertion rightward.
     *
     * @param index (int) the index where the added Room should go
     * @param r (Room) the Room object to add to the list
     */
    public void add( int index, Room r )
    {
        if (index < 0 || index > size) 
        {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        
        // get a reference to the node before index of interest
        ListRoomNode current = nodeAt(index - 1);
        
        // create a new ListNode using the constructor of the format:
        // new ListRoomNode( Room r, ListRoomNode next, ListRoomNode prev)
        ListRoomNode newNode = new ListRoomNode(r, current.next, current);
        
        // make sure all pointers point appropriately
        current.next = newNode;
        newNode.next.prev = newNode;
        
        size++;
    }

    /**
     * Adds all the Room objects from any 'list of Rooms' to the end of THIS LinkedRoomList.
     *
     * @param other (List<Room>) a list of Room objects
     */
    public void addAll(List<Room> other)
    {
        for ( Room r: other ) 
        {
            add( r );
        }
    }

    /**
     * Removes the ListRoomNode at the given index; moves all Nodes that were behind it to
     * the left.
     *
     * @param index (int) the index in the list where the ListRoomNode should be 'removed'
     */
    public void remove( int index )
    {
        // throw IndexOutOfBoundsException if the index is invalid for this list.
        checkIndex( index );
        
        // get a reference to the node in front of index of interest
        ListRoomNode current = nodeAt( index - 1 );
        
        // 'remove' the node at the index of interest by changing the prev/next links
        current.next = current.next.next;
        current.next.prev = current;
        
        size--;
    }

    /**
     * Set/replace the Room at the given list index's ListRoomNode with given Room.
     *
     * @param index (int) the index in the list where the ListRoomNode should be 'replaced'
     * @param r (Room) the room object that will replace the existing Room
     */
    public void set( int index, Room r )
    {
        // throw IndexOutOfBoundsException if the index is invalid for this list.
        checkIndex(index);
        
        // directly access the node at the given index
        ListRoomNode current = nodeAt(index);
        
        // change the Room reference/replace with the new Room r
        current.r = r;
    }

    /**
     * Clears this LinkedRoomList; sets size to zero; List is considered 'empty' afterwards.
     */
    public void clear()
    {
        front.next = back;
        back.prev = front;
        size = 0;
    }

    /**
     * Returns an iterator for this instance of LinkedRoomList.
     *
     * @return (Iterator) for ListRoomNodes
     */
    @Override
    public Iterator<ListRoomNode> iterator()
    {
        return new ListRoomNodeIterator();
    }

    /**
     * Returns the ListRoomNode at the specified index, if index is valid. Because the list 
     * is doubly-linked, it is possible to shorten search time by starting from the front 
     * or starting from the back of this LinkedRoomList.
     *
     * @param index (int) the index of interest
     * @return (ListRoomNode) Node to return
     */
    private ListRoomNode nodeAt( int index )
    {
        ListRoomNode current;
    
        // if index of interest is BEFORE the midpoint
        if (index < size / 2) 
        {
            // start at the front of the list
            current = front;
            
            for (int i = 0; i < index + 1; i++) 
            {
                current = current.next;
            }
        }
        // if index of interest is AFTER the midpoint
        else
        {
            // start at the back of the list
            current = back;
        
            for (int i = size; i >= index + 1; i--) 
            {
                current = current.prev;
            }
        }
        
        // if you didnt enter the if/else statement above, the index of interest was
        // the midpoint AND you can just return the node at the midpoint!
        return current;
    }

    /**
     * Checks if the index of interest is valid (0 <= index < list's size).
     *
     * @param index (int) an index of interest
     * @throws IndexOutOfBoundsException if the index is not valid
     */
    private void checkIndex( int index )
    {
        if ( index < 0 || index >= size() )
        {
            throw new IndexOutOfBoundsException("invalid index: " + index);
        }
    }

    /**
     * A private sub-class of LinkedRoomList to iterate over the ListRoomNodes in this list.
     * This is only for a forward-moving iterator. (even though we have nodes pointing to 
     * previous and next nodes).
     */
    private class ListRoomNodeIterator implements Iterator<ListRoomNode>
    {
        private ListRoomNode current;   // location of next ListRoomNode to return
        private boolean removeOK;       // whether it's okay to remove a Node now

        /**
         * Constructs an iterator for this LinkedRoomList.
         */
        public ListRoomNodeIterator()
        {
            current = front.next;
            removeOK = false;
        }

        /**
         * Returns true if there are more ListRoomNode elements left, false otherwise.
         *
         * @return (boolean) true if there are still ListRoomNodes to assess.
         */
        public boolean hasNext()
        {
            return current != back;
        }

        /**
         * Returns the next ListRoomNode in the iteration if there is one; OTHERWISE it 
         * will throw an exception.
         *
         * @return (ListRoomNode) if there is one
         * @throws NoSuchElementException if there is no next ListRoomNode
         */
        public ListRoomNode next()
        {
            // if no more ListRoomNodes to evaluate and trying to access the next Node,
            if ( !hasNext() )
            {
                throw new NoSuchElementException();
            }
            
            ListRoomNode result = current;
            
            current = current.next;     // advance to the next ListRoomNode
            removeOK = true;            // determine it safe to remove a Node
            return result;
        }

        /**
         * Removes the most recent ListRoomNode returned by the iterator; it is considered 
         * 'safe' to remove a ListRoomNode when next() has been called without a call on 
         * remove().
         * 
         * @throws IllegalStateException if it is not safe to remove that ListRoomNode.
         */
        public void remove()
        {
            if ( !removeOK )
            {
                throw new IllegalStateException("Ack, you can't safely remove that node!");
            }
            
            ListRoomNode prev2 = current.prev.prev;
            prev2.next = current;
            current.prev = prev2;
            
            size--;
            removeOK = false;
        }
    }
}
