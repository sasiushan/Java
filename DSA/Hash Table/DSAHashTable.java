	/*
		Author: Sasiru Ushan Hettiarachchi (20522908)
		Date:	17 May 2022
		Title: DSAHashTable
		Source: Practical7 (COMP1002 Semester2_2021)
		Description: Contains the source code to the hashtable which was previously
		coded by me.
	*/

import java.util.*;
import java.lang.*;
import java.io.*;
public class DSAHashTable
{
	private static class DSAHashEntry
	{
		private String key;
		private Object value;
		private int state;
		private DSAHashEntry next; //next

		public DSAHashEntry()
		{
			key = "";
			value = null;
			state = 0;
		}

		public DSAHashEntry(String inKey, Object inValue)
		{
			key = inKey;
			value = inValue;
		}
		public String getKey()
		{
			return key;
		}
		public Object getValue()
		{
			return value;
		}
		public int getState()
		{
			return state;
		}
		public void setKey(String inKey)
		{
			key = inKey;
		}
		public void setValue(Object inValue)
		{
			value = inValue;
		}
		public void setState()
		{
			state = 1;
		}
		public void clearState()
		{
			state = -1;
		}

	}
	private DSAHashEntry[] hashArray;
	private static int count;

	public DSAHashTable()//default constructor 
	{
		hashArray = new DSAHashEntry[64];
	}

	public DSAHashTable(int tableSize)
	{
		int actualSize = findNextPrime(tableSize);
		hashArray = new DSAHashEntry[actualSize];
	}

	private int findNextPrime(int startVal)
	{
		int primeVal;
		if(startVal % 2 == 0)
		{
			primeVal = startVal - 1;
		}
		else
		{
			primeVal = startVal;
		}
		boolean isPrime = false;
		do
		{
			primeVal = primeVal + 2;
			int ii = 3;
			isPrime = true;
			int rootVal = (int) Math.sqrt(primeVal);
			do
			{
				if(primeVal % ii == 0)
					{
						isPrime = false;
					}
				else
				{
					ii = ii+2;
				}
			}while((ii<rootVal)&&(isPrime));
		}while(!isPrime);
		return primeVal;
	}	

	private int hashFunction(String key)
	{
		int hashIndex = 0;
		for(int ii=0; ii<key.length();ii++)
		{
			hashIndex = (31*hashIndex) + key.charAt(ii);// add chars based on their ASCII value

		}
	
		return hashIndex = hashIndex % hashArray.length;
		
	}
	

	public void put(String inKey, Object inValue)
	{
		int indx = hashFunction(inKey);
		DSAHashEntry table = hashArray[indx];

		while(table!=null)
		{
			if(table.getKey().equals(inKey))
				break;
			table = table.next; //gets the next 
		}
		if(table!=null)
		{
			table.setValue(inValue);
		}
		else
		{

			DSAHashEntry newNode = new DSAHashEntry();
            newNode.setKey(inKey);
            newNode.setValue(inValue);
            newNode.next = hashArray[indx];
            hashArray[indx] = newNode;
            count++;  // Count the newly added key.

		}
	}
	

	public Object get(String inKey)
	{
		Object retValue=null;
		int hashIdx = hashFunction(inKey);
		boolean found = false;
		while(hashArray[hashIdx]!=null)
		{
			if(hashArray[hashIdx].getKey().equals(inKey))
			{
				retValue = hashArray[hashIdx].getValue();
				found = true;
			}
			else
			{
				retValue = null;
			}
			hashArray[hashIdx] = hashArray[hashIdx].next;
		}
		if(found==true)
		{
			System.out.println("Value found : " + inKey);
		}
		else
		{
			System.out.println("Value not found : " + inKey);
		}
		return retValue;
	}

	public void remove(String inKey)
	{
		Object retValue;
		int hashIdx = hashFunction(inKey);
		if((hashArray[hashIdx]) == null)
		{
			return;
		}
		if(hashArray[hashIdx].getKey().equals(inKey))
		{
			hashArray[hashIdx] = hashArray[hashIdx].next;
			count--;
			return;
		}
		DSAHashEntry prevState = hashArray[hashIdx];
		DSAHashEntry currState = prevState.next;
		while((currState!=null)&&(!currState.getKey().equals(inKey)))
		{
			currState = currState.next;
			prevState = currState;
		}
		if(currState!=null)
		{
			prevState.next = currState.next;
			count--;
		}
	}

	public int getCount()
	{
		return count;
	}

	public void resize()
	{
		DSAHashEntry[] newTable = new DSAHashEntry[hashArray.length*2];
		for(int i=0; i<hashArray.length; i++)
		{
			DSAHashEntry table = hashArray[i];
			while(table!=null)
			{
				DSAHashEntry next = table.next;
				int hash = hashFunction(table.getKey())%newTable.length;
				table.next = newTable[hash];
				newTable[hash]=table;
				table = next;
			}
		}
		hashArray = newTable;
	}
	

	public void display()
	{
		System.out.println();
        for (int i = 0; i < hashArray.length; i++) 
        {  
        	System.out.print(i + ":");
            DSAHashEntry list = hashArray[i]; 
            while (list != null) {
            System.out.print("  (" + list.getKey() + "," + list.getValue()+ ")");
            list = list.next;
            }
            System.out.println();
         }
	}

	public void saveFile(String inFile)
	{
		try
		{
			FileWriter fw = new FileWriter(inFile);
			fw.write("\n");
        	for (int i = 0; i < hashArray.length; i++) 
       		{  
       			fw.write(i + ":");
	            DSAHashEntry list = hashArray[i]; 
	            while (list != null)
	            {
	            	fw.write(" (" + list.getKey() + "," + list.getValue()+ ")");
	            	list = list.next;
	            }
	            fw.write("\n");
	        }

		fw.close();
		}catch(IOException e)
		{
			System.out.println("Error in file creation"); 
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
				put(data[0], data[1]);
				// hashCount++;
			}
			System.out.println("Successfully read file");
			buffRdr.close();

		}catch(IOException e)
		{
			System.out.println("Error in file processing : " + e.getMessage());
		}

	}


}