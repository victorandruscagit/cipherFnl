package mo.com.jaru.criptografie.file;

import mo.com.jaru.criptografie.file.exceptions.FileProcessingException;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileProcessor {
    private static final StandardOpenOption[] FILE_WRITE_OPTIONS =
            {StandardOpenOption.CREATE, StandardOpenOption.APPEND};

    /**
     *
     * @param fileName
     * @return
     * @throws FileProcessingException (maybe).
     */
    public List<String> readFile(String fileName) {
        Path filePath = Path.of(fileName);
        try {
            return Files.readAllLines(filePath);
        } catch (IOException  | InvalidPathException e) {
            throw new FileProcessingException(e.getMessage(), e);

        }
    }

    public void writeAndAppendToFile(String fileName, String content) {
        Path filePath = Path.of(fileName);
        try {
            Files.writeString(filePath, content, FILE_WRITE_OPTIONS);
        } catch (IOException e) {
            throw new FileProcessingException(e.getMessage(), e);
        }
    }
}
