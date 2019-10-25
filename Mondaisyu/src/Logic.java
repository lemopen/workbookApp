
public class Logic {
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
			Function =  Sentence.initDataControl;
			break;
		case "5":
			Function =  Sentence.initWeightConfig;
			break;
		}
		return Function;
	}
	public static boolean isRightAns(String input, String ans) {
		if(input.equals(ans)) {
			return true;
		}else {
			return false;
		}
	}
}