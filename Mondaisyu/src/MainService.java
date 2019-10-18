public class MainService {
	public static void main(String[] args) {
		//初期画面を表示して入力を受け取る
		System.out.println(Sentence.initAll);
		String input = Display.input();
//		Display.display(input);//出力確認用

		//改行して次の機能画面を表示
		slideScreen();
		Display.display(MainLogic.chooseFunction(input));
	}

	/* コンソール画面の出力を改行で見えなくするメソッド
	 * @throws  IOException
	 * @throws  InterruptedException
	 */
	public static void slideScreen() {
		for(int i = 0; i < 25; i++) {
			System.out.println();
		}
	}
}

