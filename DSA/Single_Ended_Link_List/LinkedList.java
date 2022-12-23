public class LinkedList
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

	public LinkedList()
	{
		head = null;
	}

	public void insertFirst(Object inValue)
	{
		ListNode newNode = new ListNode(inValue);
		if(isEmpty())
		{
			head = newNode;
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
		ListNode currNode;

		if(isEmpty())
		{
			head = newNode;
		}
		else
		{
			currNode = head;
			while(currNode.getNext()!=null)
			{
				currNode = currNode.getNext();
			}
			currNode.setNext(newNode);
		}
	}

	public boolean isEmpty()
	{
		return head==null;
	}

	public Object peekFirst()
	{
		Object nodeValue=null;
		if(isEmpty())
		{
			System.out.println("List is empty ");
		}
		else
		{
			nodeValue = head.getValue();
		}
		return nodeValue;
	}

	public Object peekLast()
	{
		ListNode currNode;
		Object nodeValue=null;
		if(isEmpty())
		{
			System.out.println("List is empty ");
		}
		else
		{
			currNode = head;
			while(currNode.getNext()!=null)
			{
				currNode = currNode.getNext();
			}
			nodeValue = currNode.getValue();
		}
		return nodeValue;
	}

	public Object removeFirst()
	{
		Object nodeValue=null;
		if(isEmpty())
		{
			System.out.println("List is empty ");
		}
		else
		{
			nodeValue = head.getValue();
			head = head.getNext();
		}
		return nodeValue;
	}

	public Object removeLast()
	{
		Object nodeValue=null;
		if(isEmpty())
		{
			System.out.println("List is empty ");
		}
		else if(head.getNext() == null)
		{
			nodeValue = head.getValue();
			head = null;
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
			prevNode.setNext(null);
			nodeValue = currNode.getValue();
		}
		return nodeValue;
	}

	public void display()
	{
		if(isEmpty())
		{
			System.out.println("List is empty ");
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






}