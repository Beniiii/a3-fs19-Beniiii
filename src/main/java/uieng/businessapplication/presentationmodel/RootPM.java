package uieng.businessapplication.presentationmodel;

import java.util.Random;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import uieng.businessapplication.service.SongService;

public class RootPM {
    private final StringProperty applicationTitle = new SimpleStringProperty("Cool App");
    private final SongService    service;

    private SongPM currentPM;
    private FormsPM formsPM;

    public RootPM(SongService service) {
        this.service = service;

        long id = new Random().nextInt(100) + 1;
        System.out.println(id);
        currentPM = SongPM.of(service.get(id));
        formsPM = new FormsPM(currentPM);
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
