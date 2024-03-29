import java.util.Iterator;
import java.util.Scanner;

public class Main_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OneWayLinkedListWithHead<String> list = new OneWayLinkedListWithHead<String>();
		Main_string main_string = new Main_string();
		main_string.actions(list);
	}
	
	public void actions(OneWayLinkedListWithHead list)
	{
		int n=0;
		Scanner scan = new Scanner(System.in);
		do
		{
			showMenu();
			n = scan.nextInt();
			switch(n)
			{
			case 1:
			{
				char odp='t', w;
				String value="";
				System.out.println("Wypelnic liste wprowadzonymi danymi czy wygenerowanymi przez program? [s/p]");
				w = scan.next().charAt(0);
				System.out.println("Ile wprowadzic wartosci?");
				int ile= scan.nextInt();
				for(int i=0; i<ile; i++ )
				{
					if(w == 's')
					{
						System.out.println("Podaj wartosc inta");
						value = scan.next();
						if(!list.add(value))
						{
							System.out.println("Error");
						}
					}
					else
					{
						value = value +i;
						if(!list.add(value))
						{
							System.out.println("Error");
						}
					}
				}
				break;
			}
			case 2:
			{
				System.out.println("Ile elementow chcesz dodac na koniec listy?");
				int ile;
				String value="";
				char w;
				ile = scan.nextInt();
				for(int i=0; i<ile; i++)
				{
					System.out.println("Dodac wlasne wartosci czy wygenerowane przez program?");
					w = scan.next().charAt(0);
					if(w == 's')
					{
						System.out.println("Podaj wartosc inta");
						value = scan.next();
						list.add(value);
					}
					else
					{
						value = value +i;
						list.add(value);
					}
				}
				break;
			}
			case 3:
			{
				System.out.println("Ile elementow chcesz dodac?");
				int ile, index;
				String value="";
				char w;
				ile = scan.nextInt();
				for(int i=0; i<ile; i++)
				{
					System.out.println("Dodac wlasne wartosci czy wygenerowane przez program?");
					w = scan.next().charAt(0);
					if(w == 's')
					{
						System.out.println("Podaj wartosc inta");
						value = scan.next();
						System.out.println("Podaj indeks, na ktorym ma byc wstawiony element");
						index = scan.nextInt();
						list.add(index, value);
					}
					else
					{
						System.out.println("Podaj indeks, na ktorym ma byc wstawiony element");
						index = scan.nextInt();
						value = value + i;
						list.add(index, value);
					}
				}
				break;
			}
			case 4:
			{
				list.clear();
				break;
			}
			case 5:
			{
				System.out.println("Ile elementow chcesz wyswietlic?");
				int ile, index;
				ile = scan.nextInt();
				for(int i=0; i<ile; i++)
				{
					System.out.println("Podaj indeks do wyswietlenia");
					{
						index = scan.nextInt();
						System.out.println(list.get(index));
					}
				}
				break;
			}
			case 6:
			{
				System.out.println("Ile elementow chcesz zmienic?");
				int ile, index;
				String value="";
				char w;
				ile = scan.nextInt();
				for(int i=0; i<ile; i++)
				{
					System.out.println("Dodac wlasne wartosci czy wygenerowane przez program?");
					w = scan.next().charAt(0);
					if(w == 's')
					{
						System.out.println("Podaj wartosc inta");
						value = scan.next();
						System.out.println("Podaj indeks, na ktorym ma byc zmieniony element");
						index = scan.nextInt();
						list.set(index, value);
					}
					else
					{
						System.out.println("Podaj indeks, na ktorym ma byc wstawiony element");
						index = scan.nextInt();
						value = value +  i;
						list.set(index, value);
						}
				}
				break;
			}
			case 7:
			{
				System.out.println("Ile elementow chcesz znalezc?");
				int ile, number=0, index;
				String value = "";
				ile = scan.nextInt();
				for(int i=0; i<ile; i++)
				{
						System.out.println("Podaj wartosc inta");
						value = scan.next();
						list.contains(value);
				}
				break;
			}
			case 8:
			{
				System.out.println(list.isEmpty());
				break;
			}
			case 9:
			{
				System.out.println("Ile elementow chcesz usun�� (po indeksach)?");
				int ile, index;
				ile = scan.nextInt();
				for(int i=0; i<ile; i++)
				{
						System.out.println("Podaj indeks");
						index = scan.nextInt();
						list.remove(index);
				}
				break;
			}
			case 10:
			{
				System.out.println("Ile elementow chcesz usun�� (wartosciach)?");
				int ile;
				String value="";
				ile = scan.nextInt();
				for(int i=0; i<ile; i++)
				{
						System.out.println("Podaj element");
						value = scan.next();
						Element<String> e = new Element<String>(value);
						list.remove(e);
				}
				break;
			}
			case 11:
			{
				System.out.println(list.size());
				break;
			}
			case 12:
			{
				list.reverseInPlace();
				break;
			}
			case 13:
			{
				IList new_list = list.reverseCreate();
				Iterator it = new_list.iterator();
				while(it.hasNext())
				{
					System.out.println(it.next());
				}
				break;
			}
			case 14:
			{
				boolean remove;
				System.out.println("Chcesz usuawac elementy z indeksami parzystymi?");
				remove = scan.nextBoolean();
				list.decimate(remove);
				Iterator it = list.iterator();
				while(it.hasNext())
				{
					System.out.println(it.next());
				}
				break;
			}
			case 15:
			{
				System.out.println("Podaj wartosc ktora ma byc przeniesiona na poczatek");
				String value = scan.next();
				Element<String> e = new Element<String>(value);
				System.out.println(list.moveToBegin(e));
				break;
			}
			case 16:
			{
				System.out.println("Pod��czy� liste na pocz�tek czy na koniec (true/false)?");
				boolean append = scan.nextBoolean();
				IList<String> newList = list.reverseCreate();
				IList<String> other = list.merge(newList, append);
				Iterator it = other.iterator();
				while(it.hasNext())
				{
					System.out.println(it.next());
				}
				break;
			}
			case 17:
			{
				int start, end;
				System.out.println("Podaj indeksy (start i koniec)");
				start = scan.nextInt();
				end = scan.nextInt();
				IList<String> sublist = new OneWayLinkedListWithHead<String>();
				sublist = list.sublist(start, end);
				Iterator it = sublist.iterator();
				while(it.hasNext())
				{
					System.out.println(it.next());
				}
				break;
			}
			case 18:
			{
				Iterator it = list.iterator();
				while(it.hasNext())
				{
					System.out.println(it.next());
				}
				break;
			}
		}
		}while(n!=0);
	}
	
	public void showMenu()
	{
		System.out.println("Menu:");
		System.out.println("1. Wypelnij liste");
		System.out.println("2. Dodaj element na koniec listy");
		System.out.println("3. Dodaj element na konkretn� pozycj�");
		System.out.println("4. Wyczy�� list�");
		System.out.println("5. Wy�wietl konkretny element z listy");
		System.out.println("6. Zmie� warto�� na konkretnej pozycji");
		System.out.println("7. Znajdz pozycje konkretnego elementu");
		System.out.println("8. Sprawdz czy lista jest pusta");
		System.out.println("9. Usun element z konkretnej pozycji");
		System.out.println("10. Usuwa konkretny element (po warto�ci tego elementu)");
		System.out.println("11. Sprawdz dlugosc listy");
		System.out.println("12. Odwroc elementy w liscie");
		System.out.println("13. Stworz nowa liste z odwroconymi elementami listy pierwszej");
		System.out.println("14. Usun co drugi element z tablicy");
		System.out.println("15. Przesun na poczatek wszystkie elementy, ktore maja podana wartosc");
		System.out.println("16. Polacz listy");
		System.out.println("17. Stworz nowa liste z wybranego fragmentu 'starej' listy");
		System.out.println("18. Wyswietl liste");
	}

}

