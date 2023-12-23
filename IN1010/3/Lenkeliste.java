// First in means first out
// Linked list has dynamic size???

abstract class Lenkeliste <E> implements Liste <E>{

	int stor;
	Node<E> forste;

	private class Node<E>{

			private E data;
			private Node<E> neste;

			public Node(){
				this.neste = null;
			}

			public Node<E> hentNeste(){
				return this.neste;
			}

			public void setNeste(Node<E> neste){
				this.neste = neste;
			}

			public E hentData(){
				return this.data;
			}

			public void setData(E newData){
				this.data = newData;
			}
			

		}


	public Lenkeliste(){
		stor = 0;
		forste = null;
	}

	public int stoerrelse(){
		return this.stor;
	}

	public void leggTil(E data){
		Node<E> elem = new Node<E>();
		elem.setData(data);

		if (forste == null){
			forste = elem;
		}
		else{
			boolean status = false;
			Node<E> denne = forste;
			Node<E> neste = forste.hentNeste();

			while (status == false){
				if (neste == null){
					denne.setNeste(elem);
				}
				else{
					denne = denne.hentNeste();
					neste = neste.hentNeste();
				}
			}
		}

		this.stor += 1;
	}

	public E hent(){
		return this.forste.hentData();
	}

	public E fjern(){
		E data = this.forste.hentData();
		forste = forste.hentNeste();
		return data;
	}
	
	public String toString(){
		Node<E> neste = forste;
		String str = "";

		for (int i = 0; i == this.stor; i++){
			str += String.valueOf(neste.hentData());
			str += " ";
			neste = neste.hentNeste();
		}
		
		return str.substring(0, str.length()-1);
	}

}
