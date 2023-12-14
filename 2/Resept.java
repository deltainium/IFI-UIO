abstract class Resept{
	public final Legemiddel legemiddel;
	public final Lege utskrivendeLege;
	public final int pasientId;
	public int reit;
	public String farge;

	public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
		this.legemiddel = legemiddel;
		this.utskrivendeLege = utskrivendeLege;
		this.pasientId = pasientId;
		this.reit = reit;
	}

	public boolean bruk(){
		if (this.reit <= 0){
			return false;
		}
		else{
			this.reit -= 1;
			return true;
		}
	}

	abstract public String farge();

	abstract public int prisAaBetale();
}
