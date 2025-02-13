package aventure.engine.object;

public abstract class Equipment {
	private String name;
	private int price;
	private int durabilty;
	
	public Equipment() {
		// TODO Auto-generated constructor stub
	}
	
	public int getDurabilty() {
		return durabilty;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setDurabilty(int durabilty) {
		this.durabilty = durabilty;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	//juste pour voir
}
