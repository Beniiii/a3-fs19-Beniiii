package uieng.businessapplication.view;

import javafx.scene.control.TableColumn;
import uieng.businessapplication.presentationmodel.RootPM;
import uieng.businessapplication.presentationmodel.SongPM;
import uieng.businessapplication.view.util.FHNWTableView;
import uieng.businessapplication.view.util.ViewMixin;

public class Content extends FHNWTableView<SongPM> implements ViewMixin {
    private RootPM rootPM;

    /*
    private FormRenderer displayForm;
    private Label idLabel;
    private TextField nameField;
*/
    public Content(RootPM rootPM) {
        super(rootPM.getFilteredSongs());

        this.rootPM = rootPM;
        init();
    }

    @Override
    public void initializeParts() {

        TableColumn<SongPM, String> titleCol = new TableColumn<>("Titel");
        titleCol.setCellValueFactory(cell -> cell.getValue().titleProperty());

        TableColumn<SongPM, String> albumCol = new TableColumn<>("Album");
        albumCol.setCellValueFactory(cell -> cell.getValue().albumProperty());

        TableColumn<SongPM, String> artistCol = new TableColumn<>("Artist");
        artistCol.setCellValueFactory(cell -> cell.getValue().artistProperty());

        TableColumn<SongPM, String> durationCol = new TableColumn<>("Duration");
        durationCol.setCellValueFactory(cell -> cell.getValue().durationProperty().asString());

        TableColumn<SongPM, String> genreCol = new TableColumn<>("Genre");
        genreCol.setCellValueFactory(cell -> cell.getValue().genreProperty());

        TableColumn<SongPM, String> hotnessCol = new TableColumn<>("Hotness");
        hotnessCol.setCellValueFactory(cell -> cell.getValue().hotnessProperty().asString());

        getColumns().addAll(titleCol, albumCol, artistCol, durationCol, genreCol, hotnessCol);
    }

    @Override
    public void layoutParts() {

    }

    @Override
    public void setupBindings() {
        itemsProperty().bind(rootPM.filteredSongsProperty());
    }
}
