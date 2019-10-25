import java.util.ArrayList;

public class Exercise implements ServiceInterface {
	private ArrayList<String> exercise = new ArrayList<>();
	private ArrayList<String> userAns = new ArrayList<>();
	private ArrayList<String> correctAns = new ArrayList<>();

	public ArrayList<String> getExercise() {
		return exercise;
	}

	public void setExercise(ArrayList<String> exercise) {
		this.exercise = exercise;
	}

	public Exercise startFunction(ArrayList<String> arr) {
		Exercise ex = new Exercise();
		//impインスタンスのquestionsMadeをexerciseに取り込む

		System.out.println(Sentence.initQuestions);
		//答えのある行をcorrectAnsに取り込む
		//回答を行う
		startExercise(exercise);

		//正誤を一覧表示する

		//終了
		System.out.println(Sentence.endQuestions);
		endFunction();
		return ex;
	}
	public void startExercise(ArrayList<String> exercise) {
		//順番に問題を表示して回答
		for(String sentence : exercise) {
			System.out.println(sentence);

		}
	}

	@Override
	public void endFunction() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void startFunction() {
		// TODO 自動生成されたメソッド・スタブ

	}

	//問題の各要素に重みづけするメソッド

	//格納されている問題数まで「第〇問」という表示を切り替えて出力するメソッド
//	public static String whatQuestion() {
//		for(int num : Questions) {
//			System.out.println("第" + num + "問");
//			//問題文を入れる
//		}
//	}
}
