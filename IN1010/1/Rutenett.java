public class Rutenett{
	Celle[][] rutene;
	int antRader;
	int antKolonner;

	public Rutenett(int antRader, int antKolonner){
		rutene = new Celle[antRader][antKolonner];
		this.antRader = antRader;
		this.antKolonner = antKolonner;
	}

	public void lagCelle(int rad, int kol){
		Celle ny = new Celle();

		if (Math.random() <= 0.3333){
			ny.settLevende();
		}

		rutene[rad][kol] = ny;
	}

	public void fyllMedTilfeldigeCeller(){
		for (int r = 0; r < antRader; r++){
			for (int k = 0; k < antKolonner; k++){
				lagCelle(r, k);
			}
		}
	}

	public Celle hentCelle(int rad, int kol){
		if (rad < 0 || rad > antRader-1 || kol < 0 || kol > antKolonner-1){
			return null;
		}
		else{
			return rutene[rad][kol];
		}
	}

	public void tegnRutenett(){
		for (int r = 0; r < antRader; r++){
			for (int k = 0; k < antKolonner; k++){
				System.out.print(this.hentCelle(r,k).hentStatusTegn());
			}
			System.out.print("\n");
		}
	}

	public void settNaboer(int rad, int kol){
		Celle celle = this.hentCelle(rad, kol);

		for (int r = rad-1; r < rad+2; r++){
			for (int k = kol-1; k < kol+2; k++){
				if (r == rad && k == kol){
					continue;
				}
				else if (this.hentCelle(r, k) != null){
					celle.leggTilNabo(this.hentCelle(r,k));
				}
			}
		}
	}

	public void kobleAlleCeller(){
		for (int r = 0; r < antRader; r++){
			for (int k = 0; k < antKolonner; k++){
				this.settNaboer(r,k);
			}
		}
	}

	public int antallLevende(){
		int teller = 0;

		for (int r = 0; r < antRader; r++){
			for (int k = 0; k < antKolonner; k++){
				if (this.hentCelle(r,k).erLevende()){
					teller += 1;
				}
			}
		}

		return teller;
	}

}
