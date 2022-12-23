import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Enter the name of the file you want to read: ");
		Scanner sc = new Scanner(System.in);
		String file =  sc.next();
		String line;
		String temp;
		
		try
		{
			BufferedReader bufRdr = new BufferedReader(new FileReader(file));
			while((line = bufRdr.readLine()) !=null)
			{
				String[] array = line.split(",");
				for(int i =0; i<array.length; i++)
                		{
					for(int j = 0; j<array.length-1-i; j++)
					{
						if(array[i].compareTo(array[j+1])>0)
						{
							temp = array[j];
							array[j] = array[j+1];
							array[j+1] = temp;		
						}
					}

                       	 	}	
				System.out.println("Array in ASCENDING ORDER: ");
				for(int i = 0; i<array.length; i++)
				{
					System.out.println(array[i]);
				}
			}

		}		
			
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	sc.close();

	}
}	


