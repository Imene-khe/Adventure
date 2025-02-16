package aventure.engine.object;

public class MagicalWeapon extends Weapon{
	private String power;
	private int manaCost;
	
	
	public MagicalWeapon(String name,int price, int damage, String power) {
		// TODO Auto-generated constructor stub
		super(name, price, damage);
		this.power=power;
	}
	
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}

	public int getManaCost() {
		return manaCost;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	
	
	
}
