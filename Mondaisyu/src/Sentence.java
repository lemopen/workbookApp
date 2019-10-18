import java.util.ArrayList;

public class Sentence{
	ArrayList<String> questions = new ArrayList<String>();
	//開始時の文言
	public static String initAll = "どの機能を利用しますか？\n\t1.問題表示・回答機能\n\t2.検索機能\n\t3.問題の取込み\n\t4.正答率表示・リセット\n\t5.重みづけ管理";
	public static String initQuestions = "問題を始めます";
	public static String initSearch = "検索機能";
	public static String initImport = "問題の取り込みを行います";
	public static String initData = "正答率表示・リセット";
	public static String initConfig = "重みづけ管理";

	//問題開始
	private static int questionNum = 0;
	public int getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(int questionNum) {
		Sentence.questionNum = questionNum;
	}
	public static String question = String.format("第%d問", questionNum);

	//検索機能
	public static String searchHow = "検索方法を選んでください。\n1.問題番号で検索\t2.問題に含まれる単語で検索";
	public static String searchNum = "問題番号で検索します。検索したい問題番号を入力してください";
	public static String searchWords = "単語で検索します。検索方法を選んでください\n1.AND検索　2.OR検索";
	public static String andSearch = "";
	public static String orSearch = "";
	//問題取り込み
//	public static String = "問題を作成します。テキストファイルのパスを入力してください";

	//正答率

	//重みづけ管理
}