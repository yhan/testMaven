import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestReadFile {
    @Test
    public void testRead() {
        ReadFile readFile = new ReadFile();
        try {
            var content = readFile.read("a.txt");
            Assertions.assertEquals("hello", content);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Path workingDir;

    @BeforeEach
    public void init() {
        this.workingDir = Path.of("", "src/test/resources");
    }

    @Test
    public void read() throws IOException {
        Path file = this.workingDir.resolve("test.file");
        String content = Files.readString(file);
        Assertions.assertEquals(content, "hello");
    }

//    @Test
//    public void readAsResource(){
//        String xml = new TextOf(
//                new ResourceOf("/com/example/abc.xml") // absolute path always!
//        ).asString();
//    }
}
