package cl.cutiko.cutikoplayer;

/**
 * Created by cutiko on 14-07-16.
 */
public class Song {

    private String id, title, artist;

    public Song(String id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
