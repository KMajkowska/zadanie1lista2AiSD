import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OneWayLinkedListWithHead<Integer> L1= new OneWayLinkedListWithHead<Integer>();
		Test test = new Test();
		System.out.println("Dodawanie elementów do L1");
		test.add(L1);
		System.out.println("Wyœwietlenie L1");
		test.display(L1);
		System.out.println("Zamiana w L1");
		L1.reverseInPlace();
		System.out.println("Wyœwietlenie zmienionej L1");
		test.display(L1);
		System.out.println("Tworzenie L2 na podstawie reverseCreate L1");
		OneWayLinkedListWithHead<Integer>L2 = (OneWayLinkedListWithHead)L1.reverseCreate();
		System.out.println("Wyœwietlenie L2");
		test.display(L2);
		System.out.println("Usuwanie co drugiego indeksu w L2");
		L2.decimate(true);
		System.out.println("Wyswietlenie L2");
		test.display(L2);
		System.out.println("Wyœwietlenie L1");
		test.display(L1);
		System.out.println("Usuwanie co drugiego indeksu z L1");
		L1.decimate(false);
		System.out.println("Wyœwietlenie L1");
		test.display(L1);
		System.out.println("Stworzenie L3 i dodanie do niej elementów");
		OneWayLinkedListWithHead<Integer> L3 = new OneWayLinkedListWithHead<Integer>();
		test.addL3(L3);
		System.out.println("Wyœwietlenie L3");
		test.display(L3);
		Element tmp = new Element(4);
		System.out.println("Przesuniêcie na pocz¹tek");
		L3.moveToBegin(tmp);
		System.out.println("Wyœwietlenie L3");
		test.display(L3);
		System.out.println("Wyœwietlenie L2");
		test.display(L2);
		System.out.println("Po³¹czenie listy L3 i L2");
		IList<Integer>L4 = L3.merge(L2, true);
		System.out.println("Wyœwietlenie L4");
		test.display((OneWayLinkedListWithHead)L4);
		System.out.println("Po³¹czenie listy L3 i L2");
		IList<Integer>L5 = L3.merge(L2, false);
		System.out.println("Wyœwietlenie L5");
		test.display((OneWayLinkedListWithHead)L5);
		L3.clear();
		System.out.println("Stworzenie L3 jeszcze raz");
		test.addL3(L3);
		IList<Integer> L6= new OneWayLinkedListWithHead<Integer>();
		System.out.println("Stworzenie listy L6 z L3 (indeksy zaczynaj¹ siê od 0)");
		L6 = L3.sublist(1, 3);
		System.out.println("Wyœwietlenie L6");
		test.display((OneWayLinkedListWithHead)L6);
	}
	
	public void add(OneWayLinkedListWithHead<Integer>list)
	{
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(10);
		list.add(11);;
	}
	
	public void display(OneWayLinkedListWithHead<Integer>list)
	{
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
	}
	
	public void addL3(OneWayLinkedListWithHead<Integer>L3)
	{
		L3.add(1);
		L3.add(2);
		L3.add(4);
		L3.add(4);
		L3.add(4);
		L3.add(5);
		
	}

}
