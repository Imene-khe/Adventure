package aventure.engine.map;

public class Block {
    private int line;
    private int column;
    private boolean isOccupied; // Correction du nom

    public Block(int line, int column) {
        this.line = line;
        this.column = column;
        this.isOccupied = false;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public boolean isOccupied() { // Correction du getter
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) { // Ajout du setter
        this.isOccupied = isOccupied;
    }

    @Override
    public String toString() {
        return "Block [line=" + line + ", column=" + column + "]";
    }
}

