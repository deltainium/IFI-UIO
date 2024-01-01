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
		Scanner skanner = new Scanner(fil);
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
			}
			
			skanner.close();

		}

	}

}

