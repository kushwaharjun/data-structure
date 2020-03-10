package arjun.kushwah.avltree;


/**
@author Arjun kushwah
@Date  22-July-2019
**/
public class AVLClient{
	public static void main(String sgs[]) {
		AVLTree avltree=new AVLTree();
		avltree.insert(10);
		avltree.insert(9);
		avltree.insert(8);
		avltree.insert(12);
		avltree.insert(10);
		avltree.insert(10);
		avltree.display(avltree.node);
	}
}
