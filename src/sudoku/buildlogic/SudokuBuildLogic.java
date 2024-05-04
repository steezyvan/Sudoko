package sudoku.buildlogic;

import sudoku.computationlogic.GameLogic;
import sudoku.problemdomain.IStorage;
import sudoku.userInterface.IUserInterfaceContract;

import java.io.IOException;

public class SudokuBuildLogic {
    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;

        IStorage storage= new LocalStorageImpl();

        try {
            initialState = storage.getGameData();
        } catch (IOException e ) {
            initialState = GameLogic.getNewGame();
            storage.updateGameData(intialState);
        }
        IUserInterfaceContract.EvenListener uiLogic = new ControlLogic(storage, userInterface);

        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
