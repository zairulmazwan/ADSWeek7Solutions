
public class Hash {

	static int hashTable [] = new int [5];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int val = 9;
		insert(val);
		
		printHashTable(hashTable);
		System.out.println();
		
		String str = "Zairul";
		int hashString = str.hashCode();
		System.out.println(hashString);
		
		Integer z = 20223;
		hashString = z.hashCode();
		System.out.println(hashString);
		
		Boolean b = true;
		hashString = b.hashCode();
		System.out.println(hashString);
		
		Double db = 21.9823;
		hashString = db.hashCode();
		System.out.println(hashString);
		
		Character ch = '£';
		hashString = ch.hashCode();
		System.out.println(hashString);
		

	}
	
	private static int hash(Integer x)
    {
        int hashValue = x.hashCode();
        //System.out.println("hashVal : "+hashValue);
        //System.out.println("HashTable length : "+hashTable.length);
  
        hashValue %= hashTable.length;
        //System.out.println("hashValue% : "+hashValue);
  
        if (hashValue < 0)
            hashValue += hashTable.length;
        
        //System.out.println("HashValue : "+hashValue);
        return hashValue;
    }
	
	public static void insert(int val) {
		int pos = hash(val);
		hashTable[pos] = val;
	}
	
	public static void printHashTable(int [] hashTable) {
		for (int i=0; i<hashTable.length; i++) {
			System.out.println(hashTable[i]+" ");
		}
	}

}
