package atomredtask.figure;

import atomredtask.text.CustomLabel;
import atomredtask.text.LabelImpl;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class RectangleImpl implements Shape {

    private final Rectangle rectangle;
    private final double[] offsetX = new double[1];
    private final double[] offsetY = new double[1];
    private final double[] positions = new double[2];

    private final CustomLabel label;
    private final CustomLabel setPosition;


    public RectangleImpl(Rectangle rectangle, Label label, Label setPosition) {
        this.rectangle = rectangle;
        this.label = new LabelImpl(label);
        this.setPosition = new LabelImpl(setPosition);
    }

    @Override
    public void mousePressed()
    {
        setPosition.setText(null);
        rectangle.setOnMousePressed(e -> {
            offsetX[0] = e.getSceneX() - rectangle.getTranslateX();
            offsetY[0] = e.getSceneY() - rectangle.getTranslateY();
        });
    }

    @Override
    public void mouseDragged()
    {
        setPosition.setText(null);
        rectangle.setOnMouseDragged(e -> {
            double newX = e.getSceneX() - offsetX[0];
            double newY = e.getSceneY() - offsetY[0];


            //устанавливаем предел перетаскивания прямоугольника, чтобы он перемещался только внутри своего контейнера
            var parent = rectangle.getParent();
            if (parent != null) {
                double parentWidth = parent.getLayoutBounds().getWidth();
                double parentHeight = parent.getLayoutBounds().getHeight();

                newX = Math.max(0, Math.min(newX, parentWidth - rectangle.getWidth()));

                newY = Math.max(0, Math.min(newY, parentHeight - rectangle.getHeight()));
            }

            rectangle.setTranslateX(newX);
            rectangle.setTranslateY(newY);

            positions[0] = newX;
            positions[1] = newY;

            label.setText("Координаты X: " + positions[0] + ", Y: " + positions[1]);
        });

    }

    @Override
    public void setPosition(double[] position) {

        if(position != null){
            setPosition.setText(null);
            var parent = rectangle.getParent();
            if (parent != null) {
                double parentWidth = parent.getLayoutBounds().getWidth();
                double parentHeight = parent.getLayoutBounds().getHeight();

                positions[0] = Math.max(0, Math.min(position[0], parentWidth - rectangle.getWidth()));

                positions[1] = Math.max(0, Math.min(position[1], parentHeight - rectangle.getHeight()));
            }
            rectangle.setTranslateX(positions[0]);
            rectangle.setTranslateY(positions[1]);
            label.setText("Координаты X: " + positions[0] + ", Y: " + positions[1]);
        }
    }


    @Override
    public double[] getPositions() {
        return positions;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }


}
