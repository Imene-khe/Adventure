package aventure.engine.object;

import java.util.ArrayList;

public class Quest extends Event{
	private boolean isCompleted;
	private String objective;
	private int progress;
	private ArrayList<String> actions;
	
	public Quest() {
		// TODO Auto-generated constructor stub
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public ArrayList<String> getActions() {
		return actions;
	}

	public void setActions(ArrayList<String> actions) {
		this.actions = actions;
	}
	

}
