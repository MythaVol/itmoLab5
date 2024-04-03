package Commands;

import CommandControl.CommandReceiver;

public class HelpCommand implements Command{
    private CommandReceiver commandReceiver;
    public HelpCommand(CommandReceiver cm){
        commandReceiver = cm;
    }
    @Override
    public void execute() {
        commandReceiver.help();
    }
}
