package JsonParse;

import MusicBands.MusicBand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class JsonManager implements FileManager {
    public ArrayList<MusicBand> read(File file) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        objectMapper.setDateFormat(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"));
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ArrayList<MusicBand> musicBands;
        try {

            FileReader fl = new FileReader(file);
            try {
                musicBands = objectMapper.readValue(fl, new TypeReference<ArrayList<MusicBand>>(){});
                fl.close();

            }catch (Exception e){
                throw new Exception("Целостность файла нарушена, исправьте файл, либо продолжите без чтения из файла");
            }

        } catch (IOException e) {
            throw new Exception(e);
        }
        return musicBands;
    }

    public void write(ArrayList<? extends Object> musicBands , File file) {
        ObjectMapper om = new ObjectMapper();
        om.setDateFormat(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"));
        om.registerModule(new JavaTimeModule());
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.println(om.writeValueAsString(musicBands));
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
