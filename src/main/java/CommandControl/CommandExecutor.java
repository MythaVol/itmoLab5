package CommandControl;

import Commands.Command;
//Класс запускающий команды
public class CommandExecutor {

    public void executeCommand(Command command){
        command.execute();
    }
}
