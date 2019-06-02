package uieng.businessapplication.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import uieng.businessapplication.presentationmodel.RootPM;
import uieng.businessapplication.presentationmodel.util.PagingList;
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
        setMargin(lbCount, new Insets(0, 20, 10, 20));
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
        PagingList filteredSongs = rootPM.getFilteredSongs();

        lbCount.textProperty().bind(filteredSongs.filteredCountProperty().asString().concat(" / ").concat(filteredSongs.totalCountProperty()));
    }
}
