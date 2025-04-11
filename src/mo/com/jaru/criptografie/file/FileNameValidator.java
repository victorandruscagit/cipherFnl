package mo.com.jaru.criptografie.file;

import mo.com.jaru.criptografie.file.exceptions.FileProcessingException;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileNameValidator {

    private static final List<String> FORBIDDEN_DIRS_FILES =
            List.of(".bash_history", ".bash_profile", "etc", "proc");
    public static final String SYSTEM_SEPARATOR_PROPERTY = System.getProperty("file.separator");

    public void validateForWriting(String fileName) {
        Path path = validatePath(fileName);
        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                throw new FileProcessingException("File " + path + "  is a directory");
            }
        }
        if (!Files.isWritable(path)) {
            throw new FileProcessingException("File " + path + " is not accessible for writing in it");
        }
    }

    public void validateForReading(String fileName) {
        Path path = validatePath(fileName);
        if (Files.notExists(path)) {
            throw new FileProcessingException("File " + path + " doesn't exists");
        }
        if (Files.isDirectory(path)) {
            throw new FileProcessingException("File " + path + " is a directory");
        }
        if (!Files.isReadable(path)) {
            throw new FileProcessingException("File " + path + " cannot be readable");
        }


    }

    private Path validatePath(String fileName) {
        for (String pathParts : fileName.split(SYSTEM_SEPARATOR_PROPERTY)) {
            if (FORBIDDEN_DIRS_FILES.contains(pathParts)) {
                throw new FileProcessingException("File " + pathParts + " contains forbidden parts  " + pathParts);
            }
        }

        try {
            Path path = Path.of(fileName);
            return path;
        } catch (InvalidPathException e) {
            throw new FileProcessingException("Invalid path.Reason : " + e.getMessage(), e);
        }
    }

}

