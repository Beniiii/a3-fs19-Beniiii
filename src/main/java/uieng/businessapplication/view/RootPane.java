package uieng.businessapplication.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import uieng.businessapplication.presentationmodel.RootPM;
import uieng.businessapplication.view.util.ViewMixin;

public class RootPane extends VBox implements ViewMixin {
    private RootPM rootPM;

    private Label     idLabel;
    private TextField nameField;

    public RootPane(RootPM rootPM) {
        this.rootPM = rootPM;
        init();
    }

    @Override
    public void initializeSelf() {
        addStylesheetFiles("/fonts/fonts.css", "style.css");
        getStyleClass().add("root-pane");
    }

    @Override
    public void initializeParts() {
        idLabel   = new Label();
        nameField = new TextField();
    }

    @Override
    public void layoutParts() {
        getChildren().addAll(idLabel, nameField);
    }

    @Override
    public void setupBindings() {
        idLabel.textProperty().bind(rootPM.getCurrentPM().idProperty().asString());
        nameField.textProperty().bindBidirectional(rootPM.getCurrentPM().nameProperty() );
    }
}
