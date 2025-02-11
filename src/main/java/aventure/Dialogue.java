package engine.object;

import java.util.ArrayList;

public abstract class Dialogue extends Event {
	private String npcName;
	private ArrayList<String> dialogues;
	private ArrayList<String> playerResponses;
	private int currentLine;
	
	public Dialogue() {
		// TODO Auto-generated constructor stub
	}
	public int getCurrentLine() {
		return currentLine;
	}
	
	public ArrayList<String> getDialogues() {
		return dialogues;
	}
	
	public String getNpcName() {
		return npcName;
	}
	
	public ArrayList<String> getPlayerResponses() {
		return playerResponses;
	}
	
	public void setCurrentLine(int currentLine) {
		this.currentLine = currentLine;
	}
	
	public void setDialogues(ArrayList<String> dialogues) {
		this.dialogues = dialogues;
	}
	
	public void setNpcName(String npcName) {
		this.npcName = npcName;
	}
	
	public void setPlayerResponses(ArrayList<String> playerResponses) {
		this.playerResponses = playerResponses;
	}
}
