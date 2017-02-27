package cs240;

import java.util.Vector;
import java.util.Random;

public class Pantry {

	//TODO add methods to sort and manage ingredients
	static Random rng;
	static StackVector<Ingredient> buns;
	static StackVector<Ingredient> patties;
	static StackVector<Ingredient> lettuce;
	static StackVector<Ingredient> tomatoes;
	static StackVector<Ingredient> onions;
	static StackVector<Ingredient> cheese;
	
	public Pantry(){
		buns = new StackVector<Ingredient>();
		patties = new StackVector<Ingredient>();
		lettuce = new StackVector<Ingredient>();
		tomatoes = new StackVector<Ingredient>();
		onions = new StackVector<Ingredient>();
		cheese = new StackVector<Ingredient>();
		rng = new Random();
	}
	
	//Bun(5 day), Patty(4 day), Lettuce(3 day), Tomato(3 day), Onion(5 day), Cheese(2 day)
	public static void restock(int currentDay){
		for(int i = 0; i < rng.nextInt(300) + 700; i++)
			buns.push(new Ingredient("Bun", 5, currentDay));
		for(int i = 0; i < rng.nextInt(300) + 700; i++)
			patties.push(new Ingredient("Patty", 4, currentDay));
		for(int i = 0; i < rng.nextInt(300) + 700; i++)
			lettuce.push(new Ingredient("Lettuce", 3, currentDay));
		for(int i = 0; i < rng.nextInt(300) + 700; i++)
			tomatoes.push(new Ingredient("Tomato", 3, currentDay));
		for(int i = 0; i < rng.nextInt(300) + 700; i++)
			onions.push(new Ingredient("Onion", 5, currentDay));
		for(int i = 0; i < rng.nextInt(300) + 700; i++)
			cheese.push(new Ingredient("Cheese", 2, currentDay));
	}
	
	/**
	 * Uses an ingredient from the corresponding stack.
	 * @param food the ingredient being taken from the stack
	 * @return True if the ingredient was successfully taken from the stack.
	 */
	public boolean takeIngredient(String food){
		Ingredient removed = null;
		if(food.equals("Bun"))
			removed = (Ingredient) buns.pop();
		else if(food.equals("Patty"))
			removed = (Ingredient) patties.pop();
		else if(food.equals("Lettuce"))
			removed = (Ingredient) lettuce.pop();
		else if(food.equals("Tomato"))
			removed = (Ingredient) tomatoes.pop();
		else if(food.equals("Onion"))
			removed = (Ingredient) onions.pop();
		else if(food.equals("Cheese"))
			removed = (Ingredient) cheese.pop();
		return (removed != null);
	}
	
	/**
	 * Sorts all the food stacks, putting the closest to expiration at the top.
	 */
	public void sortAll(){
		
	    StackVector<Ingredient> tempStack = new StackVector<Ingredient>();
	    while(!buns.isEmpty()) {
	        Ingredient temp = (Ingredient) buns.pop();
	        while(!tempStack.isEmpty() && ((Ingredient) tempStack.peek()).getExpiration() < temp.getExpiration()) {
	            buns.push(tempStack.pop());
	        }
	        tempStack.push(temp);
	    }
	    buns = tempStack;
	    
	    tempStack = new StackVector<Ingredient>();
	    while(!patties.isEmpty()) {
	        Ingredient temp = (Ingredient) patties.pop();
	        while(!tempStack.isEmpty() && ((Ingredient) tempStack.peek()).getExpiration() < temp.getExpiration()) {
	            patties.push(tempStack.pop());
	        }
	        tempStack.push(temp);
	    }
	    patties = tempStack;
	    
	    tempStack = new StackVector<Ingredient>();
	    while(!lettuce.isEmpty()) {
	        Ingredient temp = (Ingredient) lettuce.pop();
	        while(!tempStack.isEmpty() && ((Ingredient) tempStack.peek()).getExpiration() < temp.getExpiration()) {
	            lettuce.push(tempStack.pop());
	        }
	        tempStack.push(temp);
	    }
	    lettuce = tempStack;
	    
	    tempStack = new StackVector<Ingredient>();
	    while(!tomatoes.isEmpty()) {
	        Ingredient temp = (Ingredient) tomatoes.pop();
	        while(!tempStack.isEmpty() && ((Ingredient) tempStack.peek()).getExpiration() < temp.getExpiration()) {
	            tomatoes.push(tempStack.pop());
	        }
	        tempStack.push(temp);
	    }
	    tomatoes = tempStack;
	    
	    tempStack = new StackVector<Ingredient>();
	    while(!onions.isEmpty()) {
	        Ingredient temp = (Ingredient) onions.pop();
	        while(!tempStack.isEmpty() && ((Ingredient) tempStack.peek()).getExpiration() < temp.getExpiration()) {
	            onions.push(tempStack.pop());
	        }
	        tempStack.push(temp);
	    }
	    onions = tempStack;
	    
	    tempStack = new StackVector<Ingredient>();
	    while(!cheese.isEmpty()) {
	        Ingredient temp = (Ingredient) cheese.pop();
	        while(!tempStack.isEmpty() && ((Ingredient) tempStack.peek()).getExpiration() < temp.getExpiration()) {
	            cheese.push(tempStack.pop());
	        }
	        tempStack.push(temp);
	    }
	    cheese = tempStack;
	    
	}
	
	/**
	 * Pops all food items that are expired and prints totals
	 * @param currentDay the current day of business to compare the food items to
	 */
	public void tossExpired(int currentDay){
		
		sortAll();
		int bunsWasted = 0;
		int pattiesWasted = 0;
		int lettuceWasted = 0;
		int tomatoesWasted = 0;
		int onionsWasted = 0;
		int cheeseWasted = 0;
		
		while(((Ingredient) buns.peek()).getExpiration() <= currentDay){
			buns.pop();
			bunsWasted++;
		}
		while(((Ingredient) patties.peek()).getExpiration() <= currentDay){
			patties.pop();
			pattiesWasted++;
		}
		while(((Ingredient) lettuce.peek()).getExpiration() <= currentDay){
			lettuce.pop();
			lettuceWasted++;
		}
		while(((Ingredient) tomatoes.peek()).getExpiration() <= currentDay){
			tomatoes.pop();
			tomatoesWasted++;
		}
		while(((Ingredient) onions.peek()).getExpiration() <= currentDay){
			onions.pop();
			onionsWasted++;
		}
		while(((Ingredient) cheese.peek()).getExpiration() <= currentDay){
			cheese.pop();
			cheeseWasted++;
		}
		
		System.out.println("Buns Wasted: " + bunsWasted);
		System.out.println("Patties Wasted: " + pattiesWasted);
		System.out.println("Lettuce Wasted: " + lettuceWasted);
		System.out.println("Tomatoes Wasted: " + tomatoesWasted);
		System.out.println("Onions Wasted: " + onionsWasted);
		System.out.println("Cheese Wasted: " + cheeseWasted);
	}
	
	private class StackVector<T> implements StackInterface<Object>{

		private final Vector<T> vector;
		private int numElements;
		
		public StackVector(){
			@SuppressWarnings("unchecked")
			Vector<T> tempVector = new Vector<T>(0, 1);
			vector = tempVector;
		}
		
		@Override
		public void push(Object newEntry) {
			vector.add((T) newEntry);
			numElements = vector.size();
		}

		@Override
		public Object pop() {
			if(numElements == 0)
				return null;
			Object obj = vector.lastElement();
			vector.removeElementAt(numElements - 1);
			numElements = vector.size();
			return obj;
		}

		@Override
		public Object peek() {
			return vector.elementAt(numElements);
		}

		@Override
		public boolean isEmpty() {
			return (vector.isEmpty());
		}

		@Override
		public void clear() {
			vector.clear();
		}

	}
}
