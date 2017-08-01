/**
 * Node class for CBst
 * 
 * @author Christian Clarke
 * @version 20170316
 *
 */
public class Node {

    private Character val;
    private Node left;
    private Node right;

    /**
     * Constructor with Character value
     * 
     * @param value
     *            Element of node
     */
    public Node(Character value) {
        val = value;
        right = null;
        left = null;
    }

    /**
     * Constructor that sets the children and element
     * 
     * @param value
     *            element of node
     * @param leftNode
     *            left child
     * @param rightNode
     *            right child
     */
    public Node(Character value, Node leftNode, Node rightNode) {
        val = value;
        left = leftNode;
        right = rightNode;
    }

    /**
     * Returns the Character element of the node
     * 
     * @return the element of the node
     */
    public Character element() {
        return val;
    }

    /**
     * Returns the right Node
     * 
     * @return right node
     */
    public Node rightNode() {
        return right;
    }

    /**
     * Returns the left node
     * 
     * @return left node
     */
    public Node leftNode() {
        return left;
    }

    /**
     * Sets the element of Node
     * 
     * @param c
     *            the Character to become the new element
     */
    public void setElement(Character c) {
        val = c;
    }

    /**
     * Sets the left node
     * 
     * @param n
     *            the node to be set
     */
    public void setLeft(Node n) {
        left = n;
    }

    /**
     * Sets the right node
     * 
     * @param n
     *            the node to be set
     */
    public void setRight(Node n) {
        right = n;
    }
}
