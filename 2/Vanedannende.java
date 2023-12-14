public class Vanedannende extends Legemiddel{
	public final int styrke;
	private static int nesteid;
	public final int id;
	
	public Vanedannende(String navn, int pris, double virkestoff, int styrke){
		super(navn, pris, virkestoff);
		this.styrke = styrke;
		nesteid++;
		id = nesteid-1;
	}
}
