package uieng.businessapplication.view;

import com.dlsc.formsfx.view.renderer.FormRenderer;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import uieng.businessapplication.presentationmodel.RootPM;
import uieng.businessapplication.view.util.ViewMixin;

public class ApplicationUI extends BorderPane implements ViewMixin {
    private RootPM rootPM;
    private FormRenderer displayForm;

    private Label     idLabel;
    private TextField nameField;

    public ApplicationUI(RootPM rootPM) {
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
        displayForm = new FormRenderer(rootPM.getFormsPM().getFormInstance());
    }

    @Override
    public void layoutParts() {
        getChildren().addAll(idLabel, nameField);
        ScrollPane scrollPane = new ScrollPane(displayForm);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        
        setCenter(scrollPane);
    }

    @Override
    public void setupBindings() {
        idLabel.textProperty().bind(rootPM.getCurrentPM().idProperty().asString());
    
    }
}
