public class DictionaryController {
    private final Dictionary dictionary;

    public DictionaryController() {
        dictionary = new Dictionary();

        dictionary.addWord("Java", "A high-level programming language.");
        dictionary.addWord("Python", "A versatile programming language.");
        dictionary.addWord("Dictionary", "A collection of words and their meanings.");
    }

    public String searchWord(String word) {
        if (word == null || word.trim().isEmpty()) {
            return "Please enter a valid word.";
        }
        String meaning = dictionary.searchWord(word);
        return (meaning != null) ? meaning : "Word not found in the dictionary.";
    }
}