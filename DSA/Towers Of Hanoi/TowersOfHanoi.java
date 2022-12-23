import java.util.*;
public class TowersOfHanoi
{
	public static int towers(int n, int src, int dest) /*noOfDisk, source, destination*/
	{
		int temp,s=0, s1=0, s2=0, s3=0;
		if (n==1)
		{
			System.out.println("Moved from " + src + " to " + dest);
		}	
		else
		{	
			
			temp = (6 - src  - dest);
			
			s1=towers(n-1, src, temp);
			System.out.println("Moved from " + src + " to " + dest);
			s3=towers(n-1, temp, dest);
			s= s1+s2+s3;
				
		}
			return s;		
	}


	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("\nEnter the number of disk:\n ");
		int disk = sc.nextInt();

		System.out.println("\nWhich peg holds the disk currently?\nOptions:\n1\n2\n3\n ");
		int pegsrc = sc.nextInt();

		System.out.println("\nWhich peg do you wish to move the current disks to?\nOptions:\n1\n2\n3\n ");
		int destsrc = sc.nextInt(); 


		
		System.out.println(towers(disk, pegsrc, destsrc));
		
	}
}