package uieng.businessapplication.service.serviceimpl;

import uieng.businessapplication.service.Page;
import uieng.businessapplication.service.PagingService;
import uieng.businessapplication.service.SongDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SongServiceFileBased implements PagingService<SongDTO> {
    private static final String FILE_NAME         = "/data/songs.csv";
    private static final String DELIMITER         = ";";
    private static final int    NUMBER_OF_COLUMNS = 35;
    //private static final int    ID_COLUMN         = 24;

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
        List<SongDTO> items = getItems(start, pageSize, filter);
        return new Page<>(getFilteredCount(filter), getTotalCount(), start, items.size(), items);
    }

    private List<SongDTO> getItems(int start, int pageSize, String filter) {
        try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {
            return streamOfLines.skip(start + 1)
                    .filter(line -> contains(line, filter))
                    .map(s -> new SongDTO(s.split(DELIMITER, NUMBER_OF_COLUMNS)))
                    .limit(pageSize)
                    .collect(Collectors.toList());
        }
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
