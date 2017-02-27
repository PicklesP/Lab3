package cs240;

import java.util.Random;

public class Customers {
	
	private QueueSingleLinked<Integer> customerLine;
	private Random rng;
	private Menu m;
	
	public Customers(){
		customerLine = new QueueSingleLinked<Integer>();
		rng = new Random();
		m = new Menu();
	}
	
	/**
	 * Adds a random number of customers and assigns each of them an order they want.
	 */
	private void queueCustomers(){
		int numNewCustomers = rng.nextInt(99) + 1;
		for(int i = 0; i < numNewCustomers; i++){
			customerLine.enqueue(rng.nextInt(6) + 1);
		}
	}
	
	/**
	 * Checks each customer in the line and gives them orders
	 * @return Number of customers who were not served.
	 */
	public int[] serveCustomers(Pantry p){
		queueCustomers();
		int currentCustomer = 0;
		int[] orders = new int[7];
		do{
			currentCustomer = customerLine.next();
			if(m.order(currentCustomer - 1, p))
				orders[currentCustomer]++;
			else
				orders[0]++;
		}while(currentCustomer != 0);
		return orders;
	}
	
	private class QueueSingleLinked<T> implements QueueInterface {

		private Node<T> firstNode;
		private Node<T> currentNode;
		private Node<T> lastNode;
		
		public QueueSingleLinked(){
			firstNode = null;
			currentNode = null;
			lastNode = null;
		}
		
		public T next(){
			if(currentNode == null){
				currentNode = firstNode;
				return currentNode.getData();
			}
			else{
				T data = currentNode.getData();
				currentNode = currentNode.getNextNode();
				return data;
			}
		}
		
		@Override
		public void enqueue(Object newEntry) {
			Node newNode = new Node(newEntry, null);
			if(isEmpty())
				firstNode = newNode;
			else
				lastNode.setNextNode(newNode);
			
			lastNode = newNode;
			
		}

		@Override
		public Object dequeue() {
			T front = null;
			if(!isEmpty()){
				front = (T) firstNode.getData();
				firstNode = firstNode.getNextNode();
				
				if(firstNode == null)
					lastNode = null;
			}
			return front;
		}

		@Override
		public Object getFront() {
			T front = null;
			if(!isEmpty()){
				front = (T) firstNode.getData();
			}
			return front;
		}

		@Override
		public boolean isEmpty() {
			return(firstNode == null && lastNode == null);
		}
		
		@Override
		public void clear() {
			firstNode = null;
			lastNode = null;
			
		}

		private class Node<T> {
			private T data;
			private Node next;
			
			public Node(T item, Node nextNode){
				data = item;
				next = nextNode;
			}
			
			public boolean hasNext(){
				return (next != null);
			}
			
			public Node(T item){
				this(item, null);
			}
			
			public T getData(){
				return data;
			}
			
			public void setData(T newData){
				data = newData;
			}
			
			private Node getNextNode(){
				return next;
			}
			
			private void setNextNode(Node nextNode){
				next = nextNode;
			}
		}
	}
}
