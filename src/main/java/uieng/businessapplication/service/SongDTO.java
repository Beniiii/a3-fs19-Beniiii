package uieng.businessapplication.service;

import javafx.beans.property.DoubleProperty;

public class SongDTO {
    private final Long id;
    private final String title;
    private final String album;
    private final String artist;
    private final double duration;
    private final String genre;
    private final double hotness;


    public SongDTO(String... args) {
        id   = Long.parseLong(args[24]);
        title = args[33];
        album = args[21];
        artist = args[2];
        duration = Double.parseDouble(args[9]);
        genre = args[29];
        hotness = Double.parseDouble((args[23].isEmpty() ? "0.0" : args[23]));
    }


    // all getter and setter

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public double getHotness() {
        return hotness;
    }
}