package aventure.engine.player;

import aventure.engine.map.Block;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Image;

public class Person {
    private String name;
    private int id;
    private int health;
    private Block position;
    private ImageIcon image;

    // Constructeur pour les personnages mobiles
    public Person(String name, int id, int health, String imagePath, Block position) {
        this.name = name;
        this.id = id;
        this.health = health;
        // Utiliser un chemin relatif pour l'image
        this.image = new ImageIcon(getClass().getResource(imagePath)); // imagePath doit être relatif
        this.position=position;
    }

    public Person(String name, int id, int health) {
		// TODO Auto-generated constructor stub
    	 this.name = name;
         this.id = id;
         this.health = health;
	}

	public Person(String string, int i, int j, String imagePath) {
		// TODO Auto-generated constructor stub
		this.name = name;
        this.id = id;
        this.health = health;
        this.image = new ImageIcon(getClass().getResource(imagePath)); // imagePath doit être relatif
	}

	// Méthode pour afficher l'info et l'image
    public void showPersonInfo() {
        // Créer une fenêtre JFrame pour afficher le personnage
        JFrame frame = new JFrame(name + " (" + id + ")");
        frame.setLayout(new BorderLayout());

        // Créer un JLabel pour afficher l'image
        JLabel imageLabel = new JLabel(image);  // Afficher l'image sur le JLabel

        // Créer un JPanel pour afficher l'information (nom et ID)
        JPanel infoPanel = new JPanel();
        infoPanel.add(new JLabel("Nom : " + name));
        infoPanel.add(new JLabel("ID : " + id));

        // Ajouter les éléments à la fenêtre
        frame.add(imageLabel, BorderLayout.CENTER);  // Afficher l'image au centre
        frame.add(infoPanel, BorderLayout.SOUTH);    // Afficher l'info en bas

        // Configurer la fenêtre
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Créer une instance de Person avec une image et afficher l'info
        Person person = new Person("Alice", 1, 100, "/aventure/image/imageHero.png");
        person.showPersonInfo();
    }
}
