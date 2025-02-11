package engine.player;

import java.awt.Image;

import engine.map.Block;

public class Hero extends Person{
	public Hero(String name, int id, int health, Block position, Image imagePath) {
		super(name,id, health, position, imagePath);
	}
	
}

