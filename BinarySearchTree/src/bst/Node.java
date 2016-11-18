package bst;

public class Node {
	// fields
	private int value;
	private Node left;
	private Node right;

	// constructors
	public Node(int v) {
		this.setValue(v);
	}

	// getters and setters
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	// other methods
	public void insert(int v) {
		if (v > this.getValue()) {
			if (this.right != null) {
				this.right.insert(v);
			} else {
				this.right = new Node(v);
			}
		} else if (v < this.getValue()) {
			if (this.left != null) {
				this.left.insert(v);
			} else {
				this.left = new Node(v);
			}
		} // ignore the case where d==this.value
	}

	public Node find(int v) {
		if (v > this.getValue()) {
			if (this.right != null) {
				return this.right.find(v);
			} else {
				return null;
			}
		} else if (v < this.getValue()) {
			if (this.left != null) {
				return this.left.find(v);
			} else {
				return null;
			}
		} else {return this;}
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder(Integer.toString(this.getValue()));
		if (this.left!=null || this.right!=null){
			s.append("(");
			if (this.left != null){
				s.append(this.left.toString() + ",");
			} else {s.append("__,");}
			if (this.right != null){
				s.append(this.right.toString() + ")");
			} else {s.append("__)");}		
		}
		return s.toString();
	}
	
	public String preOrderTraversal(){
		StringBuilder s = new StringBuilder(Integer.toString(this.getValue())+", ");
		if (this.left != null){
			s.append(this.left.preOrderTraversal());
		}
		if (this.right != null){
			s.append(this.right.preOrderTraversal());
		}
		return s.toString();
	}
	
	public String inOrderTraversal(){
		StringBuilder s = new StringBuilder();
		if (this.left != null){
			s.append(this.left.inOrderTraversal());
		}
		
		s.append(Integer.toString(this.getValue())+", ");
		
		if (this.right != null){
			s.append(this.right.inOrderTraversal());
		}
		return s.toString();		
	}
	
	public String postOrderTraversal(){
		StringBuilder s = new StringBuilder();
		if (this.left != null){
			s.append(this.left.postOrderTraversal());
		}	
		
		if (this.right != null){
			s.append(this.right.postOrderTraversal());
		}
		
		s.append(Integer.toString(this.getValue())+", ");
		
		return s.toString();			
	}
}
