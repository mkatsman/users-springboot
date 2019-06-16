package myspringboot.service;

/**
 * Single Linkedlist
 * 
 * @author masha
 *
 */
public class MyLinkedList {

	private Node root;

	private Integer size = 0;

	public MyLinkedList() {
		root = new Node();
	}

	public void add(Node node) {
		if (node == null)
			return;
		Node temp = root;
		root = node;
		root.setNext(temp);
		size = size++;
	}

	public void remove(String value) {
		Node node = find(value);

	}

	public Node find(String value) {
		Node next = root.getNext();

		while (true) {
			if (next == null)
				break;
			if (next.getValue().equals(value)) {
				return next;
			}
		}
		return null;
	}

	private class Node {
		private String value;
		private Node next;
		private Node prev;

		public Node() {
			
		}
		public Node(String value) {
			this.value = value;
		}

		public Node getNext() {
			return next;

		}

		/**
		 * @return the data
		 */
		String getValue() {
			return value;
		}

		/**
		 * @param data the data to set
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * @param next the next to set
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/**
		 * @return the prev
		 */
		public Node getPrev() {
			return prev;
		}

		/**
		 * @param prev the prev to set
		 */
		public void setPrev(Node prev) {
			this.prev = prev;
		}
	}

	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * @return the root
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(Node root) {
		this.root = root;
	}
}