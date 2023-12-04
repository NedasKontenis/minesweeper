public class Grid {
    int gridSize;
    char[][] grid;

    public Grid(int gridSize, char[][] grid) {
        this.gridSize = gridSize;
        this.grid = grid;
    }

    public int getGridSize() {
        return gridSize;
    }
    public char[][] getGrid() {
        return grid;
    }

    public void setGridElement(char value, int row, int col) {
        this.grid[row][col] = value;
    }

    public char getGridElement(int row, int col) {
        return grid[row][col];
    }

    public void initializeGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public void printGrid() {
        System.out.println("   1 2 3 4 5 6 7 8 9 10");
        System.out.println("  ---------------------");
        for (int i = 0; i < gridSize; i++) {
            System.out.print((i + 1) + "| ");
            for (int j = 0; j < gridSize; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("  ---------------------");
    }
}
