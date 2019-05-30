package uieng.businessapplication.service.serviceimpl;

import uieng.businessapplication.service.SongDTO;
import uieng.businessapplication.service.SongService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;

public class SongServiceImpl implements SongService {
    private static final String FILE_NAME         = "/data/songs.csv";
    private static final String DELIMITER         = ";";
    private static final int    NUMBER_OF_COLUMNS = 35;
    private static final int    ID_COLUMN         = 0;

    @Override
    public SongDTO get(long id) {
        //return new SongDTO(String.valueOf(id), "dto-" + id);
        try (BufferedReader reader = getReader(FILE_NAME)) {
            return reader.lines()
                    .skip(1)
                    .map(line -> splitLine(line))
                    .filter(data -> data[ID_COLUMN].equals(Long.toString(id)))
                    .map(SongDTO::new)
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
        } catch (IOException e) {
            throw new IllegalStateException("failed");
        }
    }


    private BufferedReader getReader(String fileName) {
        return new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName), StandardCharsets.UTF_8));
    }

    private String[] splitLine(String line) {
        return line.split(DELIMITER, NUMBER_OF_COLUMNS);
    }
}
