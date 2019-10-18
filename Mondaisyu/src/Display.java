import java.util.Scanner;
public class Display {
	//入力を文字列化して受け取る
	public static String input() {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine().toString();
		scan.close();
		return str;
	}
	//引数に入れたものを出力する
	public static void display(String input){
		System.out.println(input);
	}
}