package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.map.Block;
import engine.map.Map;


public class MainGUI extends JFrame implements Runnable {

	private Map map;
	private GameDisplay dashboard;

	public MainGUI(String title) {
		super(title);
		initLayout();
	}

	private void initLayout() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel inventoryPanel = new JPanel(new GridLayout());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	//@Override
	/*public void run() {
		while (true) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			dashboard.repaint();
		}
	}*/
}


	