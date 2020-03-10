package arjun.kushwah.tree;

import pojo.Person;

public class BSTPerson {
	private Node root;

	public BSTPerson() {
		root = null;
	}

	public boolean insert(Person item) {
		Node n = new Node();
		n.person = item;
		n.lc = null;
		n.rc = null;
		if (root == null) {
			root = n;
			return true;
		}
		Node p = root;
		Node c = root;
		while (c != null) {
			p = c;
			if (item.getName().compareTo(c.person.getName()) < 0) {
				c = c.lc;
			} else {
				c = c.rc;
			}
		}
		if (item.getName().compareTo(p.person.getName()) < 0) {
			p.lc = n;
		} else {
			p.rc = n;
		}
		return true;
	}

	/*
	 * void show(Node n) { if (n != null & n.lc == null & n.rc == null) {
	 * System.out.println(n.person.getName()); } else if (n != null & n.lc != null)
	 * { show(n.lc); } else { show(n.rc); } }
	 */
	void show(Node n) {
		Node p = n;
		if (p != null) {
			System.out.println(p.person.getName());
			show(p.lc);
			show(p.rc);
		}
	}

	public Node findNode(String key) {
		Node n = root;
		while (n != null) {
			if (n.person.getName().compareTo(key) == 0) {
				break;
			}
			if (n.person.getName().compareTo(key) < 0) {
				n = n.lc;
			} else {
				n = n.rc;
			}
		}
		return n;
	}

	public String findParent(String name) {
		Node p = root;
		Node c = root;
		while (c != null) {
			if (name.compareTo(c.person.getName()) == 0) {

				return p.person.getName() == null ? "" : p.person.getName();
			}
			if (name.compareTo(c.person.getName()) < 0) {
				c = c.lc;
			} else {
				c = c.rc;
			}
			if (name.compareTo(c.person.getName()) != 0) {
				p = c;
			}
		}
		return p.person.getName();
	}

	public String findCommonParent(String name, String name1) {
		if (findParent(name).equals(findParent(name1))) {
			return findParent(name);
		} else {
			String s = "";
			String name2 = findParent(name);
			String name4 = findParent(name1);
			while (name2 != null & !name2.isEmpty()) {
				name2 = findParent(name2);
				while (name4 != null & !name4.isEmpty()) {
					name4 = findParent(name4);
					if (name2.equals(name4)) {
						s = name2;
						break;
					}

				}
			}
			return s;
		}
	}

	public int findHight(Node n) {
		int hight = 0;
		int left;
		int right;
		while (n != null) {
			if (n.lc == null & n.rc == null) {
				return 0;
			} else {
				if(n.lc != null & n.rc != null){
				left =findHight(n.lc);
				right=findHight(n.rc);
				hight=1+left-right;
				return hight;
			}
			}
		}

		return hight;
	}

	class Node {
		Node lc;
		Node rc;
		Person person;
	}

	public static void main(String args[]) {
		BSTPerson bst = new BSTPerson();
		Person p1 = new Person();
		p1.setName("umair");
		Person p2 = new Person();
		p2.setName("ali");
		Person p3 = new Person();
		p3.setName("uzair");
		Person p4 = new Person();
		p4.setName("adam");
		Person p5 = new Person();
		p5.setName("john");
		Person p6 = new Person();
		p6.setName("x");
		Person p7 = new Person();
		p7.setName("y");
		Person p8 = new Person();
		p8.setName("z");

		bst.insert(p1);
		bst.insert(p2);
		bst.insert(p3);
		bst.insert(p4);
		bst.insert(p5);
		bst.insert(p6);
		bst.insert(p7);
		bst.insert(p8);	

		// bst.show(bst.findNode("umair"));
		// System.out.println(bst.findCommonParent("john1", "ali1"));
		System.out.println("hello");
		System.out.println(bst.findHight(bst.findNode("umair")));

	}

}
