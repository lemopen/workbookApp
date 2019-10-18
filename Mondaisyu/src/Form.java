import java.util.ArrayList;

public class Form {
	private static String input = "";
	private static ArrayList<String> lines = new ArrayList<String>();
	public static String getInput() {
		return input;
	}
	public static void setInput(String input) {
		Form.input = input;
	}
//	public static void eraseInput() {
//		Form.input = "";
//	}
	public static ArrayList<String> getLines() {
		return lines;
	}
	public static void setLines(ArrayList<String> lines) {
		Form.lines = lines;
	}
}
