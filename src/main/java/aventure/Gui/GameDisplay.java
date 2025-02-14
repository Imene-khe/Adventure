package aventure.Gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import aventure.engine.map.Block;
import aventure.engine.map.Map;
import aventure.Gui.*;

public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;
	private Map map;

    // Setter pour la carte afin de pouvoir la passer à GameDisplay depuis le main
    public void setMap(Map map) {
        this.map = map;
        repaint();  // Redessiner lorsque la carte est définie
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Appeler la méthode de la classe parente pour s'assurer que tout soit bien initialisé

        if (map != null) {
            int blockSize = 20;  // Taille du bloc

            Block[][] blocks = map.getBlocks();  // Récupérer les blocs de la carte

            // Dessiner la carte (les blocs)
            for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
                for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
                    Block block = blocks[lineIndex][columnIndex];
                    if(block.isOccuped()) {
                    	 g.setColor(Color.RED);
                         g.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
                	}
                    else {
                    	if ((lineIndex + columnIndex) % 2 == 0) {

                            g.setColor(Color.LIGHT_GRAY);
                            g.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
                        }
                        else {
                        	g.setColor(Color.GRAY);
                            g.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
                        }
                    }
                    // Alterner les couleurs en fonction des indices
                    
                
                }
            }
        }
    }
    
 // Méthode principale pour tester
    public static void main(String[] args) {
        // Créer une carte avec 50 lignes et 50 colonnes (par exemple)
        Map map = new Map(50,50);
        Block b = map.getBlock(1,1);
        b.putElement();
        // Initialiser la fenêtre JFrame
        JFrame frame = new JFrame("Test GameDisplay");
        // Créer un objet GameDisplay pour afficher la carte
        GameDisplay gameDisplay = new GameDisplay();
        
        // Définir la carte dans GameDisplay
        gameDisplay.setMap(map);

        // Ajouter GameDisplay au JFrame pour l'afficher
        frame.add(gameDisplay);

        // Utiliser pack() pour redimensionner la fenêtre selon le contenu
        frame.pack();  // Ajuste la taille du JFrame en fonction de son contenu

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermer l'application lorsque la fenêtre se ferme
        frame.setVisible(true);  // Afficher la fenêtre
    }
}
