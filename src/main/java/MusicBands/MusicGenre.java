package MusicBands;

public enum MusicGenre {
    HIP_HOP("hip-hop"),
    JAZZ("jazz"),
    SOUL("soul");
    private String name;
    MusicGenre(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
