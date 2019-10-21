public class Main {
	public static void main(String[] args) {
		//初期画面を表示して入力を受け取る
		String input = "";
		while(true) {
			System.out.println(Sentence.initAll);
			Form.setInput(Display.input());
			input = Form.getInput();
			if(input.matches("[1-5]")){ //該当する入力があれば抜ける
				break;
			} else {
				divider();				//該当しない入力がある限り、区切り線を入れて再入力させる
				System.out.println(Sentence.initAll);
				Form.setInput(Display.input());
			}
		}
		//		Display.display(Form.getInput());//出力確認用

		//区切り線を表示
		divider();
		//選択された機能の画面を表示
		ServiceInterface function = getFunctionInstance(input);
		function.startFunction();
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
	public static void divider() {
		System.out.println("----------------------------------------------------------------");
	}
	private static ServiceInterface getFunctionInstance(String str) {
		switch(str) {
		case "1":
			return new Questions();
		case "2":
			return new Search();
		case "3":
			return new Import();
		case "4":
			return new DataControl();
		case "5":
			return new WeightConfig();
		default:
			return null;
		}
	}
}