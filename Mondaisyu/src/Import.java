import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

public class Import implements ServiceInterface {
	//	private static String dir = "";
	//	private static String fileName = "";
	private String pathName = "";
	private String text = "";
	//	private HashSet<String> chapters = new HashSet<>();
	private ArrayList<String> wordsToSearch = new ArrayList<>();
	private ArrayList<String> textArray = new ArrayList<>();
	private String splitWord = "";
	private String choice = "";
	private ArrayList<String> questionsMade = new ArrayList<>();

	@Override
	public void startFunction() {
		System.out.println(Sentence.initImport);
		pathName = Display.input();
		try {
			//パスを基にファイルを読み込み
			fileImport();
			//切り出しを行う単語の指定
			System.out.println(Sentence.whichWords);
			splitWord = Display.input();
			//問題の作成
			ArrayList<String> test = this.makeQuestions();
			for(String sentence : test) {
				System.out.print(sentence);
			}
			//			System.out.println(textArray);
			//		C:\pleiades\workspace\Mondaisyu\航空法.txt

			/*//章分けするかしないか
//			System.out.println(Sentence.splitChapterOrNot);
//			this.choice = Display.input();
//			if(this.choice.equals("y")) {
//				//「第〇章」の行を取得してchaptersに代入し、それらの行を削除
//				for(String sentence: this.textArray) {
//					if(sentence.matches("第.*?章　.*\n")) {
//						chapters.add(sentence);
//					}
////					if(sentence.contains("章")) {
////						System.out.print(sentence);
////					}
//				}
//			}else {
//				//「第〇章」の行とその下の改行を削除
//			}
//			System.out.println(chapters);*/
		}
		//		次の「第〇条」を見つけたら次のquestionに代入する
		//			if(this.choice.equals("y")) {
		//				for(String sentence: this.wordsToSearch) {
		//					System.out.println(sentence);
		//
		//				}
		//			}

		catch(PatternSyntaxException e) {
			e.printStackTrace();
			System.out.println(Sentence.genException);
			System.out.println("PatternSyntaxExceptionです");
			Main.divider();
			Main.main(null);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(Sentence.genException);
			System.out.println("FileNotFoundExceptionです");
			Main.divider();
			Main.main(null);
		}




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

	public void fileImport()throws FileNotFoundException {
		try {
			// 1.ファイルのパスを指定する
			File file = new File(this.pathName);

			// 2.ファイルが存在しない場合
			if (!file.exists()) {
				System.out.print("ファイルが存在しません。パスを再入力してください\n");
				Main.divider();
				System.out.println(Sentence.initImport);//再入力させ再度読み込み
				this.pathName = Display.input();
				fileImport();
			}
			// 3.FileReaderクラスとreadメソッドを使って1文字ずつ読み込み表示する
			FileReader fr = new FileReader(this.pathName);
			BufferedReader br = new BufferedReader(fr);
			String str;
			String textToInput = "";
			while ((str = br.readLine()) != null) {
				textToInput += str;
				this.textArray.add(str + "\n");//ArrayList<String>も用意
			}
			this.text = textToInput;//Stringで取得
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String[] splitText(String splitWord) throws IOException{
		String[] str = this.text.split(splitWord);
		return str;
	}
	public ArrayList<String> makeQuestions(){
		String question = "";
		for(int i = 0; i < textArray.size();) {
			String str = textArray.get(i);
			//「第〇条」で始まる文章を見つけたら質問文に書き加える
			//違うなら次の行の該当をチェックする
			if(i == textArray.size() - 1) {
				break;
			}
			if(str.matches("第.*条\\n")) {
				question += str;
				i++;
				str = textArray.get(i);
			}else {
				i++;
				continue;
			}
			if(i == textArray.size() - 1) {
				break;
			}
			//次の「第〇条」にぶつかるまで以下の文章を書き加える
			//ぶつかったらここまで作成したquestionをquestionsMadeにadd
			while(true) {
				if(!str.matches("第.*条\\n")) {
					question += str;
					i++;
					str = textArray.get(i);
				}else {
					questionsMade.add(question);
					question = textArray.get(i);
					i++;
					break;
				}
				if(i == textArray.size() - 1) {
					break;
				}
			}
			if(i == textArray.size() - 1) {
				break;
			}
		}
		return questionsMade;
	}
}