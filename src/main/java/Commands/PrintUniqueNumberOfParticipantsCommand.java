package Commands;

import CommandControl.CommandReceiver;

public class PrintUniqueNumberOfParticipantsCommand implements Command{
    private CommandReceiver commandReceiver;
    public PrintUniqueNumberOfParticipantsCommand(CommandReceiver cm){
        commandReceiver = cm;
    }
    @Override
    public void execute() {

    }
}
