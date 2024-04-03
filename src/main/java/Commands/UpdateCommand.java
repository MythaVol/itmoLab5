package Commands;

import CommandControl.CommandReceiver;

public class UpdateCommand implements Command{
    private CommandReceiver commandReceiver;
    public UpdateCommand(CommandReceiver cm){
        commandReceiver = cm;
    }
    @Override
    public void execute() {

    }
}
