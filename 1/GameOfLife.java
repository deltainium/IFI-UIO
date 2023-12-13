import java.util.Scanner;

public class GameOfLife{

	public static void main(String[] args){
		System.out.println("Velkommen til Game of Life!");
		Scanner input = new Scanner(System.in); // TODO input type verification

		System.out.println("Hvor mange rader skal matrisen ha?");
		
		int rader = input.nextInt();

		System.out.println("Hvor mange kolonner skal matrisen ha?");
		
		int kolonner = input.nextInt();

		input.close();
		Verden spill = new Verden(rader, kolonner);
		spill.tegn();
		

		for (int i = 0; i < 3; i++){
			spill.oppdatering();
			spill.tegn();
		}
	}

}

