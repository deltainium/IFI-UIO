// First in means first out
// Linked list has dynamic size???

import java.util.Iterator;

abstract class Lenkeliste <E> implements Liste <E>{

	int stor;
	Node forste;

	public class Node{

			public E data;
			public Node neste;

			public Node(){
				this.neste = null;
			}

			public Node hentNeste(){
				return this.neste;
			}

			public void setNeste(Node neste){
				this.neste = neste;
			}

			public E hentData(){
				return this.data;
			}

			public void setData(E newData){
				this.data = newData;
			}
			

		}


	public class LenkelisteIterator implements Iterator<E>{
		Node peker;

		public LenkelisteIterator(Lenkeliste<E> maal){
			Lenkeliste<E> liste = maal;
			peker = liste.forste;
		}

		public boolean hasNext(){
			if (peker.hentNeste() != null){
				return true;
			}
			else{
				return false;
			}
		}

		public E next(){
			if (this.hasNext()){
				E data = peker.hentData();
				peker = peker.hentNeste();
				return data;
			}
			else{
				E data = peker.hentData();
				peker = null;
				return data;
			}
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
		Node elem = new Node();
		elem.setData(data);

		if (this.forste == null){
			this.forste = elem;
		}
		else{
			boolean status = false;
			Node denne = forste;
			Node neste = forste.hentNeste();

			while (status == false){
				if (neste == null){
					denne.setNeste(elem);
					status = true;
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
		if (forste == null){
			throw new UgyldigListeindeks(0);
		}
		else if (forste.hentNeste() == null){
			E data = forste.hentData();
			forste = null;
			this.stor -= 1;
			return data;
		}
		else{
		E data = this.forste.hentData();
		forste = forste.hentNeste();
		this.stor -= 1;
		return data;
		}
	}
	
	public String toString(){
		Node neste = forste;
		String str = "";

		while (neste != null){
			str += neste.hentData();
			str += " ";
			neste = neste.hentNeste();
		}
		
		return str.substring(0, str.length());
	}

	public Iterator<E> iterator(){
		return new LenkelisteIterator(this);
	}

}
