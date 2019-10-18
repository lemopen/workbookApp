import java.io.IOException;
public class cls {
	public class CLS {
		public static void clearScreen throws IOException, InterruptedException {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
	}
}
