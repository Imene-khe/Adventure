package aventure.engine.object;

public class Weapon extends Equipment {
	private int damage;
	private int attackSpeed;
	private float range;
	private boolean isEquiped;
	
	public Weapon(String name, int price, int damage) {
		super(name,price);
		this.damage=10;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public float getRange() {
		return range;
	}

	public void setRange(float range) {
		this.range = range;
	}
	
}
