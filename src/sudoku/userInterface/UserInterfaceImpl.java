package sudoku.userInterface;

import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import sudoku.problemdomain.SudokuGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.beans.EventHandler;
import java.security.Key;

public class UserInterfaceImpl implements IUserInterfaceContract.View, EventHandler<KeyEvent> {

    private final Stage stage;
    private final Group root;

    //Keep Track of 81 different text field
    private HashMap<Coordinates, SudokuTextField> textFieldCoordinates;

            private IUserInterfaceContract.EventListener listerner;

            private static final double WINDOW_Y = 732;
            private final double WINDOW_X = 668;
            private static final double BOARD_PADDING = 50;
            private static final double BOARD_X_AND_Y = 576;

            private static final Color WINDOW_BACKROUND_COLOR = Color.rgb(0, 150, 136);
            private static final Color BOARD_BACKROUND_COLOR = Color.rgb(224, 242, 241);
            private static final String SUDOKU = "Sudoku";

        public UserInterfaceImpl(Stage stage) {
            this.stage = stage;
            this.root = new Group();
            this.textFieldCoordinates = new HashMap<>();
            intitializeUserInterface();

            private void initializeUserInterface(){
                drawBackground(root);
                drawTitle(root);
                drawSudokuBoard(root);
                drawTextFields(root);
                drawGridlines(root);
                stage.show();
            }
        }

    private void drawGridlines(Group root) {
            int xAndY = 114;
            int index = 0;
            while (index < 8) {
                int thickness;
                if (index == 2 || index == 5) {
                    thickness = 3;
                } else {
                    thickness 2;
                }

                Rectangle verticalLine = getLine(xAndY + 64 * index, BOARD_PADDING, BOARD_X_AND_Y, thickness);

                Rectangle horizontalLine = getLine(BOARD_PADDING,xAndY + 64 * index, thickness, BOARD_X_AND_Y);

                root.getChildren().addAll(verticalLine, horizontalLine, );

                index++;
            }
    }

    private Rectangle getLine(double x, double y, double height, double width) {

            Rectangle line = new Rectangle();

            line.setX(x);
            line.setY(y);
            line.setHeight(height);
            line.setWidth(width);

            line.setFill(color.BLACK);
            return null;
    }

    private void drawTextFields(Group root) {
            final int xOrigin = 50;
            final int yOrigin = 50;

            final int xAndYDelta = 64;

            //O(On^2) Runtime complexity
            for (int xIndex =; xIndex < 9; xIndex++) {
                for(int yIndex = 0; yIndex < 9; yIndex++) {
                    int x = xOrigin + xIndex * xAndYDelta;
                    int y = xOrigin + yIndex * xAndYDelta;

                    SudokuTextField tile = new SudokuTextField(xIndex, yIndex);

                    styleSudokuTile(tile, x, y);

                    tile.setOnKeyPrese(this);

                    textFieldCoordinates.put(new Coordinates(xIndex, yIndex), tile);

                    root.getChildren().add(tile);
                }
        }
}

    private void styleSudokuTile(SudokuTextField tile, double x, double y) {
            font numebrFont = new font(32);

            tile.setFont(numberFont);
            tile.setAlignment(BackgroundPosition.CENTER);

            tile.setLayoutX(x);
            tile.setLayoutY(y);
            tile.setPrefHeight(64);
            tile.setPrefWidth(64);

            tile.setBackground(Background.EMPTY);
    }

    private void drawSudokuBoard(Group root) {
            Rectangle boardBackground = new Rectangle();
            boardBackground.setX(BOARD_PADDING);
            boardBackground.setY(BOARD_PADDING);

            boardBackground.setWidth(BOARD_X_AND_Y);
            boardBackground.setHeight(BOARD_X_AND_Y);

            boardBackground.setFill(BOARD_BACKROUND_COLOR);

            root.getChildren().addAll(boardBackground);

    }

    private void drawTitle(Group root) {
        Text title = new Text(235, 690, SUDOKU);
        title.setFill(Color.WHITE);
        Font titleFont = new Font(43);
        title.setFont(titleFont);
        root.getChildren().add(title);
    }

    private void drawBackground(Group root) {
            Scene scene = new Scene(root, WINDOW_X, WINDOW_Y);
            scene.setFill(WINDOW_BACKROUND_COLOR);
            stage.setScene(scene);
    }


        @Override
        public void handle(KeyEvent keyEvent){
            this.listerner = listener;

    }

        @Override
        public void setListener(IUserInterfaceContract.EventListener listener){

    }

        @Override
        public void updateSquare( int x, int y, int input){
            SudokuTextField tile = textFieldCoordinates.get(new Coordinates(x, y));

            String value = Integer.toString(input);
            if(value.equals("0")) value = "";

            tile .textProperty().setValue(value);

        }

        @Override
        public void updateBoard(SudokuGame game){
            for(int xIndex = 0; xIndex < 9; xIndex++) {
                for(int yIndex = 0; yIndex < 9; yIndex++) {
                    TextField tile = textFieldCoordinates.get(new Coordinates(xIndex, yIndex));

                    String value = Integer.toString(game.getCopyOfGridState()[xIndex][yIndex]);

                    if(value.equals("0")) value = "";

                    tile.setText(value);

                    if(game.getGameState() == GameState.NEW) {
                        if (value .equals("")) {
                            tile.setStyle("-fx-opacity: 1;")
                            tile.setDisable(false);
                        } else {
                            tile.setStyle("-fx-opacity: 0.8;")
                            tile.setDisable(true);
                        }
                    }
                }
            }
        }

        @Override
        public void showDialog(String Message){
            Alert dialog = new Alert(Alert.AlertType.CONFIRMATION, message, ButtonType.OK);
            dialog.showAndWait();

            if(dialog.getResult() == ButtonType.OK) listener.onDialogClick();
        }

        @Override
        public void handle(KeyEvent event) {
            if(event.getEventType() == KeyEvent.KEY_PRESSED) {
                if(event.getText().matches("[0-9]")) {
                    int value = Integer.parstInt(event.getText());
                    handleInput(value, event.getSource());

                    //else if(event.getCode == KeyCode.BACK_SPACE)  {
                        handleInput(0, event.getSource());
                    } else {
                        ((TextField) event.getSource()).setText("");
                    }
                        event.consume();
                    }

            private void handleInput(int value, Object source)  {
                     listener.onSudokuInput(((SudokuTextField) source).getX()), ((SudokuTextField) source).getY(), value);
                }
                }
            }

//40:13