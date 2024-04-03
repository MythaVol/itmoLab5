package JsonParse;

import MusicBands.MusicBand;

import java.io.File;
import java.util.ArrayList;

public interface FileManager {
    ArrayList<? extends  Object> read(File file);
    void write(Object o, File file);
}
