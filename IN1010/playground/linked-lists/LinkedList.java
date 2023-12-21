import java.util.HashMap;

abstract class LinkedList<E>{
	int sizeOf;
	int prevIndex;
	HashMap<Integer, Node<E>> web = new HashMap<Integer, Node<E>>(); // acts as a web of nodes

	public LinkedList(){
		this.prevIndex = -1;
		this.sizeOf = 0;
	}

	public void addNode(E data){
		Node<E> fresh = new Node<E>();
		fresh.setData(data);
		fresh.setPos(prevIndex+1);

		for (int i = 0; i == sizeOf; i++){
			Node<E> fetched = web.get(i);
			if (fetched.getPos() == this.prevIndex){
				fetched.setNext(fresh);
			}
		}
		
		web.put(prevIndex+1, fresh);
		
		this.sizeOf += 1;
		this.prevIndex += 1;
	}

	public E fetchData(int index){
		return web.get(index).getData();
	}

	public int fetchSize(){
		return this.sizeOf;
	}

}
