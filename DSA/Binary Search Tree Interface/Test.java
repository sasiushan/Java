public class Test
{
	public static void main(String[] args)
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert("12", 1002);
		bst.insert("22", 2002);
		bst.insert("13", 3002);
		bst.delete("12");
		bst.display();


       
        
		System.out.println("\n\nfound value : " + bst.find("22"));
        // System.out.println("\n\nfound value : " + bst.find("66"));



    
        System.out.print("\n\n\nThe height of this tree is: ");
        System.out.println(bst.height());
        System.out.print("The smallest value of this tree is: ");
        System.out.println(bst.minIter());
        System.out.print("The largest value of this tree is: ");
        System.out.println(bst.maxIter());


        System.out.println("\n\n\nNEW BALANCED TREE");
        BinarySearchTree balancedTree = new BinarySearchTree();
        balancedTree.insert("30", "Hello world!");
        balancedTree.insert("18", "Hello world!");
        balancedTree.insert("50", "Hello world!");
        balancedTree.insert("24", "Hello world!");
        balancedTree.insert("36", "Hello world!");
        balancedTree.insert("51", "Hello world!");
        balancedTree.disInOrder();
        balancedTree.balance();
		// bst.display();
	}
}