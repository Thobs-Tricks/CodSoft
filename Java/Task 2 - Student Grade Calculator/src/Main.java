import java.util.Scanner;

/**
 * @author SK Thobejane
 * @version Task 2 - Student Grade Calculator
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter your name: ");
		String name =  scan.nextLine();
		
		System.out.println("\nWelcome to Student Grade Calculator " + name);
		
		int numSub = 0;
		
		System.out.println("Please Enter the Total number of your Subjects:");
		
		
		
		numSub = scan.nextInt();
		
		int[] mark = new int[numSub];
		
		
		
		for(int m = 0; m < mark.length; m++)
		{
			System.out.println("\nEnter Mark for Subject " + (m + 1) + ":");
			mark[m] = scan.nextInt();
			
			while(mark[m] < 0 || mark[m] > 100)
			{
				System.out.println("\nPlease Enter the correct Mark for Subject " + (m + 1) + ":");
				mark[m] = scan.nextInt();
			}
		}
		
		int totMark = 0;
		double aveMark = 0.0;
		String grade = "";
		
		for(int m = 0; m < mark.length; m++)
		{
			totMark += mark[m];
		}
		
		aveMark = totMark/numSub;
		
		if(aveMark >= 80)
		{
			grade = "A";
		}else if(aveMark >= 70 && aveMark < 80)
		{
			grade = "B";
		}else if(aveMark >= 60 && aveMark < 70)
		{
			grade = "C";
		}else if(aveMark >= 50 && aveMark < 60)
		{
			grade = "D";
		}else if(aveMark >= 40 && aveMark < 50)
		{
			grade = "E";
		}else if(aveMark >= 30 && aveMark < 40)
		{
			grade = "F";
		}else
		{
			grade = "FF";
		}
		
		
		System.out.printf("\n\nStudent Name: %s\n\nTotal Subjects: %d\nTotal Mark: %d\nAverage Mark: %.2f\nGrade: %s",
				name,numSub,totMark,aveMark,grade);
		
	}

}
