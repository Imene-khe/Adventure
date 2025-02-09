package engine.object;

import java.util.ArrayList;

public class Quest extends Event{
	private boolean isCompleted;
	private String objective;
	private int progress;
	private ArrayList<String> actions;
}
