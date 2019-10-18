
public class MainLogic {
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

}
