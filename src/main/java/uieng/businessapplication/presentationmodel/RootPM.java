package uieng.businessapplication.presentationmodel;

import java.time.Duration;
import java.util.function.Function;

import javafx.beans.property.*;

import uieng.businessapplication.presentationmodel.util.PagingList;
import uieng.businessapplication.presentationmodel.util.TaskBatcher;
import uieng.businessapplication.service.PagingService;
import uieng.businessapplication.service.SongDTO;

public class RootPM {
	
	private FormsPM formsPM;
    private SongPM songProxy;
    
    private final StringProperty applicationTitle = new SimpleStringProperty();
    //private final SongService    service;
    private static final Function<Integer, SongPM> fSong = index -> new SongPM();
    private final StringProperty filter = new SimpleStringProperty();
    private final IntegerProperty filteredCount = new SimpleIntegerProperty();
    private final IntegerProperty totalCount = new SimpleIntegerProperty();
    private final ObjectProperty<PagingList<SongPM, SongDTO>> filteredSongs = new SimpleObjectProperty<>();
    private final ObjectProperty<SongPM> selectedSong = new SimpleObjectProperty<>();


    private final TaskBatcher taskBatcher = new TaskBatcher(Duration.ofMillis(250));
    
    public RootPM(PagingService<SongDTO> service) {
    	songProxy = new SongPM();
    	selectedSongProperty().addListener((observable, oldSong, newSong) -> {
    		if(oldSong != null) {
    			unbindFromProxy(oldSong);
    		}
    		if (newSong != null) {
    	    	bindToProxy(newSong);
    	    }
    	});
    	
    	selectedSong.set(new SongPM());;
    	
        formsPM = new FormsPM(songProxy);
        
        setFilteredSongs(new PagingList<>(service, index -> new SongPM(), null));

        filter.addListener((observable, oldValue, newValue) ->
                taskBatcher.batch(() -> setFilteredSongs(new PagingList<>(service, fSong, newValue))));
        
    }
    
    
    private void unbindFromProxy(SongPM oldSong) {
    	songProxy.idProperty().unbindBidirectional(oldSong.idProperty());
    	songProxy.titleProperty().unbindBidirectional(oldSong.titleProperty());
    	songProxy.albumProperty().unbindBidirectional(oldSong.albumProperty());
    	songProxy.artistProperty().unbindBidirectional(oldSong.artistProperty());
    	songProxy.durationProperty().unbindBidirectional(oldSong.durationProperty());
    	songProxy.genreProperty().unbindBidirectional(oldSong.genreProperty());
    	songProxy.hotnessProperty().unbindBidirectional(oldSong.hotnessProperty());
    }

    private void bindToProxy(SongPM newSong) {
    	songProxy.idProperty().bindBidirectional(newSong.idProperty());
   	 	songProxy.titleProperty().bindBidirectional(newSong.titleProperty());
   	 	songProxy.albumProperty().bindBidirectional(newSong.albumProperty());
   	 	songProxy.artistProperty().bindBidirectional(newSong.artistProperty());
   	 	songProxy.durationProperty().bindBidirectional(newSong.durationProperty());
   	 	songProxy.genreProperty().bindBidirectional(newSong.genreProperty());
   	 	songProxy.hotnessProperty().bindBidirectional(newSong.hotnessProperty());
    }

  
//    public SongPM getCurrentPM() {
//        return currentPM;
//    }
    
    public FormsPM getFormsPM() {
        return formsPM;
    }


    // alle Getter und Setter
    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle.set(applicationTitle);
    }

    public PagingList<SongPM, SongDTO> getFilteredSongs() {
        return filteredSongs.get();
    }

    public ObjectProperty<PagingList<SongPM, SongDTO>> filteredSongsProperty() {
        return filteredSongs;
    }

    public void setFilteredSongs(PagingList<SongPM, SongDTO> filteredSongs) {
        this.filteredSongs.set(filteredSongs);
    }

    public String getFilter() {
        return filter.get();
    }

    public StringProperty filterProperty() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter.set(filter);
    }

    public int getFilteredCount() {
        return filteredCount.get();
    }

    public IntegerProperty filteredCountProperty() {
        return filteredCount;
    }

    public void setFilteredCount(int filteredCount) {
        this.filteredCount.set(filteredCount);
    }

    public int getTotalCount() {
        return totalCount.get();
    }

    public IntegerProperty totalCountProperty() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount.set(totalCount);
    }
    
    public SongPM getSelectedSong() {
        return selectedSong.get();
    }

    public ObjectProperty<SongPM> selectedSongProperty() {
        return selectedSong;
    }

    public void setSelectedSong(SongPM selectedSong) {
        this.selectedSong.set(selectedSong);
    }


}
