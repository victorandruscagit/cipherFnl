package mo.com.jaru.criptografie.caesar;

import mo.com.jaru.criptografie.file.FileNameValidator;
import mo.com.jaru.criptografie.file.FileProcessor;

import java.io.FilenameFilter;
import java.util.List;

public class CaesarCoder {
    private FileNameValidator fileNameValidator;
    private FileProcessor fileProcessor;
    private CaesarCipher caesarCipher;


    public CaesarCoder(FileNameValidator fileNameValidator,
                       FileProcessor fileProcessor,
                       CaesarCipher caesarCipher) {
        this.fileNameValidator = fileNameValidator;
        this.fileProcessor = fileProcessor;
        this.caesarCipher = caesarCipher;
    }

    public void encrypt(String inputFile, String outputFile, int key) {
        fileNameValidator.validateForReading(inputFile);
        fileNameValidator.validateForWriting(outputFile);

        List<String> sourceLines = fileProcessor.readFile(inputFile);
        for (String sourceLine : sourceLines) {
            String encryptedLine = caesarCipher.encrypt(sourceLine, key);
            fileProcessor.writeAndAppendToFile(outputFile, encryptedLine);
        }
    }
}
