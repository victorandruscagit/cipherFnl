package mo.com.jaru.criptografie.consoleui;


import mo.com.jaru.criptografie.caesar.CaesarAlhpabetException;
import mo.com.jaru.criptografie.caesar.CaesarCoder;
import mo.com.jaru.criptografie.consoleui.exceptions.InvalidUserException;
import mo.com.jaru.criptografie.file.exceptions.FileProcessingException;
import org.graalvm.nativeimage.IsolateThread;

import java.security.CodeSource;
import java.util.Scanner;

public class ConsoleDialogue implements Dialogue {
    private static final String WELCOME_MESSAGE = """
                                **************
                                ***Welcome***
                                *************
            
            """;
    private static final String OPERATION_PATTERN = "%d - %s";
    private static final String TRY_AGAIN_COMMAND = "again";

    private final Scanner in;
    private final CaesarCoder caesarCoder;

    public ConsoleDialogue() {
        in = new Scanner(System.in);
        caesarCoder = new CaesarCoder();

    }

    @Override
    public void start() {
        showMenu();
        Operation operation = readOperation();
        processOperation(operation);
    }


    private void showMenu() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println("Choose next option to continue");
        for (Operation operation : Operation.values()) {
            String message = String.format(OPERATION_PATTERN, operation.getNumber(), operation.getDescription());
            System.out.println(message);
        }

    }

    private Operation readOperation() {
        boolean shouldTryAgain = false;
        do {
            try {
                int option = readInt();
                return Operation.getByNumber(option);
            } catch (IllegalArgumentException | InvalidUserException e) {
                System.out.println("Operation number is wrong");
                System.out.println("Reason : " + e.getMessage());
                System.out.println("Enter 'again' for a new try or something other for exit");

                String input = readString();
                if (TRY_AGAIN_COMMAND.equalsIgnoreCase(input)) {
                    shouldTryAgain = true;
                }
            }
        } while (shouldTryAgain);
        return Operation.EXIT;
    }

    private void processOperation(Operation operation) {
        switch (operation) {
            case EXIT -> processExit();
            case ENCRYPTION -> processEncryptionOperation();
            case DECRYPTION -> processDecryptionOperation();
        }

    }

    private void processDecryptionOperation() {
        System.out.println("Enter filename you want to decrypt:");
        String inputFileName = readString();

        System.out.println("Enter filename will be used to save result:");
        String outputFileName = readString();
        System.out.println("Enter the key : ");
        int key = readInt();
        try {
            caesarCoder.decrypt(inputFileName, outputFileName, key);
            System.out.println("Done.");
        } catch (FileProcessingException | CaesarAlhpabetException e) {
            System.out.println("Error happened. Cause : " + e.getMessage());
            e.printStackTrace();
        }


    }

    private void processEncryptionOperation() {
        System.out.println("Enter file name which contains original text");
        String inputFileName = readString();

        System.out.println("Enter filename will be used to save result:");
        String outputFileName = readString();
        int key = readInt();
        try {
            caesarCoder.encrypt(inputFileName, outputFileName, key);
            System.out.println("Done");
        }catch (FileProcessingException | CaesarAlhpabetException e) {
            System.out.println("Error happened. Cause : " + e.getMessage());
            e.printStackTrace();
        }


    }

    private void processExit() {
        System.out.println("Buy");
    }

    private int readInt() {
        String input = in.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidUserException("Integer value is wrong ", e.getMessage());
        }

    }

    private String readString() {
        return in.nextLine();
    }
}
