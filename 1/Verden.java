public class Verden{
	Rutenett rutenett;
	int genNr;
	int rad;
	int kol;

	public Verden(int rader, int kolonner){
		rutenett = new Rutenett(rader, kolonner);
		genNr = 0;
		rad = rader;
		kol = kolonner;

		rutenett.fyllMedTilfeldigeCeller();
		rutenett.kobleAlleCeller();
	}

	public void tegn(){
		System.out.println("Generasjon nr. "+genNr+":");
		rutenett.tegnRutenett();
		System.out.println("Antall levende celler: "+rutenett.antallLevende()+"\n");
	}

	public void oppdatering(){
		for (int r = 0; r < rad; r++){
			for (int k = 0; k < kol; k++){
				Celle celle = rutenett.hentCelle(r,k);
				celle.tellLevendeNaboer();
			}
		}
		for (int r = 0; r < rad; r++){
			for (int k = 0; k < kol; k++){
				Celle celle = rutenett.hentCelle(r,k);
				celle.oppdaterStatus();
			}
		}
		
		this.genNr += 1;
	}

}
