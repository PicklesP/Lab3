package cs240;

public class Ingredient {
	private String itemName;
	private int expirationDate;
	
	public Ingredient(String itemName, int expirationTime, int currentDate){
		this.itemName = itemName;
		expirationDate = expirationTime + currentDate;
	}
	
	public boolean isExpired(int currentDate){
		return currentDate > expirationDate;
	}
	
	public String getName(){
		return itemName;
	}
	
	public int getExpiration(){
		return expirationDate;
	}
}
