package CommandControl;

import Commands.Command;
import Commands.CommandWithParametr;

//Класс запускающий команды
public class CommandExecutor {

    public void executeCommand(Command command){
        command.execute();
    }
    public void executeCommandWithParameter(CommandWithParametr command, String parameter){
        command.setParameter(parameter);
        command.execute();
    }
}
