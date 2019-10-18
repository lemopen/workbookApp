import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class ReadFile {
	private String dir = "../";
    private String filename = "航空法.xml";
	Form.lines = Files.readAllLines(Paths.get(dir, filename),
    		Charset.forName("UTF-8"));
}
