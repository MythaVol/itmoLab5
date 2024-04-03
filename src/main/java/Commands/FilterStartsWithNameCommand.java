package Commands;

import CommandControl.CommandReceiver;

public class FilterStartsWithNameCommand implements Command{
    private CommandReceiver commandReceiver;
    public FilterStartsWithNameCommand(CommandReceiver cm){
        commandReceiver = cm;
    }
    @Override
    public void execute() {

    }
}
