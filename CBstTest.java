import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for CBst
 * 
 * @author Christian Clarke
 * @version 20170316
 *
 */
public class CBstTest {

    /**
     * Tests if PreOrder returns the string representation of the tree
     */
    @Test
    public void doesPreOrderReturnTheCorrectStringRep() {
        CBst tree = new CBst();
        tree.simpleBst();
        String expected = "zvay";
        String actual = tree.preorder();
        assertEquals("Didn't output correct preorder", expected, actual);
    }

    /**
     * Tests if Insert inserts a Character in the correct order
     */
    @Test
    public void doesInsertProperlyInsertChar() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('c');
        tree.insert('z');
        tree.insert('a');
        String actual = tree.preorder();
        assertEquals("Didn't insert correctly", "hcaz", actual);
    }

    /**
     * Tests if Insert inserts a Character in the correct order
     */
    @Test
    public void doesInsertProperlyInsertChar2() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('c');
        tree.insert('w');
        tree.insert('x');
        tree.insert('b');
        tree.insert('a');
        String actual = tree.preorder();
        assertEquals("Didn't insert correctly", "hcbawx", actual);
    }

    /**
     * Tests if Insert inserts a Character in the correct order
     */
    @Test
    public void doesInsertProperlyInsertChar3() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('d');
        tree.insert('e');
        tree.insert('c');

        String actual = tree.preorder();
        assertEquals("Didn't insert correctly", "hdce", actual);
    }

    /**
     * Tests if find, finds the given Character in the tree
     */
    @Test
    public void doesFindReturnTrue() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('c');
        tree.insert('w');
        tree.insert('x');
        tree.insert('b');
        assertTrue(tree.find('b'));
    }

    /**
     * Tests if find, returns false if the character is not in the tree
     */
    @Test
    public void doesFindReturnFalse() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('c');
        tree.insert('w');
        tree.insert('x');
        tree.insert('b');
        assertFalse(tree.find('y'));
    }

    /**
     * Tests if remove, deleted the node correctly
     */
    @Test
    public void doesRemoveDeleteNodeCorrectly() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('d');
        tree.insert('z');
        tree.insert('f');
        tree.insert('g');
        tree.insert('c');
        tree.insert('e');
        tree.remove('d');
        String actual = tree.preorder();
        assertEquals("Didn't remove correctly", "hcfegz", actual);
    }

    /**
     * Tests if remove, deleted the node correctly
     */
    @Test
    public void doesRemoveDeleteNodeCorrectly2() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('d');
        tree.insert('z');
        tree.insert('f');
        tree.insert('g');
        tree.insert('c');
        tree.insert('e');
        tree.remove('z');
        String actual = tree.preorder();
        assertEquals("Didn't remove correctly", "hdcfeg", actual);
    }

    /**
     * Tests if remove, deleted the node correctly
     */
    @Test
    public void doesRemoveDeleteNodeCorrectly3() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('d');
        tree.insert('d');
        tree.insert('z');
        tree.insert('f');
        tree.insert('g');
        tree.insert('e');
        tree.remove('d');
        String actual = tree.preorder();
        assertEquals("Didn't remove correctly", "hfegz", actual);
    }

    /**
     * Tests if remove, deleted the node correctly
     */
    @Test
    public void doesRemoveDeleteNodeCorrectly4() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('d');
        tree.insert('z');
        tree.insert('f');
        tree.insert('g');
        tree.insert('e');
        tree.insert('c');
        tree.insert('a');
        tree.remove('d');
        String actual = tree.preorder();
        assertEquals("Didn't remove correctly", "hcafegz", actual);
    }

    /**
     * Tests if remove, deleted the node correctly
     */
    @Test
    public void doesRemoveDeleteNodeCorrectly5() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('d');
        tree.insert('z');
        tree.insert('f');
        tree.insert('g');
        tree.insert('e');
        tree.insert('b');
        tree.insert('c');
        tree.insert('a');
        tree.remove('d');
        String actual = tree.preorder();
        assertEquals("Didn't remove correctly", "hcbafegz", actual);
    }
    
    /**
     * Tests if remove, deleted the node correctly
     */
    @Test
    public void doesRemoveDeleteNodeCorrectly6() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('d');
        tree.insert('c');
        tree.insert('a');
        tree.remove('c');
        String actual = tree.preorder();
        assertEquals("Didn't remove correctly", "hda", actual);
    }

    /**
     * Tests if remove, doesn't delete if the root is null
     */
    @Test
    public void doesRemoveNotDelete() {
        CBst tree = new CBst();
        tree.remove('c');
        String actual = tree.preorder();
        assertEquals("Didn't remove correctly", "", actual);
    }

    /**
     * Tests if height returns the correct depth of the tree
     */
    @Test
    public void doesHeightReturnCorrectDepth() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('d');
        tree.insert('z');
        tree.insert('f');
        tree.insert('g');
        tree.insert('c');
        tree.insert('e');
        int actual = tree.height();
        assertEquals("Didn't calculate the proper depth", 4, actual);
    }

    /**
     * Tests if isBalanced returns true if the tree is properly balanced
     */
    @Test
    public void doesIsBalancedReturnTrueIfBalanced() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('d');
        tree.insert('z');
        tree.insert('f');
        boolean actual = tree.isBalanced();
        assertTrue(actual);
    }

    /**
     * Tests if isBalanced returns true if the tree is properly balanced
     */
    @Test
    public void doesIsBalancedReturnTrueIfUnbalanced2() {
        CBst tree = new CBst();
        tree.insert('h');
        boolean actual = tree.isBalanced();
        assertTrue(actual);
    }

    /**
     * Tests if isBalanced returns true if the tree is properly balanced
     */
    @Test
    public void doesIsBalancedReturnTrueIfUnbalanced3() {
        CBst tree = new CBst();
        boolean actual = tree.isBalanced();
        assertTrue(actual);
    }

    /**
     * Tests if isBalanced returns false if the tree is unbalanced
     */
    @Test
    public void doesIsBalancedReturnFalseIfUnbalanced() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('d');
        tree.insert('z');
        tree.insert('f');
        tree.insert('g');
        tree.insert('c');
        tree.insert('e');
        boolean actual = tree.isBalanced();
        assertFalse(actual);
    }
    
    /**
     * Tests if isBalanced returns false if the tree is unbalanced
     */
    @Test
    public void doesIsBalancedReturnFalseIfUnbalanced2() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('d');
        tree.insert('u');
        tree.insert('w');
        tree.insert('x');
        tree.insert('y');
        tree.insert('z');
        tree.insert('f');
        tree.insert('g');
        tree.insert('c');
        tree.insert('e');
        boolean actual = tree.isBalanced();
        assertFalse(actual);
    }

    /**
     * Tests if position returns the correct Position of the Character
     */
    @Test
    public void doesPositionReturnCorrectPosition() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('d');
        tree.insert('z');
        tree.insert('f');
        tree.insert('g');
        tree.insert('c');
        tree.insert('e');
        int actual = tree.position('e');
        assertEquals("Didn't return correct position", 9, actual);
    }

    /**
     * Tests if position returns the correct Position of the Character
     */
    @Test
    public void doesPositionReturnCorrectPosition2() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('d');
        tree.insert('z');
        tree.insert('f');
        tree.insert('g');
        tree.insert('c');
        tree.insert('e');
        int actual = tree.position('c');
        assertEquals("Didn't return correct position", 3, actual);
    }

    /**
     * Tests if position returns the correct position of a charcter in the tree
     */
    @Test
    public void doesPositionReturnCorrectPosition3() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('d');
        tree.insert('b');
        tree.insert('f');
        tree.insert('l');
        tree.insert('j');
        tree.insert('n');
        int position = tree.position('f');
        assertEquals("Didn't get correct position", 4, position);
    }

    /**
     * Tests if position returns -1 if the character is not in the tree
     */
    @Test
    public void doesPositionReturnCorrectPositionIfNotInTree() {
        CBst tree = new CBst();
        tree.insert('h');
        tree.insert('d');
        tree.insert('z');
        tree.insert('f');
        tree.insert('g');
        tree.insert('c');
        tree.insert('e');
        int actual = tree.position('y');
        assertEquals("Didn't return -1", -1, actual);
    }
}
