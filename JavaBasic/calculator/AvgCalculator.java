import java.util.*;
public class AvgCalculator
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		double average;
		double numb1,numb2;
		System.out.println("Enter the first number: ");
		numb1 = sc.nextInt();
		System.out.println("Enter the second number: ");
		numb2 = sc.nextInt();
		average = calculateAvg(numb1, numb2);
			System.out.println(" The average is: " + average);
		sc.close();
	}	
	private static double calculateAvg (double a, double b)
	{	
		double average;
		average = (a + b)/2;
		return average;
	}	
}

