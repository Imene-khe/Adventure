package aventure.engine.player;

import engine.map.Block;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Person {		//mettre la classe en abstract

		private String name;
		private int id;
		private int health;
		private Block position;
		private Image image;
		//ajout d'un attribut vitesse
		
		public Person(String name, int id, int health, Block position, Image imagePath) {		//constructeur pour les personnages mobiles faisant parti de l'histoire
			// TODO Auto-generated constructor stub
			this.name=name;
			this.id = id;
			this.health=health;
			this.position=position;
			this.image=new ImageIcon(imagePath).getImage();
		}
		
		public 
		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getHealth() {
			return health;
		}

		public void setHealth(int health) {
			this.health = health;
		}

		public Block getPosition() {
			return position;
		}

		public void setPosition(Block position) {
			this.position = position;
		}
		
		
}
