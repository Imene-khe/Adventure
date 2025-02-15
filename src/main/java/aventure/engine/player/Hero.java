package aventure.engine.player;

import aventure.engine.map.Block;

public class Hero {
    private Block position;

    public Hero(Block startPosition) {
        this.position = startPosition;
    }

    public Block getPosition() { // Ajout du getter
        return position;
    }

    public void setPosition(Block newPosition) { // Ajout du setter
        this.position = newPosition;
    }
}
