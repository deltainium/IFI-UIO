public class IndeksertListe<E> extends Lenkeliste<E>{

	public void leggTil(int pos, E x){
		// 0<=pos<=this.stor
		if (pos < 0 || pos > stor){
			throw new UgyldigListeindeks(pos);  
		}

		Node<E> nytt = new Node<E>();
		nytt.setData(x);
		
		if (pos == 0){
			if (this.forste == null){
				this.forste = nytt;
			}
			else{
				Node<E> kopi = new Node<E>();
				kopi.setData(this.forste.hentData());
				kopi.setNeste(this.forste.hentNeste());

				nytt.setNeste(kopi);
				this.forste = nytt;
			}
		}

		else{
			Node<E> denne = this.forste;
			int teller = 0;

			if (pos == stor){
				while (true) {
					if (teller == pos-1){
						denne.setNeste(nytt);
						break;
					}
					else{
						denne = denne.hentNeste();
						teller++;
					}
				}
			}

			else{
				while (true){
					if (teller == pos-1){
						Node<E> kopi = new Node<E>();
						kopi.setData(x);
						kopi.setNeste(denne.hentNeste());
						break;
					}
					else {
						denne = denne.hentNeste();
						teller++;
					}
				}
			}
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
