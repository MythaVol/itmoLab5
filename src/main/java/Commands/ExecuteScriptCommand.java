package Commands;

import CommandControl.CommandReceiver;

public class ExecuteScriptCommand implements Command{
    private CommandReceiver commandReceiver;
    public ExecuteScriptCommand(CommandReceiver cm){
        commandReceiver = cm;
    }
    @Override
    public void execute() {

    }
}
