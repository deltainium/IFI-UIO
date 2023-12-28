public class HvitResept extends Resept{
	int pris;

	public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
		super(legemiddel, utskrivendeLege, pasient, reit);
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
