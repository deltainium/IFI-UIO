// Singly linked list
public class Node<E>{
	private E data;
	private Node<E> next;
	private int pos;

	public Node(){
		this.next = null;
	}

	public int getPos(){
		return this.pos;
	}

	public void setPos(int newPos){
		this.pos = newPos;
	}

	public Node<E> getNext(){
		return this.next;
	}

	public void setNext(Node<E> next){
		this.next = next;
	}

	public E getData(){
		return this.data;
	}

	public void setData(E newData){
		this.data = newData;
	}

}
