package Commands;

import Collection.CollectionManager;
import CommandControl.ConsoleMessage;
import MusicBands.Coordinates;
import MusicBands.MusicBand;
import MusicBands.Studio;

import java.io.InputStream;

public class AddIfMinCommand implements Command{
    private CollectionManager collectionManager;
    private InputStream inputStream;
    private ConsoleMessage cm;
    public AddIfMinCommand(CollectionManager cm, InputStream is){
        collectionManager = cm;
        this.cm = new ConsoleMessage(is);
        inputStream= is;
    }
    @Override
    public void execute() {
        int value = Integer.parseInt(cm.ask("Введите количество участников"));
        AddCommand addCommand = new AddCommand(collectionManager,inputStream){
            @Override
            public void execute() {
                try {
                    MusicBand musicBand = new MusicBand();
                    Coordinates coordinates = new Coordinates();
                    musicBand.setName(cm.ask("Введите название группы"));
                    coordinates.setX(Integer.parseInt(cm.ask("Введите координату х")));
                    coordinates.setY(Integer.parseInt(cm.ask("Введите координату y")));
                    musicBand.setCoordinates(coordinates);
                    musicBand.setNumberOfParticipants(value);
                    Studio studio = new Studio();
                    studio.setName(cm.ask("Введите имя студии"));
                    studio.setAddress(cm.ask("Введите адрес студии"));
                    musicBand.setStudio(studio);
                    musicBand.setGenre(getValidator().getGenre(cm.ask("Введите жанр: hip-hop, jazz или soul")));
                    musicBand.setId(collectionManager.getIdCounter());
                    collectionManager.addNewBand(musicBand);
                    collectionManager.sort();
                }catch (Exception e){
                    ConsoleMessage.message("Данные введены неверно");
                }

            }
        };
        boolean flag =true;
        for(MusicBand musicBand: collectionManager.getMusicBands()){
            if(value > musicBand.getNumberOfParticipants()){
                flag = false;
                ConsoleMessage.message("Есть группа с меньшим количеством участников");
            }
        }
        if(flag){
            addCommand.execute();
        }
    }

    @Override
    public boolean isParametrized() {
        return false;
    }
}
