/** 
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    public static void display(int[] A)//Display Method to display output
    {
        for(int i = 0; i<A.length;i++)
        {
            System.out.println(A[i]);
        }
    }  
    


    public static void bubbleSort(int[] A)// bubble sort
    {
        int temp=0;

        for(int i=0; i<A.length; i++)
        {
            for(int j=1; j<A.length-i;j++)
            {
                if(A[j-1] > A[j])
                {
                    temp=A[j-1];
                    A[j-1] = A[j];
                    A[j]=temp;
                }
            }
        }
    }

    
    public static void selectionSort(int[] A)// selection sort
    {
        int min;
        int temp=0;

        for(int i=0; i<A.length; i++)
        {
            min = i;
            for(int j=i+1; j<A.length;j++)
            {
                if(A[j] < A[min])
                {
                    min=j;
                }
            }
            temp=A[i];
            A[i]=A[min];
            A[min]=temp;
        } 
    }

    
    public static void insertionSort(int[] A)// insertion sort
    {
        int temp = 0, j;
            for(int i =0; i<A.length; i++)
            {
                temp = A[i];
                j = i;
                while(j>0 && A[j-1]>temp)
                {
                    A[j] = A[j-1];
                    j = j-1;
                }
                A[j] = temp;
            }
    }

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		return 0;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


}//end Sorts calss
