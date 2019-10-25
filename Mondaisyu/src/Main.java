import java.util.ArrayList;
import java.util.List;

public class Main {
	private static String input;
	private static ArrayList<String> arr = new ArrayList<>();
	private static ArrayList<String> a = new ArrayList<>();

	public static void main(String[] args) {
		//まずはクイズ機能を立ち上げる
		Quiz q = new Quiz();
		imp.startFunction();
		while (true) {
			ServiceInterface function = getFunctionInstance(input);
			if (count == 0) {
				mainimp = function.startFunction();
				count++;
			} //2週目以降は選択された機能を開始
			else {
				chooseFunction();
				function.startFunction();
			}
			divider();
			//機能終了、続行するか確認
			System.out.println(Sentence.confirmEndAll);
			input = FileUser.checkInput(Display.input());
			if (input.equals("n")) {
				break;
			}
			divider();
		}
	}

	/* コンソール画面の出力をクリアするメソッド
	 * @throws  IOException
	 * @throws  InterruptedException
	 */
	//	public static void clearConsole() throws IOException, InterruptedException {
	//		// 2秒停止
	//		//Thread.sleep(2000);
	//		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	//		for(int i = 0 ; i < 15 ; i++){
	//			System.out.println();
	//		}
	//	}
	//改行メソッド
	public static void chooseFunction() {
		while (true) {
			System.out.println(Sentence.initAll);
			input = FileUser.checkInput(Display.input());
			if (input.matches("[1-5]")) {
				divider();
				break;
			} else {
				System.out.println(Sentence.invalidInput);
				divider();
			}
		}
	}

	public static void passArrayList(ArrayList<String> input) {

	}

	private static ServiceInterface getFunctionInstance(String str) {
		switch (str) {
		case "1":
			return new Exercise();
		case "2":
			return new Search();
		case "3":
			return new Quiz();
		case "4":
			return new DataControl();
		case "5":
			return new WeightConfig();
		default:
			return null;
		}
	}

	public static void main(String[] args) {
		// クイズインスタンス取得
		Quiz qu = new Quiz();
		List<String> list = null;
		while (true) {
			// 読込ファイルパス入力
			System.out.println(Sentence.initImport);
			String filePath = Display.input();
			list = qu.getQuestionList(filePath);
			if(list == null) {
				System.out.println("ファイルが存在しません。再入力してください");
				System.out.println(Sentence.divider);
				System.out.println(Sentence.initImport);//再入力させ再度読み込み
				continue;
			}
		}


		// 問題表示
		for (String str : list) {
			System.out.println(str);
			// 回答入力
			String input = Display.input();
			// 回答の正誤判定呼び出し

			// 判定結果取得力
		}
	}
}