package cs240;

import java.util.Vector;

public class Menu {

	private ListVector<String>[] menuItems;
	
	public Menu(){
		menuItems = new ListVector[6];
		for(int i = 0; i < menuItems.length; i++)
			menuItems[i] = new ListVector<String>();
		
		//(1) Burger – Bun, Patty, Lettuce, Tomato, Onion	
		menuItems[0].add("Bun");
		menuItems[0].add("Patty");
		menuItems[0].add("Lettuce");
		menuItems[0].add("Tomato");
		menuItems[0].add("Onion");
		
		//(2) Cheese Burger – Cheese, Bun, Patty, Lettuce, Tomato, Onion
		menuItems[1].add("Cheese");
		menuItems[1].add("Bun");
		menuItems[1].add("Patty");
		menuItems[1].add("Lettuce");
		menuItems[1].add("Tomato");
		menuItems[1].add("Onion");
		
		//(3) Vegan lettuce wrap Burger – (NO Bun, No Patty),2 order of Lettuce, Tomato, Onion
		menuItems[2].add("Lettuce");
		menuItems[2].add("Lettuce");
		menuItems[2].add("Tomato");
		menuItems[2].add("Onion");
		
		//(4) Burger No Onion - (No Onion), Bun, Patty, Lettuce, Tomato, 
		menuItems[3].add("Bun");
		menuItems[3].add("Patty");
		menuItems[3].add("Lettuce");
		menuItems[3].add("Tomato");
		
		//(5) Cheese Burger No Onion – (No Onion), Cheese, Bun, Patty, Lettuce, Tomato
		menuItems[4].add("Cheese");
		menuItems[4].add("Bun");
		menuItems[4].add("Patty");
		menuItems[4].add("Lettuce");
		menuItems[4].add("Tomato");
		
		//(6) Burger No Tomato - (No Tomato), Bun, Patty, Lettuce, Onion  
		menuItems[5].add("Bun");
		menuItems[5].add("Patty");
		menuItems[5].add("Lettuce");
		menuItems[5].add("Onion");
	}
	
	/**
	 * Orders a menu item by removing the ingredients from the pantry.
	 * @param menuItem the index of the item being ordered
	 * @return True if there were sufficient ingredients to fulfill order
	 */
	public boolean order(int menuItem, Pantry p){
		boolean complete = true;
		for(int i = 0; i < menuItems[menuItem].length(); i++)
			if(!(p.takeIngredient((String) menuItems[menuItem].look(i))))
				complete = false;
		return false;
	}
	
	public class ListVector<T> implements ListInterface {

		private Vector list;

		public ListVector(){
			list = new Vector();
		}
		
		@Override
		public void add(Object item) {
			list.add(item);
		}

		@Override
		public void add(Object item, int index) {
			list.add(index, item);
		}

		@Override
		public Object remove(int index) {
			return list.remove(index);
		}

		@Override
		public void removeAll() {
			list = new Vector();
		}

		@Override
		public T replace(Object item, int index) {
			T result = (T) list.get(index);
			list.add(index, item);
			return result;
		}

		@Override
		public Object look(int index) {
			return list.get(index);
		}

		@Override
		public void lookAll() {
			for(int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		}

		@Override
		public boolean check(Object item) {
			return list.contains(item);
		}

		@Override
		public int length() {
			return list.size();
		}

		@Override
		public boolean isEmpty() {
			return list.isEmpty();
		}
	}
}
