public class Stabel<E> extends Lenkeliste<E>{

	public Stabel(){
	}

	@Override
	public void leggTil(E data){
		Node<E> nytt = new Node<E>();
		nytt.setData(data);

		if (forste == null){
			this.forste = nytt;
		}

		else{
		Node<E> klone = new Node<E>();
		klone.setData(forste.hentData());
		klone.setNeste(forste.hentNeste());
		
		nytt.setNeste(klone);
		this.forste = nytt;

		}
		this.stor += 1;
	}

}
