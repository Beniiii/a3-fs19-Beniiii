package uieng.businessapplication.view;

import javafx.scene.layout.HBox;
import uieng.businessapplication.presentationmodel.RootPM;
import uieng.businessapplication.view.util.ViewMixin;

public class Footer extends HBox implements ViewMixin {
    private RootPM rootPM;

    public Footer(RootPM rootPM) {
        this.rootPM = rootPM;
        init();
    }

    @Override
    public void initializeParts() {

    }

    @Override
    public void layoutParts() {

    }

    @Override
    public void setupBindings() {

    }
}
