package arjun.kushwah.tree;

public class BTree {
	private Node root;

	private class Node {
		private int data;
		private Node left;
		private Node right;

		private Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public void insert(int data) {
		Node n = root;
		if (n != null) {
			while (n != null) {
				if (n.data > data) {
					if (n.left != null) {
						n = n.left;
					} else {
						n.left = new Node(data);
						break;
					}
				} else {
					if (n.right != null) {
						n = n.right;
					} else {
						n.right = new Node(data);
						break;
					}
				}
			}
		} else {
			root = new Node(data);
		}
	}

	public void print(Node n) {
		Node node = n;
		if (node != null) {
			System.out.println(node.data);
			print(node.left);
			print(node.right);
		}
	}
	public static void main(String args[]) {
		System.out.println("Hello");
		BTree pt=new BTree();
		pt.insert(4);
		pt.insert(2);
		pt.insert(3);
		pt.insert(1);
		pt.insert(5);
		pt.print(pt.root);
	}

}
