public class Prioritetskoe<E extends Comparable<E>> extends Lenkeliste<E>{

	public Prioritetskoe(){
	}

	@Override
	public void leggTil(E data){
		this.stor++;

		Node<E> nytt = new Node<E>();
		nytt.setData(data);

		if (this.forste == null){
			this.forste = nytt;
		}

		else{
			Node<E> elem = forste;
			E elem_data = elem.hentData();

			while (true)
			{
				if (elem.hentNeste() != null)
				{

					if (data.compareTo(elem.hentNeste().hentData()) <= 0) // if data comes right after elem
					{	
						Node<E> kopi = new Node<E>();
						kopi.setData(elem.hentNeste().hentData());
						elem.setNeste(nytt);
						nytt.setNeste(kopi);
						break;
					}

					else
					{
						elem = elem.hentNeste();
						elem_data = elem.hentData();
					}
				}

				else
				{
					break;
				}
			}
		
		if (nytt.hentNeste() == null)
		{
			elem.setNeste(nytt);
		}
		}
	}
}


