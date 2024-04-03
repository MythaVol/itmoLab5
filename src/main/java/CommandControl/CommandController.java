package CommandControl;

import Commands.AddCommand;
import Commands.Command;
import Commands.HelpCommand;
import Commands.InfoCommand;

import java.util.HashMap;
import java.util.Scanner;

public class CommandController {

    private HashMap<String, Command> commands;
    public CommandController(CommandReceiver cr){
        commands = new HashMap<>(){{
            put("help", new HelpCommand(cr));
            put("info", new InfoCommand(cr));
            put("add", new AddCommand(cr));
        }};
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        CommandExecutor commandExecutor = new CommandExecutor();
        while(true){
            String command = scanner.nextLine();
            if(command.equals("exit")){
                break;
            }else{
                String[] s = command.split(" ");
                commandExecutor.executeCommand(commands.get(s[0]));
            }

        }
    }

}
