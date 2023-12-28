public class MilResept extends HvitResept{

	public MilResept(Legemiddel legemiddel, Lege utskrivendLege, Pasient pasient){
		super(legemiddel, utskrivendLege, pasient, 3 /*reit*/);
	}

	@Override
	public int prisAaBetale(){
		return this.pris*0; // 100% rabatt
	}

}
