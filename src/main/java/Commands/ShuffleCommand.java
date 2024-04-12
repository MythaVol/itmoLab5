package Commands;

import Collection.CollectionManager;

public class ShuffleCommand implements Command{
    private CollectionManager collectionManager;
    public ShuffleCommand(CollectionManager cm){
        collectionManager = cm;
    }
    @Override
    public void execute() {
        collectionManager.shuffle();
    }

    @Override
    public boolean isParametrized() {
        return false;
    }
}
