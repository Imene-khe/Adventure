package aventure.engine.object;

public class Armor extends Equipment {
	    private int defense;
	    private String material;
	    private boolean equipped;
	    
	    public Armor() {
			// TODO Auto-generated constructor stub
		}
	    
	    public int getDefense() {
			return defense;
		}
	    
	    public String getMaterial() {
			return material;
		}
	    
	    public boolean isEquipped() {
			return equipped;
		}
	    
	    public void setDefense(int defense) {
			this.defense = defense;
		}
	    
	    public void setEquipped(boolean equipped) {
			this.equipped = equipped;
		}
	    
	    public void setMaterial(String material) {
			this.material = material;
		}
}
