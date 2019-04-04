/**
 * Class ListRoomNode stores single nodes of a LinkedRoomList.
 * This node class is for a doubly linked list of Room instances.
 * 
 * @author Megan Laine
 * @version 4 Mar 2019 CSC 143
 */
public class ListRoomNode
{
    public Room r;              // Room object stored in this node
    public ListRoomNode next;   // link to next node in the list
    public ListRoomNode prev;   // link to previous node in the list

    /**
     * ListRoomNode Constructor (default 1/3) constructs a ListRoomNode with Room r,
     * next, and prev all pointing to nothing.
     */
    public ListRoomNode()
    {
        this( null, null, null );
    }

    /**
     * ListRoomNode Constructor (2/3) constructs a ListRoomNode with the given Room; next 
     * and prev point to nothing.
     *
     * @param r (Room) a Room object to store in the ListRoomNode
     */
    public ListRoomNode( Room r )
    {
        this(r, null, null);
    }
    
    /**
     * ListRoomNode Constructor (3/3) construts a ListRoomNode with the given Room AND the
     * given PREVIOUS and NEXT nodes.
     *
     * @param r (Room) a Room object to store in the ListRoomNode
     * @param next (ListRoomNode) a ListRoomNode
     * @param prev (ListRoomNode) a ListRoomNode
     */
    public ListRoomNode( Room r, ListRoomNode next, ListRoomNode prev )
    {
        this.r = r;
        this.next = next;
        this.prev = prev;
    }
}
