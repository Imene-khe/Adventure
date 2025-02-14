package aventure.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import aventure.engine.map.Block;
import aventure.engine.map.Map;
import aventure.gui.*;

public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;
	private Map map;

	public GameDisplay() {
		// Créer une carte avec 50 lignes et 50 colonnes (par exemple)
       this.map= new Map(50,50);
        //Block b = map.getBlock(1,1);
        //b.putElement();
	}
	
	public void setMap(Map map) {
        this.map = map;
        repaint();  // Redessiner la carte après changement
    }
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Appeler la méthode de la classe parente pour s'assurer que tout soit bien initialisé

        if (map != null) {
            int blockSize = 20;  // Taille du bloc

            Block[][] blocks = map.getBlocks();  // Récupérer les blocs de la carte

            // Dessiner la carte (les blocs)
            for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
                for (int columnIndex = 0; columnIndex < map.getLineCount(); columnIndex++) {
                    Block block = blocks[lineIndex][columnIndex];
                    if(block.isOccuped()) {
                    	 g.setColor(Color.RED);
                         g.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
                	}
                    else {
                    	if ((lineIndex + columnIndex) % 2 == 0) {

                            g.setColor(Color.GREEN);
                            g.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
                        }
                        else {
                        	g.setColor(Color.LIGHT_GRAY);
                            g.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
                        }
                    }
                }
            }
        }
    }
}
