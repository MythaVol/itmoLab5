package Commands;

import Collection.CollectionManager;

public class FilterStartsWithNameCommand implements CommandWithParametr{
    private CollectionManager collectionManager;

    public FilterStartsWithNameCommand(CollectionManager cm){
        collectionManager = cm;
    }
    @Override
    public void execute() {

    }

    @Override
    public boolean isParametrized() {
        return true;
    }

    @Override
    public void setParameter(String parameter) {

    }
}
