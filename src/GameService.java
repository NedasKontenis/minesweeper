public class GameService {
    private Mine mine;
    private Grid grid;

    public GameService(Mine mine, Grid grid) {
        this.mine = mine;
        this.grid = grid;
    }

    public void processCells(int row, int col) {
        int numAdjacentMines = countAdjacentMines(row, col);
        grid.setGridElement((char) (numAdjacentMines + '0'), row, col);
        if (numAdjacentMines == 0) {
            clearAdjacentCells(row, col);
        }
    }

    public void clearAdjacentCells(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < grid.getGridSize() && newCol >= 0 && newCol < grid.getGridSize() && grid.getGridElement(newRow,newCol) == '-') {
                    int numAdjacentMines = countAdjacentMines(newRow, newCol);
                    grid.setGridElement((char) (numAdjacentMines + '0'), newRow, newCol);
                    if (numAdjacentMines == 0) {
                        clearAdjacentCells(newRow, newCol);
                    }
                }
            }
        }
    }
    public int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < grid.getGridSize() && newCol >= 0 && newCol < grid.getGridSize()) {
                    if (mine.getMineFieldElement(newRow, newCol) == '*') {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
