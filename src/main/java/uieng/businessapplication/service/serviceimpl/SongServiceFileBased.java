package uieng.businessapplication.service.serviceimpl;

import uieng.businessapplication.presentationmodel.SongPM;
import uieng.businessapplication.service.Page;
import uieng.businessapplication.service.PagingService;
import uieng.businessapplication.service.SongDTO;
import uieng.businessapplication.service.SongService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class SongServiceFileBased implements PagingService<SongDTO> {
    private static final String FILE_NAME         = "/data/songs.csv";
    private static final String DELIMITER         = ";";
    private static final int    NUMBER_OF_COLUMNS = 35;
    private static final int    ID_COLUMN         = 24;

    /*
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
    */

    private String[] splitLine(String line) {
        return line.split(DELIMITER, NUMBER_OF_COLUMNS);
    }

    private int totalCount = -1;

    @Override
    public int getTotalCount() {
        if(totalCount == -1){
            try (BufferedReader reader = getReader(FILE_NAME)) {
                totalCount = (int) reader.lines()
                        .skip(1)
                        .count();
            } catch (IOException e) {
                throw new IllegalStateException("failed");
            }
        }
        return totalCount;
    }

    @Override
    public int getFilteredCount(String filter) {
        try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {
            return (int) streamOfLines.skip(1)
                    .filter(line -> contains(line, filter))
                    .count();
        }
    }

    @Override
    public Page<SongDTO> getPage(int start, int pageSize, String filter) {
        return null;
    }

    private boolean contains(String line, String filter){
        return filter == null || filter.isEmpty() || line.toLowerCase().contains(filter.toLowerCase());
    }

    private Stream<String> getStreamOfLines(String fileName) {
        try {
            return Files.lines(getPath(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private Path getPath(String fileName) {
        try {
            return Paths.get(getClass().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private BufferedReader getReader(String fileName) {
        return new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName), StandardCharsets.UTF_8));
    }
}