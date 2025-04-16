package mo.com.jaru.criptografie.consoleui;


import mo.com.jaru.criptografie.caesar.CaesarCoder;
import mo.com.jaru.criptografie.consoleui.exceptions.InvalidUserException;

import java.util.Scanner;

public class ConsoleDialogue implements Dialogue {
    private static final String WELCOME_MESSAGE = """
                                **************
                                ***Welcome***
                                *************
            
            """;
    private static final String OPERATION_PATTERN = "%d - %s";
    private static final String TRY_AGAIN_COMMAND = "again";

    private final Scanner scanner;
    private final CaesarCoder caesarCoder;

    public ConsoleDialogue() {
        scanner = new Scanner(System.in);
        caesarCoder = new CaesarCoder();

    }

    @Override
    public void start() {
        showMenu();
        Operation operations = readOperation();
    }

    private void showMenu() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println("Choose next option to conitinue");
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
                System.out.println("Enter 'again' for trying something other for exit");

                String input = readString();
                if (TRY_AGAIN_COMMAND.equalsIgnoreCase(input)) {
                    shouldTryAgain = true;
                }
            }
        } while (shouldTryAgain);
        return Operation.EXIT;
    }

    private String readString() {
        return "";
    }


    private int readInt() {
        return 0;

    }
}
