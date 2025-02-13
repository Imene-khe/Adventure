package aventure.engine.player;

import aventure.engine.object.Block;

public class Antagonist {
    private Block position; // Position actuelle

    public Antagonist(Block startPosition) {
        this.position = startPosition;
    }

    public Block getPosition() { //  Récupère la position
        return position;
    }

    public void setPosition(Block newPosition) { //  Change la position
        this.position = newPosition;
    }
}
