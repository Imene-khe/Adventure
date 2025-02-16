package aventure.engine.map;

import java.util.HashMap;
import aventure.engine.object.Obstacle;

public class Map {
    private Block[][] blocks;
    private HashMap<Block, Obstacle> obstacles = new HashMap<>();
    private HashMap<Block, Boolean> terrainBlocked = new HashMap<>();
    private HashMap<Block, String> staticObjects = new HashMap<>();
    private HashMap<Block, String> staticTerrain = new HashMap<>();

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

        for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                Block block = blocks[lineIndex][columnIndex];

                // Définir le terrain aléatoire
                double random = Math.random();
                if (random < 0.15) {
                    staticTerrain.put(block, "water");
                } else if (random < 0.3) {
                    staticTerrain.put(block, "path");
                } else {
                    staticTerrain.put(block, "grass");
                }
            }
        }

        for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                Block block = blocks[lineIndex][columnIndex];

                // Définition du type de terrain
                double random = Math.random();
                if (random < 0.15) {
                    staticTerrain.put(block, "water");
                } else if (random < 0.3) {
                    staticTerrain.put(block, "path");
                } else {
                    staticTerrain.put(block, "grass");
                }
            }
        }
        generateObjects();

    }
    
    public HashMap<Block, String> getStaticTerrain() {
        return staticTerrain;
    }


    private void generateObjects() {
        for (int lineIndex = 0; lineIndex < lineCount; lineIndex++) {
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                Block block = blocks[lineIndex][columnIndex];

                if (staticTerrain.get(block) != null && staticTerrain.get(block).equals("grass")) {
                    double rand = Math.random();

                    if (rand < 0.05) {  // 🔄 Augmente les arbres à 5%
                        staticObjects.put(block, "tree");
                        setTerrainBlocked(block, true);
                    } else if (rand < 0.08) {  // 🔄 Augmente les maisons à 3%
                        staticObjects.put(block, "house");
                        setTerrainBlocked(block, true);
                    } else if (rand < 0.10) {  // 🔄 Ajoute plus de coffres (2%)
                        staticObjects.put(block, "chest");
                        setTerrainBlocked(block, true);
                    }
                    }
                }
            }
        }
 


    public boolean isBlocked(Block block) {
        return obstacles.containsKey(block) || terrainBlocked.getOrDefault(block, false) || 
               (staticTerrain.containsKey(block) && staticTerrain.get(block).equals("water")) || 
               staticObjects.containsKey(block);
    }

    public void setTerrainBlocked(Block block, boolean blocked) {
        terrainBlocked.put(block, blocked);
    }

    public int getColumnCount() {
        return columnCount;
    }

    public int getLineCount() {
        return lineCount;
    }
    
    public Block[][] getBlocks() {
        return blocks;
    }


    public Block getBlock(int line, int column) {
        return blocks[line][column];
    }
    

    public HashMap<Block, String> getStaticObjects() {
        return staticObjects;
    }
}
