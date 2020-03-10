package arjun.kushwah.linkedList;

public class IntLinkList {
	private Node head;
	private boolean isEmptyConst = false;

	public IntLinkList() {
		isEmptyConst = true;
	}

	public IntLinkList(int item) {
		head = new Node();
		head.value = item;
		head.link = null;
	}

	public boolean add(int value) {
		Node n = new Node();
		n.value = value;
		n.link = head;
		head = n;
		return true;
	}

	public int remove() {
		head = head.link;
		return head.value;
	}

	public boolean remove(int item) throws Exception {
		boolean isItemAvail = false;
		if (head.value == item) {
			head = head.link;
			isItemAvail = true;
		} else {
			Node previusNode = head;
			Node n = head.link;
			while (n != null) {
				if (n.value == item) {
					previusNode = n.link;
					isItemAvail = true;
				}
				previusNode = n;
				n = n.link;
			}
		}
		return isItemAvail;
	}

	public void printLinkedList() {
		Node n = head;
		while (n != null) {
			System.out.println(n.value);
			n = n.link;
		}
	}

	public int peekFirst() throws Exception {
		if (head != null) {
			return head.value;
		} else {
			throw new Exception("Empty list");
		}
	}

	public int peekLast() throws Exception {
		if (head.link == null) {
			return head.value;
		} else if (head == null) {
			throw new Exception("Empty list");
		} else {
			Node n = head;
			while (n.link != null) {
				n = n.link;
			}
			return n.value;
		}
	}

	class Node {
		int value;
		Node link;
	}

	public static void main(String[] args) throws Exception {
		IntLinkList lt = new IntLinkList(5);
		lt.add(2);
		lt.add(8);

		lt.printLinkedList();
		lt.remove(2);
		System.out.println("\n");
		lt.printLinkedList();

	}
}
