public class LinkList
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

	public LinkList()
	{
		head = null;
		tail = null;
	}

	public void display()
	{
		if(isEmpty())
		{
			System.out.println("Link List is empty ");
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
			tail = newNode;
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
		if(isEmpty())
		{
			tail = newNode;
			head = newNode;
		}
		else
		{
			tail.setNext(newNode); //make connection. make tail point to newNode before assingnig the newNode to tail
			tail = newNode;
		}
	}

	public Object removeFirst()
	{
		Object delNode=null;

		if(isEmpty())
		{
			System.out.println("Link list is empty ");
		}
		if(head==tail)
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
		Object delNode=null;
		if(isEmpty())
		{
			System.out.println("Link List is empty ");
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
		Object node=null;
		ListNode currNode = head;
		if(isEmpty())
		{
			System.out.println("Link List in empty");
		}
		else
		{
			node  = currNode.getValue();
		}
		return node;
	}

	public Object peekLast()
	{
		Object node=null;
		ListNode currNode = tail;

		if(isEmpty())
		{
			System.out.println("Link List is empty ");
		}
		else
		{
			node = currNode.getValue();
		}
		return node;
	}








}