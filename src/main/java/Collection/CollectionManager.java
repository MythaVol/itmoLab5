package Collection;

import CommandControl.ConsoleMessage;
import JsonParse.JsonManager;
import MusicBands.MusicBand;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;

public class CollectionManager {
    private final JsonManager jsonManager = new JsonManager();
    private final ArrayList<MusicBand> musicBands = new ArrayList<>();
    private long idCounter;
    private LocalDateTime initDate;
    public CollectionManager(){
        initDate = LocalDateTime.now();
        try {
            musicBands.addAll(jsonManager.read(new File(System.getenv("FILEPATH"))));
        } catch (Exception e) {
            ConsoleMessage.message(e.getMessage());
        }
        if(musicBands.isEmpty())
            idCounter = 1;
        else {
            idCounter = musicBands.get(musicBands.size() - 1).getId() + 1;
        }
    }

    public LocalDateTime getInitDate() {
        return initDate;
    }

    public void addNewBand(MusicBand mb){
        musicBands.add(mb);
        idCounter+=1;
    }
    public void sort(){
        Collections.sort(musicBands);
    }

    public ArrayList<MusicBand> getMusicBands() {
        return musicBands;
    }
    public void shuffle(){
        Collections.shuffle(musicBands);
    }

    public long getIdCounter() {
        return idCounter;
    }

    public  int searchById(Long id) throws Exception {
         for (MusicBand musicBand: musicBands) {
            if(musicBand.getId().equals(id))
                return musicBands.indexOf(musicBand);
        }
        throw new Exception("Объекта с таким id не существует");
    }
}
