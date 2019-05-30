package uieng.businessapplication.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongDTOTest {
    @Test
    void testConstructor(){
        //given

        String[] data = new String[]{
                "0.631289508",
                "AR03BDP1187FB5B324",
                "Britney Spears",
                "pop",
                "6",
                "0.282",
                "1.14876",
                "0.155",
                "0.06657",
                "223.52934",
                "0",
                "0.947327507",
                "10",
                "0.529",
                "34.05349",
                "Kentwood, LA; Los Angeles, CA",
                "-118.24532",
                "-5.304",
                "0",
                "0.498",
                "535192",
                "Oops!... I Did It Again",
                "ARX6TAQ11C8A415850",
                "0.650405808",
                "48",
                "214.698",
                "1",
                "0.06657",
                "111.004",
                "dance pop",
                "1",
                "4",
                "1",
                "Don't Go Knockin' On My Door",
                "2000"
        };

        //when
        SongDTO dto = new SongDTO(data);

        //then
        /*
        private final String id;
        private final String title;
        private final String album;
        private final String artist;
        private final double duration;
        private final String genre;
        private final double hotness;
        */

        assertAll("ctor",
                () -> assertEquals(48,                   dto.getId()),
                () -> assertEquals("Don't Go Knockin' On My Door",             dto.getTitle()),
                () -> assertEquals("Oops!... I Did It Again",                   dto.getAlbum()),
                () -> assertEquals("Britney Spears",   dto.getArtist()),
                () -> assertEquals(223.52934,            dto.getDuration()),
                () -> assertEquals("dance pop",            dto.getGenre()),
                () -> assertEquals(0.650405808,            dto.getHotness())
        );
    }
}
