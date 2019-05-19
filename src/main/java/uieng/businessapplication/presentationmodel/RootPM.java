package uieng.businessapplication.presentationmodel;

import java.util.Random;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import uieng.businessapplication.service.SomeService;

public class RootPM {
    private final StringProperty applicationTitle = new SimpleStringProperty("Cool App");
    private final SomeService    service;

    private SomePM currentPM;

    public RootPM(SomeService service) {
        this.service = service;

        long id = new Random().nextInt(100) + 1;
        currentPM = SomePM.of(service.get(id));
    }

    public SomePM getCurrentPM() {
        return currentPM;
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
