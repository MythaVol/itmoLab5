package Commands;

import Collection.CollectionManager;
import JsonParse.JsonManager;

import java.io.File;

public class SaveCommand implements Command{
    private JsonManager jsonManager = new JsonManager();
    private CollectionManager collectionManager;
    public SaveCommand(CollectionManager cm){
        collectionManager = cm;
    }
    @Override
    public void execute() {
        collectionManager.sort();
        jsonManager.write(collectionManager.getMusicBands(), new File(System.getenv("FILEPATH")));
    }

    @Override
    public boolean isParametrized() {
        return false;
    }
}
