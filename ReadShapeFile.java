
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadShapeFile {

    // TODO: You will likely need to write four methods here. One method to
    // construct each shape
    // given the Scanner passed as a parameter. I would suggest static
    // methods in this case.

    /**
     * Reads the data file used by the program and returns the constructed queue
     *
     * @param in
     *            the scanner of the file
     * @return the queue represented by the data file
     */

    private static Triangle readTriangle(Scanner in){
        int x = in.nextInt();
        int y = in.nextInt();
        int vx = in.nextInt();
        int vy = in.nextInt();
        boolean isFilled = in.nextBoolean();
        int side = in.nextInt();
        int R = in.nextInt();
        int G = in.nextInt();
        int B = in.nextInt();
        int insertionTime = in.nextInt();
        Color color = Color.rgb(R,G,B);
        boolean pulsing = in.nextBoolean();

        Triangle triangle = new Triangle("triangle", insertionTime, x, y, vx, vy, side, color, isFilled, pulsing);

        return triangle;
    }

    /**
     *
     * @param in
     * @return
     */
    private static Rect readRect(Scanner in){
        int x=in.nextInt();
        int y=in.nextInt();
        int vx=in.nextInt();
        int vy=in.nextInt();
        boolean isFilled=in.nextBoolean();
        int width=in.nextInt();
        int height=in.nextInt();
        int R=in.nextInt();
        int G=in.nextInt();
        int B=in.nextInt();
        int insertionTime=in.nextInt();
        Color colour=Color.rgb(R,G,B);
        boolean pulsing = in.nextBoolean();

        Rect rect=new Rect("rect", insertionTime, x,y,vx, vy, width, height,colour,isFilled, pulsing);

        return rect;
    }

    private static Square readSquare(Scanner in){
        int x=in.nextInt();
        int y=in.nextInt();
        int vx=in.nextInt();
        int vy=in.nextInt();
        boolean isFilled=in.nextBoolean();
        int side=in.nextInt();
        int R=in.nextInt();
        int G=in.nextInt();
        int B=in.nextInt();
        int insertionTime=in.nextInt();
        Color colour= Color.rgb(R,G,B);
        boolean pulsing = in.nextBoolean();

        Square square=new Square("square", insertionTime, x, y, vx, vy, side, colour, isFilled, pulsing);

        return square;
    }

    private static Circle readCircle(Scanner in) {
        int x=in.nextInt();
        int y=in.nextInt();
        int vx=in.nextInt();
        int vy=in.nextInt();
        boolean isFilled=in.nextBoolean();
        int diameter=in.nextInt();
        int R=in.nextInt();
        int G=in.nextInt();
        int B=in.nextInt();
        int insertionTime=in.nextInt();
        Color colour= Color.rgb(R,G,B);
        boolean pulsing = in.nextBoolean();

        Circle circle=new Circle("circle",insertionTime, x, y, vx, vy, diameter, colour, isFilled, pulsing);

        return circle;
    }

    private static Oval readOval(Scanner in) {
        int x=in.nextInt();
        int y=in.nextInt();
        int vx=in.nextInt();
        int vy=in.nextInt();
        boolean isFilled=in.nextBoolean();
        int width=in.nextInt();
        int height=in.nextInt();
        int R=in.nextInt();
        int G=in.nextInt();
        int B=in.nextInt();
        int insertionTime=in.nextInt();
        Color colour=Color.rgb(R,G,B);
        boolean pulsing = in.nextBoolean();

        Oval oval=new Oval("oval", insertionTime, x,y,vx, vy, width, height,colour,isFilled, pulsing);

        return oval;
    }


    private static Queue<ClosedShape> readDataFile(Scanner in) {
        Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

        //read in the shape files and place them on the Queue

        while(in.hasNext()) {
            String objectType=in.next();
            if(objectType.equals("circle")){
                Circle circle=readCircle(in);
                shapeQueue.enqueue(circle);
            }
            else if(objectType.equals("oval")){
                Oval oval=readOval(in);
                shapeQueue.enqueue(oval);
            }
            else if(objectType.equals("rect")) {
                Rect rect = readRect(in);
                shapeQueue.enqueue(rect);
            }
            else if(objectType.equals("square")) {
                Square square = readSquare(in);
                shapeQueue.enqueue(square);
            }
            else if(objectType.equals("triangle")){
                Triangle triangle = readTriangle(in);
                shapeQueue.enqueue(triangle);
            }
        }


        //Right now, returning an empty Queue.  You need to change this.
        return shapeQueue;
    }

    /**
     * Method to read the file and return a queue of shapes from this file. The
     * program should handle the file not found exception here and shut down the
     * program gracefully.
     *
     * @param filename
     *            the name of the file
     * @return the queue of shapes from the file
     */
    public static Queue<ClosedShape> readDataFile(String filename) {
        // HINT: You might want to open a file here.

        File inputFile=new File(filename);
        Scanner in = null; //null is not sensible. Please change

        try{
            in=new Scanner(inputFile);
        }
        catch (FileNotFoundException e){
            System.out.println("Cannot open "+filename);
            System.exit(0);
        }

        return ReadShapeFile.readDataFile(in);

    }
}

