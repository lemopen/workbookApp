import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUser {
	//空文字が入る限り正しい入力を要求するメソッド
	public static String checkInput(String input) {
		while(true) {
			if(!input.equals("")) {
				break;
			}
			System.out.println(Sentence.invalidInput);
			input = Display.input();
		}
		return input;
	}

	public static String checkInput(String input, String sentence) {
		while(true) {
			if(!input.equals("")) {
				break;
			}
			System.out.println(Sentence.invalidInput);
			System.out.println(sentence);
			input = Display.input();
		}
		return input;
	}
	public static void exportText(String dir, String fileName,  ArrayList<String> textArray) {
        try {
            FileWriter fw = new FileWriter(dir + fileName);
            for(String text : textArray) {
                fw.write(text);
            }
            fw.close();
        } catch (IOException ex) {
        	System.out.println("書き込み時に問題が発生しました");
            ex.printStackTrace();
        }
    }
}