/**
 * Class GuestTree creates a binary tree of Guest objects.
 * 
 * @author Megan Laine
 * @version 7 Mar 2019 CSC 143
 */
public class GuestTree
{
    // root of overall GuestTree
    private GuestTreeNode overallRoot;

    /**
     * GuestTree Constructor (default 1/2) constructs an empty search tree.
     */
    public GuestTree()
    {
        // overallRoot should point to nothing
        overallRoot = null;
    }
    
    /**
     * GuestTree Constructor (2/2) constructs a search tree with the given Guest as overall 
     * root; there will be no child nodes to this new tree with 1 node.
     * 
     * @param g (Guest) the guest to set at the overall Root of the new Guest Tree.
     */
    public GuestTree( Guest g )
    {
        // overallRoot should point to Guest g; no child nodes.
        overallRoot = new GuestTreeNode( g );
    }

    /**
     * (Public method) Adds a Guest to this GuestTree; preserves the binary search tree 
     * functionality of GuestTree.
     *
     * @param g (Guest) the guest to add to the tree.
     */
    public void add( Guest g )
    {
        overallRoot = add( overallRoot, g );
    }

    /**
     * (Private method) Returns a GuestTreeNode with the given Guest object; preserves 
     * binary search tree functionality - relative to the root that the node will be added 
     * to; a recursive method.
     *
     * @param node (GuestTreeNode) a tree node to 'add' a Guest to
     * @param other (Guest) the guest object to 'add' to the root
     * @return root (GuestTreeNode) with modifications
     */
    private GuestTreeNode add( GuestTreeNode node, Guest other )
    {
        // case : node points to nothing
        if (node == null)
        {
            node = new GuestTreeNode(other);
        }
        // if other Guest is alphabetically 'in front of' node's Guest
        else if (node.g.compareTo(other) >= 0) 
        {
            node.left = add(node.left, other);
        } 
        // if other Guest is alphabetically 'after' node's Guest
        else 
        {
            node.right = add(node.right, other);
        }
        
        return node;
    }

    /**
     * (Public method) Returns true if GuestTree contains value, returns false otherwise.
     *
     * @param g (Guest) A Guest to look for
     * @return (boolean) true if the guest is found in the tree; false otherwise
     */
    public boolean contains( Guest g )
    {
        return contains( g, overallRoot );
    }   

    /**
     * (Private method) Returns true if GuestTree contains value, returns false otherwise.
     *
     * @param node (GuestTreeNode) A guest tree node to assess
     * @param other (Guest) A Guest to look for
     * @return (boolean) true if the guest is found in the tree; false otherwise
     */
    private boolean contains( Guest other, GuestTreeNode node )
    {
        // case: if node points to nothing, 'other' is not in that node
        if (node == null)
        {
            return false;
        }
        else
        {
            int compare = other.compareTo( node.g );
            
            // if other is 'found'
            if (compare == 0)
            {
                return true;
            }
            // if other is alphabetically 'in front of' the guest currently in node
            else if (compare < 0) 
            {
                // search the left-side of the tree
                return contains(other, node.left);
            } 
            // if other is alphabetically 'after' the guest currently in node,
            else
            {   
                // search the right-side of the tree
                return contains(other, node.right);
            }
        }
    }

    /**
     * Prints Guest information from the GuestTree using in-order traversal; 
     * outputs to console: one line per Guest.
     */
    public void print()
    {
        // call the private method
        printInorder(overallRoot);
    }

    /**
     * Prints Guest information from the GuestTree using in-order traversal; 
     * outputs to console: one line per Guest.
     * 
     * @param node (GuestTreeNode) the GuestTreeNode to process
     */
    private void printInorder( GuestTreeNode node )
    {
        // if there is data to process...
        if (node != null)
        {
            // recursively call LEFT-node, then CURRENT-NODE, then RIGHT-node
            printInorder( node.left );
            System.out.println( node.g.toString() );
            printInorder( node.right );
        }
    }
    
    /**
     * Returns a String of Guest information from the GuestTree using pre-order traversal.
     */
    @Override
    public String toString()
    {
        return toStringPreorder(overallRoot);
    }

    /**
     * Returns a String of Guest info from the GuestTreeNode using pre-order traversal.
     * 
     * @param node (GuestTreeNode) the GuestTreeNode to process
     */
    private String toStringPreorder( GuestTreeNode node )
    {
        // if there is data to process...
        String result = "";
        if (node != null)
        {   
            // recursively call node, then LEFT-node, then RIGHT-node
            result += "\n" + (node.g.getFirstName() + " " + node.g.getLastName() + " " + 
                        node.g.getPhoneNum() + " " + node.g.isMilitary() + " " + 
                        node.g.isGovernment() + " " + node.g.isMember() + " " + 
                        node.g.getRoomPref());
            // ARGH CHANGE = CHANGE(X)
            result += toStringPreorder( node.left );
            result += toStringPreorder( node.right );
        }

        return result;
    }
    
    /**
     * Finds given Guest within a binary search tree; returns null if Guest is not found; 
     * otherwise returns the GuestTreeNode (Client will have to access Guest 
     * within the node returned to access or change data).
     * 
     * @param g (Guest) the guest of interest.
     * @return (GuestTreeNode) if found, or null if guest is not found.
     */
    public GuestTreeNode find( Guest g )
    {
        return find( g, overallRoot );
    }
    
    /**
     * Finds given Guest within a GuestTreeNode; returns null if Guest is not found; 
     * otherwise returns the GuestTreeNode (Client will have to access Guest 
     * within the node returned to access or change data). 
     * 
     * @param g (Guest) the guest to look for.
     * @param node (GuestTreeNode) the node to evaluate.
     * @return result (GuestTreeNode) containing the matched item; or null if not found.
     */
    private GuestTreeNode find( Guest g, GuestTreeNode node )
    {
        // if the node in question points to nothing, then the Guest was not found
        if (node == null)
        {
            return null;
        }
        
        // compare the Guest we're searching for with the node's Guest
        if (g.compareTo(node.g) < 0)
        {
            // look in the left node if the Guest we're searching for is alphabetically 
            // 'less than'/in front of Node's guest.
            return find( g, node.left );
        }
        else if (g.compareTo(node.g) > 0)
        {
            // look in the right node if the Guest we're searching for is alphabetically 
            // 'more than'/after Node's guest.
            return find( g, node.right );
        }
        else // in this case, g.compareTo(node.g) == 0; GUEST IS FOUND IN CURRENT NODE!
        {
            return node;
        }
    }
    
    /**
     * Removes a GuestTreeNode based on the Guest parameter; if the guest is not found in 
     * the tree, nothing is done.
     * 
     * @param g (Guest) the guest to find; remove the relevant node.
     */
    public void remove( Guest g )
    {
        overallRoot = remove( g, overallRoot );
    }
    
    /**
     * Private method to remove GuestTreeNodes from a GuestTree based on parameter GUEST; if
     * the Guest is not found in the tree, returns a pointer to null;
     * 
     * @param g (Guest) the guest to remove.
     * @param node (GuestTreeNode) the node to check.
     * @return the new node.
     */
    private GuestTreeNode remove( Guest g, GuestTreeNode node )
    {
        // if node is null, Guest was not found.
        if ( node == null )
        {
            // Do nothing/return a pointer to null.
            return node;
        }
        
        // if Guest in question is alphabetically before the node's Guest
        if ( g.compareTo( node.g ) < 0 )
        {
            // check this node's left node
            node.left = remove( g, node.left );
        }
        // if Guest in question is alphabetically after the node's Guest
        else if ( g.compareTo( node.g ) > 0 )
        {
            // check this node's right node
            node.right = remove( g, node.right );
        }
        // if Guest in question is considered 'equal to' this node's Guest...
        // AND if this node has children nodes on both left/right sides...
        else if ( node.left != null && node.right != null )
        {
            // REPLACE the Guest object that we want to 'remove' with the alphabetically 
            // 'smallest' Guest from the right-side branch of this node
            node.g = findMin( node.right ).g;
            
            // remove the 'original' version of the 'smallest' Guest from the right-side
            // branch of this node
            node.right = remove( node.g, node.right );
        }
        // if Guest in question is considered equal to this node's Guest...
        // AND if this node has only one child node
        else
        {
            // if the child node is on the left
            if (node.left != null)
            {
                // 'remove' Guest in question by 'reattaching' 
                // the tree to one node further down
                node = node.left;
            }
            // if the child node is on the right
            else
            {
                // 'remove' Guest in question by 'reattaching'
                // the tree to one node further down
                node = node.right;
            }
        }
        
        // if guest in question is considered 'equal to' this node's Guest...
        // AND this node has NO children nodes on either side...
        return node;
    }
    
    /**
     * Private method to find the 'smallest' Guest in a subtree. 'Small' is equivalent to
     * being lexicographically earlier in the alphabet. (For ex: a comes before z; 
     * a's 'smaller').
     * 
     * @param node (GuestTreeNode) the node to evaluate
     * @return GuestTreeNode containing the 'smallest' Guest.
     */
    private GuestTreeNode findMin( GuestTreeNode node )
    {
        // if there is no guest data in the node
        if (node == null)
        {
            return null;
        }
        // if there are no alphabetically 'smaller' guests to look for...stop looking
        else if (node.left == null)
        {
            // you've found the 'min' node
            return node;
        }
        
        // look on the left side if there are still nodes to evaluate
        return findMin(node.left);
    }
}
