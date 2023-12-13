import java.util.Scanner;

public class GameOfLife{

	public static void main(String[] args){
		for (byte i = 0; i < 127; i++){
			System.out.println();
		}

		System.out.flush();
		System.out.println("Velkommen til Game of Life!");
		Scanner input = new Scanner(System.in); // TODO input type verification

		System.out.println("Hvor mange rader skal matrisen ha?");
		
		int rader = input.nextInt();

		System.out.println("Hvor mange kolonner skal matrisen ha?");
		
		int kolonner = input.nextInt();

		Verden spill = new Verden(rader, kolonner);
		spill.tegn();
		
		String choice = "";

		while (choice != "q"){
			spill.oppdatering();
			spill.tegn();
			System.out.println("Trykk ENTER for å fortsette, eller input q for å avslutte");
			choice = input.nextLine().strip().toLowerCase();
			if (choice.isEmpty()){
				continue;
			}
			else{
				input.close();
				break;
			}
		}
	}

}

