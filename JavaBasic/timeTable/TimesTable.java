import java.util.*;
public class TimesTable
{
	public static void main(String[] args)
	{
		int maxTable;
		System.out.println("Welcome to the times tables!");
		maxTable = userInput(1, 12);
		for(int table = 1; table <= maxTable; table++)
		{
			outputTable(table);/* the times table */
		}
	}

	public static int userInput(int pLower, int pUpper)
	{
		int number = -1;
		Scanner sc = new Scanner(System.in);
		while((number <= pLower) || (pUpper <= number))
		{	
			System.out.print("Enter a value between " + pLower + " and " + pUpper + ":");
			number = sc.nextInt();
		}
	sc.close();
	return number;
	}

	public static void outputTable(int pTable)
	{
		System.out.println("The " + pTable + " Times Table");
		for(int number = 1; number <= 12; number++)
		{
			System.out.println(pTable + " x " + number + " = " + (pTable * number));
		}
	}
}

