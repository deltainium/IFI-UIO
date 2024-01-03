public class PResept extends HvitResept{

	public PResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
		super(legemiddel, utskrivendeLege, pasient, reit);
	}

	@Override
	public int prisAaBetale(){
		if (this.pris-108 < 0){
			return 0;
		}
		else{
			return this.pris-108;
		}
	}

}
