package uieng.businessapplication.presentationmodel;

import java.time.Duration;
import java.util.Random;
import java.util.function.Function;

import javafx.beans.property.*;

import uieng.businessapplication.presentationmodel.util.PagingList;
import uieng.businessapplication.presentationmodel.util.TaskBatcher;
import uieng.businessapplication.service.PagingService;
import uieng.businessapplication.service.SongDTO;
import uieng.businessapplication.service.SongService;

public class RootPM {
    private final StringProperty applicationTitle = new SimpleStringProperty("Cool App");
    //private final SongService    service;
    private static final Function<Integer, SongPM> fSong = index -> new SongPM();
    private final StringProperty filter = new SimpleStringProperty();
    private final IntegerProperty filteredCount = new SimpleIntegerProperty();
    private final IntegerProperty totalCount = new SimpleIntegerProperty();
    private final ObjectProperty<PagingList<SongPM, SongDTO>> filteredSongs = new SimpleObjectProperty<>();


    private final TaskBatcher taskBatcher = new TaskBatcher(Duration.ofMillis(250));

    private SongPM currentPM;
    private FormsPM formsPM;

    public RootPM(PagingService<SongDTO> service) {
        //this.service = service;

        //long id = new Random().nextInt(100) + 1;
        //currentPM = SongPM.of(service.get(id));
        //formsPM = new FormsPM(currentPM);
        setFilteredSongs(new PagingList<>(service, index -> new SongPM(), null));

        filter.addListener((observable, oldValue, newValue) ->
                taskBatcher.batch(() -> setFilteredSongs(new PagingList<>(service, fSong, newValue))));
    }

    public SongPM getCurrentPM() {
        return currentPM;
    }
    
    public FormsPM getFormsPM() {
        return formsPM;
    }

    // alle Getter und Setter
    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle.set(applicationTitle);
    }

    public PagingList<SongPM, SongDTO> getFilteredSongs() {
        return filteredSongs.get();
    }

    public ObjectProperty<PagingList<SongPM, SongDTO>> filteredSongsProperty() {
        return filteredSongs;
    }

    public void setFilteredSongs(PagingList<SongPM, SongDTO> filteredSongs) {
        this.filteredSongs.set(filteredSongs);
    }

    public String getFilter() {
        return filter.get();
    }

    public StringProperty filterProperty() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter.set(filter);
    }

    public int getFilteredCount() {
        return filteredCount.get();
    }

    public IntegerProperty filteredCountProperty() {
        return filteredCount;
    }

    public void setFilteredCount(int filteredCount) {
        this.filteredCount.set(filteredCount);
    }

    public int getTotalCount() {
        return totalCount.get();
    }

    public IntegerProperty totalCountProperty() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount.set(totalCount);
    }


}
