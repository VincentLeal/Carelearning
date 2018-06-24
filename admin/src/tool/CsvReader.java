package tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvReader {
    private Reader source;

    public List<String> getLines() throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(source)) {
            return getLines(bufferedReader).collect(Collectors.toList());
        }catch (IOException e){
            throw new IOException(e);
        }
    }

    private Stream<String> getLines(BufferedReader reader) {
        int headerLines = 1;

        return reader.lines().skip(headerLines);
    }
}
