public class HvitResept extends Resept{
	int pris;

	public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
		super(legemiddel, utskrivendeLege, pasientId, reit);
		this.farge = "Hvit";
		this.pris = legemiddel.hentPris();
}

	public String farge(){
		return this.farge;
	}

	public int prisAaBetale(){
		return this.pris;
	}

}
