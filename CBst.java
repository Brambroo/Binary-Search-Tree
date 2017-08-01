/**
 * Implementaion class for CBstADT
 * 
 * @author Christian Clarke
 * @version 20170316
 */
public class CBst implements CBstADT {

    private Node root;
    private String preOrder = "";
    private int position;
    private boolean gotPosition;

    /**
     * Default constructor
     */
    public CBst() {
        root = null;
    }

    /**
     * Simple Bst for help with preorder method
     */
    protected void simpleBst() {
        root = new Node('z', new Node('v'), new Node('y'));
        root.leftNode().setLeft(new Node('a'));

    }

    /*
     * (non-Javadoc)
     * 
     * @see CBstADT#find(java.lang.Character)
     */
    @Override
    public Boolean find(Character c) {
        Node n = findHelper(root, c);
        return n != null;
    }

    /**
     * Recursive helper method for find
     * 
     * @param n
     *            Root node of the current tree
     * @param c
     *            Character that is being looked for
     * @return null Node if the Character is not in the tree, or the Node
     *         containing the Character
     */
    private Node findHelper(Node n, Character c) {
        if (n == null) {
            return n;
        }
        if (n.element() != c) {
            if (n.element().compareTo(c) > 0) {
                return findHelper(n.leftNode(), c);
            }
            else {
                return findHelper(n.rightNode(), c);
            }
        }
        return n;

    }

    /*
     * (non-Javadoc)
     * 
     * @see CBstADT#height()
     */
    @Override
    public Integer height() {
        return heightHelper(root);
    }

    /**
     * Recursive helper method for height
     * 
     * @param n
     *            the root of the current tree
     * @return the height of the tree
     */
    private Integer heightHelper(Node n) {
        if (n == null) {
            return 0;
        }
        int leftSide = heightHelper(n.leftNode());
        int rightSide = heightHelper(n.rightNode());

        if (leftSide > rightSide) {
            return leftSide + 1;
        }
        else {
            return rightSide + 1;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see CBstADT#insert(java.lang.Character)
     */
    @Override
    public void insert(Character c) {
        if (!find(c)) {
            root = insertHelper(root, c);
        }

    }

    /**
     * Recursive helper method for insert
     * 
     * @param n
     *            root of the current tree
     * @param c
     *            Character that is being inserted
     * @return the main root of the tree, to be assigned to the root field
     */
    private Node insertHelper(Node n, Character c) {
        if (n == null) {
            return new Node(c);
        }
        if (n.element().compareTo(c) > 0) {
            n.setLeft(insertHelper(n.leftNode(), c));
        }
        else {
            n.setRight(insertHelper(n.rightNode(), c));
        }
        return n;
    }

    /*
     * (non-Javadoc)
     * 
     * @see CBstADT#isBalanced()
     */
    @Override
    public Boolean isBalanced() {
        return isBalancedHelper(root);
    }

    /**
     * Recursive helper method for isBalanced that determines whether or not the
     * tree is balanced
     * 
     * @param n
     *            the root of the current tree
     * @return whether or not the tree is balanced
     */
    private boolean isBalancedHelper(Node n) {
        if (root == null || height() == 1) {
            return true;
        }
        if (n == null) {
            return true;
        }
        int treeDifference = (heightHelper(n.leftNode()) < 0)
                ? -heightHelper(n.leftNode()) : heightHelper(n.rightNode());

        if (treeDifference > 1) {
            return false;
        }
        else {
            return isBalancedHelper(n.leftNode())
                    && isBalancedHelper(n.rightNode());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see CBstADT#position(java.lang.Character)
     */
    @Override
    public Integer position(Character c) {
        if (!find(c)) {
            return -1;
        }

        return positionHelper(root, c, 0);
    }

    /**
     * Helper method that uses recursion to find the position of the node
     * 
     * @param n
     *            the root of the tree
     * @param c
     *            the character that is being looked for
     * @param pos
     *            the position of the current node
     */
    private Integer positionHelper(Node n, Character c, int pos) {
        /*
         * boolean found = recursivePosition(n, c, level, 1); if (found) {
         * return; } positionHelper(n, c, height, level + 1);
         */
        if (n == null) {
            return parentPos(pos);
        }
        if (n.element() == c) {
            gotPosition = true;
            position = pos;
            return pos;
        }
        pos = positionHelper(n.leftNode(), c, leftPos(pos));
        pos = positionHelper(n.rightNode(), c, rightPos(pos));
        if (gotPosition) {
            return this.position;
        }
        return parentPos(pos);
    }

    /**
     * Helper method that calculates the position of the left child node
     * 
     * @param pos
     *            the current position
     * @return the position of the left child
     */
    private int leftPos(int pos) {
        return 2 * pos + 1;
    }

    /**
     * Helper method that calculates the position of the parent node
     * 
     * @param pos
     *            the current position
     * @return the position of the parent node
     */
    private int parentPos(int pos) {
        return (pos - 1) / 2;
    }

    /**
     * Helper method that calculates the position of the right node
     * 
     * @param pos
     *            the position of the current node
     * @return the position of the right child node
     */
    private Integer rightPos(int pos) {

        return 2 * pos + 2;
    }

    /*
     * (non-Javadoc)
     * 
     * @see CBstADT#preorder()
     */
    @Override
    public String preorder() {
        preorderHelper(root);
        return preOrder;
    }

    /**
     * Recursive helper method for preorder
     * 
     * @param n
     *            the root of the current tree
     */
    private void preorderHelper(Node n) {
        if (n == null) {
            return;
        }
        preOrder += n.element();
        preorderHelper(n.leftNode());
        preorderHelper(n.rightNode());

    }

    /*
     * (non-Javadoc)
     * 
     * @see CBstADT#remove(java.lang.Character)
     */
    @Override
    public void remove(Character c) {
        removeHelper(root, c);
    }

    /**
     * Recursive helper method for remove
     * 
     * @param n
     *            the root of the current tree
     * @param c
     *            the Character being removed
     * @return the main node of the tree
     */
    private Node removeHelper(Node n, Character c) {
        if (n == null) {
            return null;
        }
        if (n.element().compareTo(c) > 0) {
            n.setLeft(removeHelper(n.leftNode(), c));
        }
        else if (n.element().compareTo(c) < 0) {
            n.setRight(removeHelper(n.rightNode(), c));
        }
        else if (n.element().compareTo(c) == 0) {
            if (n.leftNode() == null) {
                return n.rightNode();
            }
            else if (n.rightNode() == null) {
                return n.leftNode();
            }
            else {
                Node point = getMaxHelper(n.leftNode());
                n.setElement(point.element());
                n.setLeft(removeMax(n.leftNode()));
            }
        }
        return n;
    }

    /**
     * Recursive helper method for removerHelper, that finds the max value in
     * the tree
     * 
     * @param n
     *            the root of the current tree
     * @return the node with the max value in the tree
     */
    private Node getMaxHelper(Node n) {
        if (n.rightNode() == null) {
            return n;
        }
        return getMaxHelper(n.rightNode());
    }

    /**
     * Recursive helper method for removerHelper, that removes the max value in
     * the tree
     * 
     * @param n
     *            the root of the current tree
     * @return the main node if the tree after the removal
     */
    private Node removeMax(Node n) {
        if (n.rightNode() == null) {
            return n.leftNode();
        }
        n.setRight(removeMax(n.rightNode()));
        return n;
    }

}
