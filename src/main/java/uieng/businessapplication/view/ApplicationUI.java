package uieng.businessapplication.view;

import com.dlsc.formsfx.view.renderer.FormRenderer;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import uieng.businessapplication.presentationmodel.RootPM;
import uieng.businessapplication.view.util.ViewMixin;

public class ApplicationUI extends VBox implements ViewMixin {
    private RootPM rootPM;

    private Header header;
    private Content content;
    private Footer footer;



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
        header = new Header(rootPM);
        content = new Content(rootPM);
        footer = new Footer(rootPM);
        /*
        idLabel   = new Label();
        nameField = new TextField();
        displayForm = new FormRenderer(rootPM.getFormsPM().getFormInstance());
        */
    }

    @Override
    public void layoutParts() {
        getChildren().addAll(header, content, footer);
        setSpacing(10);

        /*
        getChildren().addAll(idLabel, nameField);
        ScrollPane scrollPane = new ScrollPane(displayForm);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        
        setCenter(scrollPane);
        */
    }

    @Override
    public void setupBindings() {
        //idLabel.textProperty().bind(rootPM.getCurrentPM().idProperty().asString());
    
    }
}
