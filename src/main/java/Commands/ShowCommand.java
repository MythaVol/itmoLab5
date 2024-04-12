package Commands;

import Collection.CollectionManager;

public class ShowCommand implements Command{
    private CollectionManager collectionManager;
    public ShowCommand(CollectionManager cm){
        collectionManager = cm;
    }
    @Override
    public void execute() {
        System.out.println(collectionManager.getMusicBands());
    }

    @Override
    public boolean isParametrized() {
        return false;
    }
}
