import java.io.*;
import java.util.*;
public class BinarySearchTree implements Serializable
{
	private class TreeNode implements Serializable
	{
		private String m_key;
		private Object m_value;
		private TreeNode m_leftChild;
		private TreeNode m_rightChild;

		public TreeNode(String inKey, Object inVal)
		{
			if(inKey==null)
			{
				throw new IllegalArgumentException("Key cannot be null");
			}
			m_key = inKey;
			m_value = inVal;
			m_rightChild = null;
			m_leftChild = null;
		}

		public String getKey()
		{
			return m_key;
		}
		public Object getValue()
		{
			return m_value;
		}
		public TreeNode getLeft()
		{
			return m_leftChild;
		}
		public TreeNode getRight()
		{
			return m_rightChild;
		}
		public void setLeft(TreeNode inLeft)
		{
			m_leftChild = inLeft;
		}
		public void setRight(TreeNode inRight)
		{
			m_rightChild = inRight;
		}
	}

	private TreeNode m_root;

	public BinarySearchTree()
	{
		m_root =null;
	}
	public Object find(String inKey)
	{
		Object returnElement = null;
		try
		{
			returnElement = findRec(inKey, m_root);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Cannot find element\n" + e);
		}
		return returnElement;
	}
	private Object findRec(String key, TreeNode currNode)
	{
		Object value = null;
		if(currNode==null)
		{
			throw new NoSuchElementException("Key " + key + " is not found");
		}
		else if(key.equals(currNode.getKey()))
		{
			value = currNode.getValue();
		}
		else if(key.compareTo(currNode.getKey()) < 0)
		{
			value = findRec(key, currNode.getLeft());
		}
		else 
		{
			value = findRec(key, currNode.getRight());
		}
		return value;
	}
	public void insert(String inKey, Object inValue)
	{
		m_root = insertRec(inKey, inValue, m_root);
	}
	private TreeNode insertRec(String inKey, Object inValue, TreeNode currNode)
	{
		TreeNode updateNode = currNode;
		if(currNode == null)
		{
			TreeNode newNode = new TreeNode(inKey, inValue);
			updateNode = newNode;
		}
		else if(inKey.equals(currNode.getKey()))
		{
			System.out.println("Key already present in the tree");
		}
		else if(inKey.compareTo(currNode.getKey())<0)
		{
			currNode.setLeft(insertRec(inKey, inValue, currNode.getLeft()));
		}
		else
		{
			currNode.setRight(insertRec(inKey, inValue, currNode.getRight()));
		}
		return updateNode;
	}
	
    public void delete(String key)
    {
        m_root = deleteRec(key, m_root);
    }

    private TreeNode deleteRec(String key, TreeNode currNode)
    {
        TreeNode updateNode = currNode;
        if (key.equals(currNode.getKey()))
        {
            updateNode = deleteNode(key, currNode);
        }
        else if (key.compareTo(currNode.getKey()) < 0)
        {
            currNode.setLeft(deleteRec(key, currNode.getLeft()));
        }
        else if (key.compareTo(currNode.getKey()) > 0)
        {
            currNode.setRight(deleteRec(key, currNode.getRight()));
        }
        currNode = updateNode;
        return currNode;
    }
     private TreeNode deleteNode(String key, TreeNode delNode)
    {
        TreeNode updateNode = null;
        TreeNode currNode = delNode;

        if (delNode.getLeft() == null && delNode.getRight() == null)
        {
            delNode = null;
        }
        else if (delNode.getLeft() != null && delNode.getRight() == null)
        {
            updateNode = delNode.getLeft();
        } 
        else if (delNode.getLeft() == null && delNode.getRight() != null)
        {
            updateNode = delNode.getRight();
        }
        else
        {
            updateNode = promoteSuccessor(delNode);
            if (updateNode != delNode.getRight())
            {
                updateNode.setRight(delNode.getRight());
            }
            updateNode.setLeft(delNode.getLeft());
        }
        return updateNode;
    }
      private TreeNode promoteSuccessor(TreeNode currNode)
    {
        TreeNode successor = currNode;

        if (currNode.getLeft() == null)
        {
            successor = currNode;
        }

        if (currNode.getLeft() != null)
        {
            successor = promoteSuccessor(currNode.getLeft());
            if (successor == currNode.getLeft())
            {
                currNode.setLeft(successor.getRight());
            }
        }
        return successor;
    }


	public void display()
	{
		System.out.println("DISPLAY INORDER ");
		displayInOrder(m_root);
		System.out.println("DISPLAY PREORDER ");
		displayPreOrder(m_root);
		System.out.println("DISPLAY POSTORDER ");
		displayPostOrder(m_root);
	}

	/*
		----INORDER TRAVERSEL----
		Traverse the left subtree.
		Visit the root.
		Traverse the right subtree. 
	*/
	public void displayInOrder(TreeNode currNode)
    {
    	if(currNode!=null)
    	{
    		displayInOrder(currNode.getLeft());
    		System.out.print(currNode.getKey());
    		System.out.print(" : ");
    		System.out.println(currNode.getValue());
    		displayInOrder(currNode.getRight());

    	}
    }
    /* 
    	-----PREORDER TRAVERSAL----
    	Visit the root.
    	Traverse the left subtree.
    	Traverse the right subtree.
    */
    public void displayPreOrder(TreeNode currNode)
    {
    	if(currNode!=null)
    	{
    		System.out.print(currNode.getKey());
    		System.out.print(" : ");
    		System.out.println(currNode.getValue());
    		displayPreOrder(currNode.getLeft());
    		displayPreOrder(currNode.getRight());
    	}
    }
	/*
		------POSTORDER TRAVERSAL-----
		Traverse the left subtree.
		Traverse the right subtree.
		Visit the root.
	*/
    public void displayPostOrder(TreeNode currNode)
    {
    	if(currNode!=null)
    	{
    		displayPostOrder(currNode.getLeft());
    		displayPostOrder(currNode.getRight());
    		System.out.print(currNode.getKey());
    		System.out.print(" : ");
    		System.out.println(currNode.getValue());
    	}
    }

    //method signatures used for the interactive menu
    public void disInOrder()
    {
    	displayInOrder(m_root);
    }
    public void disPreOrder()
    {
    	displayPreOrder(m_root);
    }
    public void disPostOrder()
    {
    	displayPostOrder(m_root);
    }

    

	 public int height()
    {
        return heightRec(m_root);
    }

    private int heightRec(TreeNode currNode)
    {
        int currHeight, leftHeight, rightHeight;

        if (currNode == null)
        {
            currHeight = 0;
        }
        else
        {
            leftHeight = heightRec(currNode.getLeft());
            rightHeight = heightRec(currNode.getRight());

            if (leftHeight > rightHeight)
            {
                currHeight = leftHeight + 1;
            }
            else
            {
                currHeight = rightHeight + 1;
            }
        }
        return currHeight;
    }
    public String minIter()
    {
        String minKey = minIter(m_root);
        return minKey;
    }

    private String minIter(TreeNode currNode)
    {
        String minKey;
        while (currNode.getLeft() != null)
        {
            currNode = currNode.getLeft();
        }
        minKey = currNode.getKey();
        return minKey;
    }

    public String maxIter()
    {
        String maxKey = maxIter(m_root);
        return maxKey;
    }

    private String maxIter(TreeNode currNode)
    {
        String maxKey;
        while (currNode.getRight() != null)
        {
            currNode = currNode.getRight();
        }
        maxKey = currNode.getKey();
        return maxKey;
    }

    public void balance()
    {
        balance(m_root);
    }

    private void balance(TreeNode currNode)
    {
        int leftHeight = heightRec(currNode.getLeft());
        int rightHeight = heightRec(currNode.getRight());

        System.out.print("The height balance is : ");
        System.out.print(leftHeight / rightHeight * 100);
        System.out.println("%");
    }
}