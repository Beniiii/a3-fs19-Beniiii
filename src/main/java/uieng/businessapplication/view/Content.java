package uieng.businessapplication.view;

import com.dlsc.formsfx.view.renderer.FormRenderer;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    }

    @Override
    public void layoutParts() {

    }

    @Override
    public void setupBindings() {

    }
}
