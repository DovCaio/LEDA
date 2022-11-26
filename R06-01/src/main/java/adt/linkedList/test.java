package adt.linkedList;

public class test {

	
	public static void main(String[] args) {
		
		RecursiveDoubleLinkedListImpl dlin = new RecursiveDoubleLinkedListImpl<>();
		
		dlin.insert(3);
		dlin.insert(2);
		dlin.insert(1);
		dlin.insert(0);
		
		dlin.removeFirst();
		//dlin.removeFirst();
		
		//System.out.println(dlin.size());
		//dlin.removeLast();
		//dlin.removeFirst();
		//System.out.println("ola");
		for(Object numero : dlin.toArray()) {
			System.out.println(numero);
		}

		
	}
	
}
