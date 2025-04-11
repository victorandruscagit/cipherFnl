package mo.com.jaru.criptografie.caesar;

import java.util.*;

public class CaesarAlphabet {
    private static final Character[] EN_ALPHABET =
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    private static final Character[] SYMBOL_ALPHABET =
            {'1', '2', '3', '5', '*', '#', '('};

    private final List<Character> alphabet;
    private final Map<Character, Integer> charIndexes;


    public CaesarAlphabet() {
        List<Character> temporaryAlphabet = new ArrayList<>();
        temporaryAlphabet.addAll(Arrays.asList(EN_ALPHABET));
        temporaryAlphabet.addAll(Arrays.asList(SYMBOL_ALPHABET));

        alphabet = List.copyOf(temporaryAlphabet);
        charIndexes = new HashMap<>();
        for (int i = 0; i < alphabet.size(); i++) {
            charIndexes.put(alphabet.get(i), i);

        }
    }
}
