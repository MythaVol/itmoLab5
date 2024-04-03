package Commands;

import CommandControl.CommandReceiver;

public class ShowCommand implements Command{
    private CommandReceiver commandReceiver;
    public ShowCommand(CommandReceiver cm){
        commandReceiver = cm;
    }
    @Override
    public void execute() {

    }
}
