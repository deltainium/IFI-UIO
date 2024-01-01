public class Lege implements Comparable<Lege>{
	String navn;
	IndeksertListe<Resept> utskrevneResepter;
	
	public Lege(String navn){
		this.navn = navn;
	}
	
	public String hentNavn(){
		return this.navn;
	}

	public int compareTo(Lege lege){
		if (this.navn == lege.navn)
		{
			return 0;
		}
		else
		{
			int ref;

			if (this.navn.length() > lege.navn.length())
			{
				ref = this.navn.length();
			}
			else
			{
				ref = lege.navn.length();
			}

			for (int i = 0; i < ref; i++)
				{
				int a = (int) this.navn.charAt(i);
				int b = (int) lege.navn.charAt(i);

				if ( a > b){
					return a-b;
				}
				else if (a < b){
					return b-a;
				}
				else{
					continue;
				}

				}
			}
		return -999; // -999 should be interpreted as an error code
		}

	public void leggTilResept(Resept resept){
		utskrevneResepter.leggTil(resept);
	}

	public void fjernResept(Resept resept){
		int counter = 0;
		int indeks = -1;

		for (Resept elem: utskrevneResepter){
			if (elem == resept){
				indeks = counter;
				break;
			}
		}

		try{
			utskrevneResepter.fjern(indeks);
		}
		catch(Exception e){
		}
	}

	public IndeksertListe<Resept> hentReseptListe(){
		return utskrevneResepter;
	}

	public Resept skrivResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
		HvitResept nytt = new HvitResept(legemiddel, this, pasient, reit);
		this.leggTilResept(nytt);
		return nytt;
	}
}
