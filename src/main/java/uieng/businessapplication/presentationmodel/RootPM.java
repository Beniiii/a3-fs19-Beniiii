package uieng.businessapplication.presentationmodel;

import java.time.Duration;
import java.util.Random;
import java.util.function.Function;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import uieng.businessapplication.presentationmodel.util.PagingList;
import uieng.businessapplication.presentationmodel.util.TaskBatcher;
import uieng.businessapplication.service.SongService;

public class RootPM {
    private final StringProperty applicationTitle = new SimpleStringProperty("Cool App");
    //private final SongService    service;
    private static final Function<Integer, SongPM> fSong = index -> new SongPM();
    private final TaskBatcher taskBatcher = new TaskBatcher(Duration.ofMillis(250));

    private SongPM currentPM;
    private FormsPM formsPM;

    public RootPM(SongService service) {
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
    


}
