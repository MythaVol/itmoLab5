package CommandControl;

import Collection.CollectionManager;
import Commands.*;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class CommandController {

    private HashMap<String, Command> commands;
    public CommandController(CollectionManager cm, InputStream inputStream){
        commands = new HashMap<>(){{
            put("help", new HelpCommand());
            put("info", new InfoCommand(cm));
            put("add", new AddCommand(cm,inputStream));
            put("save", new SaveCommand(cm));
            put("clear", new ClearCommand(cm));
            put("show", new ShowCommand(cm));
            put("shuffle", new ShuffleCommand(cm));
            put("print_unique_number_of_participants", new PrintUniqueNumberOfParticipantsCommand(cm));
            put("update", new UpdateCommand(cm, inputStream));
            put("remove_by_id", new RemoveByIdCommand(cm));
            put("execute_script", new ExecuteScriptCommand(cm));
            put("filter_starts_with_name", new FilterStartsWithNameCommand(cm));
            put("add_if_max", new AddIfMaxCommand(cm, inputStream));
            put("add_if_min", new AddIfMinCommand(cm, inputStream));
            put("print_field_descending_genre", new PrintFieldDescendingGenreCommand(cm));
        }};
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        CommandExecutor commandExecutor = new CommandExecutor();
        while(true){
            ConsoleMessage.message("Введите команду:");
            String command = scanner.nextLine();
            if(command.equals("exit")){
                break;
            }else{
                String[] s = command.split(" ");
                if(s.length==1)
                    try {
                        commandExecutor.executeCommand(commands.get(s[0]));
                    }catch (Exception e){
                        ConsoleMessage.message("Команда введена неверно");
                    }
                else if (s.length==2) {
                    if(commands.get(s[0]).isParametrized())
                        try{
                            commandExecutor.executeCommandWithParameter((CommandWithParametr) commands.get(s[0]),s[1]);
                        }catch (Exception e){
                            ConsoleMessage.message("Команда введена неверно");
                        }
                    else ConsoleMessage.message("У этой команды нет аргументов");
                }else ConsoleMessage.message("Команда введена неверно");
            }

        }
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }
}
