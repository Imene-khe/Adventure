package aventure.engine.traitement;

import java.util.ArrayList;
import java.util.List;

import config.GameConfiguration;
import aventure.engine.map.Block;
import aventure.engine.map.Map;
import aventure.engine.player.Antagonist;
import aventure.engine.player.Hero;

public class MobileElementManager implements ElementInterface {
    private Map map;
    private Hero hero;
    private ArrayList<Antagonist> enemies = new ArrayList<>();

    public MobileElementManager(Map map) {
        this.map = map;
    }

    @Override
    public void set(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void add(Antagonist antagonist) {
        enemies.add(antagonist);
    }

    @Override
    public void moveLeftHero() {
        Block position = hero.getPosition();
        if (position.getColumn() > 0) {
            Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
            if (!map.isBlocked(newPosition)) { // Vérification d'obstacle
                hero.setPosition(newPosition);
            }
        }
    }

    @Override
    public void moveRightHero() {
        Block position = hero.getPosition();
        if (position.getColumn() < map.getColumnCount() - 1) {
            Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
            if (!map.isBlocked(newPosition)) {
                hero.setPosition(newPosition);
            }
        }
    }

    @Override
    public void generateEnemy() {
        int randomColumn = (int) (Math.random() * map.getColumnCount());
        Block position = map.getBlock(0, randomColumn);
        if (!map.isBlocked(position)) {
            Antagonist enemy = new Antagonist(position);
            add(enemy);
        }
    }

    @Override
    public Hero getHero() {
        return hero;
    }

    @Override
    public List<Antagonist> getEnemies() {
        return enemies;
    }
}

