package engine.object;

import java.util.ArrayList;

public abstract class Dialogue extends Event {
	private String npcName;
	private ArrayList<String> dialogues;
	private ArrayList<String> playerResponses;
	private int currentLine;
}
