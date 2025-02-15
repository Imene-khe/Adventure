package aventure.engine.map;

import java.util.HashMap;
import aventure.engine.object.Obstacle;
import aventure.Item;

public class Map {
    private Block[][] blocks;
    private HashMap<Block, Obstacle> obstacles = new HashMap<>();
    private HashMap<Block, Item> items = new HashMap<>();
    private int lineCount;
    private int columnCount;

    public Map(int lineCount, int columnCount) {
        this.lineCount = lineCount;
        this.columnCount = columnCount;
        blocks = new Block[lineCount][columnCount];

        for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                blocks[lineIndex][columnIndex] = new Block(lineIndex, columnIndex);
            }
        }
    }

    public Block getBlock(int line, int column) {
        if (line < 0 || line >= lineCount || column < 0 || column >= columnCount) {
            throw new IllegalArgumentException("Coordonnées hors limites !");
        }
        return blocks[line][column];
    }

    public void addObstacle(Block block, Obstacle obstacle) {
        obstacles.put(block, obstacle);
        block.setOccupied(true); 
    }

    public void addItem(Block block, Item item) {
        items.put(block, item);
    }

    public boolean isBlocked(Block block) {
        return obstacles.containsKey(block);
    }

    public boolean hasItem(Block block) {
        return items.containsKey(block);
    }

    public Item pickUpItem(Block block) {
        return items.remove(block);
    }

    public boolean isOnBorder(Block block) {
        int line = block.getLine();
        int column = block.getColumn();
        return line == 0 || line == lineCount - 1 || column == 0 || column == columnCount - 1;
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getColumnCount() {
        return columnCount;
    }
}
