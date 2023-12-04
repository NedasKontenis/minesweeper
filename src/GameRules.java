public class GameRules {
    private Mine mine;
    private Grid grid;

    public GameRules(Mine mine, Grid grid) {
        this.mine = mine;
        this.grid = grid;
    }


    public boolean isGameOver() {
        return true;
    }

    public boolean hasHitMine(int row, int col) {
        return mine.getMineFieldElement(row, col) == '*';
    }

    public boolean isGameWon() {
        int uncoveredCells = 0;
        for (int i = 0; i < grid.getGrid().length; i++) {
            for (int j = 0; j < grid.getGrid()[i].length; j++) {
                if (grid.getGridElement(i, j) != '-') {
                    uncoveredCells++;
                }
            }
        }
        return uncoveredCells + mine.getNumMines() == grid.getGridSize() * grid.getGridSize();
    }
}
