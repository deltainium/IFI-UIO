public class BlaaResept extends Resept{
	int pris;

	public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
		super(legemiddel, utskrivendeLege, pasientId, reit);
		this.farge = "Blaa";
		this.pris = legemiddel.hentPris();
	}
	
	public String farge(){
		return this.farge;
	}

	@Override
	public int prisAaBetale(){
		return (int)Math.round(this.pris*0.25);
	}

}
