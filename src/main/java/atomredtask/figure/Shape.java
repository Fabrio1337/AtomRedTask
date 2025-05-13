package atomredtask.figure;

public interface Shape {
    public void mousePressed();
    public void mouseDragged();
    public void setPosition(double[] position);
    public double[] getPositions();
}
