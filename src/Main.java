import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int gridSize = 10;
        int numMines = 15;

        Grid grid = new Grid(gridSize, new char[gridSize][gridSize]);
        Mine mine = new Mine(numMines, new char[gridSize][gridSize]);
        GameService gameService = new GameService(mine, grid);
        GameRules gameRules = new GameRules(mine, grid);

        grid.initializeGrid();
        mine.initializeMineField(grid.getGridSize());

        boolean gameOver = false;

        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            grid.printGrid();

            System.out.print("Enter row and column (e.g., 1 2): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (gameRules.hasHitMine(row, col)){
                System.out.println("Game is over! You hit a mine!");
                gameOver = gameRules.isGameOver();
            } else {
                gameService.processCells(row, col);
                if (gameRules.isGameWon()) {
                    System.out.println("Congratulations! You win!");
                    gameOver = true;
                }
            }
        }

        scanner.close();
    }
}