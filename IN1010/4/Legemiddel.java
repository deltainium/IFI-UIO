abstract class Legemiddel{
	public final String navn;
	public int pris;
	public final double virkestoff; // 
	
	private static int nesteid;
	public final int id;

	public Legemiddel(String navn, int pris, double virkestoff){
		this.navn = navn;
		this.pris = pris;
		this.virkestoff = virkestoff;

		nesteid++;
		id = nesteid-1;
	}

	public String hentNavn(){
		return this.navn;
	}

	public int hentPris(){
		return this.pris;
	}

	public void settNyPris(int nyPris){
		this.pris = nyPris;
	}

	public int hentId(){
		return this.id;
	}

}
