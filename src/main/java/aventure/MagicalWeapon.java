package engine.object;

import aventure.engine.object.Weapon;

public class MagicalWeapon extends Weapon{
	private String type;
	private String power;
	
	public MagicalWeapon() {
		// TODO Auto-generated constructor stub
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	
	
}
