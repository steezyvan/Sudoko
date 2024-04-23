package sudoku.problemdomain;

import sudoku.problemdomain.SudokuGame;

public interface IStorage {
    void updateGameDate(SudokuGame game) throws IOException;
    SudokuGame getGameDate() throws IOException;
}
