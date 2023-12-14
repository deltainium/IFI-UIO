abstract class Legemiddel{
	public final String navn;
	public int pris;
	public final double virkestoff; // 

	public Legemiddel(String navn, int pris, double virkestoff){
		this.navn = navn;
		this.pris = pris;
		this.virkestoff = virkestoff;
	}

	public int hentPris(){
		return this.pris;
	}

	public void settNyPris(int nyPris){
		this.pris = nyPris;
	}

}
