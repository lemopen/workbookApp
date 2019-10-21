import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Import implements ServiceInterface {
	//	private static String dir = "";
	//	private static String fileName = "";
	private String pathName = "";
	private String text = "";
	private ArrayList<String> wordsToSearch = new ArrayList<>();

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ArrayList<String> getWordsToSearch() {
		return wordsToSearch;
	}

	public void setWordsToSearch(ArrayList<String> wordsToSearch) {
		this.wordsToSearch = wordsToSearch;
	}

	@Override
	public void startFunction() {
		System.out.println(Sentence.initImport);
		setPathName(Display.input());
		fileImport();//パスを基にファイル読み込み
		System.out.println(this.text);

		//入力されたパスを最後の\マークでファイルパスとファイル名に分離
		//		int lastIndex = input.lastIndexOf("\\");
		//		Import.dir = input.substring(0,lastIndex);
		//		Import.fileName = input.substring(lastIndex + 1);

		//		//抜き出したい単語を指定してもらい、その単語を含む行をthis.textに代入
		//		System.out.println(Sentence.whichWords);
		//		String str = Display.input();
		//		wordsToSearch = (ArrayList<String>) Arrays.asList(str.split(","));
		//		System.out.println(wordsToSearch);

		//第1引数をパス、第2以降は可変長でString指定し、その単語を含む行を抜き出す

	}

	public void fileImport() {
		try {
			// 1.ファイルのパスを指定する
			File file = new File(this.pathName);

			// 2.ファイルが存在しない場合
			if (!file.exists()) {
				System.out.print("ファイルが存在しません。パスを再入力してください\n");
				Main.divider();
				System.out.println(Sentence.initImport);//再入力させ再度読み込み
				pathName = Display.input();
				fileImport();
			}
			// 3.FileReaderクラスとreadメソッドを使って1文字ずつ読み込み表示する
			FileReader fr = new FileReader(pathName);
			BufferedReader br = new BufferedReader(fr);
			String str;
			List<String> list = new ArrayList<>();
			while ((str = br.readLine()) != null) {
				list.add(str);
			}

			for(String str2 : list) {
				System.out.println(str2);
			}

			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//public String searchWords(String pathName, String ... searchString){
	//	String str = "";//検索した行の出力用
	//
	//	//パターン型ArrayListに検索単語をコンパイル、代入
	//	ArrayList<Pattern> patterns = new ArrayList<>();
	//	for(int i = 0; i < wordsToSearch.size(); i++) {
	//		patterns.add(Pattern.compile(wordsToSearch.get(i)));
	//	}
	//	//読み込んでstrに代入
	//	while ((this.text = br.readLine()) != null) {
	//		for(Pattern pattern : patterns) {
	//			Matcher m = pattern.matcher(text);
	//			if (m.find()){
	//				str += text + "\n";
	//			}
	//		}
	//	}
	//}
}