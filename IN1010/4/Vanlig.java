public class Vanlig extends Legemiddel{
	private static int nesteid = 0;
	public final int id;

	public Vanlig(String navn, int pris, double virkestoff){
		super(navn, pris, virkestoff);
		nesteid++;
		id = nesteid-1;
	}

}
