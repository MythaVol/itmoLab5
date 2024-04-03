package MusicBands;

import java.util.Objects;

public class MusicBand {
    private Long id = (long) hashCode(); //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long numberOfParticipants; //Значение поля должно быть больше 0
    private MusicGenre genre; //Поле не может быть null
    private Studio studio; //Поле не может быть null

    public MusicBand(String name){
        this.name = name;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MusicBand musicBand)) return false;
        return numberOfParticipants == musicBand.numberOfParticipants && Objects.equals(id, musicBand.id) && Objects.equals(name, musicBand.name) && Objects.equals(coordinates, musicBand.coordinates) && Objects.equals(creationDate, musicBand.creationDate) && genre == musicBand.genre && Objects.equals(studio, musicBand.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coordinates, creationDate, numberOfParticipants, genre, studio);
    }
}
