package uieng.businessapplication.view;

import javafx.geometry.Insets;
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
    }

    @Override
    public void layoutParts() {
        getChildren().addAll(header, content, footer);
    }

    @Override
    public void setupBindings() {
    
    }
}
