import java.util.*;
import java.io.*;
public class TestHarness{
    public static BinarySearchTree bst = new BinarySearchTree();
    public static String[] array1 = new String[7000];
    public static String[] array2 = new String[7000];
    public static void main(String[] args) 
    {
        
        mainMenu();
      
    }
    public static void mainMenu()  
    {
        clear();
        Scanner sc = new Scanner(System.in);
        int option;
        do
        {
            System.out.println("\n\nINTERACTIVE MENU FOR BINARY SEARCH TREE: ");
            System.out.println("1> Read a '.csv' file");
            System.out.println("2> Read a 'serialised' file");
            System.out.println("3> Display Tree");
            System.out.println("4> Write a '.csv' file");
            System.out.println("5> Write a 'serialised' file ");
            System.out.println("0> EXIT");
          
            option = sc.nextInt();
            if(option == 1)
            {
                clear();
                option1();
            }
            else if(option == 2)
            {
                clear();
                option2();
            }
            else if(option == 3)
            {
                clear();
                option3();
            }
            else if(option == 4)
            {
                clear();
                option4();
            }
            else if(option == 5)
            {
                clear();
                option5();
            }
        }while(option!=0);

    }


    public static void option1()
    {
       
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the .csv file you wish to read : ");
        String fileName = sc.nextLine();
        bst = fileReader(fileName);
    }

    public static void option2()
    {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the name of the file you wish to read : ");
       String fileName = sc.nextLine();
       BinarySearchTree resultTree = readObjectFromFile(fileName);
       resultTree.disInOrder();
    }

    public static void option3()
    {
        Scanner sc = new Scanner(System.in);
        int displayOption;
        do{
            System.out.println("\n\nWhat travesal method do u wish to perform to display the tree : ");
            System.out.println("1> INORDER traversal");
            System.out.println("2> PREORDER traversal");
            System.out.println("3> POSTORDER traversal");
            System.out.println("0> EXIT");
           
            displayOption = sc.nextInt();

            if(displayOption == 1)
            {
                bst.disInOrder();
            }
            else if(displayOption == 2)
            {
                bst.disPreOrder();  
            }
            else if(displayOption == 3)
            {
                bst.disPostOrder();  
            }
            else
            {
                System.out.println("PLEASE ENTER VALID CHOICE");
                clear();
            }
        }while(displayOption!=0);
    }


    public static void option4()
    {
        Scanner sc =  new Scanner(System.in);
        int choice;
        do
        {
            System.out.println("\n\nWhat traversal method do you wish to implement when WRITING A CSV FILE");
            System.out.println("1> INORDER traversal");
            System.out.println("2> PREORDER traversal");
            System.out.println("3> POSTORDER traversal");
            System.out.println("0> EXIT");
            
            choice = sc.nextInt();
            if(choice == 1)
            {
                clear();
                option4InOrder();

            }
            else if(choice == 2)
            {
                clear();
                option4InOrder();
            }
            else if(choice == 3)
            {
                clear();
                option4InOrder();
            }
            else
            {
                System.out.println("PLEASE ENTER VALID CHOICE");
                clear();
            }
            
        }while(choice!=0);
    }

    public static void option4InOrder()
    {
        Scanner sc = new Scanner(System.in);
        String fileName;
        System.out.println("ENTER THE NAME FO THE FILE YOU WISH TO WRITE TO: ");
        fileName = sc.nextLine();
        fileWriter(fileName);
    }
    // public static void option4PreOrder()
    // {
    //     Scanner sc = new Scanner(System.in);
    //     String fileName;
    //     System.out.println("ENTER THE NAME FO THE FILE YOU WISH TO WRITE TO: ");
    //     fileName = sc.nextLine();
    //     fileWriter(fileName);
    // }
    // public static void option4PostOrder()
    // {
    //     Scanner sc = new Scanner(System.in);
    //     String fileName;
    //     System.out.println("ENTER THE NAME FO THE FILE YOU WISH TO WRITE TO: ");
    //     fileName = sc.nextLine();
    //     fileWriter(fileName);
    // }

    public static void option5()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of serialised file you wish write to : ");
        String fileName = sc.nextLine();

        writeObjectToFile(bst, fileName);
        
    }

    public static BinarySearchTree fileReader(String fileName) 
    {
        int i =0;
        BinarySearchTree tree = new BinarySearchTree();
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        //int lineNum = 0;
        String line;
        try{
            fileInputStream = new FileInputStream(fileName);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            line = bufferedReader.readLine();
            while(line!=null){
                String[] splitLine;
                splitLine = line.split(",");
                array1[i] = splitLine[0];
                array2[i] = splitLine[1];
                tree.insert(splitLine[0],splitLine[1]);
                line = bufferedReader.readLine();
                i++;
                //lineNum++;
            }
            clear();
            System.out.println("SUCCESSFULLY READ FROM FILE ");
            fileInputStream.close();          
        }catch(IOException ioException){
            System.out.println("Error in File Processing : "+ioException.getMessage());
        }
        return tree;
    }

    public static void fileWriter(String inFile)
    {
        try
        {
            FileWriter fw = new FileWriter(inFile);
            for(int i=0;i<array1.length;i++)
            {
                fw.write(array1[i] + "," + array2[i]+ "\n" );
            }
        System.out.println("SUCCESSFULLY CREATED FILE");
        fw.close();

        }catch(IOException e)
        {
            System.out.println("ERROR WHEN CREATING FILE ");
            e.printStackTrace();
        }
    }

    public static BinarySearchTree readObjectFromFile(String filepath) //serialisation 
    {
        try {
 
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            BinarySearchTree obj = (BinarySearchTree) objectIn.readObject();
 
            System.out.println("THE OBJECT HAS BEEN READ FROM THE FILE");
            objectIn.close();
            return obj;
 
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void writeObjectToFile(BinarySearchTree serObj, String filepath) //serialisation
    {
        try {
 
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("SUCCESSFULLY SAVED TO FILE!");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

       private static void clear() 
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}