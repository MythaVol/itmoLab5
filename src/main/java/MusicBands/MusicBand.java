package MusicBands;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.Objects;

public class MusicBand implements Comparable<MusicBand> {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long numberOfParticipants; //Значение поля должно быть больше 0
    private MusicGenre genre; //Поле не может быть null
    private Studio studio; //Поле не может быть null

    public MusicBand(String name){
        this.name = name;
    }
    public MusicBand(){
        creationDate = LocalDateTime.now();
    }


    public Studio getStudio() {
        return studio;
    }
    public void setStudio(Studio studio) {
        this.studio = studio;
    }
    public MusicGenre getGenre() {
        return genre;
    }
    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }
    public long getNumberOfParticipants() {
        return numberOfParticipants;
    }
    public void setNumberOfParticipants(long numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "\n"+"MusicBand{" + "\n"+
                    "   id=" + id + ",\n"+
                    "   name='" + name + '\'' + ",\n"+
                    "   coordinates=" + coordinates + ",\n"+
                    "   creationDate=" + creationDate +",\n"+
                    "   numberOfParticipants=" + numberOfParticipants + ",\n"+
                    "   genre=" + genre + ",\n"+
                    "   studio=" + studio + ",\n"+
                    "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MusicBand musicBand)) return false;
        return numberOfParticipants == musicBand.numberOfParticipants && Objects.equals(id, musicBand.id) && Objects.equals(name, musicBand.name) && Objects.equals(coordinates, musicBand.coordinates) && Objects.equals(creationDate, musicBand.creationDate) && genre == musicBand.genre && Objects.equals(studio, musicBand.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coordinates, creationDate, numberOfParticipants, genre, studio);
    }

    @Override
    public int compareTo(MusicBand o) {
        return (int) (this.getId() - o.getId());
    }
}
