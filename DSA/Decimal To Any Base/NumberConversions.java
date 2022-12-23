import java.util.*;
public class NumberConversions
{
	public static int Binary(int x)/*Denary to Binary conversion method*/
	{
		
		if(x == 0)
		{
			return 0;
		}
		else
		
			return ((x%2) + 10 * Binary(x/2)); /* for eg x=14, 14/2 is perfectly divisible(%) the answer will be 0. 14/2 = 7. Binary(7) is called in recursive form*/
	}

	/*
		Author: N/A
		Date: 22 Nov 2013 
		Title: Convert Decimal to Hex using Recursive method Java
		Link: https://stackoverflow.com/q/20150901
		Type: Source code
	*/
	 public static String Hex(String s) { /*Denary to Hexadecimal */
        String result = "";
        int n = Integer.parseInt(s);
        int remainder = n % 16;

        if (n == 0) {
            return "";
        } else {
            switch (remainder) {
                case 10:
                    result = "A";
                    break;
                case 11:
                    result = "B";
                    break;
                case 12:
                    result = "C";
                    break;
                case 13:
                    result = "D";
                    break;
                case 14:
                    result = "E";
                    break;
                case 15:
                    result = "F";
                    break;
                default:
                    result = Integer.toString(remainder) + result; //Convert remainder which is int to string; result is already String
                    break;
            }

            return Hex(Integer.toString(n / 16)) + result; //Recursion (function called again). (n/16) is converted into string.
        }
    }
		


	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		try{
			System.out.println("Enter the Denary Number to convert into Binary: ");
			int num1 = sc.nextInt();
			System.out.println(Binary(num1));

			

			System.out.println("Enter the Denary number to convert into Hexadecimal: ");
			String num2 = sc.next();
			System.out.println(Hex(num2));
		}catch(Exception e)
		{
			System.out.println("Error! Input is invalid. ");	
		}
		}
}