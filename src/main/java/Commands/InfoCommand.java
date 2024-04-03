package Commands;

import CommandControl.CommandReceiver;

public class InfoCommand implements Command{
    private CommandReceiver commandReceiver;
    public InfoCommand(CommandReceiver cm){
        commandReceiver = cm;
    }
    @Override
    public void execute() {

    }
}
