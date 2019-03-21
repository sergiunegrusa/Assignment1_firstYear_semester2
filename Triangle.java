import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
//TwoRedCircles
public class Triangle extends ClosedShape{
    private double[] xPoints = new double[3];
    private double[] yPoints = new double[3];
    private int side;
    private int aux;

    public Triangle(String shape, int insertionTime, int x, int y, int vx, int vy, int side, Color color, boolean isFilled, boolean pulsing){
        super(shape,insertionTime, x, y, vx, vy, color, isFilled, pulsing);
        setSide(side);
        setAux();
        setCoordinates(x,y, side);
    }

    public void setCoordinates(double x1, double y1, int side){
        this.side = side;
        this.xPoints[0] = x1;
        this.yPoints[0] = y1;

        this.xPoints[1] = this.xPoints[0] + side;
        this.yPoints[1] = this.yPoints[0];

        this.xPoints[2] = (this.xPoints[0] + this.xPoints[1]) / 2;
        this.yPoints[2] = this.xPoints[2] - this.xPoints[0] + this.yPoints[0];
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setAux() {
        this.aux = side;
    }

    public int getAux() {
        return aux;
    }

    @Override
    public int getWidth() {
        return side;
    }

    @Override
    public int getHeight() {
        return side;
    }

    public String getShape() {
        return this.shape;
    }

    @Override
    public boolean outOfBoundsX(double winX){
        return (this.xPoints[1] > winX) || (this.xPoints[0] < 0);
    }

    @Override
    public boolean outOfBoundsY(double winY){
        return (this.yPoints[2] > winY) || (this.yPoints[0] < 0);
    }

    @Override
    public void putInBoundsX (double winX) {
        if (this.xPoints[0] < 0){
            this.xPoints[0] = 0;
            setCoordinates(this.xPoints[0], this.yPoints[0],side);
        }
        if (this.xPoints[1] > this.xPoints[0] + getWidth()) {
            this.xPoints[1] = (int) (winX - Math.ceil (this.getWidth ()));
            setCoordinates(this.xPoints[0], this.yPoints[0], side);
        }
    }


    @Override
    public void putInBoundsY (double winY) {
        if (this.yPoints[2] > winY){
            this.yPoints[2] = winY;
        }
        if (this.yPoints[0] < 0) {
            this.yPoints[0] = 0;
            setCoordinates(this.xPoints[0], this.yPoints[0],side);
        }
    }


    @Override
    public void move() {
        for(int i = 0; i < 3; i++){
            this.xPoints[i] += xVec;
            this.yPoints[i] += yVec;



        }
    }

    @Override
    public void draw(GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillPolygon(xPoints, yPoints, 3);
        }
        else {
            g.strokePolygon(xPoints, yPoints, 3);
        }
    }
}
