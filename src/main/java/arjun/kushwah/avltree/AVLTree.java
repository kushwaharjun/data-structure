package arjun.kushwah.avltree;

/**
*@author Arjun kushwah
*@Date  22-July-2019
*/
public class AVLTree{
	Node node;

	private class Node {
		private int data;
		private int hight;
		private Node left;
		private Node right;

		private Node(int data) {
			this.data = data;
			hight = 1;
			left = right = null;
		}
	}

	public void insert(int data) {
		this.node = insert(this.node, data);
	}

	private Node insert(Node node,int data) {
		if(node==null) {
			return new Node(data);
		}
		else {
			if(node.data>data || node.data==data) {
				node.left=insert(node.left,data);
			}else {
				node.right=insert(node.right,data);
			}
			node.hight=Math.max(hight(node.left),(hight(node.right))+1);
			int factor=hight(node.left)-hight(node.right);
			if(factor>1 && node.data>data ) {
				this.node=rightRotate(node);
			}else if(factor>1 && node.left.data <data){
				node.left=leftRotate(node.left);
				node=rightRotate(node);
			}
			if(factor <-1 && node.data<data) {
				node=leftRotate(node);
			}else if(factor<-1 && data<node.right.data){
				node.right=rightRotate(node.right);
				node=leftRotate(node);
			}
		}
		return node;
	}

	private Node leftRotate(Node node) {
		Node B = node.right;
		Node T3 = B.left;
		B.left = node;
		node.right = T3;
		return B;
	}

	private Node rightRotate(Node node) {
		Node B = node.left;
		Node T2 = B.right;
		B.right = node;
		node.left = T2;
		return B;
	}

	private int hight(Node node) {
		if(node!=null) {
		return node.hight;
		}else {
			return 0;
		}
	}
	public void display(Node node) {
		System.out.println(node.data);
		if(node.left!=null) {
			display(node.left);
		}
		else if(node.right!=null) {
			display(node.right);
		}
	}

}
