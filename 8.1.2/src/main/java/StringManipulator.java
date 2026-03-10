
public class StringManipulator {

    /**
     * Concatenates two input strings and returns the result.
     * @param str1 The first string.
     * @param str2 The second string.
     * @return The concatenated string.
     */
    public String concatenate(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null; // Or throw an exception, depending on desired behavior
        }
        return str1 + str2;
    }

    /**
     * Returns the length of the input string.
     * @param str The input string.
     * @return The length of the string.
     */
    public int findLength(String str) {
        if (str == null) {
            return 0; // Or throw an exception
        }
        return str.length();
    }

    /**
     * Converts the input string to uppercase and returns the result.
     * @param str The input string.
     * @return The uppercase string.
     */
    public String convertToUpperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    /**
     * Converts the input string to lowercase and returns the result.
     * @param str The input string.
     * @return The lowercase string.
     */
    public String convertToLowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    /**
     * Checks if the input string contains the given substring.
     * @param str The main string.
     * @param subStr The substring to search for.
     * @return True if the substring is found, otherwise false.
     */
    public boolean containsSubstring(String str, String subStr) {
        if (str == null || subStr == null) {
            return false;
        }
        return str.contains(subStr);
    }
}