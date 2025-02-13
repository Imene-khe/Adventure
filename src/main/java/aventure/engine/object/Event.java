package aventure.engine.object;


public abstract class Event {
	private String name;
	private String description;
	private int duration;
	private boolean isActive;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}
	
	public int getDuration() {
		return duration;
	}
	
	
}
