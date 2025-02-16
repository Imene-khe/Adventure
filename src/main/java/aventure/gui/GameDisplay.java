package aventure.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import aventure.engine.map.Block;
import aventure.engine.map.Map;
import aventure.engine.player.Hero;

public class GameDisplay extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int GRID_SIZE = 30;
    private static final int BLOCK_SIZE = 32;
    private Map map;
    private Hero hero;
    private HashMap<String, Image> tileset;

    public GameDisplay() {
        try {
            this.map = new Map(GRID_SIZE, GRID_SIZE);
            this.hero = new Hero(map.getBlock(GRID_SIZE / 2, GRID_SIZE / 2));
            this.tileset = new HashMap<>();
            loadImages();
            System.out.println("✅ GameDisplay créé avec succès !");
        } catch (Exception e) {
            System.out.println("❌ ERREUR : Impossible d'initialiser GameDisplay !");
            e.printStackTrace();
        }
    }

    private void loadImages() {
        try {
            System.out.println("📥 Chargement des images...");
            tileset.put("grass", loadImage("aventure/image/img/Tiles/Grass_Middle.png"));
            tileset.put("water", loadImage("aventure/image/img/Tiles/Water_Middle.png"));
            tileset.put("path", loadImage("aventure/image/img/Tiles/Path_Middle.png"));
            tileset.put("house", loadImage("aventure/image/img/Outdoor decoration/House.png"));
            tileset.put("tree", loadImage("aventure/image/img/Outdoor decoration/Oak_Tree.png"));
            tileset.put("chest", loadImage("aventure/image/img/Outdoor decoration/Chest.png"));
            System.out.println("✅ Toutes les images sont chargées !");
        } catch (Exception e) {
            System.out.println("❌ ERREUR : Impossible de charger les images !");
            e.printStackTrace();
        }
    }

    private Image loadImage(String path) throws IOException {
        return ImageIO.read(new File("src/main/java/" + path));
    }

    public void setMap(Map map) {
        this.map = map;
        repaint();
    }
    
    public Map getMap() {
        return map;
    }


    public Hero getHero() {
        return hero;
    }

    public void moveHero(Block newPosition) {
        System.out.println("🕹 Déplacement du héros !");
        hero.setPosition(newPosition);
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (map == null) return;

        Block[][] blocks = map.getBlocks();
        for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
            for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
                Block block = blocks[lineIndex][columnIndex];

                // 🔵 Vérifier que la case a bien un type de terrain défini
                if (map.getStaticTerrain().containsKey(block) && map.getStaticTerrain().get(block) != null) {
                    String terrainType = map.getStaticTerrain().get(block);
                    if (tileset.containsKey(terrainType)) {
                        g.drawImage(tileset.get(terrainType), block.getColumn() * BLOCK_SIZE, block.getLine() * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, null);
                    } else {
                        System.out.println("⚠ Terrain non trouvé : " + terrainType);
                    }
                } else {
                    g.drawImage(tileset.get("grass"), block.getColumn() * BLOCK_SIZE, block.getLine() * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, null);
                }

                // 🌳 Vérifier si un objet statique doit être dessiné sur cette case
                if (map.getStaticObjects().containsKey(block) && map.getStaticObjects().get(block) != null) {
                    String objectType = map.getStaticObjects().get(block);
                    if (tileset.containsKey(objectType)) {
                        g.drawImage(tileset.get(objectType), block.getColumn() * BLOCK_SIZE, block.getLine() * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, null);
                    } else {
                        System.out.println("⚠ Objet non trouvé dans le tileset : " + objectType);
                    }
                }
            }
        }

        // 🎭 Dessiner le héros
        if (hero != null) {
            hero.draw(g, BLOCK_SIZE);
        }

        // ❤️ Dessiner la barre de vie
        drawHealthBar(g);
    }

    // ✅ Méthode pour dessiner la barre de vie
    private void drawHealthBar(Graphics g) {
        int maxHealth = 100;
        int currentHealth = 75;  // 🔥 Modifier cette valeur pour tester les effets visuels

        g.setColor(java.awt.Color.RED);
        g.fillRect(10, 10, 200, 20); // Barre rouge (fond)
        g.setColor(java.awt.Color.GREEN);
        g.fillRect(10, 10, (currentHealth * 200) / maxHealth, 20); // Barre verte (vie restante)
        g.setColor(java.awt.Color.BLACK);
        g.drawRect(10, 10, 200, 20); // Contour
        g.drawString("Vie : " + currentHealth + "%", 90, 25); // Texte affichant le pourcentage
    }



    }


