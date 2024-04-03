package Commands;

import CommandControl.CommandReceiver;

public class RemoveByIdCommand implements Command{
    private CommandReceiver commandReceiver;
    public RemoveByIdCommand(CommandReceiver cm){
        commandReceiver = cm;
    }
    @Override
    public void execute() {

    }
}
