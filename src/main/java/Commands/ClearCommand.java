package Commands;

import Collection.CollectionManager;

public class ClearCommand implements Command{
    private CollectionManager collectionManager;
    public ClearCommand(CollectionManager cm){
        collectionManager = cm;
    }
    @Override
    public void execute() {

        collectionManager.getMusicBands().clear();
    }

    @Override
    public boolean isParametrized() {
        return false;
    }
}
