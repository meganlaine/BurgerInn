/**
 * Class GuestTreeNode stores single nodes of a GuestTree; this node class is for trees of 
 * Guest instances; it contains a Guest object, and a reference to a left child node and a 
 * right child node.
 * 
 * @author Megan Laine
 * @version 4 Mar 2019 CSC 143 
 */
public class GuestTreeNode
{
    public Guest g;  
    public GuestTreeNode left;
    public GuestTreeNode right;

    /**
     * GuestTreeNode Constructor 1/1 takes a Guest object as a parameter and returns a tree node
     * where the node is considered the tip of a branch (a 'leaf').
     *
     * @param g (Guest) the guest to add to the GuestTree
     */
    public GuestTreeNode( Guest g )
    {
        this( g, null, null );
    }

    // post: constructs a node with the given data and links
    /**
     * GuestTreeNode Constructor 2/2 takes a Guest object, a reference to two other nodes; 
     * it returns a tree node that has added the two other nodes as children of the returned 
     * node.
     *
     * @param g (Guest) a guest to add to the GuestTree
     * @param left (GuestTreeNode) node to add as the returned node's left-child-node
     * @param right (GuestTreeNode) node to add as the returned node's right-child-node
     */
    public GuestTreeNode( Guest g, GuestTreeNode left, GuestTreeNode right )
    {
        this.g = g;
        this.left = left;
        this.right = right;
    }
}
