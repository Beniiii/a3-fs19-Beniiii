package uieng.businessapplication.presentationmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import uieng.businessapplication.service.SongDTO;

public class SongPM implements PMBase<SongDTO> {

    private final LongProperty   id   = new SimpleLongProperty();
    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty album = new SimpleStringProperty();
    private final StringProperty artist = new SimpleStringProperty();
    private final DoubleProperty duration = new SimpleDoubleProperty();
    private final StringProperty genre = new SimpleStringProperty();
    private final DoubleProperty hotness = new SimpleDoubleProperty();


    @Override
    public void apply(SongDTO dto) {
        //setId(dto.getId());
        setTitle(dto.getTitle());
        setAlbum(dto.getAlbum());
        setArtist(dto.getArtist());
        setDuration(dto.getDuration());
        setGenre(dto.getGenre());
        //setHotness(dto.getHotness());
    }

    /*
        public static SongPM of(SongDTO songDTO) {
            SongPM pm = new SongPM();

            pm.setId(songDTO.getId());
            pm.setTitle(songDTO.getTitle());
            pm.setAlbum(songDTO.getAlbum());
            pm.setArtist(songDTO.getArtist());
            pm.setDuration(songDTO.getDuration());
            pm.setGenre(songDTO.getGenre());
            pm.setHotness(songDTO.getHotness());

            return pm;
        }
    */
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
    
    public double getHotness() {
        return hotness.get();
    }

    public DoubleProperty hotnessProperty() {
        return hotness;
    }

    public void setHotness(double hotness) {
        this.hotness.set(hotness);
    }
}
