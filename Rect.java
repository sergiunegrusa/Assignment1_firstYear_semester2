

/**
 * Oval.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of
 * CSC-115 (Daniel Archambault and Liam O'Reilly)
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * Oval is an oval shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * oval's bounding rectangle
 */
public class Rect extends ClosedShape {
    //The width and height of the oval (major and minor axis)
    private int width, height;
    private int initWidth;
    private int initHeight;

    /**
     * Creates a rect.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rect (in pixels).
     * @param height The height of the rect (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the rect is filled with colour, false if opaque.
     */
    public Rect (String shape, int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled, boolean pulsing) {
        super (shape, insertionTime, x, y, vx, vy, colour, isFilled, pulsing);
        this.width = width;
        this.height = height;
        setInitHeight(height);
        setInitWidth(width);
    }

    /**
     * Method to convert a rect to a string.
     */
    public String toString () {
        String result = "This is a rect\n";
        result += super.toString ();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    public void setInitWidth(int initWidth) {
        this.initWidth = initWidth;
    }

    public void setInitHeight(int initHeight) {
        this.initHeight = initHeight;
    }

    public int getInitWidth() {
        return initWidth;
    }

    public int getInitHeight() {
        return initHeight;
    }

    public String getShape() {
        return this.shape;
    }

    /**
     * @param width Resets the width.
     */
    public void setWidth (int width) {
        this.width = width;
    }

    /**
     * @param height Resets the height.
     */
    public void setHeight (int height) {
        this.height = height;
    }

    /**
     * @return The width of the rect.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return The height of the rect.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Draw the rect.
     * @param g The graphics object of the drawable component.
     */
    public void draw (GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, width, height );
        }
        else {
            g.strokeRect( x, y, width, height );
        }
    }
}
