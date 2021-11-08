package SinglyLinkedList;

public class SinglyLinkedList {
	
		Node head;
		Node tail;
		
	static class Node {
		
		
		int data;
		Node next;
		
		Node (int d){
			this.data = d;
			next = null;
		}
		
	}
	
	private void insert (Node n) {
		
		tail.next = n;
		tail = n;
	}
	
	private void delete (Node n) {
		
		//if the head to be deleted
		if (head.data == n.data) {
			head = head.next; //get the next of the head becomes as head
		}
		else {
			Node current = head.next; //get the next node as current
			Node previous = head; //assign the as as previous
			
			//as long as there is a node
			while(current!=null) {
				if(current.data == n.data) {
					previous.next = current.next; //get the previous and link it to next node of current because we want to remove the current node
				}
				previous = current; //moving ahead
				current = current.next;
			}
			
		}
		
	}
	
	private void setHead (Node node) {
		
		head = node;
		tail = node;
	}
	
	public static void printNodes (SinglyLinkedList nodes) {
		
		Node currentNode = nodes.head;
		System.out.print("LinkedList: ");
		
		while(currentNode!=null) {
			System.out.print(currentNode.data);
			
			if (currentNode.next!=null)
				System.out.print("=>");
			
			currentNode = currentNode.next;
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SinglyLinkedList hd = new SinglyLinkedList();
		Node nd1 = new Node(3);
		Node nd2 = new Node(1);
		Node nd3 = new Node(9);
		Node nd4 = new Node(6);
		
		hd.setHead(nd1);
		hd.insert(nd2);
		hd.insert(nd3);
		hd.insert(nd4);
		
		printNodes(hd);
		
		hd.delete(nd2);
		System.out.println();
		printNodes(hd);
		hd.delete(nd1);
		System.out.println();
		printNodes(hd);
		
	}

}
