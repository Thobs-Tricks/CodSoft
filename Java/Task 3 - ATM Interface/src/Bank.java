/**
 * @author SK Thobejane
 * @version Task 3 - ATM Interface
 */

public class Bank
{
	private double Bal;
	protected final int PinNum = 12345;
	protected final String AccType = "Savings";
	protected final double depFee = 5.50;
	protected final double withFee = 2.50;

	/**
	 * @param bal
	 */
	public Bank(double bal)
	{
		Bal = bal;
	}
	
	public double getBal()
	{
		return Bal;
	}
	
	public void setBal(double bal)
	{
		Bal = bal;
	}	
}
