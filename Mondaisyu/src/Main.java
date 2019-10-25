import java.util.List;

public class Main {
	public static void main(String[] args) {
		//クイズインスタンス取得
		Quiz qu = new Quiz();
		List<String> list = null;
		String filePath;
		while (true) {
			// 読込ファイルパス入力
			System.out.println(Sentence.initImport);
			filePath = Display.input();
			list = qu.getQuestionList(filePath);
			if(list == null) {
				System.out.println("ファイルが見つかりません。パスを再入力してください");
				System.out.println(Sentence.divider);
			}else {
				break;
			}
		}
		System.out.println(Sentence.divider);

		//問題に「第〇問」などの文言を付加・空白を除去
		list = qu.addStringAndTrim(list);
		//正規表現に従って分割
		//問\d*.*
		String splitWord;
		while(true) {
			System.out.println(Sentence.whichWord);
			splitWord = Display.input();
			if(splitWord != "") {
				break;
			}
		}
		System.out.println(Sentence.divider);

		//問題を準備
		list = qu.makeQuestions(splitWord, list);
		//解答を準備し、各行を半角数字だけ（答えだけ）にする
		String ansFilePath = qu.removeExtension(filePath) + "ans" + qu.getExtension(filePath);
		List<String> anslist = qu.getQuestionList(ansFilePath);

		//問題表示
		for (int i = 0; i < list.size(); i++) {
			//問題
			System.out.println(list.get(i));
			//対応する解答の読み込み
			String ans = anslist.get(i).trim().replace("　", "").replaceAll("\\D*", "");
			// 回答入力
			System.out.println(Sentence.putAnswer);
			String input= Display.input();
			// 正誤判定呼び出し
			Boolean flag =  Logic.isRightAns(input, ans);
			// 判定結果を出力、間を空ける
			if(flag) {
				System.out.println(Sentence.divider);
				System.out.println(Sentence.rightAns);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println(Sentence.divider);
				System.out.println(Sentence.wrongAns);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		//「全問終了しました」
		System.out.println(Sentence.questionsComp);
	}
}