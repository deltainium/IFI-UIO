// må kjøres med -ea flagget

public class TestLegemiddel{

	public void testID(){
		Vanlig forste = new Vanlig("forste", 1, 1);
		Vanedannende andre = new Vanedannende("andre", 1, 1, 1);
		Narkotisk tredje = new Narkotisk("tredje", 1, 1, 1);
		Vanlig vanlig_to = new Vanlig("NrTo", 1, 1);
		Vanedannende vanedannende_to = new Vanedannende("NrTo", 1, 1, 2);
		Narkotisk narkotisk_to = new Narkotisk("NrTo", 1, 1, 2);
		boolean status = false;
		
		try{
		assert forste.id == 0;
		assert andre.id == 0;
		assert tredje.id == 0;
		assert vanlig_to.id == 1;
		assert vanedannende_to.id == 1;
		assert narkotisk_to.id == 1;
		status = true;
		}
		catch(Exception e){
		status = false;
		}
		finally{
		if (status){
			System.out.println("TestID status: Suksess | ID var 0 og 1");
		}
		else{
			System.out.println("TestID status: Feilet | ID var ikke 0 og 1");
		}
		}
	}

	public void testHentPris(){
		Vanlig forste = new Vanlig("forste", 1, 1);
		Vanedannende andre = new Vanedannende("andre", 2, 1, 1);
		Narkotisk tredje = new Narkotisk("tredje", 3, 1, 1);
		boolean status = false;

		try{
		assert forste.hentPris() == 1;
		assert andre.hentPris() == 2;
		assert tredje.hentPris() == 3;
		status = true;
		}
		catch(Exception e){
		status = false;
		}
		finally{
		if (status){
			System.out.println("testHentPris status: Suksess | Pris var 1, 2, og 3");
		}
		else{
			System.out.println("testHentPris status: Feilet | Pris var 1, 2, og 3");
		}
		}
	}

	public void testStyrke(){
		Vanedannende andre = new Vanedannende("andre", 2, 2, 1);
		Narkotisk tredje = new Narkotisk("tredje", 3, 3, 1);
		boolean status = false;

		try{
		assert andre.styrke == 1;
		assert tredje.styrke == 1;
		status = true;
		}
		catch(Exception e){
		status = false;
		}
		finally{
		if (status){
			System.out.println("TestPris status: Suksess | pris var 1 og 1");
		}
		else{
			System.out.println("TestPris status: Feilet | pris var 1 og 1");
		}
		}
	}

	public void testSettPris(){
		Vanlig forste = new Vanlig("forste", 1, 1);
		Vanedannende andre = new Vanedannende("andre", 2, 1, 1);
		Narkotisk tredje = new Narkotisk("tredje", 3, 1, 1);
		boolean status = false;

		try{
		assert forste.hentPris() == 1;
		assert andre.hentPris() == 2;
		assert tredje.hentPris() == 3;

		forste.settNyPris(3);
		andre.settNyPris(4);
		tredje.settNyPris(5);
		
		assert forste.hentPris() == 3;
		assert andre.hentPris() == 4;
		assert tredje.hentPris() == 5;
		
		status = true;
		}
		catch(Exception e){
		status = false;
		}
		finally{
		if (status){
			System.out.println("testSettPris status: Suksess | pris ble byttet fra (1,2,3) til (3,4,5)");
		}
		else{
			System.out.println("testSettPris status: Feilet | pris ble ikke byttet fra (1,2,3) til (3,4,5)");
		}
		}
	}

	public static void main(String[] args){
		TestLegemiddel testobj = new TestLegemiddel();
		testobj.testID();
		testobj.testHentPris();
		testobj.testSettPris();
	}

}
