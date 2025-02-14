package aventure.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private GameDisplay dashboard;

    // Constructeur de MainGUI
    public MainGUI() {
        super("MainGUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 900);
        initLayout();
    }

    // Initialisation du layout
    private void initLayout() {
        // Obtenir le contentPane et définir son layout à BorderLayout
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        // Créer une instance de GameDisplay et l'ajouter au centre
        dashboard = new GameDisplay(); // Utiliser le champ dashboard
        contentPane.add(dashboard, BorderLayout.CENTER);  // Ajouter GameDisplay au centre

        // Créer un panel inventoryPanel avec FlowLayout pour la zone SOUTH
        JPanel inventoryPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout avec alignement à gauche
        inventoryPanel.add(new JButton("Objet 1"));
        inventoryPanel.add(new JButton("Objet 2"));
        inventoryPanel.add(new JButton("Objet 3"));
        inventoryPanel.add(new JButton("Objet 4"));
        inventoryPanel.add(new JButton("Objet 5"));

        // Ajouter inventoryPanel dans la zone SOUTH du BorderLayout
        contentPane.add(inventoryPanel, BorderLayout.SOUTH);
    }

    // Méthode main pour lancer l'application
    public static void main(String[] args) {
        // Lancer l'interface graphique dans le thread EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> {
            MainGUI mainGUI = new MainGUI();  // Créer l'instance de MainGUI
            mainGUI.setVisible(true);  // Afficher la fenêtre
        });
    }
}
