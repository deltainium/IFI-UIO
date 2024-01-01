public class IndeksertListe<E> extends Lenkeliste<E>{

	public void leggTil(int pos, E x){
		this.stor++;
		// 0<=pos<=this.stor
		if (pos < 0 || pos > stor){
			throw new UgyldigListeindeks(pos);
		}

		Node nytt = new Node();
		nytt.setData(x);
		
		if (pos == 0){
			if (this.forste == null){
				this.forste = nytt;
			}
			else{
				Node kopi = new Node();
				kopi.setData(this.forste.hentData());
				kopi.setNeste(this.forste.hentNeste());

				nytt.setNeste(kopi);
				this.forste = nytt;
			}
		}

		else{
			Node denne = this.forste;

			if (pos == stor){
				while (true) {
					if (denne.hentNeste() == null){
						denne.setNeste(nytt);
						break;
					}
					else{
						denne = denne.hentNeste();
					}
				}
			}

			else{
				int teller = 0;

				while (true){
					if (teller == pos-1){
						Node kopi = new Node();
						kopi.setData(x);
						kopi.setNeste(denne.hentNeste());
						denne.setNeste(kopi);
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
		if (pos < 0 || pos >= this.stor){
			throw new UgyldigListeindeks(pos);
		}

		int teller = 0;
		Node denne = this.forste;

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
		if (pos < 0 || pos >= this.stor){
			throw new UgyldigListeindeks(pos);
		}

		int teller = 0;
		Node denne = this.forste;

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
		if (pos < 0 || pos >= this.stor){
			throw new UgyldigListeindeks(pos);
		}

		this.stor--;

		int teller = 0;
		Node denne = this.forste;
		
		while (true){
			if (teller == pos-1){
				Node ny = denne.hentNeste().hentNeste();
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
