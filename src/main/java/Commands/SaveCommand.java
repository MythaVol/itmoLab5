package Commands;

import CommandControl.CommandReceiver;

public class SaveCommand implements Command{
    private CommandReceiver commandReceiver;
    public SaveCommand(CommandReceiver cm){
        commandReceiver = cm;
    }
    @Override
    public void execute() {

    }
}
