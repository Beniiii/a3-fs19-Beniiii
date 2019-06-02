package uieng.businessapplication.view;

import com.dlsc.formsfx.view.renderer.FormRenderer;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import uieng.businessapplication.presentationmodel.RootPM;
import uieng.businessapplication.view.util.ViewMixin;

public class Content extends VBox implements ViewMixin {
    private RootPM rootPM;
    private TableView tableView;
    private FormRenderer displayForm;

    public Content(RootPM rootPM) {
        this.rootPM = rootPM;
        init();
    }


    @Override
    public void initializeParts() {
        tableView = new TableView(rootPM);
        displayForm = new FormRenderer(rootPM.getFormsPM().getFormInstance());
    }

    @Override
    public void layoutParts() {
        getChildren().addAll(displayForm, tableView);
        setMargin(tableView, new Insets(0, 20, 10, 20));
    }

    @Override
    public void setupBindings() {
    	
    }
}
