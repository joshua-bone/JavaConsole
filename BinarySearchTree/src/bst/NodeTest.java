package bst;

public class NodeTest {
	public static void main(String[] args) {
		Node n = new Node(15);
		int[] iList = {12, 18, 10, 16, 20, 11, 17};
		for (int i : iList){
			n.insert(i);
		}
		System.out.println("Binary Tree: " + n);
		System.out.println("PreOrder: " + n.preOrderTraversal());
		System.out.println("InOrder: " + n.inOrderTraversal());
		System.out.println("PostOrder: " + n.postOrderTraversal());
	}
}
