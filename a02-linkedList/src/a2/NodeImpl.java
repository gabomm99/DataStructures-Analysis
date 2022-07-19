package a2;

public class NodeImpl implements Node {

	private int _value;
	private Node _next;
	
	public NodeImpl(int value, Node next) {
		_value = value;
		_next = next;
	}
	

	public int getValue() {

		return _value;
	}


	public void setValue(int value) {
		_value = value;
	}


	public Node getNext() {
		return _next;
	}


	public void setNext(Node next) {
		_next = next;
	}
}
