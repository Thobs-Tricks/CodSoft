import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * @author SK Thobejane
 * @version Task 3 - ATM Interface
 */


public class ATM extends StackPane
{
	private ScrollPane scl;
	private VBox vDisp;
	private TitledPane tldWith;
	private TitledPane tldDep;
	
	private TextField txtAvailBal;
	private Bank bank;
	private int Pin;
	private String AccT;
	
	public ATM()
	{
		bank = new Bank(0.5);
		Pin = 0;
		AccT = "";
		
		vDisp = new VBox();
		vDisp.setSpacing(5);
		tldWith = new TitledPane();
		tldDep = new TitledPane();
		
		txtAvailBal = new TextField();
		txtAvailBal.setEditable(false);
		txtAvailBal.setText("R " + bank.getBal());
		
		accSection();
		withDrawPane();
		DepositPane();

		
		scl = new ScrollPane();
		scl.setContent(vDisp);;
		
		this.getChildren().add(scl);
	}
	
	public void accSection()
	{
		GridPane grdAcc = new GridPane();
		grdAcc.setHgap(4);
		grdAcc.setVgap(7);
		
		Label lblAccName = new Label("Account Holder's Name: ");
		Label lblAccNameD = new Label(" Mr SK Thobejane");
		
		Label lblAccNum = new Label("Account Number:");
		Label lblAccNumD = new Label("167 256 5278");
		
		Label lblSavings = new Label("Savings Account");
		Label lblAvailBal = new Label("Available:");
		
		Button btnRe = new Button("Refresh");
		
		btnRe.setOnAction(e ->
		{
			double bal = bank.getBal();
			txtAvailBal.setText("R " + bal);
		});

		grdAcc.add(lblAccName, 0, 0);
		grdAcc.add(lblAccNameD, 1, 0);
		grdAcc.add(lblAccNum, 0, 1);
		grdAcc.add(lblAccNumD, 1, 1);
		grdAcc.add(lblSavings, 0, 3);
		grdAcc.add(lblAvailBal, 0, 4);
		grdAcc.add(txtAvailBal, 1, 4);
		grdAcc.add(btnRe, 0, 6);
		grdAcc.add(new Label(""), 0, 7);
		
		grdAcc.setVgap(7);
		vDisp.setAlignment(Pos.TOP_CENTER);
		vDisp.getChildren().add(grdAcc);
	}
	
	public void withDrawPane()
	{
		tldWith.setText("Withdraw Here:");
		tldWith.setExpanded(false);
		
		Label lblWith = new Label("Withdrawal Amount: ");
		TextField txtWith = new TextField();
		txtWith.setMaxWidth(75);
		
		Label lblPin = new Label("Enter Pin: ");
		TextField txtPin = new TextField();
		txtPin.setMaxWidth(75);
		
		TextArea txtSMS = new TextArea();
		
		Button btnDraw = new Button("Proceed");
		
		btnDraw.setOnAction(e -> 
		{
			double amount = Double.parseDouble(txtWith.getText().toString());
			int Pin = Integer.parseInt(txtPin.getText().toString());
			
			
			if(Pin == bank.PinNum)
			{
				String sms = withDraw(amount);
				txtSMS.setText(sms);
				
			}else
			{
				txtSMS.setText("You have Entered an Incorrect Pin!");
			}
			
		});
		
		txtSMS.setEditable(false);
		txtSMS.setWrapText(true);
		txtSMS.setMaxHeight(10);
		txtSMS.setMaxWidth(270);
		
		GridPane grdWith = new GridPane();
		//grdWith.setHgap(10);
		grdWith.setVgap(10);
		grdWith.add(lblWith, 0, 0);
		grdWith.add(txtWith, 1, 0);
		grdWith.add(lblPin, 0, 1);
		grdWith.add(txtPin, 1, 1);
		grdWith.add(btnDraw, 1, 2);
		grdWith.add(txtSMS, 0, 3,2,1);
		
		tldWith.setContent(grdWith);
		vDisp.getChildren().add(tldWith);
	}
	
	public void DepositPane()
	{
		tldDep.setText("Deposit Here:");
		tldDep.setExpanded(false);
		
		Label lblDep = new Label("Deposit Amount: ");
		TextField txtDep = new TextField();
		txtDep.setMaxWidth(75);
		//txtDep.
		
		Label lblAcc = new Label("Account Type: ");
		ComboBox<String> cbbAcc = new ComboBox<String>();
		cbbAcc.getItems().add("Savings");
		
		TextArea txtSMS = new TextArea();

		Button btnDep = new Button("Proceed");
		btnDep.setOnAction(e -> 
		{
			double deposit = Double.parseDouble(txtDep.getText().toString());
			String AccT = cbbAcc.getSelectionModel().getSelectedItem().toString();
			
			if(AccT != null)
			{
				if(AccT.equals(bank.AccType))
				{
					String sms = Deposit(deposit);
					txtSMS.setText(sms);
					
				}else
				{
					txtSMS.setText("Make Sure you choose the Correct Account Type!");
				}
			}else
			{
				txtSMS.setText("Please choose your Account Type!");
			}
		});
		
		txtSMS.setEditable(false);
		txtSMS.setWrapText(true);
		txtSMS.setMaxHeight(10);
		txtSMS.setMaxWidth(270);
		
		GridPane grdDep = new GridPane();
		grdDep.setVgap(10);
		grdDep.add(lblDep, 0, 0);
		grdDep.add(txtDep, 1, 0);
		grdDep.add(lblAcc, 0, 1);
		grdDep.add(cbbAcc, 1, 1);
		grdDep.add(btnDep, 1, 2);
		grdDep.add(txtSMS, 0, 3,2,1);
		
		tldDep.setContent(grdDep);
		
		vDisp.getChildren().add(tldDep);
	}
	
	
	public String withDraw(double amount)
	{
		String sms = "";
		if(bank.getBal() <= amount)
		{
			sms = "You have Insufficient Funds for such Withdrawal!";
			
		}else
		{
			double newB = (bank.getBal() - amount) - bank.withFee;
			
			bank.setBal(newB);
			
			sms = "Transaction Done. \nWithdrawal Amount: R " + amount + "\nWithdrawal Fee: R " + bank.withFee;
		}
		
		return sms;
	}
	
	public String Deposit(double amount)
	{
		String sms = "";
		
		double newB = (bank.getBal() + amount) - bank.depFee;
			
		bank.setBal(newB);
		
		sms = "Transaction Done. \nDeposit Amount: R " + amount + "\nCash Deposit Fee: R " + bank.depFee;
	
		return sms;
	}
}
