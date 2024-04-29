package sudoku.computationlogic;

import sudoku.problemdomain.SudokuGame;

public class SudokuUtilities {
    public static void copySudokuArrayValues(int[][] old Array, int[][] newArray) {
        for (int xIndex = 0; xIndex < SudokuGame.GRID_BOUNDARY; xIndex++) {
            for (int yIndex = 0; yIndex < SudokuGame.GRID_BOUNDARY; yIndex++) {
                newAray[xIndex][yIndex] = oldArray[xIndex][yIndex];
            }
        }
    }

    public static int[][] copyToNewArray(int[][] oldArray) {
        int[][] = new int[SudokuGame.GRID_BOUNDARY][SudokuGame.GRID_BOUNDARY];

        for (int xIndex = 0; xIndex < SudokuGame.GRID_BOUNDARY; xIndex++) {
            for (int yIndex = 0; yIndex < SudokuGame.GRID_BOUNDARY; yIndex++) {
                newAray[xIndex][yIndex] = oldArray[xIndex][yIndex];
            }
        }
    }
}
