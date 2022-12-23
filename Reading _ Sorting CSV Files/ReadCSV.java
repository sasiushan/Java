import java.io.*;
import java.util.*;
public class ReadCSV
{

    public static int[] id;
    public static String[] name;


    public ReadCSV(int[] pId, String[] pName)//Constructor with parameters
    {
        setId(pId);
        setName(pName);
    }

    public ReadCSV(ReadCSV pReadCSV)//Copy Constructors
    {
        setId(pReadCSV.getId());
        setName(pReadCSV.getName());
    }

    public ReadCSV()//Initialized and set the size of each array
    {
        setId(new int[6999]);
        setName(new String[6999]);
    }

    public int[] getId()//Accessor
    {
        return id;
    }
    public String[] getName()//Accessor
    {
        return name;
    }

    public void setId(int id[])//Mutator
    {
        ReadCSV.id = id;
    }
    public void setName(String name[])//Mutator
    {
        ReadCSV.name = name;
    }

    
    public static void readcsv(String path)//readcsv method ask user for input and opens a file to read.
	{
	
		String line=" ";
		int i=0;
		try
		{
			BufferedReader bufRdr = new BufferedReader(new FileReader(path));
			line = bufRdr.readLine();
			
			while((line=bufRdr.readLine())!=null)
			{
				
				String[] data = line.split(",");	
				id[i] = Integer.parseInt(data[0]);//Data stored in the 0th column in array "data" is put into array "id"
                i++;
			}
			bufRdr.close();

            Sorts obj = new Sorts();
            obj.bubbleSort(id);//Sort using bubbleSort
            obj.display(id);//Display method will output data after sorting 

            System.out.println("\n");

            obj.selectionSort(id);//Sort using selectionSort
            obj.display(id);//Display method wil output data after sorting

            System.out.println("\n");

            obj.insertionSort(id);//Sort using insertionSort
            obj.display(id);//Display method will output data aftet sorting 
            


		}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();		
			}
		
	}



    
}




