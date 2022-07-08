import java.util.*;
public class OneWayLinkedListWithHead<E> extends AbstractList<E>{
	
	Element head=null;
	public OneWayLinkedListWithHead() {
		
	}
	public boolean isEmpty()
	{
		return head==null;
	}

	public void clear() 
	{
		head=null;
	}
	
	/*public void add_end(E value)
	{
		Element added = new Element(value);
		if(head == null)
		{
			head = tail = added; //tail to element wskazuj¹cy na ostatni element, trzeba go odpowiednio zaimplementowaæ
		}
		else 
		{
			tail.setNext(added);
			tail = added;
		}
		
		
		
	}*/
	
	public int size() {
		int pos=0;
		Element actElem=head;
		while(actElem!=null)
		{
			pos++;
			actElem=actElem.getNext();
		}
		return pos;
	}
	
	private Element getElement(int index)
	{
		if(index<0) throw new IndexOutOfBoundsException();
		Element actElem=head;
		while(index>0 && actElem!=null){
			index--;
			actElem=actElem.getNext();
		}
		if (actElem==null)
			throw new IndexOutOfBoundsException();
		return actElem;
	}
	
	public boolean add(E e) {
		Element newElem=new Element(e);
		if(head==null){
			head=newElem;
			return true;
		}
		Element tail=head;
			while(tail.getNext()!=null)
				tail=tail.getNext();
		tail.setNext(newElem);
		return true;
	}


	
	public void add(int index, E data) {
		if(index<0) throw new IndexOutOfBoundsException();
			Element newElem=new Element(data);
		if(index==0)
		{
			newElem.setNext(head);
			head=newElem;
		}
		else 
		{
			Element actElem=getElement(index-1);
			newElem.setNext(actElem.getNext());
			actElem.setNext(newElem);
		}
	}
	@Override
	public int indexOf(E data) {
		int pos=0;
		Element actElem=head;
		while(actElem!=null)
		{
			if(actElem.getValue().equals(data))
				return pos;
			pos++;
			actElem=actElem.getNext();
		}
		return -1;
	}

	@Override
	public boolean contains(E data) 
	{
		return indexOf(data)>=0;
	}
	@Override
	public E get(int index) 
	{
		Element actElem=getElement(index);
		return (E)actElem.getValue();
	}
	@Override
	public E set(int index, E data) 
	{
		Element actElem=getElement(index);
		E elemData=(E)actElem.getValue();
		actElem.setValue(data);
		return elemData;
	}

	@Override
	public E remove(int index) 
	{
		if(index<0 || head==null) throw new IndexOutOfBoundsException();
		if(index==0)
		{
			E retValue=(E)head.getValue();
			head=head.getNext();
			return retValue;
		}
		Element actElem=getElement(index-1);
		if(actElem.getNext()==null)
			throw new IndexOutOfBoundsException();
		E retValue=(E)actElem.getNext().getValue();
		actElem.setNext(actElem.getNext().getNext());
		return retValue;
	}
	@Override
	public boolean remove(Element value) {
		if(head==null) 
			return false;
		if(head.getValue().equals(value.getValue()))
		{
			head=head.getNext();
			return true;
		}
		Element actElem=head;
		while(actElem.getNext()!=null && !actElem.getNext().getValue().equals(value.getValue())) 
			actElem=actElem.getNext();
		if(actElem.getNext()==null)	
				return false;
		actElem.setNext(actElem.getNext().getNext());
		return true;
	}
	@Override
	public Iterator<E> iterator() {
		Iterator<E> it = new ListIterator();
		return it;
	}

	
	public void reverseInPlace()
	{
		Element previous = null;
		Element current = head;
		Element next;
		while (current != null) {
			next = current.getNext(); //next ustawia na nastêpny element
			current.setNext(previous); // nastêpny po curent ustawia na poprzedni
			previous = current; // poprzedni ustawia na aktualny
			current = next; // aktualny ustawia na poprzedni
		}
		head = previous; //poprzedni ustawia na g³owe
	}
	
	public IList<E> reverseCreate()
	{
		OneWayLinkedListWithHead<E> list = new OneWayLinkedListWithHead<E>();
		Element current = head;
		int i=0;
		while (current != null) 
		{
			list.add((E)current.getValue());
			current = current.getNext();
		}
		list.reverseInPlace();
		return list;
	}
	
	public void decimate( boolean del_even )
	{
		if(del_even)
		{
			int i = 0;
			while(i<size())
			{
				remove(i);
				i++;
			}
		}
		else
		{
			int i = 1;
			while(i<size())
			{
				remove(i);
				i++;
			}
		}
	}
	
	public int moveToBegin(Element e )
	{
		int number =0, tmp;
		Element next = head;
		Element actElem = head;
		while(actElem != null)
		{
			next = actElem.getNext();
			if(actElem.getValue().equals(e.getValue()))
			{
				remove(actElem);
				number++;
			}
			actElem = next;
		}
		tmp = number;
		while(tmp>0)
		{
			add(0, (E)e.getValue());
			tmp--;
		}
		return number;
	}
	
	public IList<E> merge( IList<E> other, boolean append )
	{
		IList<E> list = new OneWayLinkedListWithHead<E>();
		if(append)
		{
			int i=0;
			while(i<size())
			{
				list.add(get(i));
				i++;
			}
			i=0;
			while(i<other.size())
			{
				list.add(other.get(i));
				i++;
			}
		}
		else
		{
			int i=0;
			while(i<other.size())
			{
				list.add(other.get(i));
				i++;
			}
			i=0;
			while(i<size())
			{
				list.add(get(i));
				i++;
			}
		}
		return list;
	}
	
	public IList<E> sublist( int start_ind, int end_ind )
	{
		OneWayLinkedListWithHead<E> list = new OneWayLinkedListWithHead<E>();
		if(end_ind > size())
		{
			while(start_ind < size())
			{
				list.add(get(start_ind));
				start_ind++;
			}
			return list;
		}
		else if(start_ind > size())
		{
			list = null;
			return list;
		}
		else
		{
			while(start_ind <=end_ind)
			{
				list.add(get(start_ind));
				start_ind++;
			}
			return list;
		}
	}
	
	private class ListIterator<E> implements Iterator<E> {
		
		Element actElem;
		ListIterator() 
		{
			actElem=head;
		}
		@Override
		public boolean hasNext() {
			return actElem!=null;
		}
		@Override
		public E next() {
			E value=(E)actElem.getValue();
			actElem=actElem.getNext();
			return value;
		}


}

}

/* E dequeue()        Kolejka FIFO na liœcie wi¹zanej
{
	if(head == null)
		throw new EmptyQueueException();
	else
	{
		E zwracana = head.getValue();
		head = head.next();
		return zwracana;
	}
}*/