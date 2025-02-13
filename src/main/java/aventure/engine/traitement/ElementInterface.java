package aventure.engine.traitement;

import java.util.List;

import aventure.engine.player.Antagonist;
import engine.map.Block;
import engine.player.*;

public interface ElementInterface {

	void set(Hero hero);

	void add(Antagonist elt);

	void moveLeftHero();

	void moveRightHero();

	void generateEnemy();

	//void nextRound();

	Hero getHero();

	List<Antagonist> getEnemies();

}