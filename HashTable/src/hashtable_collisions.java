
public class hashtable_collisions {

	static String [] myTable = new String [5];
	
	public static void main(String[] args) {
		
		insert(9, "Zairul");
		insert(5, "Mazwan");
		insert(12, "Jilani");
		insert(15, "Rania");
		insert(11, "John");
	
		//System.out.println(collision (1));
		printData();		

	}
	
	public static int hashFunction (int key) {
		int index = -1;
		index = key % myTable.length;		
		return index;
	}
	
	public static void insert (int key, String name) {
		//get the index to store the name using hash function
		int index = hashFunction(key);
		int i = 1;
		while (collision(index)==true) {
			index = probLinear (key, i);
			i++;
		}
		myTable [index] = name; 
	}
	
	public static int probLinear (int key, int i) {
		int index = (key+i) % myTable.length;
		return index;
	}
	
	public static boolean collision (int index) {
		boolean col = false;
		if (myTable[index]!=null) {
			col = true;
		}
		return col;
	}
	
	public static void printData () {
		for (int i = 0; i<myTable.length; i++) {
			System.out.print(myTable[i]);
			System.out.println();
		}
	}

}
