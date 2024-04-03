package Commands;

import CommandControl.CommandReceiver;

public class AddIfMinCommand implements Command{
    private CommandReceiver commandReceiver;
    public AddIfMinCommand(CommandReceiver cm){
        commandReceiver = cm;
    }
    @Override
    public void execute() {

    }
}
