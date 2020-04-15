package concept;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConceptTest {

    @Test
    void binarySearchTree() {
        BinarySearchTree bst = new BinarySearchTree();

        int[] keys = {5, 3, 4, 1, 2};
        for (int key : keys)
            bst.insert(key);

        assertEquals("1,2,3,4,5", bst.inorder());
        assertEquals(true, bst.contains(1));
        assertEquals(false, bst.contains(10));
        assertEquals(1, bst.min());
        assertEquals(5, bst.max());
        assertEquals(4, bst.successor(3));
        assertEquals(3, bst.predecessor(4));
    }
}