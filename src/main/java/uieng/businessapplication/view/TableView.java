package uieng.businessapplication.view;

import javafx.scene.control.TableColumn;
import uieng.businessapplication.presentationmodel.RootPM;
import uieng.businessapplication.presentationmodel.SongPM;
import uieng.businessapplication.view.util.FHNWTableView;
import uieng.businessapplication.view.util.ViewMixin;

public class TableView extends FHNWTableView<SongPM> implements ViewMixin {
    private RootPM rootPM;

    TableColumn<SongPM, String> titleCol;
    TableColumn<SongPM, String> albumCol;
    TableColumn<SongPM, String> artistCol;
    TableColumn<SongPM, String> durationCol;
    TableColumn<SongPM, String> genreCol;
    TableColumn<SongPM, String> hotnessCol;
    
    public TableView(RootPM rootPM) {
        super(rootPM.getFilteredSongs());

        this.rootPM = rootPM;
        init();
    }

    @Override
    public void initializeParts() {

        titleCol = new TableColumn<>();
        titleCol.setCellValueFactory(cell -> cell.getValue().titleProperty());

        albumCol = new TableColumn<>("Album");
        albumCol.setCellValueFactory(cell -> cell.getValue().albumProperty());

        artistCol = new TableColumn<>("Artist");
        artistCol.setCellValueFactory(cell -> cell.getValue().artistProperty());

        durationCol = new TableColumn<>("Duration");
        durationCol.setCellValueFactory(cell -> cell.getValue().durationProperty().asString());

        genreCol = new TableColumn<>("Genre");
        genreCol.setCellValueFactory(cell -> cell.getValue().genreProperty());

        hotnessCol = new TableColumn<>("Hotness");
        hotnessCol.setCellValueFactory(cell -> cell.getValue().hotnessProperty().asString());

        getColumns().addAll(titleCol, albumCol, artistCol, durationCol, genreCol, hotnessCol);
    }

    @Override
    public void layoutParts() {
    	titleCol.prefWidthProperty().bind(this.widthProperty().multiply(0.20));
    	albumCol.prefWidthProperty().bind(this.widthProperty().multiply(0.20));
    	artistCol.prefWidthProperty().bind(this.widthProperty().multiply(0.20));
    	durationCol.prefWidthProperty().bind(this.widthProperty().multiply(0.1));
    	genreCol.prefWidthProperty().bind(this.widthProperty().multiply(0.15));
    	hotnessCol.prefWidthProperty().bind(this.widthProperty().multiply(0.1));
    }
    
    @Override
    public void setupValueChangedListeners() {
    	getSelectionModel().selectedItemProperty().addListener((observable, oldSong, newSong) -> {
            rootPM.setSelectedSong(newSong);
        });
    }

    @Override
    public void setupBindings() {
    	titleCol.textProperty().bind(rootPM.getFormsPM().getFormInstance().getFields().get(0).labelProperty());
    	albumCol.textProperty().bind(rootPM.getFormsPM().getFormInstance().getFields().get(1).labelProperty());
    	artistCol.textProperty().bind(rootPM.getFormsPM().getFormInstance().getFields().get(2).labelProperty());
    	durationCol.textProperty().bind(rootPM.getFormsPM().getFormInstance().getFields().get(3).labelProperty());
    	genreCol.textProperty().bind(rootPM.getFormsPM().getFormInstance().getFields().get(4).labelProperty());
    	hotnessCol.textProperty().bind(rootPM.getFormsPM().getFormInstance().getFields().get(5).labelProperty());
    }
  
}
