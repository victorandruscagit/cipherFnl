import mo.com.jaru.criptografie.consoleui.ConsoleDialogue;
import mo.com.jaru.criptografie.consoleui.Dialogue;

import javax.tools.Diagnostic;

public class Application {
    public static void main(String[] args) {
        Dialogue dialogue = new ConsoleDialogue();
        dialogue.start();
    }
}
