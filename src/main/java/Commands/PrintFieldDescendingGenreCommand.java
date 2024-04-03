package Commands;

import CommandControl.CommandReceiver;

public class PrintFieldDescendingGenreCommand implements Command{
    private CommandReceiver commandReceiver;
    public PrintFieldDescendingGenreCommand(CommandReceiver cm){
        commandReceiver = cm;
    }
    @Override
    public void execute() {

    }
}
