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

    public Character getCharByIndex(int index) {
        if (index < 0 || index > alphabet.size()) {
            throw new CaesarAlhpabetException("Invalid index.Index : " + index +
                    " is valid from 0 to " + alphabet.size());
        }
        return alphabet.get(index);
    }

    public int getCharacterIndex(Character character) {
        if (!charIndexes.containsKey(character)) {
            throw new CaesarAlhpabetException("Invalid character.Char : " + character + ".");
        }
        return charIndexes.get(character);

    }

    public int getSize() {
        return alphabet.size();
    }
}
