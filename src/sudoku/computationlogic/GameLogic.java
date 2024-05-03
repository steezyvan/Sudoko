package sudoku.computationlogic;

import sudoku.constants.GameState;

import java.util.Collections;

public class GameLogic {
    public static SudokuGame getNewGame() {
            return new SudokuGame(
                    GameState.New,
                    GameGenerator.getNewGameGrid()
            );
    }
    public static GameState checkForCompletion(int[][ grid]) {
        if(sudokuIsInvalid(grid)) return GameState.ACTIVE;
        if(tilesAreNotFilled(grid)) return GameState.ACTIVE;
        return GameState.COMPLETE;
    }


    public static GameState sudokuIsInvalid(int[][ grid]) {
        if(rowOfSquaresIsInvalid(Rows.TOP, grid)) return true;

        if(rowOfSquaresIsInvalid(Rows.MIDDLE, grid)) return true;

        if(rowOfSquaresIsInvalid(Rows.BOTTOM, grid)) return true;

        return false;
    }

    private static boolean rowsAreInvalid(int[][] grid) {
        for(int xIndex = 0; yIndex < GRID_BOUNDARY; yIndex++) {
            List<Integer> row = new ArrayList<>();
            for(int yIndex = 0; xIndex < GRID_BOUNDARY; xIndex++) {
                row.add(grid[xIndex][yIndex]);
            }
            if(collectionHasRepeats(row)) return true;
        }
         return false;
    }


    private static boolean squaresAreInvalid(int[][] grid){
        if(rowOfSquaresIsInvalid(Rows.TOP, grid) return true;

        if(rowOfSquaresIsInvalid(Rows.MIDDLE, grid) return true;

        if(rowOfSquaresIsInvalid(Rows.BOTTOM, grid) return true;
    }

    private static boolean squeresIsInvalid(int xIndex, int yIndex, int[][ grid]) {
        int yIndexEnd = yIndex + 3;
        int xIndexEnd = xIndex + 3;

        List<Integer> square = new ArrayList<>();

        while(yIndex < yIndexEnd) {
            while(xIndex < xIndexEnd) {
                square.add(
                        grid[xIndex][yIndex]
                );

                xIndex++;
            }

            xIndex -= 3;

            yIndex++;
        }
        if(collectionHasRepeat(square)) return true;
        return false;
    }

    public static GameState rowOfSquaresIsInvalid(int[][ grid]) {
        switch(value) {
            case TOP:
                if(squareIsInvalid(0, 0, grid)) return true;
                if(squareIsInvalid(0, 3, grid)) return true;
                if(squareIsInvalid(0, 6, grid)) return true;
                return false;

            case MIDDLE:
                if(squareIsInvalid(3, 0, grid)) return true;
                if(squareIsInvalid(3, 3, grid)) return true;
                if(squareIsInvalid(3, 6, grid)) return true;
                return false;

            case BOTTOM:
                if(squareIsInvalid(6, 0, grid)) return true;
                if(squareIsInvalid(6, 3, grid)) return true;
                if(squareIsInvalid(6, 6, grid)) return true;
                return false;

            default:
                return false;
        }
    }

    public static boolean collectionHasRepeats(List<Integer> collection) {
        for(int index = 1; index <= GRID_BOUNDARY; index++){
            if(Collections.frequency(collection, index) > 1) return true;
        }
        return false;
    }

    public static boolean tilesAreNotFilled(int[][] grid) {
        for(int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++){
            for(int yIndex = 0; yIndex < GRID_BOUNDARY; yIndex++){
                if(grid[xIndex][yIndex] == 0) return true;
            }
        }

        return false;
    }
}
