package mo.com.jaru.criptografie.caesar;


public class CaesarCipher {

    private final CaesarAlphabet caesarAlphabet;


    public CaesarCipher(CaesarAlphabet caesarAlphabet) {
        this.caesarAlphabet = caesarAlphabet;
    }

    public String encrypt(String originalText, int key) {
        return process(originalText, key);
    }

    public String decrypt(String originalText, int key) {
        return process(originalText, -key);
    }

    private String process(String originalText, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < originalText.length(); i++) {
            Character originalChar = toLowerTheCase(originalText.charAt(i));
            int originalCharIndex = caesarAlphabet.getCharacterIndex(originalChar);
            int newCharIndex =
                    (caesarAlphabet.getSize() + (originalCharIndex + key)) % caesarAlphabet.getSize();
            result.append(caesarAlphabet.getCharByIndex(newCharIndex));
        }
        return result.toString();
    }

    private Character toLowerTheCase(Character character) {
        return (character + "").toLowerCase().charAt(0);

    }

}
