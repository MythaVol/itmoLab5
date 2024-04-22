package JsonParse;

import MusicBands.MusicBand;

import java.io.File;
import java.util.ArrayList;

public interface FileManager {
    ArrayList<? extends  Object> read(File file) throws Exception;
    void write(ArrayList<? extends Object> list, File file);
}
