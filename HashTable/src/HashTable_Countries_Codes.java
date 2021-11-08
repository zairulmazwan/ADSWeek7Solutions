
public class HashTable_Countries_Codes {

	static String [][] countries = new String [242][2];
	
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

		printData();

	}
	
	
	public static int hashFunction (int key) {
		int index = -1;
		index = key % countries.length;		
		return index;
	}
	
	public static void insert (int key, String country) {
		//get the index to store the name using hash function
		int index = hashFunction(key);
		//System.out.println(index);
		int i = 1;
		while (collision(index)==true) {
			index = probLinear (key, i);
			i++;
		}
		countries [index][0] = String.valueOf(key); 
		countries [index][1] = country; 
	}
	
	public static int probLinear (int key, int i) {
		int index = (key+i) % countries.length;
		return index;
	}
	
	public static boolean collision (int index) {
		boolean col = false;
		if (countries[index][0]!=null) {
			col = true;
		}
		return col;
	}
	
	public static void printData () {
		for (int i = 0; i<countries.length; i++) {
			System.out.print(i+1+","+countries[i][0]+","+countries[i][1]);
			System.out.println();
		}
	}

}
