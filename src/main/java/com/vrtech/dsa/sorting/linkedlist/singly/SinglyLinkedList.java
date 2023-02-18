package com.vrtech.dsa.sorting.linkedlist.singly;

public class SinglyLinkedList {

	private Node head;
	private Node tail;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public SinglyLinkedList(Node head) {
		super();
		this.head = head;
	}

	public void insertAtHead(int data) {

		Node n = new Node(data);
		n.setNext(this.head);
		this.head = n;
	}

	public void insertAtTail(int data) {

		Node n = new Node(data);
		this.head.setNext(head);
		this.head = n;
	}

	public void insertAfter(Node prev_node, int new_data) {
		/* 1. Check if the given Node is null */
		if (prev_node == null) {
			System.out.println("The given previous node cannot be null");
			return;
		}
		/*
		 * 2. Allocate the Node & 3. Put in the data
		 */
		Node new_node = new Node(new_data);
		/* 4. Make next of new Node as next of prev_node */
		new_node.setNext(prev_node.getNext());
		/* 5. make next of prev_node as new_node */
		prev_node.setNext(new_node.getNext());
	}

	public void insertAtEnd(int new_data) {
		/*
		 * 1. Allocate the Node & 2. Put in the data 3. Set next as null
		 */
		Node new_node = new Node(new_data);

		/*
		 * 4. If the Linked List is empty, then make the new node as head
		 */
		if (this.head == null) {
			head = new Node(new_data);
			return;
		}

		/*
		 * 4. This new node is going to be the last node, so make next of it as null
		 */
		new_node.setNext(null);

		/* 5. Else traverse till the last node */
		Node temp = head;
		while (temp.getNext() != null)
			temp = temp.getNext();

		/* 6. Change the next of last node */
		temp.setNext(new_node);
	}

	public void print(Node head) {
		System.out.println();
		if (head != null) {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.getData());
				temp = temp.getNext();
				if(temp!=null)
					System.out.print("-->");
			}
		} else {
			System.out.println("Singlylinked list empty");
		}
	}

	

	public void reverve() {
		Node prev = null;
		Node curr = this.head;
		while (curr != null) {
			Node forword = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = forword;
		}
		this.head = prev;
	}

	public Node kgroupReverve(Node head, int k) {
		if (head == null)
			return null;
		// STEP 1
		Node next = null;
		Node prev = null;
		Node curr = head;
		int cnt = 0;
		while (curr != null && cnt < k) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
			cnt++;
		}
		// step 2
		if (next != null)
			head.setNext(kgroupReverve(next, k));
		// step 3
		return prev;
	}

	public boolean isCircular(Node head) {

		if (head == null)
			return true;

		Node temp = head.getNext();
		while (temp != null && temp != head) {
			temp = temp.getNext();
		}

		if (temp == head)
			return true;

		return false;

	}
	
	public Node middleNode(Node head) {
		
		if(head==null)
			return null;
           
		Node slow=head;
		Node fast=head.getNext();		
		while(fast!=null&&fast.getNext()!=null) {
			fast=fast.getNext();
			if(fast.getNext()!=null)
				fast=fast.getNext();
			slow=slow.getNext();
		}
		return slow;
	}
	
	
	public boolean flydeLoop(Node head) {
		if(head==null)
			return false; 		
		Node slow=head;
		Node fast=head.getNext();		
		while(fast!=null&&fast.getNext()!=null) {
			fast=fast.getNext();
			if(fast.getNext()!=null)
				fast=fast.getNext();
			slow=slow.getNext();
			
			if(slow==fast)
				return true ;
			
		}
		return false;
	}
	
	public Node flydeNodeLoop(Node head) {
		if(head==null)
			return null; 		
		Node slow=head;// slow pointer
		Node fast=head.getNext();	//fast pointer	
		while(fast!=null&&fast.getNext()!=null) {
			fast=fast.getNext();
			if(fast.getNext()!=null)
				fast=fast.getNext();
			slow=slow.getNext();
			//itersection point
			if(slow==fast)
			   break ;			
		}		
		Node start=head;
		//finding the loop node
		while(start!=fast) {
			start=start.getNext();
			fast=fast.getNext();
		}
		System.out.println(start.getData());
		return start;
	}
	
	
	public void removeNodeLoop(Node head) {
		if(head==null)
			return ; 		
		Node startOfLoop=flydeNodeLoop(this.head);
		Node temp=startOfLoop;
		while(temp.getNext()!=null) {
			temp=temp.getNext();
		}
		temp.setNext(null);
	}
	

	public static void main(String[] args) {
		Node head = new Node();
		SinglyLinkedList linkedList = new SinglyLinkedList(head);
		linkedList.insertAtHead(1);
		linkedList.insertAtHead(2);
		linkedList.insertAtHead(3);
		linkedList.print(linkedList.head);
		// linkedList.reverve();
		//Node prev = linkedList.kgroupReverve(linkedList.head, 3);
		//linkedList.print(prev);		
		//System.out.println(linkedList.isCircular(linkedList.head));
		//
		
		//Node mid=linkedList.middleNode(linkedList.head);
		//System.out.println(mid.getData());

	}
}
