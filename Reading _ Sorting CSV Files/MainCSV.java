import java.util.*;
public class MainCSV 
{

    public static void main(String[] args)
    {
        String path;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file you want to SORT:");
        path = sc.next();

        ReadCSV obj = new ReadCSV();
        obj.readcsv(path);
        
       
        

    }

    
}
