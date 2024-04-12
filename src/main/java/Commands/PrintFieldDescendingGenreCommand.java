package Commands;

import Collection.CollectionManager;
import CommandControl.ConsoleMessage;
import MusicBands.MusicBand;

public class PrintFieldDescendingGenreCommand implements Command{
    private CollectionManager collectionManager;
    public PrintFieldDescendingGenreCommand(CollectionManager cm){
        collectionManager = cm;
    }
    @Override
    public void execute() {
        for (MusicBand musicBand: collectionManager.getMusicBands()) {
            ConsoleMessage.message(musicBand.getGenre().getName());
        }
    }

    @Override
    public boolean isParametrized() {
        return false;
    }
}
