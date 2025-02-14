package aventure.engine.player;

import java.awt.Image;

import aventure.engine.*;

public class Hero extends Person{
	public Hero(String name, int id, int health, Image imagePath) {
		super(name,id, health, position, imagePath);
	}
	
}

