import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

public class Import implements ServiceInterface {
	private static String dir = "";
	private static String fileName = "";
	private String pathName = "";
	//	private HashSet<String> chapters = new HashSet<>();
	private ArrayList<String> textArray = new ArrayList<>();
	private String splitWord = "";
	private ArrayList<String> questionsMade = new ArrayList<>();

	@Override
	public void startFunction() {
		//パス入力
		System.out.println(Sentence.initImport);
		pathName = Display.input();

//		//入力されたパスを最後の\マークでファイルパスとファイル名に分離
//		int lastIndex = pathName.lastIndexOf("\\");
//		dir = pathName.substring(0,lastIndex);
//		fileName = pathName.substring(lastIndex + 1);

		try {
			//パスを基にテキストを読み込み行ごとArrayListへ
			textArray = FileUser.textToArrayList(pathName);
			//		C:\pleiades\workspace\Mondaisyu\航空法.txt

			//切り出しを行う単語の指定
			System.out.println(Sentence.whichWord);
			splitWord = FileUser.checkInput(Display.input());

			//問題の作成
			ArrayList<String> exercise = makeQuestions(splitWord, textArray);
			//第.*章　.*\n
			//第.*条\n

			//ディレクトリパス、ファイル名の入力、ファイルへの出力
			System.out.println(Sentence.putExportDir);
			dir = FileUser.checkInput(Display.input());
			System.out.println(Sentence.putExportFileName);
			fileName = FileUser.checkInput(Display.input());
			FileUser.exportText(dir, fileName, exercise);

//			for(String sentence : exercise) {
//				System.out.print(sentence);
//			}
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

		//		次の「第〇条」を見つけたら次のquestionに代入する
		//			if(this.choice.equals("y")) {
		//				for(String sentence: this.wordsToSearch) {
		//					System.out.println(sentence);
		//
		//				}
		//			}
		}catch(PatternSyntaxException e) {
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


		//		//抜き出したい単語を指定してもらい、その単語を含む行をthis.textに代入
		//		System.out.println(Sentence.whichWords);
		//		String str = Display.input();
		//		wordsToSearch = (ArrayList<String>) Arrays.asList(str.split(","));
		//		System.out.println(wordsToSearch);

		//第1引数をパス、第2以降は可変長でString指定し、その単語を含む行を抜き出す
	}

	//文章をを正規表現に従って切り分けるメソッド
	public ArrayList<String> makeQuestions(String searchString, ArrayList<String> textForQuestions){
		String oneString = "";
		for(int i = 0; i < textForQuestions.size();) {
			String str = textForQuestions.get(i);
			//「第〇条」で始まる文章を見つけたら質問文に書き加える
			//違うなら次の行の該当をチェックする
			if(str.matches(searchString)) {
				oneString += str;
				i++;
				str = textForQuestions.get(i);
			}
			if(i == textForQuestions.size() - 1) {
				break;
			}
			//次の「第〇条」にぶつかるまで以下の文章を書き加える
			//ぶつかったらここまで作成したquestionをquestionsMadeにadd
			while(true) {
				if(!str.matches(searchString)) {
					oneString += str;
					i++;
					str = textForQuestions.get(i);
				}else {
					questionsMade.add(oneString);
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