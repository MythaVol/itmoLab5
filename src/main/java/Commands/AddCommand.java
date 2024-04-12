package Commands;

import Collection.CollectionManager;
import CommandControl.ConsoleMessage;
import CommandControl.Validator;
import MusicBands.Coordinates;
import MusicBands.MusicBand;
import MusicBands.Studio;

public class AddCommand implements Command{
    private Validator validator = new Validator();
    private CollectionManager collectionManager;
    private ConsoleMessage cm;
    public AddCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        cm = new ConsoleMessage(System.in);
    }
    @Override
    public void execute() {
        try {
            MusicBand musicBand = new MusicBand();
            Coordinates coordinates = new Coordinates();
            musicBand.setName(cm.ask("Введите название группы"));
            coordinates.setX(Integer.parseInt(cm.ask("Введите координату х")));
            coordinates.setY(Integer.parseInt(cm.ask("Введите координату y")));
            musicBand.setCoordinates(coordinates);
            musicBand.setNumberOfParticipants(Integer.parseInt(cm.ask("Введите кол-во участников")));
            Studio studio = new Studio();
            studio.setName(cm.ask("Введите имя студии"));
            studio.setAddress(cm.ask("Введите адрес студии"));
            musicBand.setStudio(studio);
            musicBand.setGenre(validator.getGenre(cm.ask("Введите жанр")));
            musicBand.setId(collectionManager.getIdCounter());
            collectionManager.addNewBand(musicBand);
            collectionManager.sort();
        }catch (Exception e){
            System.out.println("Данные введены неверно");
        }

    }

    @Override
    public boolean isParametrized() {
        return false;
    }

    public ConsoleMessage getCm() {
        return cm;
    }

    public void setCm(ConsoleMessage cm) {
        this.cm = cm;
    }
}
