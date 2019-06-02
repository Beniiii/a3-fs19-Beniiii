package uieng.businessapplication.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
    public void initializeSelf() {
        getStyleClass().add("tool-bar");
    }

    @Override
    public void initializeParts() {
        tfFilter = new TextField();

        save = new Button("\uf0c7");
        save.getStyleClass().add("fontawesome");

        reset = new Button("\uf0e2");
        reset.getStyleClass().add("fontawesome");

        languageDE = new Button("\ue001");
        languageDE.getStyleClass().add("flaticon");

        languageEN = new Button("\ue000");
        languageEN.getStyleClass().add("flaticon");
    }

    @Override
    public void layoutParts() {
        HBox spacer = new HBox();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        setMargin(spacer, new Insets(0, 20, 10, 20));
        setMargin(tfFilter, new Insets(2, 10, 0, 15));
        setMargin(languageEN, new Insets(2, 10, 0, 0));
        getChildren().addAll(tfFilter, save, reset, spacer, languageDE, languageEN);
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
