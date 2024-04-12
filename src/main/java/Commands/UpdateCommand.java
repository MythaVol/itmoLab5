package Commands;

import Collection.CollectionManager;
import CommandControl.ConsoleMessage;
import CommandControl.Validator;
import MusicBands.Coordinates;
import MusicBands.MusicBand;
import MusicBands.Studio;

import java.io.InputStream;

public class UpdateCommand implements CommandWithParametr{
    private CollectionManager collectionManager;
    private String parameter;
    private ConsoleMessage cm;
    private Validator validator = new Validator();
    public UpdateCommand(CollectionManager cm, InputStream is){
        collectionManager= cm;
        this.cm = new ConsoleMessage(is);
    }
    public void setParameter(String parameter){
        this.parameter = parameter;
    }
    @Override
    public void execute() {
        try {
            Integer index = collectionManager.searchById(Long.parseLong(parameter));
            MusicBand musicBand = collectionManager.getMusicBands().get(index);
            Coordinates coordinates = musicBand.getCoordinates();
            musicBand.setName(cm.ask("Введите название группы"));
            coordinates.setX(Integer.parseInt(cm.ask("Введите координату х")));
            coordinates.setY(Integer.parseInt(cm.ask("Введите координату y")));
            musicBand.setCoordinates(coordinates);
            musicBand.setNumberOfParticipants(Integer.parseInt(cm.ask("Введите кол-во участников")));
            Studio studio = musicBand.getStudio();
            studio.setName(cm.ask("Введите имя студии"));
            studio.setAddress(cm.ask("Введите адрес студии"));
            musicBand.setStudio(studio);
            musicBand.setGenre(validator.getGenre(cm.ask("Введите жанр")));
            collectionManager.getMusicBands().set(index,musicBand);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean isParametrized() {
        return true;
    }

    public void setCm(ConsoleMessage cm) {
        this.cm = cm;
    }
}
