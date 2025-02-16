package aventure.engine.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import aventure.engine.map.Block;

public class Hero {
    private Block position;
    private BufferedImage spriteSheet;
    private int spriteX = 0, spriteY = 0; // Position du sprite dans l'image

    public Hero(Block startPos) {
        this.position = startPos;
        try {
            spriteSheet = ImageIO.read(new File("src/main/java/aventure/image/img/Player/Player.png"));
        } catch (IOException e) {
            System.out.println("❌ Impossible de charger l'image du héros !");
            e.printStackTrace();
        }
    }

    public Block getPosition() {
        return position;
    }

    public void setPosition(Block newPosition) {
        this.position = newPosition;
    }

    public void moveLeft() {
        spriteY = 96;  // Regarde à gauche
        spriteX = (spriteX + 32) % (32 * 3);
    }

    public void moveRight() {
        spriteY = 64;  // Regarde à droite
        spriteX = (spriteX + 32) % (32 * 3);
    }

    public void moveUp() {
        spriteY = 32;  // Regarde en haut
        spriteX = (spriteX + 32) % (32 * 3);
    }

    public void moveDown() {
        spriteY = 0;  // Regarde en bas
        spriteX = (spriteX + 32) % (32 * 3);
    }


    public void draw(Graphics g, int size) {
        if (spriteSheet != null) {
            BufferedImage sprite = spriteSheet.getSubimage(spriteX, spriteY, 32, 32);
            g.drawImage(sprite, position.getColumn() * size, position.getLine() * size, size, size, null);
        }
    }
}
