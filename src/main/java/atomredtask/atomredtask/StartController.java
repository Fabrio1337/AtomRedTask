package atomredtask.atomredtask;

import atomredtask.button.PositionButton;
import atomredtask.button.PositionButtonImpl;
import atomredtask.figure.RectangleImpl;
import atomredtask.figure.Shape;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

public class StartController {

    @FXML
    private Rectangle rectangle;

    @FXML
    private Label position;

    @FXML
    private Label setPosition;

    @FXML
    private TextField positionX;

    @FXML
    private TextField positionY;

    @FXML
    private Button setPositionButton;

    private Shape shape;

    private PositionButton positionButton;

    @FXML
    private void initialize() {
        shape = new RectangleImpl(rectangle, position, setPosition);
        shape.mousePressed();
        shape.mouseDragged();

        positionButton = new PositionButtonImpl(positionX, positionY, setPosition);
    }

    @FXML
    private void setPositionAction() {
        double[] shapePositions = shape.getPositions();
        double[] positionArray = positionButton.getPosition(shapePositions[0], shapePositions[1]);
        shape.setPosition(positionArray);
    }

}