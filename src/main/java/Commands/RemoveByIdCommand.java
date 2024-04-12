package Commands;

import Collection.CollectionManager;

public class RemoveByIdCommand implements CommandWithParametr{
    private String parameter;
    private CollectionManager collectionManager;
    public RemoveByIdCommand(CollectionManager cm){
        collectionManager = cm;
    }
    @Override
    public void execute() {
        try {
            collectionManager.getMusicBands().remove(collectionManager.searchById(Long.parseLong(parameter)));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public boolean isParametrized() {
        return true;
    }

    @Override
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
