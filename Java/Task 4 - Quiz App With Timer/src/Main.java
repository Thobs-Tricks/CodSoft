import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author SK Thobejane
 * @version Task 4 - Quiz App With Timer
 */
public class Main extends Application{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage arg) throws Exception {
		// TODO Auto-generated method stub
		
		QuizPane quiz = new QuizPane();
		
		Scene scn = new Scene(quiz,300,300);
		
		arg.setTitle("Quiz Application");
		arg.setResizable(false);
		arg.setScene(scn);
		arg.show();
		
	}

}
