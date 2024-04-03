import CommandControl.CommandController;
import CommandControl.CommandReceiver;
import MusicBands.MusicBand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args){
        CommandReceiver commandReceiver = new CommandReceiver();
        CommandController commandController = new CommandController(commandReceiver);
        commandController.run();
    }
}