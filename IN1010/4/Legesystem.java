import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Legesystem{
	IndeksertListe<Pasient> pasienter = new IndeksertListe<Pasient>();
	IndeksertListe<Lege> leger = new IndeksertListe<Lege>();
	IndeksertListe<Legemiddel> middler = new IndeksertListe<Legemiddel>();

	public Legesystem(){
	}

	public void lesFraFil(String filnavn) throws FileNotFoundException{
		File fil = new File(filnavn);
		Scanner skanner = new Scanner(fil); // TODO Find a way to close the scanner sensibly
		String gruppe = "";

		while (skanner.hasNextLine()){
			String line = skanner.nextLine();

			if (line.charAt(0) == '#'){
				String[] kuttet = line.split(" ");
				gruppe = kuttet[1];
				}

			else if (gruppe == "Pasienter"){
				String[] kuttet = line.split(",");
				String navn = kuttet[0];
				String fodnum = kuttet[1];
				
				Pasient pasient = new Pasient(navn, fodnum);
				pasienter.leggTil(pasient);
			}

			else if (gruppe == "Legemidler"){
				String[] kuttet = line.split(",");
				String navn = kuttet[0];
				String type = kuttet[1];
				int pris = Integer.parseInt(kuttet[2]);
				int virkestoff = Integer.parseInt(kuttet[3]);

				if (type == "narkotisk"){
					int styrke = Integer.parseInt(kuttet[4]);
					Narkotisk nytt = new Narkotisk(navn, pris, virkestoff, styrke);
					middler.leggTil(nytt);
					}
				else if (type == "vanedannende"){
					int styrke = Integer.parseInt(kuttet[4]);
					Vanedannende nytt = new Vanedannende(navn, pris, virkestoff, styrke);
					middler.leggTil(nytt);
					}
				else if (type == "vanlig"){
					Vanlig nytt = new Vanlig(navn, pris, virkestoff);
					middler.leggTil(nytt);
					}
				}

			else if (gruppe == "Leger"){
				String[] kuttet = line.split(",");
				String navn = kuttet[0];
				String kode = kuttet[1];

				if (kode == "0"){
					Lege lege = new Lege(navn);
					leger.leggTil(lege);
				}
				else{
					Spesialist lege = new Spesialist(navn, kode);
					leger.leggTil(lege);
				}
			}

			else if (gruppe == "Resepter"){
				String[] kuttet = line.split(",");
				int middelNum = Integer.parseInt(kuttet[0]);
				String legeNavn = kuttet[1];
				int pasientId = Integer.parseInt(kuttet[2]);
				String type = kuttet[3];

				Lege lege = new Lege("temp");
				Legemiddel middel = new Vanlig("temp", 0, 0.0);
				Pasient pasient = new Pasient("temp", "temp");

				for (Lege sjekkLege: this.leger){
					if (sjekkLege.hentNavn() == legeNavn){
						lege = sjekkLege;
						break;
					}
				}

				for (Legemiddel sjekkMid: this.middler){
					if (sjekkMid.hentId() == middelNum){
						middel = sjekkMid;
					}
				}

				for (Pasient sjekkPas: this.pasienter){
					if (sjekkPas.hentId() == pasientId){
						pasient = sjekkPas;
					}
				}

				if (type == "hvit"){
					int reit = Integer.parseInt(kuttet[4]);
					HvitResept resept = new HvitResept(middel, lege, pasient, reit);
					lege.leggTilResept(resept);
				}

				else if (type == "blaa"){
					int reit = Integer.parseInt(kuttet[4]);
					BlaaResept resept = new BlaaResept(middel, lege, pasient, reit);
					lege.leggTilResept(resept);
				}

				else if (type == "militaer"){
					MilResept resept = new MilResept(middel, lege, pasient);
					lege.leggTilResept(resept);
				}

				else{
					int reit = Integer.parseInt(kuttet[4]);
					PResept resept = new PResept(middel, lege, pasient, reit);;
					lege.leggTilResept(resept);
				}
			}
		}
	}
}
