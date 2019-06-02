package uieng.businessapplication.view;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TableColumn;
import uieng.businessapplication.presentationmodel.RootPM;
import uieng.businessapplication.presentationmodel.SongPM;
import uieng.businessapplication.view.util.FHNWTableView;
import uieng.businessapplication.view.util.ViewMixin;

public class TableView extends FHNWTableView<SongPM> implements ViewMixin {
    private RootPM rootPM;

    private final StringProperty titleHead = new SimpleStringProperty();
    private final StringProperty albumHead = new SimpleStringProperty();
    private final StringProperty artistHead = new SimpleStringProperty();
    private final StringProperty durationHead = new SimpleStringProperty();
    private final StringProperty genreHead = new SimpleStringProperty();
    private final StringProperty hotnessHead = new SimpleStringProperty();
    
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
    

    public String getTitleHead() {
        return titleHead.get();
    }

    public StringProperty titleHeadProperty() {
        return titleHead;
    }

    public void setTitleHead(String titleHead) {
        this.titleHead.set(titleHead);
    }
    
    public String getAlbumHead() {
        return albumHead.get();
    }

    public StringProperty albumHeadProperty() {
        return albumHead;
    }

    public void setAlbumHead(String albumHead) {
        this.albumHead.set(albumHead);
    }
    
    public String getArtistHead() {
        return artistHead.get();
    }

    public StringProperty artistHeadProperty() {
        return artistHead;
    }

    public void setArtistHead(String artistHead) {
        this.artistHead.set(artistHead);
    }
    
    public String getDurationHead() {
        return durationHead.get();
    }

    public StringProperty durationHeadProperty() {
        return durationHead;
    }

    public void setDurationHead(String durationHead) {
        this.durationHead.set(durationHead);
    }
    
    public String getGenreHead() {
        return genreHead.get();
    }

    public StringProperty genreHeadProperty() {
        return genreHead;
    }

    public void setGenreHead(String genreHead) {
        this.genreHead.set(genreHead);
    }
    
    public String getHotnessHead() {
        return hotnessHead.get();
    }

    public StringProperty hotnessHeadProperty() {
        return hotnessHead;
    }

    public void setHotnessHead(String hotnessHead) {
        this.hotnessHead.set(hotnessHead);
    }
}
