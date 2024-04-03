package Commands;

import Collection.CollectionManager;
import CommandControl.CommandReceiver;

public class AddCommand implements Command{

    private CommandReceiver commandReceiver;
    public AddCommand(CommandReceiver cm){
        commandReceiver = cm;
    }
    @Override
    public void execute() {

    }
}
