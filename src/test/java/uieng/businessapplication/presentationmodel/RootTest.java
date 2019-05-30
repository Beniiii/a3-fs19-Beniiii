package uieng.businessapplication.presentationmodel;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uieng.businessapplication.service.PagingService;
import uieng.businessapplication.service.SongDTO;
import uieng.businessapplication.service.serviceimpl.SongServiceFileBased;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RootTest {
    @BeforeAll
    static void initJavaFX() {
        Platform.startup(() -> {
            //nothing to do
        });
        Platform.setImplicitExit(false);
    }


    public RootPM pm;

    @BeforeEach
    void setup() {
        PagingService<SongDTO> service = new SongServiceFileBased();
        pm = new RootPM(service);
    }

    @Test
    void testInitialization() {
        //given

        //when

        //then
        assertNotNull(pm.getFilteredSongs());
    }
}
