package atomredtask.text;

import javafx.scene.control.Label;

public class LabelImpl implements CustomLabel {

    private final Label label;

    public LabelImpl(Label label) {
        this.label = label;
    }

    @Override
    public void setText(String text) {
        label.setText(text);
    }

    public Label getLabel() {
        return label;
    }

}
