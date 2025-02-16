package aventure.engine.stats;

import java.util.HashMap;
import aventure.engine.object.*;


public class Inventory {
	private HashMap<String,Equipment> inventory;
	
	public Inventory() {
		inventory = new HashMap<String, Equipment>();
	}	
}
