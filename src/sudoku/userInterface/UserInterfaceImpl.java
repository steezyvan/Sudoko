package sudoku.userInterface;

import javax.swing.*;
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


    }

    private void drawSudokuBoard(Group root) {
    }

    private void drawTitle(Group root) {
    }

    private void drawBackground(Group root) {
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

        }

}


//28:28