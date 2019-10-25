import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Quiz {
	/**
	 * 問題取得メソッド
	 **/
	public ArrayList<String> getQuestionList(String filePath){
		// 問題を一覧を取得して返却
		try {
			return QuizDao.textToArrayList(filePath);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 受け取ったファイル名の拡張子を除去して返すメソッド
	 * */
	public String removeExtension(String filePath) {
		String str;
		int last = filePath.lastIndexOf(".");
		str = filePath.substring(0,last);
		return str;
	}
	public String getExtension(String filePath) {
		String str;
		int last = filePath.lastIndexOf(".");
		str = filePath.substring(last);
		return str;
	}

	/**
	 * 問題の空白を除去し、文言を付与して成形するメソッド
	 * @param list
	 * @return
	 */
	public ArrayList<String> addStringAndTrim(List<String> list) {
		ArrayList<String> strArray = new ArrayList<>();
		String str = "";
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			str = list.get(i).trim().replace("　", "").replace("\n", "");
			switch (i % 7) {
			case 0:
				str = "問" + (count + 1) + "　" + str;
				count++;
				break;
			case 1:
				str = "\t1:" + str;
				break;
			case 2:
				str = "\t2:" + str;
				break;
			case 3:
				str = "\t3:" + str;
				break;
			case 4:
				str = "\t4:" + str;
				break;
			}
			strArray.add(str);
		}
		return strArray;
	}

	/**
	 * 文章を正規表現に従って切り分けるメソッド
	 * @param searchString
	 * @param textForQuestions
	 * @return
	 */
	public ArrayList<String> makeQuestions(String input, List<String> list) {
		ArrayList<String> questions = new ArrayList<>();
		for (int i = 0; i < list.size();) {
			String sentence = "";
			String str = list.get(i);

			//指定した正規表現で始まる文章を見つけたら質問文に書き加える
			//違うなら次の行の該当をチェックする
			if (str.matches(input)) {
				sentence += str + "\n";
				i++;
				str = list.get(i);
			}
			if (i == list.size() - 1) {
				break;
			}
			//指定した正規表現にぶつかるまでに読み込んだ文章を書き加える
			//ぶつかったらここまで作成したquestionをquestionsMadeにadd
			while (true) {
				if (!str.matches(input) && str != "") {
					sentence += str + "\n";
					i++;
					str = list.get(i);
				}else{
					questions.add(sentence);
					break;
				}
				if (i == list.size() - 1) {
					break;
				}
			}
			if (i == list.size() - 1) {
				break;
			}
		}
		return questions;
	}
}