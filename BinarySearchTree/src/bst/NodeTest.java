package bst;

public class NodeTest {
	public static void main(String[] args) {
		Node n = new Node(15);
		int[] iList = {12, 18, 10, 16, 20, 11, 17};
		for (int i : iList){
			n.insert(i);
		}
		System.out.println(n);
		System.out.println(n.preOrderTraversal());
		System.out.println(n.inOrderTraversal());
		System.out.println(n.postOrderTraversal());
	}
}
