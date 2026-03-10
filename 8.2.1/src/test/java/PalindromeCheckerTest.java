import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeCheckerTest {

    @Test
    public void testIsPalindrome() {
        PalindromeChecker checker = new PalindromeChecker();

        // Basic palindromes
        assertTrue(checker.isPalindrome("radar"));
        assertTrue(checker.isPalindrome("level"));

        // Palindromes with different casing
        assertTrue(checker.isPalindrome("Madam"));

        // Palindromes with spaces and punctuation
        assertTrue(checker.isPalindrome("A man, a plan, a canal, Panama"));
        assertTrue(checker.isPalindrome("No 'x' in 'Nixon'"));

        // Non-palindromes
        assertFalse(checker.isPalindrome("hello"));
        assertFalse(checker.isPalindrome("openai"));
        assertFalse(checker.isPalindrome("not a palindrome"));

        // Edge cases
        assertTrue(checker.isPalindrome("")); // An empty string is often considered a palindrome
        assertTrue(checker.isPalindrome("a")); // A single character is a palindrome
        assertFalse(checker.isPalindrome(null)); // Null should not be a palindrome
    }
}