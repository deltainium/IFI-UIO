public class Pasient{
	final String navn;
	final String fodnum;
	final int id;
	static int neste_id = 0;
	private IndeksertListe<Resept> resepter;

	public Pasient(String navn, String fodnum){
		this.navn = navn;
		this.fodnum = fodnum;
		neste_id++;
		this.id = neste_id-1;
	}

	public void leggTilResept(Resept res){
		resepter.leggTil(res);
	}

}
