package Commands;

import Collection.CollectionManager;

public class PrintFieldDescendingGenreCommand implements Command{
    private CollectionManager collectionManager;
    public PrintFieldDescendingGenreCommand(CollectionManager cm){
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
