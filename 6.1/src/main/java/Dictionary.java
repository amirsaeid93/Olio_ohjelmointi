import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private final Map<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    public void addWord(String word, String meaning) {
        dictionary.put(word.toLowerCase(), meaning);
    }

    public String searchWord(String word) {
        return dictionary.getOrDefault(word.toLowerCase(), null);
    }
}