package arjun.kushwah.linkedList;

public class DoublyLinkList {
	private Node head;
	public DoublyLinkList() {
		Node n=new Node();
		n.value=0;
		n.prev=null;
		n.next=null;
		head=n;
	}
	public DoublyLinkList(int item) {
		Node n=new Node();
		n.value=item;
		n.prev=null;
		n.next=null;
		head=n;
	}

	class Node {
		private int value;
		private Node prev;
		private Node next;
	}
	public void delete(int item) {
		if(head.next.value==item) {
			head.next=head.next.next;
		}
		else {
			Node x=head.next.next;
			Node y=x.next;
			while (true) {
				if(y==null || y.value==item) {
					break;
				}
				else {
					x=y;
					y=y.next;
				}
			}
			if(y!=null) {
				x.next=y;
			}
		}
		
	}
	public void sortList() {
		Node x=head;
		while(x.next!=null) {
			Node y=head;
			while(y.next!=null) {
				if(x.value>y.value) {
					int c=x.value;
					x.value=y.value;
					y.value=c;
				}
				y=y.next;
			}
			x=x.next;
		}
	}
	public static void main(String []args) {
		DoublyLinkList dl=new DoublyLinkList();
	}
}
