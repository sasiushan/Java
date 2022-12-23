	/*
		Author: Sasiru Ushan Hettiarachchi (20522908)
		Date:	17 May 2022
		Title: DSAHeaps
		Source: Practical8 (COMP1002 Semester2_2021)
		Description: Contains the source code to the heaps which was previously
		coded by me in semester 2 year 2021 for unit COMP1002, practial 8.
	*/
import java.io.*;
public class DSAHeap
{
	private class DSAHeapEntry
	{
		private int priority;
		private Object value;
		
	
		public DSAHeapEntry(int inPriority, Object inValue)
		{
			this.priority = inPriority;
			this.value = inValue;
		}	

		public int getPriority()
		{
			return priority;
		}

		public Object getValue()
		{
			return value;
		}

		public void setPriority(int inPriority)
		{
			this.priority = inPriority;
		}

		public void setValue(Object inValue)
		{
			this.value = inValue;
		}

	}

	private DSAHeapEntry[] heap;
	private int maxSize;	//size of array
	private int count;//currentSize


	public DSAHeap(int headSize)
	{
		maxSize = headSize;
		count  = 0;
		heap = new DSAHeapEntry[headSize];
		
	}

	public boolean isEmpty()
	{
		return count==0;
	}

	private int parentIndex(int currIdx)
	{
		return (currIdx-1)/2;
	}

	private int leftChildIndex(int currIdx)
	{
		return (currIdx * 2) + 1;
	}

	private int rightChildIndex(int currIdx)
	{
		return (currIdx * 2) + 2;
	}

	public boolean add(int inPriority, Object inValue)
	{
		if(count == maxSize)
		{
			return false;
		}
		DSAHeapEntry newNode = new DSAHeapEntry(inPriority, inValue);
		heap[count] = newNode;
		trickleUp(count++);
		return true;
	}

	public DSAHeapEntry remove()
	{
		DSAHeapEntry heapRear = heap[0];
		heap[0] = heap[--count];
		trickleDown(0);
		return heapRear;
	}	
	
	public void display()
	{
		
		for(int i = 0; i<count; i++)
		{	
			if(heap[i]!=null)
			{
				System.out.print(heap[i].getPriority() + " : " + heap[i].getValue() + " ");
			}
			else
			{	
				System.out.println(" ");
			}
			System.out.println();
		}
	}

	public void trickleUp(int index)
	{
		
		int parent = parentIndex(index);
		DSAHeapEntry heapRear = heap[index];

		while((index>0) && heap[parent].getPriority() < heapRear.getPriority())
		{
			heap[index] = heap[parent];
			index = parent;
			parent = parentIndex(parent);
		}	
			
		
		heap[index] = heapRear;
	}

	public void trickleDown(int index)
	{
		int largerChildIdx, leftChildIdx, rightChildIdx;
		DSAHeapEntry head = heap[index];
		while(index<count/2)
		{
			leftChildIdx = leftChildIndex(index);
			rightChildIdx = leftChildIdx + 1;

			if(rightChildIdx<count && heap[leftChildIdx].getPriority()<heap[rightChildIdx].getPriority())
			{
				largerChildIdx = rightChildIdx;
			}
			else
			{
				largerChildIdx = leftChildIdx;
			}
			if(head.getPriority()>=heap[largerChildIdx].getPriority())
				break;

			heap[index] = heap[largerChildIdx];
			index = largerChildIdx;
		}
		heap[index] = head;
	}

	/* MAX Heap sort */
	public void heapSort()
	{
		

		for(int i=count/2-1; i>=0;i--)
		{
			heapify(heap, count, i);
		}
		for(int i = count-1; i>=0;i--)
		{
			DSAHeapEntry temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			heapify(heap, i, 0);
		}
	}

	
	public void heapify(DSAHeapEntry[] arr, int n, int i)
	{
		int parentIndex = i;
		int leftChildIndex = leftChildIndex(i);
		int rightChildIndex = rightChildIndex(i);

		if(leftChildIndex<n && arr[leftChildIndex].getPriority()>arr[parentIndex].getPriority())
		{
			parentIndex = leftChildIndex;
		}
		if(rightChildIndex<n && arr[rightChildIndex].getPriority()>arr[parentIndex].getPriority())
		{
			parentIndex = rightChildIndex;
		}
		if(parentIndex!=i)
		{
			DSAHeapEntry temp = arr[i];
			arr[i] = arr[parentIndex];
			arr[parentIndex] = temp;
			heapify(arr, n, parentIndex);

		}
	}

	
	public void displayAfterHeapSort()
	{
		for(int i=count-1;i>=0;i--)
		{
			{	
				System.out.println(heap[i].getPriority() + " " + heap[i].getValue() + " ");
			}
		}
	}

	public void readFile(String inFile)
	{
		FileInputStream fileInputStream = null;
		InputStreamReader inputStreamReader;
		BufferedReader bufferedReader;
		String line;

		try{
			BufferedReader buffRdr;
			buffRdr = new BufferedReader(new FileReader(new File(inFile)));

			while((line = buffRdr.readLine())!=null)
			{
				String[] data = line.split(",");
				add(Integer.parseInt(data[0]), data[1]);
				// hashCount++;
			}
			System.out.println("Successfully read file");
			buffRdr.close();

		}catch(IOException e)
		{
			System.out.println("Error in file processing : " + e.getMessage());
		}

		// return hashCount;

	}


	
}