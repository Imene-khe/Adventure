package engine.player;

import java.awt.Image;

import aventure.engine.player.Person;
import engine.map.Block;

public class Antagonist extends Person{

	public Antagonist(String name, int id, int health, Block position, Image imagePath) {
		super(name, id, health, position, imagePath);
		// TODO Auto-generated constructor stub
	}
	
	public Antagonist(Block position) {
		// TODO Auto-generated constructor stub
		super(position);
	}
}
