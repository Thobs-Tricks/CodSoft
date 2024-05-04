import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author SK Thobejane
 * @version Task 3 - ATM Interface
 */
public class Main extends Application{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		launch(args);
	}
	

	@Override
	public void start(Stage pStage) throws Exception
	{
		// TODO Auto-generated method stub
		
		ATM atm = new ATM();
		
		Scene scn = new Scene(atm,300,500);
		
		pStage.setTitle("ATM Interface");
		pStage.setScene(scn);
		pStage.show();
	}

}
