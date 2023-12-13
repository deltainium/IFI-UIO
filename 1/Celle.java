public class Celle{
	boolean levende; 
	Celle[] naboer;
	int antNaboer;
	int antLevendeNaboer;

	public Celle(){
		levende = false;
		naboer = new Celle[8];
		antNaboer = 0;
		antLevendeNaboer = 0;
	}

	public void settDoed(){
		this.levende = false;
	}
	
	public void settLevende(){
		this.levende = true;
	}

	public boolean erLevende(){
		return this.levende;
	}

	public char hentStatusTegn(){
		if (this.levende){
			return 'O';
		}
		else{
			return '.';
		}
	}

	public void leggTilNabo(Celle nabo){
		antNaboer += 1;

		for (int i = 0; i < 8; i ++){
			if (naboer[i] == null){
				naboer[i] = nabo;
				break;
			}
		}
	}

	public void tellLevendeNaboer(){ 
		this.antLevendeNaboer = 0;

		for (int i = 0; i < 8; i ++){
			if (naboer[i] == null){
				continue;
			}
			else if (naboer[i].erLevende()){
				this.antLevendeNaboer += 1;
			}
		}
	}

	public void oppdaterStatus(){
		if (antNaboer == 3){
			levende = true;
		}
		else if (antNaboer > 3 || antNaboer < 2){
			levende = false;
		}
	}

}
