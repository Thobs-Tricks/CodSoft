import java.util.Random;
import java.util.Scanner;

/**
 * @author SK Thobejane
 * @version Task 1 - Number Game
 */
public class Main
{
	private static int gameWins;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		//Introduction
		System.out.println("*******Welcome TO Guessing Game*******\n");
		System.out.println("What is Your Name: \n");
		
		Scanner scan = new Scanner(System.in);
		
		String userName = scan.nextLine();
		
		System.out.println("Hello " + userName);
		
		String option;
		boolean run = true;
		gameWins = 0;
		
		do
		{
			System.out.println("\nPlease Select an Option Below: \n\n1. Start\n2. Quit\n");
			
			option = scan.next();
			
			switch(option)
			{
			case "1":
				
				game(scan, run);
				
				System.out.println("\n\nWould you like to play again?: \n\n1. Yes\n2. No\n");
				String choice = scan.next();
				
				while(choice.equals("1"))
				{
					game(scan, run);
					System.out.println("\n\nWould you like to play again?: \n\n1. Yes\n2. No\n");
					
					choice = scan.next();
				}
				
				System.out.println("****Congratulation - You have Won " + gameWins + " Round(s)*****");

				run = false;
				
				break;
				
			case "2":
				
				System.out.println("****What A Looser, You Chickened-Out*****");
				run = false;
				break;
				
			default:
				
				System.err.println("Incorrect Input, Please Enter Again!");
				break;
			}
			
		}while(run);	
	}
	
	/**
	 * @param scan
	 * @param run
	 */
	public static void game(Scanner scan, boolean run)
	{
		Random rnd = new Random();
		int rndValue = rnd.nextInt(101);
		System.out.println("Let the Guessing Game Begin!");
		
		int chances = 5;
		int guess;
		
		while(chances > 0)
		{
			System.out.println("\nChances Left: " + chances);
			System.out.println("Please enter Your Guess: ");

			guess = scan.nextInt();
			
			if(guess > rndValue)
			{
				System.out.println("Enter a Lower Value!!!\n");
				
			}else if(guess < rndValue)
			{
				System.out.println("Enter a Higher Value!!!\n");
				
			}else
			{
				System.out.println("****Congratulation - You Win, Horrray!!*****");
				gameWins++;
				run = false;
				break;
			}
			
			chances -= 1;
		}
		
		if(run)
		{
			System.out.println("\nRandom Value = " + rndValue);
			System.out.println("\n****Game Over - You Loose, Looser!!*****");
			run = false;
		}	
	}
}
