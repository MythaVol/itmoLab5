package Commands;

import Collection.CollectionManager;

public class InfoCommand implements Command{
    private CollectionManager collectionManager;
    public InfoCommand(CollectionManager cm){
        collectionManager = cm;
    }
    @Override
    public void execute() {
        System.out.println("Дата инициализации " + collectionManager.getInitDate());
        System.out.println("Количество элементов " + collectionManager.getMusicBands().size());
        System.out.println("Тип " + collectionManager.getMusicBands().getClass().getCanonicalName());
    }

    @Override
    public boolean isParametrized() {
        return false;
    }
}
