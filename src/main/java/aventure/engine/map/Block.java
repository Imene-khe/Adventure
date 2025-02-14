package engine.map;

public class Block {
	private int line;
	private int column;
	private boolean isOccuped;

	public Block(int line, int column) {
		this.line = line;
		this.column = column;
		isOccuped=false;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}
	
	public boolean isOccuped() {
		return isOccuped;
	}

	@Override
	public String toString() {
		return "Block [line=" + line + ", column=" + column + "]";
	}
	
	public void putElement() {
		isOccuped=true;
	}

}
