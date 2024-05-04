package sudoku.persistence;

import sudoku.problemdomain.IStorage
import sudoku.problemdomain.SudokuGame;

import java.io.FileOutputStream;
import java.io.IOException;

public class LocalStorageImpl implements IStorage {
    private static File GAME_DATA = new file (System.getProperty("user.home"), "gamedata.txt");

    @Override
    public void updateGameDate(SudokuGame game) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(GAME_DATA);
            ObjectOutputStream object = new ObjectOuputStream(fileOutputStream);
            objectOutputStream.writeObject(game);
            objectOutputStream.close();
        } catch (IOException) {
            throw new IOException("Unable to access Game Data");
        }
    }

    @Override
    public SudokuGame getGameData() throws IOException {
        FIleINputStream fileINputStream = new FileInputSteam(GAME_DATA);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileINputStream);
        try {
            SudokuGame gameState = (SudokuGame) objectInputStream.readObject();
            objectInputStream.close();
            return gameState;
        } catch (ClassNotFoundException e) {
            throw new IOException("File Not Found");
        }
    }
}
