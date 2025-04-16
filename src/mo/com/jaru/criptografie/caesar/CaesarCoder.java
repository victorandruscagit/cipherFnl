package mo.com.jaru.criptografie.caesar;

import mo.com.jaru.criptografie.file.FileNameValidator;
import mo.com.jaru.criptografie.file.FileProcessor;

import java.util.List;

public class CaesarCoder {

    private FileNameValidator validator;
    private FileProcessor fileProcessor;
    private CaesarCipher caesarCipher;

    public CaesarCoder() {

    }

    public CaesarCoder(FileNameValidator fileNameValidator,
                       FileProcessor fileProcessor,
                       CaesarCipher caesarCipher) {
        this.caesarCipher = new CaesarCipher( new CaesarAlphabet());
        this.validator = new FileNameValidator();
        this.fileProcessor = new FileProcessor();
    }

    public void encrypt(String inputFile, String outputFile, int key) {
        validator.validateForReading(inputFile);
        validator.validateForWriting(outputFile);

        List<String> sourceLines = fileProcessor.readFile(inputFile);
        for (String sourceLine : sourceLines) {
            String encryptedLine = caesarCipher.encrypt(sourceLine, key);
            fileProcessor.writeAndAppendToFile(outputFile, encryptedLine);
        }
    }

    public void decrypt(String inputFile, String outputFile, int key) {
        validator.validateForReading(inputFile);
        validator.validateForWriting(outputFile);

        List<String> sourceLines = fileProcessor.readFile(inputFile);
        for (String sourceLine : sourceLines) {
            String encryptedLine = caesarCipher.encrypt(sourceLine, key);
            fileProcessor.writeAndAppendToFile(outputFile, encryptedLine);
        }
    }
}
