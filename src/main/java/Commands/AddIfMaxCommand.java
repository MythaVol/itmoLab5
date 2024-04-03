package Commands;

import CommandControl.CommandReceiver;

public class AddIfMaxCommand implements Command{
    private CommandReceiver commandReceiver;
    public AddIfMaxCommand(CommandReceiver cm){
        commandReceiver = cm;
    }
    @Override
    public void execute() {

    }
}
