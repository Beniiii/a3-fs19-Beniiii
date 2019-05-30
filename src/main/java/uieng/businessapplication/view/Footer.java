package uieng.businessapplication.view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import uieng.businessapplication.presentationmodel.RootPM;
import uieng.businessapplication.view.util.ViewMixin;

public class Footer extends HBox implements ViewMixin {
    private RootPM rootPM;

    private Label lbCount;

    public Footer(RootPM rootPM) {
        this.rootPM = rootPM;
        init();
    }

    @Override
    public void initializeParts() {
        lbCount = new Label();
    }

    @Override
    public void layoutParts() {
        getChildren().add(lbCount);
    }

    @Override
    public void setupValueChangedListeners() {
        rootPM.filteredSongsProperty().addListener((observable, oldValue, newValue) -> {
            lbCount.textProperty().bind(newValue.filteredCountProperty().asString()
                    .concat(" / ")
                    .concat(newValue.totalCountProperty()));

        });
    }

    @Override
    public void setupBindings() {

    }
}
