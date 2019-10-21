
public class TestSample {

	public static void main(String[] args) {
		int x = 0;
		while(x<1) {
			System.out.println("入力してください。");
			Form.setInput(Display.input());
			System.out.println(Form.getInput());
			if(Form.getInput().equals("1")) {
				x=1;
			}
			System.out.println("おわらない");
			//x=1;
		}

	}

}
