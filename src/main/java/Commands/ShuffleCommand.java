package Commands;

import CommandControl.CommandReceiver;

public class ShuffleCommand implements Command{
    private CommandReceiver commandReceiver;
    public ShuffleCommand(CommandReceiver cm){
        commandReceiver = cm;
    }
    @Override
    public void execute() {

    }
}
