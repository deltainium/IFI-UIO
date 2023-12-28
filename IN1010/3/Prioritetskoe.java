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

			if (data.compareTo(this.forste.hentData()) <=0){
				Node<E> kopi = new Node<E>();
				kopi.setNeste(this.forste.hentNeste());
				kopi.setData(this.forste.hentData());
				nytt.setNeste(kopi);
				this.forste = nytt;
			}
			
			else{

				while (true)
				{
					if (elem.hentNeste() != null)
					{

						if (data.compareTo(elem.hentNeste().hentData()) <= 0) // if data comes right after elem
						{	
							Node<E> kopi = new Node<E>();
							kopi.setData(elem.hentNeste().hentData());
							kopi.setNeste(elem.hentNeste().hentNeste());
							elem.setNeste(nytt);
							nytt.setNeste(kopi);
							break;
						}

						else
						{
							elem = elem.hentNeste();
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
}


