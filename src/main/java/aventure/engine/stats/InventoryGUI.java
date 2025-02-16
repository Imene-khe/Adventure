package aventure.engine.stats;

import javax.swing.*;
import aventure.engine.object.Equipment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryGUI {
    private JFrame frame;
    private JPanel inventoryPanel;
    private Inventory inventory;

    public InventoryGUI(Inventory inventory) {
        this.inventory = inventory;
        frame = new JFrame("Inventaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300); // Taille de la fenêtre

        // Initialisation du panneau d'inventaire
        inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Disposition en ligne

        updateInventoryDisplay();

        // Ajouter le panneau à la fenêtre
        frame.add(inventoryPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Méthode pour mettre à jour l'affichage des éléments dans l'inventaire
    public void updateInventoryDisplay() {
        inventoryPanel.removeAll(); // Réinitialiser le panneau

        // Ajouter les éléments de l'inventaire au panneau
        for (int i = 0; i < 4; i++) { // Utiliser inventory.getSize() au lieu de 4
            Equipment item = inventory.getEquipmentAt(i);
            JButton button = new JButton();
            if (item != null) {
                button.setToolTipText(item.getName()); // Afficher le nom de l'objet en info-bulle
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame, "Vous avez sélectionné: " + item.getName());
                    }
                });
            } else {
                button.setText("Vide"); // Si aucune case n'est remplie
            }
            inventoryPanel.add(button);
        }

        inventoryPanel.revalidate(); // Revalider le panneau pour qu'il se réaffiche correctement
        inventoryPanel.repaint();    // Redessiner le panneau
    }

    public static void main(String[] args) {
        // Exemple d'utilisation avec un inventaire de 4 éléments
        Inventory inventory = new Inventory();

        // Ajouter quelques objets à l'inventaire
        inventory.addEquipment(new Equipment("Épée", 0));
        inventory.addEquipment(new Equipment("Bâton en bois", 100));
        inventory.addEquipment(new Equipment("Fouet", 0));

        new InventoryGUI(inventory);
    }
}
