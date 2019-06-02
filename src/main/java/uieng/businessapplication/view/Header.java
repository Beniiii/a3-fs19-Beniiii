package uieng.businessapplication.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import uieng.businessapplication.presentationmodel.RootPM;
import uieng.businessapplication.view.util.ViewMixin;

public class Header extends HBox implements ViewMixin {
    private RootPM rootPM;
    private TextField tfFilter;
    private Button save;
    private Button reset;
    private Button languageDE;
    private Button languageEN;

    public Header(RootPM rootPM) {
        this.rootPM = rootPM;
        init();
    }


    @Override
    public void initializeParts() {
        tfFilter = new TextField();
        save = new Button("Save");
        reset = new Button("Reset");
        languageDE = new Button("\ue001");
        languageEN = new Button("\ue000");
    }

    @Override
    public void layoutParts() {
        getChildren().addAll(tfFilter, save, reset, languageDE, languageEN);
    }
    
    @Override
    public void setupEventHandlers() {
    	reset.setOnAction(event -> rootPM.getFormsPM().getFormInstance().reset());
        save.setOnAction(event -> rootPM.getFormsPM().getFormInstance().persist());

        languageDE.setOnAction(event -> {
            rootPM.getFormsPM().translate("DE");
            languageDE.setDisable(true);
            languageEN.setDisable(false);
        });

        languageEN.setOnAction(event -> {
        	rootPM.getFormsPM().translate("EN");
            languageEN.setDisable(true);
            languageDE.setDisable(false);
        });
    }

    @Override
    public void setupBindings() {
        tfFilter.textProperty().bindBidirectional(rootPM.filterProperty());
        save.disableProperty().bind(rootPM.getFormsPM().getFormInstance().persistableProperty().not());
        reset.disableProperty().bind(rootPM.getFormsPM().getFormInstance().changedProperty().not());
    }
}
