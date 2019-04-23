

public class DemoLab10 {

	public static void main(String[] args) 
	{
		LinkedList<String> list = new LinkedList<String>();
		
		BinaryTree<String> tree1 = new BinaryTree<String>("C");
		BinaryTree<String> tree2 = new BinaryTree<String>("E");
		BinaryTree<String> tree3 = new BinaryTree<String>("A");
		BinaryTree<String> tree4 = new BinaryTree<String>("F");
		BinaryTree<String> tree5 = new BinaryTree<String>("D");
		BinaryTree<String> tree6 = new BinaryTree<String>("B");
		
		tree1.setTree(tree2, tree3);
		tree2.setTree(tree4, tree5);
		tree3.setTree(tree6, null);
		
		tree1.inorderTraverse(list);
		System.out.println();
		tree1.preorderTraverse();
		System.out.println();
		tree1.postorderTraverse();
		System.out.println();
		
		ListIterator<String> iterator = list.listIterator(0);
		
		for(int i = 0; i < 2; i++)
			System.out.println(iterator.next());
		
		while(iterator.hasNext())
			System.out.println(iterator.next());
	}

}
