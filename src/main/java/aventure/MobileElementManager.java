package engine.traitement;

import java.util.ArrayList;
import java.util.List;

import config.GameConfiguration;
import engine.environnement.StaticElement;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Enemy;
import engine.mobile.Missile;
import engine.player.Antagonist;
import engine.player.Hero;
import engine.player.MobileElement;

public class MobileElementManager implements ElementInterface{
	private Map map;
	private Hero hero;
	private ArrayList<Antagonist> enemies = new ArrayList<Antagonist>();
	
	public MobileElementManager(Map map) {
		this.map=map;
	}

	@Override
	public void set(Hero hero) {
		// TODO Auto-generated method stub
		this.hero=hero;
	}

	@Override
	public void add(Antagonist antagonist) {
		// TODO Auto-generated method stub
		enemies.add(antagonist);
	}

	@Override
	public void moveLeftHero() {
		Block position = hero.getPosition();
		if(position.getColumn() > 0) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
			hero.setPosition(newPosition);
		}
	}

	@Override
	public void moveRightHero() {		//determiner le pattern des ennemies
		// TODO Auto-generated method stub
		Block position = hero.getPosition();

		if (position.getColumn() < GameConfiguration.COLUMN_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
			hero.setPosition(newPosition);
		}
	}

	@Override
	public void generateEnemy() {
		// TODO Auto-generated method stub
		int randomColumn = getRandomNumber(0, GameConfiguration.COLUMN_COUNT - 1);
		Block position = map.getBlock(0, randomColumn);
		Antagonist enemy = new Antagonist(position);
		add(enemy);
	}

	@Override
	public Hero getHero() {
		// TODO Auto-generated method stub
		return hero;
	}

	@Override
	public List<Antagonist> getEnemies() {
		// TODO Auto-generated method stub
		return enemies;
	}

}
