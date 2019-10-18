public class MainService {
	public static void main(String[] args) {
		//初期画面を表示して入力を受け取る

		while(true) {
			System.out.println(Sentence.initAll);
			Form.setInput(Display.input());
			if(Form.getInput().matches("[1-5]")){
				break;
			}
		}
		//		NoSuchElementExceptionがかいひできない

		//		Display.display(Form.getInput());//出力確認用

		//選択された機能の画面表示
		divider();
		Display.display(MainLogic.chooseFunction(Form.getInput()));
		//		Display.display(startFunction());
	}

	/* コンソール画面の出力を改行で見えなくするメソッド
	 * @throws  IOException
	 * @throws  InterruptedException
	 */
	public static void divider() {
		System.out.println("----------------------------------------------------------------");
	}
	interface Function{
		public void startFunction();
	}
}