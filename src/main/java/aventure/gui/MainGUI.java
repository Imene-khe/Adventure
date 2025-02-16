package aventure.gui;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import aventure.engine.map.Block;
import aventure.engine.map.Map;

public class MainGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private GameDisplay dashboard;
    private Map map;

    public MainGUI() {
        super("Aventure - Déplacement du Héros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        this.map = new Map(30, 30);
        this.dashboard = new GameDisplay();
        add(dashboard, BorderLayout.CENTER);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                moveHero(e.getKeyCode());
            }
        });
        setFocusable(true);
        setVisible(true);
    }

    
    private void moveHero(int keyCode) {
        Block currentPos = dashboard.getHero().getPosition();
        Block newPos = currentPos;

        if (keyCode == KeyEvent.VK_LEFT && currentPos.getColumn() > 0) {
            newPos = dashboard.getMap().getBlock(currentPos.getLine(), currentPos.getColumn() - 1);
            dashboard.getHero().moveLeft();
        } else if (keyCode == KeyEvent.VK_RIGHT && currentPos.getColumn() < dashboard.getMap().getColumnCount() - 1) {
            newPos = dashboard.getMap().getBlock(currentPos.getLine(), currentPos.getColumn() + 1);
            dashboard.getHero().moveRight();
        } else if (keyCode == KeyEvent.VK_UP && currentPos.getLine() > 0) {
            newPos = dashboard.getMap().getBlock(currentPos.getLine() - 1, currentPos.getColumn());
            dashboard.getHero().moveUp();
        } else if (keyCode == KeyEvent.VK_DOWN && currentPos.getLine() < dashboard.getMap().getLineCount() - 1) {
            newPos = dashboard.getMap().getBlock(currentPos.getLine() + 1, currentPos.getColumn());
            dashboard.getHero().moveDown();
        }
        
        // pour surveiller les beugs de mouvement 

        if (!dashboard.getMap().isBlocked(newPos)) {
            dashboard.repaint(currentPos.getColumn() * 32, currentPos.getLine() * 32, 32, 32); // 🔥 Effacer l’ancienne position
            dashboard.getHero().setPosition(newPos);
            System.out.println(" Héros déplacé à : " + newPos.getLine() + ", " + newPos.getColumn());
            dashboard.repaint(newPos.getColumn() * 32, newPos.getLine() * 32, 32, 32); // 🔥 Redessine uniquement la nouvelle position
        } else {
            System.out.println(" Déplacement bloqué !");
        }
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::new);
    }
}

