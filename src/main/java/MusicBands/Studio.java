package MusicBands;

public class Studio {
    private String name; //Поле может быть null
    private String address; //Поле может быть null
    public Studio(String name, String address){
        this.name = name;
        this.address = address;
    }

    public Studio() {
    }

    @Override
    public String toString() {
        return "Studio{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
