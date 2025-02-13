package aventure.engine.map;

import java.util.HashMap;
import aventure.engine.object.Block;
import aventure.engine.object.Obstacle;
import aventure.Item;


public class Map {
    private Block[][] blocks; // Grille de la carte
    private HashMap<Block, Obstacle> obstacles = new HashMap<>(); // Objets statiques
    private HashMap<Block, Item> items = new HashMap<>(); // Objets récupérables sur la carte du coup

    private int lineCount;
    private int columnCount;

    public Map(int lineCount, int columnCount) {
        this.lineCount = lineCount;
        this.columnCount = columnCount;
        blocks = new Block[lineCount][columnCount];

        // on construit les blocs
        
        for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                blocks[lineIndex][columnIndex] = new Block(lineIndex, columnIndex);
            }
        }
    }

    /** on recup un bloc precis */
    public Block getBlock(int line, int column) {
        if (line < 0 || line >= lineCount || column < 0 || column >= columnCount) {
            throw new IllegalArgumentException("Coordonnées hors limites !");
        }
        return blocks[line][column];
    }

    //ajout d'un obstacle
    public void addObstacle(Block block, Obstacle obstacle) {
        obstacles.put(block, obstacle);
    }

    // ajout d'un truc qu'on peut recup
    public void addItem(Block block, Item item) {
        items.put(block, item);
    }

    //si un bloc contient un obstacle
    public boolean isBlocked(Block block) {
        return obstacles.containsKey(block);
    }

    //Vérifie si un item est présent 
    public boolean hasItem(Block block) {
        return items.containsKey(block);
    }

    //Récupère un item et le retire de la map 
    public Item pickUpItem(Block block) {
        return items.remove(block);
    }

     // Vérifie si un bloc est sur le bord 
    public boolean isOnBorder(Block block) {
        int line = block.getLine();
        int column = block.getColumn();
        return line == 0 || line == lineCount - 1 || column == 0 || column == columnCount - 1;
    }
}

