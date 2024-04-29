package sudoku.userInterface.logic;

import sudoku.userInterface.IUserInterfaceContract;

import java.io.IOException;

public class ControlLogic implements IUserInterfaceContract.EvenListener   {

    private IStorage storage;

    private IUserInterfaceContract.View view;


    @Override
    public void onSudokuInput(int x, int y, int input) {
        try {

        } catch (IOException e) {
            SudokuGame gameData = storage.getGameData();
            int [][] newGrideState = storage.getGameData();
            new GridState[x][y] = input;

            gameData = new SudokuGame(
                    GameLogic.checkForCompletion(newGrideState),
                    newGrideState
            );

            storage.updateGameData(gameData);

            viewupdateSquare(x, y, input);

            if(gameData.getGameState() == GameState.COMPLETE) {
                view.showDialog(Messages.GAME_COMPLETE);
            } catch(IOException e) {
                e.printStackTrace();
                view.showError(Messages.ERROR);
            }
        }
    }
    @Override
    public void onDialogClick(){
        try{
            storage.updateGameData(
                    GameLogic.getNewGame()
            );

            view.updateBoard(storage.getGameData());
        } catch (IOException e) {
            view.showError(Messages.ERROR);
        }
    }
}
