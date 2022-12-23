import java.io.*;
import java.util.*;
public class DSALinkedList
{
	private class ListNode
	{
		public Object value;
		public ListNode next;

		public ListNode(Object inValue)
		{	
			value = inValue;
			next = null;
		}

		public Object getValue()
		{
			return value;
		}

		public ListNode getNext()
		{
			return next;
		}

		public void setValue(Object inValue)
		{
			value = inValue;
		}
		public void setNext(ListNode inNext)
		{
			next = inNext;
		}
	}

	public ListNode head;
	public ListNode tail;

	public DSALinkedList()
	{
		head = null;
		tail = null;
	}

	public void display()
	{
		if(isEmpty())
		{
			System.out.println("Link List is empty");
		}
		else
		{
			ListNode currNode = head;
			while(currNode!=null)
			{
				System.out.print(currNode.getValue() + " ");
				currNode = currNode.getNext();
			}
			System.out.println();
		}
	}

	public boolean isEmpty()
	{
		return head == null;
	}

	public void insertFirst(Object inValue)
	{
		ListNode newNode = new ListNode(inValue);
		if(isEmpty())
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			newNode.setNext(head);
			head = newNode;
		}
	}

	public void insertLast(Object inValue)
	{
		ListNode newNode = new ListNode(inValue);
		if(isEmpty())
		{
			head= newNode;
			tail = newNode;
		}
		else
		{
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	public Object removeFirst()
	{
		Object delNode =null;
		if(isEmpty())
		{
			System.out.println("Link list is empty");
		}
		else if(head==tail)
		{
			head = null;
			tail = null;
		}
		else
		{
			delNode = head.getValue();
			head = head.getNext();
		}

		return delNode;
	}

	public Object removeLast()
	{
		Object delNode = null;
		if(isEmpty())
		{
			System.out.println("Link List is empty");
		}
		else
		{
			ListNode currNode = head;
			ListNode prevNode = null;

			while(currNode.getNext()!=null)
			{
				prevNode = currNode;
				currNode = currNode.getNext();
			}

			delNode = currNode.getValue();

			if(!(head==tail))
			{
				tail = prevNode;
				tail.setNext(null);
			}
			else
			{
				head = null;
				tail = null;
			}
		}
		return delNode;
	}

	public Object peekFirst()
	{
		Object returnNode=null;
		if(isEmpty())
		{
			System.out.println("Link List is empty");
		}
		else
		{
			returnNode = head.getValue();
		}
		return returnNode;
	}

	public Object peekLast()
	{
		Object returnNode=null;
		if(isEmpty())
		{
			System.out.println("Link List is empty");
		}
		else
		{
			returnNode = tail.getValue();
		}
		return returnNode;
	}

	 public static void save(DSALinkedList objToSave, String fileName)
    {
        FileOutputStream fileStrm;
        ObjectOutputStream objStrm;

        try
        {
            fileStrm = new FileOutputStream(fileName);
            objStrm = new ObjectOutputStream(fileStrm);
            objStrm.writeObject(objToSave);
            objStrm.close();
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Unable to save object to file");
        }
    }

    public static DSALinkedList load(String fileName) throws IllegalArgumentException
    {
        FileInputStream fileStrm;
        ObjectInputStream objStrm;
        // DSALinkedList inObj = null;
        DSALinkedList inObj = new DSALinkedList();

        try
        {
            fileStrm = new FileInputStream(fileName);
            objStrm = new ObjectInputStream(fileStrm);
            inObj.insertFirst((DSALinkedList) objStrm.readObject());
            objStrm.close();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class Container not found" + e.getMessage());
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Unable to load object from file");
        }
        return inObj;
    }



}