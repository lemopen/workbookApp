
public class MainLogic {
	//選択された機能の画面に遷移するメソッド
	public static String chooseFunction(String str) {
		String Function = "";
		switch(str) {
		case "1":
			Function = Sentence.initQuestions;
			break;
		case "2":
			Function =  Sentence.initSearch;
			break;
		case "3":
			Function =  Sentence.initImport;
			break;
		case "4":
			Function =  Sentence.initData;
			break;
		case "5":
			Function =  Sentence.initConfig;
			break;
		}
		return Function;
	}
	//格納されている問題数まで「第〇問」という表示を切り替えて出力するメソッド
	public static String whatQuestion() {
		for(int num : Questions) {
			System.out.println("第" + num + "問");
			//問題文を入れる
		}
	}

}
