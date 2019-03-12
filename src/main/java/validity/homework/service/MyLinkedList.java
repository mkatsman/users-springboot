package validity.homework.service;

public class MyLinkedList {

	private Node root;
	private Integer size = 0;
	private Node prev;

	public void add(Node node) {
     root =  node;
     size = size++;
	}

	public void remove(Node node) {
        Node prev;
		Node node1 = find (node.getData());
         
	}

	public Node find(String data) {
		Node next = root.getNext();
		
		while(true) {
			if (next == null) break;
			if(next.getData().equals(data) ) {
				return next;
			}
		}
		return null;
	}
	
	private class Node {
		private String data;

		public Node getNext() {
			return null;

		}

		/**
		 * @return the data
		 */
		String getData() {
			return data;
		}

		/**
		 * @param data the data to set
		 */
		void setData(String data) {
			this.data = data;
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