public class Selftest{

	public static void main(String[] args){
		Pasient ny = new Pasient("Ole", "123");
		Pasient ny2 = new Pasient("Dole", "321");
		Pasient ny3 = new Pasient("Dole", "321");

		System.out.println(ny.hentID());
		System.out.println(ny2.hentID());
		System.out.println(ny3.hentID());
	}

}
