package aventure.engine.player;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import aventure.engine.map.Block;

public class Hero {
    private Block position;
    private int spriteX = 0;  // Animation frame (horizontale)
    private int spriteY = 0;  // Direction (verticale)
    private boolean isFlipped = false;  //  Permet d'inverser l'image pour la gauche
    private Image heroSprite;  //  Stocke l'image du héros
    private int health = 100;  //  Vie du héros


    public Hero(Block startPosition) {
        this.position = startPosition;
        loadHeroSprite();
    }
    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) health = 0;  // Empêche d’avoir une vie négative
        System.out.println("💥 Héros touché ! Vie restante : " + health + "%");
    }


    // Charger l’image du hero
    private void loadHeroSprite() {
        try {
            heroSprite = ImageIO.read(new File("src/main/java/aventure/image/img/Player/Player.png"));
        } catch (IOException e) {
            System.out.println("❌ ERREUR : Impossible de charger l’image du héros !");
            e.printStackTrace();
        }
    }

    //  Déplacement à gauche (on inverse l’image)
    public void moveLeft() {
        spriteY = 32;  
        spriteX = (spriteX + 32) % (32 * 3);
        isFlipped = true;  //  Active l'effet miroir pcq j'ai pas d'image pour la gauche
    }

    // ✅ Déplacement à droite 
    public void moveRight() {
        spriteY = 32;  
        spriteX = (spriteX + 32) % (32 * 3);
        isFlipped = false;  
    }

    // ✅ Déplacement en haut
    public void moveUp() {
        spriteY = 64;  // 🔄 Ligne 3 -> Héros regarde en haut
        spriteX = (spriteX + 32) % (32 * 3);
    }

    // Déplacement en bas
    public void moveDown() {
        spriteY = 0;  // 🔄 Ligne 1 -> Héros regarde en bas
        spriteX = (spriteX + 32) % (32 * 3);
    }

    // 
    public void draw(Graphics g, int blockSize) {
        int drawX = position.getColumn() * blockSize;
        int drawY = position.getLine() * blockSize;

        if (isFlipped) {
            //  Dessine l’image inversée pour la gauche
            g.drawImage(heroSprite, drawX + blockSize, drawY, drawX, drawY + blockSize,
                    spriteX, spriteY, spriteX + 32, spriteY + 32, null);
        } else {
            //  Dessine l’image normalement
            g.drawImage(heroSprite, drawX, drawY, drawX + blockSize, drawY + blockSize,
                    spriteX, spriteY, spriteX + 32, spriteY + 32, null);
        }
    }

    // Récupérer la position actuelle du héros
    public Block getPosition() {
        return position;
    }

    // Modifier la position du héros
    public void setPosition(Block newPosition) {
        this.position = newPosition;
    }
    
    public int getHealth() {
        return health;
    }
    
}
