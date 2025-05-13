package atomredtask.button;

import atomredtask.textField.PositionField;
import atomredtask.textField.PositionFieldImpl;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.TextAlignment;

public class PositionButtonImpl implements PositionButton {

    private final PositionField positionXField;
    private final PositionField positionYField;
    private final Label label;

    public PositionButtonImpl(TextField positionXField, TextField positionYField, Label label) {
        this.positionXField = new PositionFieldImpl(positionXField);
        this.positionYField = new PositionFieldImpl(positionYField);
        this.label = label;
    }

    @Override
    public double[] getPosition(double positionX, double positionY) {
        double[] position = new double[2];
        position[0] = positionXField.getPosition(positionX);
        position[1] = positionYField.getPosition(positionY);
        if(position[0] == -1 || position[1] == -1) {
            label.setText("Неправильные координаты!" +
                    "\nВведите только числа");
            label.setTextAlignment(TextAlignment.CENTER);
            return null;
        }
        else
        {
            return position;
        }
    }
}
