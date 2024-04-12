package Commands;

import Collection.CollectionManager;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueNumberOfParticipantsCommand implements Command{
    private CollectionManager collectionManager;
    public PrintUniqueNumberOfParticipantsCommand(CollectionManager cm){
        collectionManager = cm;
    }
    @Override
    public void execute() {
        Set<Integer> numberOfParticipants = new HashSet<>();
        for (int i = 0; i <collectionManager.getMusicBands().size() ; i++) {
            numberOfParticipants.add((int)collectionManager.getMusicBands().get(i).getNumberOfParticipants());
        }
        System.out.println(numberOfParticipants);
    }

    @Override
    public boolean isParametrized() {
        return false;
    }
}
