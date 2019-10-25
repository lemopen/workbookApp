import java.util.ArrayList;

public class Sentence{
	//文章を集めるクラス

	ArrayList<String> questions = new ArrayList<String>();
	//一般的な文言
	public static final String initAll = "どの機能を利用しますか？\n\t1.問題表示・回答機能\n\t2.検索機能\n\t3.問題の取込み\n\t4.正答率表示・リセット\n\t5.重みづけ管理";
	public static final String initQuestions = "問題を始めます";
	public static final String initSearch = "検索機能";
	public static final String initImport = "インポートしたファイルを基に問題を作成します。\nファイル名を入力してください\n\t例）Sample.txt";
	public static final String initDataControl = "正答率表示・リセット";
	public static final String initWeightConfig = "重みづけ管理";
	public static final String isOkay = "この内容で良いですか？\n続ける：y　やり直す:n";
	public static final String confirmEndAll = "引き続き他の機能を利用しますか？\n続ける：y　終了する:n";
	public static final String invalidInput = "入力は無効です。再入力してください";

	//例外処理
	public static final String genException = ("例外処理が発生しました。プログラムを再起動します");

	//問題開始
	public static final String putAnswer = "回答を入力してください";
	public static final String rightAns = "正解です";
	public static final String wrongAns = "間違いです";
	public static final String questionsComp = "全ての問題に回答しました。";

	//検索機能
	public static final String searchHow = "検索方法を選んでください。\n1.問題番号で検索\t2.問題に含まれる単語で検索";
	public static final String searchNum = "問題番号で検索します。検索したい問題番号を入力してください";
	public static final String searchWords = "単語で検索します。検索方法を選んでください\n1.AND検索　2.OR検索";
	public static final String andSearch = "";
	public static final String orSearch = "";
	//問題取り込み
	public static final String importFileName = "ファイル名を拡張子付きで入力してください";
	public static final String splitChapterOrNot = "章ごとに切り分けを行いますか？\n行う：y 行わない:n";
	public static final String whichWord = "テキストを区切るための単語を１つ入力してください。正規表現も利用できます\n例）Question.*\\n もしくは 第.*条\\n など";
	public static final String putAnyWord = "何らかの単語を入力してください";
	public static final String putExportDir = "作成した問題をファイルに出力するディレクトリのパスを入力してください。\n入力の最後は\\マークにして下さい\n例）C:\\Users\\SampleFolder\\";
	public static final String putExportFileName = "先ほどのディレクトリに出力するファイルの名前を決めてください\n例）Sample.txt";
	public static final String checkQuestions = "問題の作成に成功しました。内容を確認しますか？\n確認する:y 確認しない:n";
	public static final String continueImport = "さらに他のテキストファイルをインポートして問題に追加しますか？\nインポートする：y インポートしない：n";
	//正答率

	//重みづけ管理
	public static String divider = "----------------------------------------------------------------";
}