import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class BSTTest {
    private BST<Integer, String> bst;
    
    @Before
    public void setUp() {
        bst = new BST<>();
    }

    // Test isEmpty() ==============================================
    @Test
    public void testIsEmptyOnCreation() {
        assertTrue("New BST should be empty", bst.isEmpty());
    }

    @Test
    public void testIsEmptyAfterInsert() {
        bst.put(5, "Apple");
        assertFalse("BST with elements shouldn't be empty", bst.isEmpty());
    }

    // Test size() =================================================
    @Test
    public void testSizeOnCreation() {
        assertEquals("Empty BST should have size 0", 0, bst.size());
    }

    @Test
    public void testSizeAfterInsertions() {
        bst.put(10, "A");
        bst.put(5, "B");
        bst.put(15, "C");
        assertEquals("BST with 3 elements should have size 3", 3, bst.size());
    }

    // Test put()/get() ============================================
    @Test
    public void testPutAndGet() {
        bst.put(20, "Mango");
        assertEquals("Should retrieve inserted value", "Mango", bst.get(20));
    }

    @Test
    public void testUpdateValue() {
        bst.put(10, "Original");
        bst.put(10, "Updated");
        assertEquals("Should update existing key", "Updated", bst.get(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutNullKey() {
        bst.put(null, "Invalid");
    }

    // Test contains() =============================================
    @Test
    public void testContainsExistingKey() {
        bst.put(7, "Grape");
        assertTrue("Should find existing key", bst.contains(7));
    }

    @Test
    public void testContainsMissingKey() {
        bst.put(3, "Orange");
        assertFalse("Shouldn't find nonexistent key", bst.contains(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContainsNullKey() {
        bst.contains(null);
    }

    // Test get() edge cases ========================================
    @Test
    public void testGetMissingKey() {
        bst.put(2, "Berry");
        assertNull("Should return null for missing key", bst.get(99));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNullKey() {
        bst.get(null);
    }

    // Test tree structure ==========================================
    @Test
    public void testMultiLevelInsert() {
        bst.put(50, "Root");
        bst.put(30, "Left");
        bst.put(70, "Right");
        bst.put(20, "Left-Left");
        
        assertEquals("Root should be 50", "Root", bst.get(50));
        assertEquals("Left child should be 30", "Left", bst.get(30));
        assertEquals("Rightmost leaf should be 20", "Left-Left", bst.get(20));
        assertEquals("Size should match insertions", 4, bst.size());
    }
}
