package Commands;

import CommandControl.CommandReceiver;

public class ClearCommand implements Command{
    private CommandReceiver commandReceiver;
    public ClearCommand(CommandReceiver cm){
        commandReceiver = cm;
    }
    @Override
    public void execute() {

    }
}
