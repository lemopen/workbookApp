import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class Quiz implements ServiceInterface {
	private String pathName = "";
	private ArrayList<String> textArray = new ArrayList<>();
	private String splitWord = "";
	private ArrayList<String> questionsMade = new ArrayList<>();

	/**
	 * 問題取得メソッド
	 * */
	public ArrayList<String> getQuestionList(String filePath) throws FileNotFoundException {
		// 問題を一覧を取得して返却
		return FileUser.textToArrayList(filePath);
	}

	public ArrayList<String> getQuestionsMade() {
		return questionsMade;
	}

	public void setQuestionsMade(ArrayList<String> questionsMade) {
		this.questionsMade = questionsMade;
	}

	public void startFunction() {
		//パス入力
		System.out.println(Sentence.initImport);
		pathName = Display.input();

		try {
			//パスを基にテキストを読み込み行ごとArrayListへ


			textArray = addString(textArray);
			Sentence.divider;
			//切り出しを行う単語の指定
			System.out.println(Sentence.whichWord);
			splitWord = FileUser.checkInput(Display.input());

			//問題を作成する
			ArrayList<String> exercise = makeQuestions(splitWord, textArray);

			//必要なら文章を出力して確認
			System.out.println(Sentence.checkQuestions);
			String choice = FileUser.checkInput(Display.input());
			while (true) {
				if (choice.equals("y")) {
					for (String sentence : exercise) {
						System.out.print(sentence);
					}
					break;
				} else if (choice.equals("n")) {
					break;
				} else {
					choice = FileUser.checkInput(Display.input());
				}
			}
		} catch (PatternSyntaxException e) {
			e.printStackTrace();
			System.out.println(Sentence.genException);
			System.out.println("PatternSyntaxExceptionです");
			Main.divider();
			Main.main(null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(Sentence.genException);
			System.out.println("FileNotFoundExceptionです");
			Main.divider();
			Main.main(null);
		}
	}

	public ArrayList<String> addString(ArrayList<String> input) {
		ArrayList<String> strArray = new ArrayList<>();
		String str = "";
		int count = 0;
		for (int i = 0; i < input.size(); i++) {
			str = textArray.get(i).trim().replace("　", "");
			switch (i % 7) {
			case 0:
				str = "問" + (count + 1) + "　" + str + "\n";
				count++;
				break;
			case 1:
				str = "\t1:" + str + "\n";
				break;
			case 2:
				str = "\t2:" + str + "\n";
				break;
			case 3:
				str = "\t3:" + str + "\n";
				break;
			case 4:
				str = "\t4:" + str + "\n";
				break;
			case 5:
				str += "\n";
				break;
			default:
				str = "\n";
			}
			if (str.matches("")) {
				System.out.println();
			}
			strArray.add(str);
		}
		return strArray;
	}

	//文章をを正規表現に従って切り分けるメソッド
	public ArrayList<String> makeQuestions(String searchString, ArrayList<String> textForQuestions) {
		String sentence = "";
		for (int i = 0; i < textForQuestions.size();) {
			String str = textForQuestions.get(i);
			//指定した正規表現で始まる文章を見つけたら質問文に書き加える
			//違うなら次の行の該当をチェックする
			if (str.matches(searchString)) {
				sentence += str;
				i++;
				str = textForQuestions.get(i);
			}
			if (i == textForQuestions.size() - 1) {
				break;
			}
			//指定した正規表現にぶつかるまでに読み込んだ文章を書き加える
			//ぶつかったらここまで作成したquestionをquestionsMadeにadd
			while (true) {
				if (!str.matches(searchString)) {
					sentence += str;
					i++;
					str = textForQuestions.get(i);
				} else {
					questionsMade.add(sentence);
					break;
				}
				if (i == textArray.size() - 1) {
					break;
				}
			}
			if (i == textArray.size() - 1) {
				break;
			}
		}
		this.setQuestionsMade(questionsMade);
		return questionsMade;
	}

	@Override
	public void endFunction() {
		// TODO 自動生成されたメソッド・スタブ

	}
}