import java.util.Random;

public class Mine {
    int numMines;
    char[][] mineField;

    public Mine(int numMines, char[][] mineField) {
        this.numMines = numMines;
        this.mineField = mineField;
    }

    public char getMineFieldElement(int row, int col) {
        return mineField[row][col];
    }

    public char[][] getMineField() {
        return mineField;
    }

    public int getNumMines() {
        return numMines;
    }

    public void initializeMineField(int gridSize) {
        Random rand = new Random();
        for (int i = 0; i < numMines; i++) {
            int row, col;
            do {
                row = rand.nextInt(gridSize);
                col = rand.nextInt(gridSize);
            } while (mineField[row][col] == '*');
            mineField[row][col] = '*';
        }
    }
}
