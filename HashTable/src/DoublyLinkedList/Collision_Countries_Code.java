package DoublyLinkedList;

import DoublyLinkedList.StringDoublyLinkedList.Node;

public class Collision_Countries_Code {
	
	static StringDoublyLinkedList [] countries = new StringDoublyLinkedList [100];

	public static void main(String[] args) {
		
		String fileName = "C:\\Users\\zairu\\Sheffield Hallam University\\Sept 21-22\\ADS\\Labs\\Lab 7\\iso-country-codes.csv";
		String [][] rawData = readFile.readFile(fileName);
		System.out.println("Raw data length : "+rawData.length);
		
		for (int i=1; i<rawData.length; i++) {
			//System.out.println(countries[i][3]);
			int key = Integer.valueOf(rawData[i][3]);
			String country = (String)rawData[i][0];
			//System.out.println(i+" : Key and Country : "+key+" "+country);
			insert(key, country);
		}

		printData ();
		StringDoublyLinkedList x = getLongestDLL(countries);
		System.out.println("Res : "+x.length);
		printStringLL(x);
	}
	
	
	public static StringDoublyLinkedList getLongestDLL(StringDoublyLinkedList [] dll) {
		
		StringDoublyLinkedList res = new StringDoublyLinkedList();
		int max = 0;
		for(int i=0; i<dll.length; i++) {
			if(dll[i] != null && dll[i].length >= max) {
				res = dll[i];
				max = dll[i].length;
			}
		}
		
		return res;
	}
	
	public static void printStringLL(StringDoublyLinkedList dll) {
		StringDoublyLinkedList.printNodes(dll);
	}
	
public static void insert (int key, String name) {
		
		int index = hashFunction (key);
		StringDoublyLinkedList dll = new StringDoublyLinkedList();
		Node n = new Node(key, name);
		
		if (collision(index)==false) {
			dll.setHead(n);
			countries [index] = dll;
		}
		else {
			dll = countries[index];
			dll.insert(n);
		}
	}
	
	public static int hashFunction (int key) {
		int index = key%countries.length;
		return index;
	}
	
	public static boolean collision (int index) {
		boolean coll = false;
		if (countries[index]!=null) {
			coll = true;
		}
		return coll;
	} 

	public static void printData () {
		for (int i = 0; i<countries.length; i++) {
			System.out.println("Index "+i+" : ");
			if (countries[i]!=null) {
				System.out.println("There are "+countries[i].length+ " record/s");
				StringDoublyLinkedList.printNodes(countries[i]);
			}
			else {
				System.out.print("No record here!");
			}
			
			System.out.println("\n");
		}
	}


}
