package uieng.businessapplication.presentationmodel;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import uieng.businessapplication.service.SomeDTO;

public class SomePM {

    private final LongProperty   id   = new SimpleLongProperty();
    private final StringProperty name = new SimpleStringProperty();

    public static SomePM of(SomeDTO someDTO) {
        SomePM pm = new SomePM();

        pm.setId(someDTO.getId());
        pm.setName(someDTO.getName());

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

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
