package uieng.businessapplication.view;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import uieng.businessapplication.presentationmodel.RootPM;
import uieng.businessapplication.view.util.ViewMixin;

public class Header extends HBox implements ViewMixin {
    private RootPM rootPM;
    private TextField tfFilter;

    public Header(RootPM rootPM) {
        this.rootPM = rootPM;
        init();
    }


    @Override
    public void initializeParts() {
        tfFilter = new TextField();
    }

    @Override
    public void layoutParts() {
        getChildren().add(tfFilter);
    }

    @Override
    public void setupBindings() {
        tfFilter.textProperty().bindBidirectional(rootPM.filterProperty());
    }
}
