package Commands;

import Collection.CollectionManager;

public class AddIfMinCommand implements Command{
    private CollectionManager collectionManager;
    public AddIfMinCommand(CollectionManager cm){
        collectionManager = cm;
    }
    @Override
    public void execute() {
    }

    @Override
    public boolean isParametrized() {
        return false;
    }
}
