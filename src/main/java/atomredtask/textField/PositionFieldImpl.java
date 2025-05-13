package atomredtask.textField;


import javafx.scene.control.TextField;

public class PositionFieldImpl implements PositionField {
    private final TextField positionField;

    public PositionFieldImpl(TextField positionField) {
        this.positionField = positionField;
    }

    @Override
    public double getPosition(double position)
    {
        try
        {
            return Integer.parseInt(positionField.getText());
        }
        catch(Exception e)
        {
            return -1;
        }
    }
}
