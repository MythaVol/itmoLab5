package JsonParse;

import MusicBands.MusicBand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class JsonManager implements FileManager {
    public ArrayList<MusicBand> read(File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<MusicBand> musicBands;
        try {
            musicBands = objectMapper.readValue(file, new TypeReference<ArrayList<MusicBand>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return musicBands;
    }

    public void write(Object o, File file) {
        ObjectMapper om = new ObjectMapper();
        try {
            PrintWriter pw = new PrintWriter(file);
            String object = om.writeValueAsString(o);
            pw.println(object);
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
