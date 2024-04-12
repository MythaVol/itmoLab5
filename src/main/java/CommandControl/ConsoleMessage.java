package CommandControl;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleMessage {
    private InputStream inputStream;
    public ConsoleMessage(InputStream is){
        inputStream = is;
    }
    public String ask(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextLine();
    }
    public static void message(String message){
        System.out.println(message);
    }
}
