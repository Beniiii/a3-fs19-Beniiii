package uieng.businessapplication.presentationmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import uieng.businessapplication.service.SongDTO;

public class SongPM {

    private final LongProperty   id   = new SimpleLongProperty();
    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty album = new SimpleStringProperty();
    private final StringProperty artist = new SimpleStringProperty();
    private final DoubleProperty duration = new SimpleDoubleProperty();
    private final StringProperty genre = new SimpleStringProperty();
    private final DoubleProperty hottness = new SimpleDoubleProperty();

    public static SongPM of(SongDTO someDTO) {
        SongPM pm = new SongPM();

        pm.setId(someDTO.getId());
        pm.setTitle(someDTO.getTitle());

        return pm;
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }
    
    public String getAlbum() {
        return album.get();
    }

    public StringProperty albumProperty() {
        return album;
    }

    public void setAlbum(String album) {
        this.album.set(album);
    }
    
    public String getArtist() {
        return artist.get();
    }

    public StringProperty artistProperty() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }
    
    public double getDuration() {
        return duration.get();
    }

    public DoubleProperty durationProperty() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration.set(duration);
    }
    
    public String getGenre() {
        return genre.get();
    }

    public StringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }
    
    public double getHottness() {
        return hottness.get();
    }

    public DoubleProperty hottnessProperty() {
        return hottness;
    }

    public void setHottness(double hottness) {
        this.hottness.set(hottness);
    }
}
