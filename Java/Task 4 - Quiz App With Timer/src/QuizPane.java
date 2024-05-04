import java.awt.event.ActionListener;

import javax.swing.Timer;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * @author SK Thobejane
 * @version Task 4 - Quiz App With Timer
 */
public class QuizPane extends StackPane
{
	private String[] Questions = {"What is my name?","How old am I?","Who is your crush?"};

	private String[][] Options = {
			{"SK", "Shepherd", "Dimple","Noname"},
			{"15","10","18","20"},
			{"Anyone","myself","Yena","Riri"}};
			
	private String[] Answers = {"B","D","C"};

			
	private VBox vInfo;
	private Quiz quiz;
	private TitledPane tldQueNum = new TitledPane();
	private TextField txtTime = new TextField();

	private Button btnA = new Button("A");
	private Button btnB = new Button("B");
	private Button btnC = new Button("C");
	private Button btnD = new Button("D");
	
	private Label lblQ1 = new Label();
	private Label lblQ2 = new Label();
	private Label lblQ3 = new Label();
	private Label lblQ4 = new Label();
	
	
	private String answer;
	private int c_guess = 0;
	private int seconds = 5;
	private int index = 0;
	
	public QuizPane()
	{
		quiz = new Quiz();
		
		vInfo = new VBox();
		vInfo.setAlignment(Pos.TOP_CENTER);
		vInfo.setSpacing(15);
		Label lblHeading = new Label("CodSoft Quiz Challenge");
		
		
		vInfo.getChildren().add(lblHeading);
		
		tldQueNum.setExpanded(true);
		
		GridPane grdLayer = new GridPane();
		grdLayer.setHgap(10);
		grdLayer.setVgap(5);
		
		
		grdLayer.add(btnA, 0, 0);
		grdLayer.add(btnB, 0, 1);
		grdLayer.add(btnC, 0, 2);
		grdLayer.add(btnD, 0, 3);
		
		grdLayer.add(lblQ1, 1, 0);
		grdLayer.add(lblQ2, 1, 1);
		grdLayer.add(lblQ3, 1, 2);
		grdLayer.add(lblQ4, 1, 3);
		
		tldQueNum.setContent(grdLayer);
		
		txtTime.setMaxWidth(50);
		txtTime.setEditable(false);
		txtTime.setText(String.valueOf(seconds) + " sec");
		
		HBox hTime = new HBox();
		hTime.setAlignment(Pos.BASELINE_RIGHT);
		hTime.getChildren().add(txtTime);
				
		
		vInfo.getChildren().addAll(tldQueNum, hTime);
		
		this.getChildren().add(vInfo);
		
		nextQ(); 
		
		btnA.setOnAction(e -> 
		{
			actionPerformed();
			correctA();
		});
		
		btnB.setOnAction(e -> 
		{
			actionPerformed();
			correctA();
		});
		
		btnC.setOnAction(e -> 
		{
			actionPerformed();
			correctA();
		});
		
		btnD.setOnAction(e -> 
		{
			actionPerformed();
			correctA();
		});
		
	}
	
	
	public void nextQ()
	{
		if(index >= Questions.length)
		{
			result();
			
		}else
		{
			tldQueNum.setText("Question " + (index + 1) + "\n\n" + Questions[index]);
			lblQ1.setText(Options[index][0]);
			lblQ2.setText(Options[index][1]);
			lblQ3.setText(Options[index][2]);
			lblQ4.setText(Options[index][3]);
		}
	}


	public void actionPerformed() {
		// TODO Auto-generated method stub
		
		btnA.setDisable(true);
		btnB.setDisable(true);
		btnC.setDisable(true);
		btnD.setDisable(true);
		
		answer = "";
		
		
		if(btnA.isPressed())
		{
			answer = "A";
			if(answer.equals(Answers[index]))
			{
				c_guess++;
			}
		}
		
		if(btnB.isPressed())
		{
			answer = "B";
			if(answer.equals(Answers[index]))
			{
				c_guess++;
			}
		}
		
		if(btnC.isPressed())
		{
			answer = "C";
			if(answer.equals(Answers[index]))
			{
				c_guess++;
			}
		}
		
		if(btnD.isPressed())
		{
			answer = "D";
			if(answer.equals(Answers[index]))
			{
				c_guess++;
			}
		}
		
		//correctA();
	}
	
	public void correctA()
	{
		btnA.setDisable(true);
		btnB.setDisable(true);
		btnC.setDisable(true);
		btnD.setDisable(true);
		
		if(!Answers[index].equals("A"))
		{
			lblQ1.setVisible(false);
		}
		if(!Answers[index].equals("B"))
		{
			lblQ2.setVisible(false);
		}
		if(!Answers[index].equals("C"))
		{
			lblQ3.setVisible(false);
		}
		if(!Answers[index].equals("D"))
		{
			lblQ4.setVisible(false);
		}
		
		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				
				seconds = 5;
				txtTime.setText(String.valueOf(seconds) + " sec");
				index++;
				
				lblQ1.setVisible(true);
				lblQ2.setVisible(true);
				lblQ3.setVisible(true);
				lblQ4.setVisible(true);
				
				
				btnA.setDisable(false);
				btnB.setDisable(false);
				btnC.setDisable(false);
				btnD.setDisable(false);
				nextQ();
			}
		});
		
		pause.setRepeats(false);
		pause.start();
				
	}
	
	public void result()
	{
		
	}
}
