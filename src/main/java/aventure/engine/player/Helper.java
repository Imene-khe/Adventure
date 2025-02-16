package aventure.engine.player;

import java.awt.Image;

import aventure.engine.map.Block;

public class Helper extends Person{

	private String helpMessage; 		// le message que l'helper peut donner. A voir si on ne fait pas une interface

    // Constructeur de Helper avec position et un message d'aide
    public Helper(String name, int id, int health, String imagePath, Block position, String helpMessage) {
        super(name, id, health, imagePath, position); // Appel du constructeur de Person
        this.helpMessage = helpMessage;
    }

    public Helper(Block position, String helpMessage) {
        super(position);
        this.helpMessage = helpMessage;
    }

    public void giveHelp() {
        System.out.println(super.getName() + " dit : " + helpMessage);
    }

    public String getHelpMessage() {
        return helpMessage;
    }

    public void setHelpMessage(String helpMessage) {
        this.helpMessage = helpMessage;
    }

}
