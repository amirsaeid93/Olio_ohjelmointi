
public class PalindromeChecker {

    /**
     * Checks if the given string is a palindrome or not.
     * A palindrome reads the same forward and backward, ignoring spaces,
     * punctuations, and capitalization.
     *
     * @param str The string to check.
     * @return true if the string is a palindrome, false otherwise.
     */
    public boolean isPalindrome(String str) {
        // Handle null input
        if (str == null) {
            return false;
        }

        // 1. Sanitizes the string: removes non-alphanumeric characters and converts
        // all the letters to a lower case letter.
        // The regex [^a-zA-Z0-9] matches any character that is NOT a letter or a digit.
        String sanitized = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 2. Reverses the sanitized string.
        String reversed = new StringBuilder(sanitized).reverse().toString();

        // 3. Compares the sanitized string with its reversed version.
        return sanitized.equals(reversed);
    }
}