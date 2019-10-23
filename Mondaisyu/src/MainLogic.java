
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
			Function =  Sentence.initDataControl;
			break;
		case "5":
			Function =  Sentence.initWeightConfig;
			break;
		}
		return Function;
	}
	/** 文字列の中は、すべて漢数字であること。 */
	public static int convert(String str) {
		int ひと桁 = 1;
		int 四桁 = 0;
		int 答え = 0;
		for (int i=0; i<str.length(); i++) {
			switch (str.charAt(i)) {
			case '一':	ひと桁 = 1;	break;
			case '二':	ひと桁 = 2;	break;
			case '三':	ひと桁 = 3;	break;
			case '四':	ひと桁 = 4;	break;
			case '五':	ひと桁 = 5;	break;
			case '六':	ひと桁 = 6;	break;
			case '七':	ひと桁 = 7;	break;
			case '八':	ひと桁 = 8;	break;
			case '九':	ひと桁 = 9;	break;
			case '十':	四桁 += (ひと桁!=0?ひと桁:1) * 10;	ひと桁 = 0;	break;
			case '百':	四桁 += (ひと桁!=0?ひと桁:1) * 100;	ひと桁 = 0;	break;
			case '千':	四桁 += (ひと桁!=0?ひと桁:1) * 1000;	ひと桁 = 0;	break;
			case '万':	答え += (四桁!=0?四桁:1)*10000; 四桁 = 0;	ひと桁 = 0;	break;
			case '億':	答え += (四桁!=0?四桁:1)*100000000; 四桁 = 0;	ひと桁 = 0;	break;
			default:	System.out.println("??? "+str.charAt(i));
			}
		}
		return 答え + 四桁 + ひと桁;
	}
}
