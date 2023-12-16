public class MilResept extends HvitResept{

	public MilResept(Legemiddel legemiddel, Lege utskrivendLege, int pasientId){
		super(legemiddel, utskrivendLege, pasientId, 3 /*reit*/);
	}

	@Override
	public int prisAaBetale(){
		return this.pris*0; // 100% rabatt
	}

}
