package mo.com.jaru.criptografie.consoleui.exceptions;

public class InvalidUserException extends  RuntimeException {
    public InvalidUserException() {
    }

    public InvalidUserException(String message) {
        super(message);
    }

    public InvalidUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUserException(Throwable cause) {
        super(cause);
    }

    public InvalidUserException(String integerValueIsWrong, String message) {
    }
}
