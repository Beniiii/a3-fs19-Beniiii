package uieng.businessapplication.service;

import org.junit.jupiter.api.Test;
import uieng.businessapplication.service.serviceimpl.SongServiceFileBased;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SongServiceTest {
    @Test
    void testTotalCount() {
        //given
        PagingService<SongDTO> service = new SongServiceFileBased();

        //when
        int count = service.getTotalCount();

        //then
        assertTrue(count > 2000);
    }
}
