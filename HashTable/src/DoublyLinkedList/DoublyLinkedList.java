package DoublyLinkedList;

public class DoublyLinkedList {
	
	Node head;
	Node tail;
	int length=1;
	
	static class Node {
		
		int data;
		Node next;
		Node previous;
		
		Node (int d){
			this.data = d;
			next = null;
			previous = null;
		}
		
	}
	
	public void setHead (Node n) {
		head = n;
		tail = n;
		
	}
	
	
	public void insert (Node n) {
		tail.next = n;
		n.previous = tail;
		tail = n;
		length++;
		
	}
	
	public void insertAfter (Node n, Node after) {
		Node next = after.next; //get the existing next node before inserting the new node
		after.next = n; //making the n node as next from after node
		n.previous = after; //making after node as previous of n node
		n.next = next; //making the existing next node as next of n
		next.previous = n; //making n node becomes previous from the existing next
		length++;
	}
	
	public void insertBefore (Node n, Node before) {
		Node previous = before.previous; //get the existing previous node before inserting the new node
		before.previous = n; //making the n node as previous from before node
		n.next = before; //making the before node as next from n
		previous.next = n; //making the n node becomes next of previous node
		n.previous = previous; //making previous node as previous from n node.
		length++;
	}
	
	
	public void remove (Node n) {
		//if the head to be deleted
		if (head.data == n.data) {
			head = head.next; //get the next of the head becomes as head
			head.previous = null;
			length--;
		}
		else if (tail.data == n.data) {
			tail = tail.previous;
			tail.next = null;
			length--;
		}
		else {
			Node current = head.next;
			Node previous = head;
			
			while (current!=null) {
				if(current.data == n.data) {
					Node newCurrent = current.next; 
					previous.next = newCurrent; 
					newCurrent.previous = previous;
					length--;
				}
				previous = current;
				current = current.next;
			}
		}
	}
	
	public boolean findNode (int x) {
		boolean res = false;
		Node current = head;

		if (current.data == x) {
			res = true;
		}
		else {
			for (int i=0; i<length-1; i++) {
				current = current.next;
				
				if (current.data==x) {
					res = true;
					break;
				}
			}
		}
		
		return res;
	}

	public static void printNodes (DoublyLinkedList nodes) {
		
		Node current = nodes.head;
		System.out.print("LinkedList: ");
		
		while(current!=null) {
			System.out.print(current.data);
			if (current.next!=null && current.previous!=null) {
				System.out.print("<=>");
			}
			
			else if(current.next!=null) {
				System.out.print("=>");
			}
			current = current.next;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList dll = new DoublyLinkedList();
		
		Node n1 = new Node(33);
		Node n2 = new Node(45);
		Node n3 = new Node(21);
		Node n4 = new Node(13);
		
		dll.setHead(n1);
		dll.insert(n2);
		dll.insert(n3);
		dll.insert(n4);
		
		printNodes(dll);
		System.out.println();
		System.out.println(dll.findNode(21));
		dll.remove(n4);
		System.out.println();
		printNodes(dll);
		
		
//		System.out.println();
//		printNodes(dll);
//		System.out.println();
//		System.out.println("Head and tail are : "+dll.head.data+" "+dll.tail.data);
//		System.out.println("Node length : "+dll.length);
//		Node n5  = new Node(17);
//		dll.insert(n5);
//		printNodes(dll);
//		
//		Node n6  = new Node(28);
//		dll.insertAfter(n6,n2);
//		System.out.println();
//		printNodes(dll);
//		System.out.println();
//		System.out.println(dll.findNode(13));
//		
//		Node n7 = new Node(29);
//		dll.insertBefore(n7,n4);
//		System.out.println();
//		System.out.println("Len "+dll.length);
//		printNodes(dll);
	
		
		
	}

}
