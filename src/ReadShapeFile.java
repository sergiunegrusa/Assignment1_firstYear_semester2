
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

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
	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

		//read in the shape files and place them on the Queue

        while(in.hasNext()){
            String shape = in.next();
            int x = in.nextInt();
            int y = in.nextInt();
            int vx = in.nextInt();
            int vy = in.nextInt();
            boolean isFilled = Boolean.parseBoolean(in.next());
            int diameter = in.nextInt();
            int R = in.nextInt();
            int G = in.nextInt();
            int B = in.nextInt();
            int insertionTime = in.nextInt();

            Color color = Color.rgb(R,G,B);
            Circle circle = new Circle(insertionTime, x, y, vx, vy, diameter, color, isFilled);
            shapeQueue.enqueue(circle);
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
	    Scanner in = null; //null is not sensible. Please change
        try{
			in = new Scanner(new File(filename));
			//readDataFile(in);
		}

		catch (FileNotFoundException e){
			System.out.println ("Cannot open " + filename);
			System.exit (0);
		}
	    
	    return ReadShapeFile.readDataFile(in);
	    
	}
}
