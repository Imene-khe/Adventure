package aventure.engine.object;

public class ManualWeapon extends Weapon {
	private double useTime;
	private String specialAbility;
	
	public ManualWeapon(String name,int price, int damage, double useTime, String specialAbility) {
		// TODO Auto-generated constructor stub
		super(name, price,damage);
		this.useTime=useTime;
		this.specialAbility=specialAbility;
	}

	public double getUseTime() {
		return useTime;
	}

	public void setUseTime(double useTime) {
		this.useTime = useTime;
	}

	public String getSpecialAbility() {
		return specialAbility;
	}

	public void setSpecialAbility(String specialAbility) {
		this.specialAbility = specialAbility;
	}

	
	
}
