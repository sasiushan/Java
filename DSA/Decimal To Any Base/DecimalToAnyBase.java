import java.util.*;
public class DecimalToAnyBase
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b = sc.nextInt();

		int dn = getValueInBase(n, b);
		System.out.println(dn);

	}

	public static int getValueInBase(int n, int b)
	{
		int res = 0;
		int pow = 0;
		int rem;
		while(n>0)
		{
			rem = n%b;
			res+=rem*Math.pow(10, pow);
			n = n/b;
			pow +=1;
		}
		return res;
	}
}