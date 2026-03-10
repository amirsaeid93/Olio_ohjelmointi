import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTest {

    private StringManipulator manipulator;

    @BeforeEach
    void setUp() {
        manipulator = new StringManipulator();
    }

    @Test
    void testConcatenate() {
        assertEquals("HelloWorld", manipulator.concatenate("Hello", "World"));
        assertEquals("JavaTest", manipulator.concatenate("Java", "Test"));
        assertEquals("Empty", manipulator.concatenate("Empty", ""));
        assertNull(manipulator.concatenate(null, "test"));
    }

    @Test
    void testFindLength() {
        assertEquals(5, manipulator.findLength("Hello"));
        assertEquals(0, manipulator.findLength(""));
        assertEquals(0, manipulator.findLength(null));
    }

    @Test
    void testConvertToUpperCase() {
        assertEquals("HELLO", manipulator.convertToUpperCase("hello"));
        assertEquals("WORLD", manipulator.convertToUpperCase("World"));
        assertEquals("", manipulator.convertToUpperCase(""));
        assertNull(manipulator.convertToUpperCase(null));
    }

    @Test
    void testConvertToLowerCase() {
        assertEquals("hello", manipulator.convertToLowerCase("HELLO"));
        assertEquals("world", manipulator.convertToLowerCase("World"));
        assertEquals("", manipulator.convertToLowerCase(""));
        assertNull(manipulator.convertToLowerCase(null));
    }

    @Test
    void testContainsSubstring() {
        assertTrue(manipulator.containsSubstring("Hello World", "World"));
        assertFalse(manipulator.containsSubstring("Hello World", "Java"));
        assertTrue(manipulator.containsSubstring("Test", "")); // Every string contains an empty string
        assertFalse(manipulator.containsSubstring("Test", null));
        assertFalse(manipulator.containsSubstring(null, "Test"));
    }
}