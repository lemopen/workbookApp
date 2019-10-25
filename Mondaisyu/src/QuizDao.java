import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuizDao {
	public static ArrayList<String> textToArrayList(String pathName) throws IOException {
		// 1.ファイルのパスを指定する
		File file = new File(pathName);

		// 2.ファイルが存在しない場合
		if (!file.exists()) {
			return null;

		}
		// 3.FileReaderクラスとreadメソッドを使って1文字ずつ読み込み表示する
		FileReader fr = new FileReader(pathName);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> strArray = new ArrayList<>();
		String str = "";
		while ((str = br.readLine()) != null) {
			strArray.add(str + "\n");//ArrayList<String>も用意
		}
		fr.close();
		return strArray;
	}
}
