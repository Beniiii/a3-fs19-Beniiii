package uieng.businessapplication;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import uieng.businessapplication.presentationmodel.RootPM;

import uieng.businessapplication.service.PagingService;
import uieng.businessapplication.service.SongDTO;
import uieng.businessapplication.service.serviceimpl.SongServiceFileBased;
import uieng.businessapplication.view.ApplicationUI;

public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage){
        //PagingService<SongDTO> service   = new SongServiceFileBased();
        PagingService<SongDTO> service = new SongServiceFileBased();

        RootPM      pm        = new RootPM(service);
        Parent      rootPanel = new ApplicationUI(pm);

        Scene scene = new Scene(rootPanel);

        primaryStage.titleProperty().bind(pm.getFormsPM().getFormInstance().titleProperty());

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
