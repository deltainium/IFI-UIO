public class IndeksertListe<E> extends Lenkeliste<E>{

	public void leggTil(int pos, E x){
		String input = pos + "";

		if (input.isEmpty()){
			pos = (this.stor-1);
		}

		this.stor += 1;

		int teller = 0;
		Node<E> nytt = new Node<E>();
		nytt.setData(x);

		if (pos == 0){
			this.forste = nytt;;
		}

		Node<E> denne = this.forste;

		while (true){
			if (teller == pos-1){
				Node<E> kopi = new Node<E>();
				kopi.setData(denne.hentNeste().hentData());
				kopi.setNeste(denne.hentNeste().hentNeste());
				denne.setNeste(nytt);
				nytt.setNeste(kopi);
				break;
			}
			teller += 1;
			denne = denne.hentNeste();
		}
	}
	
	public void sett (int pos, E x){
		int teller = 0;
		Node<E> denne = this.forste;

		while (true){
			if (teller == pos){
				denne.setData(x);
				break;
			}
			else{
				denne = denne.hentNeste();
					teller += 1;
			}

		}

	}

	public E hent (int pos){
		int teller = 0;
		Node<E> denne = this.forste;

		while (true){
			if (teller == pos){
				return denne.hentData();
			}
			else{
				teller += 1;
				denne = denne.hentNeste();
			}
	}
	}

	public E fjern (int pos){
		this.stor -= 1;

		int teller = 0;
		Node<E> denne = this.forste;
		
		while (true){
			if (teller == pos-1){
				Node<E> ny = denne.hentNeste().hentNeste();
				E data = denne.hentNeste().hentData();
				denne.setNeste(ny);
				return data;
			}
			else{
				teller += 1;
				denne = denne.hentNeste();
			}
		}
	}

}
