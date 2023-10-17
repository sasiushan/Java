package edu.curtin.saed.assignment1;

import edu.curtin.saed.assignment1.model.Citadel;
import edu.curtin.saed.assignment1.model.Robot;
import edu.curtin.saed.assignment1.model.Wall;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.canvas.*;
import javafx.geometry.VPos;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.io.*;
import java.util.*;

/**
 * A JavaFX GUI element that displays a grid on which you can draw images, text and lines.
 */

public class JFXArena extends Pane
{
    private List<ArenaListener> listeners = null;
    private ArenaListener scoreListener, queueCommandsListener;
    private Timeline scoreTimeLine;
    private WallLogic wallLogic;

    public List<Robot> robots = new ArrayList<>();
    public List<Citadel> citadels = new ArrayList<>();
    public List<Wall> walls = new ArrayList<>();
    public List<Wall> hitWalls = new ArrayList<>();

    private int score = 0;


    // Represents an image to draw, retrieved as a project resource.
    private static final String IMAGE_ROBOT = "1554047213.png";
    private static final String IMAGE_CIDATEL = "rg1024-isometric-tower.png";
    private static final String IMAGE_WALL = "181478.png";
    private static final String IMAGE_BROKENWALL = "181479.png";
    private Image robot1, citadel, wall, brokenWall;

    
    // The following values are arbitrary, and you may need to modify them according to the 
    // requirements of your application.
    private int gridWidth = 0;
    private int gridHeight = 0;

    private double robotX = 0;
    private double robotY = 0;

    private double gridSquareSize; // Auto-calculated
    private Canvas canvas; // Used to provide a 'drawing surface'.

    private Timeline robotTimeLine;
    private boolean endGame = false;

    private TextArea textArea;




    /**
     * Creates a new arena object, loading the robot image and initialising a drawing surface.
     */

    public JFXArena(int gridWidth, int gridHeight, TextArea textArea)
    {

        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.textArea = textArea;

        robot1 = checkImage(IMAGE_ROBOT);
        citadel = checkImage(IMAGE_CIDATEL);
        wall = checkImage(IMAGE_WALL);
        brokenWall = checkImage(IMAGE_BROKENWALL);

        //update score by 10 points every second
        scoreTimeLine = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    incrementScore(10);
                    updateQueueCommand();
                })
        );

        scoreTimeLine.setCycleCount(Timeline.INDEFINITE);//runs forever
        scoreTimeLine.play();

        robotTimeLine = new Timeline(
                new KeyFrame(Duration.millis(40), event -> {

                    for (Robot robot : robots)
                    {
                        if (robot.isMoving())
                        {
                            continue;
                        }

                        double newX = robot.getX();
                        double newY = robot.getY();

                        // Check if the new position is acceptable
                        if (acceptableMove(newX, newY)) {
                            robot.shiftTo(robot, newX, newY);
                        }
                    }
                })
        );
        robotTimeLine.setCycleCount(Timeline.INDEFINITE); // Run indefinitely
        robotTimeLine.play();

        wallLogic = new WallLogic(this);
        wallLogic.run();

        canvas = new Canvas();
        canvas.widthProperty().bind(widthProperty());
        canvas.heightProperty().bind(heightProperty());
        getChildren().add(canvas);

    }



    // Here's how (in JavaFX) you get an Image object from an image file that's part of the
    // project's "resources". If you need multiple different images, you can modify this code
    // accordingly.

    // (NOTE: _DO NOT_ use ordinary file-reading operations here, and in particular do not try
    // to specify the file's path/location. That will ruin things if you try to create a
    // distributable version of your code with './gradlew build'. The approach below is how a
    // project is supposed to read its own internal resources, and should work both for
    // './gradlew run' and './gradlew build'.)

    private Image checkImage(String imageFiles)
    {
        Image image = null;
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(imageFiles))
        {
            if (is == null)
            {
                throw new AssertionError("Cannot find image file " + imageFiles);
            }
            image = new Image(is);
        } catch (IOException e)
        {
            throw new AssertionError("Cannot load image file " + imageFiles, e);
        }

        return image;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public List<Citadel> getCitadels()
    {
        return citadels;
    }

    public List<Wall> getWalls()
    {
        return walls;
    }

    public List<Wall> getBrokenWalls()
    {
        return hitWalls;
    }


    public boolean acceptableMove(double x, double y)
    {

        boolean boundCheck, notVacant = true;

        //grid boundaries
        boundCheck = x < gridWidth && x >= 0  && y < gridHeight && y >= 0;

        // We will see if another robot is found in the next location the robots move to.
        for(Robot robot : getRobots())
        {
            if(robot.getX() == x && robot.getY() == y)
            {
                notVacant = false;
                break;
            }
        }
        return boundCheck && notVacant;
    }


    public void setScoreListener(ArenaListener arenaListener)
    {
        scoreListener = arenaListener;
    }

    public void incrementScore(int points)
    {
        score =  score + points;
        if(scoreListener!=null && endGame==false)
        {
            scoreListener.updatedScore(score);
        }
    }

    public void queueCommandListener(ArenaListener arenaListener)
    {
        queueCommandsListener = arenaListener;
    }

    private void updateQueueCommand()
    {
        if(queueCommandsListener!=null)
        {
            queueCommandsListener.printCommand(getQueuedCommands());
        }
    }

    private int getQueuedCommands()
    {
        int count = wallLogic.wallQueue.size();
        return count;
    }



    //when a WALL is hit, it is removed and the score is increased by 100
    public void wallHit()
    {
        for(Wall hitWall : getWalls())
        {
            if(hitWall.isHit() == true)
            {
                Wall tempWall = new Wall(hitWall.getX(), hitWall.getY());
                hitWalls.add(tempWall);
                walls.remove(hitWall);
                //-1 currentNoOfWalls when a wall is destroyed
                wallLogic.reduceCurrNoOfWalls();
                score = score + 100;
                newEventInstance("Wall Hit!");
            }
        }
    }
    //when a BROKEN WALL is hit, it is removed and the score is increased by 100
    public void brokenWallHit()
    {
        for(Wall hitWall : getBrokenWalls())
        {
            if(hitWall.isHit() == true)
            {
                hitWalls.remove(hitWall);
                score = score + 100;
                newEventInstance("Wall Broken!");
            }
        }
    }

    public boolean endTheGame(boolean endGame)
    {
        wallLogic.stopBuildingWalls();
        newEventInstance("END GAME");
        return this.endGame = endGame;

    }




    /**
     * Moves a robot image to a new grid position. This is highly rudimentary, as you will need
     * many different robots in practice. This method currently just serves as a demonstration.
     */
    public void setRobotPosition(int id, double x, double y)
    {

        robotX = x;
        robotY = y;
        requestLayout();

    }

    
    /**
     * Adds a callback for when the user clicks on a grid square within the arena. The callback 
     * (of type ArenaListener) receives the grid (x,y) coordinates as parameters to the 
     * 'squareClicked()' method.
     */
    public void addListener(ArenaListener newListener)
    {
        if(listeners == null)
        {
            listeners = new LinkedList<>();
            setOnMouseClicked(event ->
            {
                int gridX = (int)(event.getX() / gridSquareSize);
                int gridY = (int)(event.getY() / gridSquareSize);
                
                if(gridX < gridWidth && gridY < gridHeight)
                {
                    for(ArenaListener listener : listeners)
                    {   
                        listener.squareClicked(gridX, gridY);

//                        Wall newWall = new Wall(gridX, gridY);
//                        addWall(newWall);
                        wallLogic.buildAWall(gridX, gridY);
//                        System.out.println("Square clicked: " + gridX +" " + gridY);
                    }
                }
            });
        }
        listeners.add(newListener);
    }
        

    public void addRobot(Robot robot)
    {
        if(robot.getX() != -1 && robot.getY() != -1)
        {
            if(robots.size()<4)
            {
                robots.add(robot);
                newEventInstance("Robot : " + robot.getId() + " has been created");
            }

        }
        requestLayout();

//        System.out.println(robots.size());
    }

    public void removeRobot(Robot robot)
    {
        robots.remove(robot);
        requestLayout();
    }

    public boolean isRobotPresent(double posx, double posy)
    {
        boolean isPresent = false;
        for(Robot robot : robots)
        {
            if(posx == robot.getX() && posy == robot.getY())
            {
                isPresent = true;
            }
        }
        return isPresent;
    }

//    public void addWall(Wall wall)
//    {
//        walls.add(wall);
//    }

    public void addWalls(double x, double y)
    {
        Wall newWall = new Wall(x, y);
        walls.add(newWall);
    }

    /**
     * This method is called in order to redraw the screen, either because the user is manipulating 
     * the window, OR because you've called 'requestLayout()'.
     *
     * You will need to modify the last part of this method; specifically the sequence of calls to
     * the other 'draw...()' methods. You shouldn't need to modify anything else about it.
     */
    @Override
    public void layoutChildren()
    {
        super.layoutChildren(); 
        GraphicsContext gfx = canvas.getGraphicsContext2D();
        gfx.clearRect(0.0, 0.0, canvas.getWidth(), canvas.getHeight());
        
        // First, calculate how big each grid cell should be, in pixels. (We do need to do this
        // every time we repaint the arena, because the size can change.)
        gridSquareSize = Math.min(
            getWidth() / (double) gridWidth,
            getHeight() / (double) gridHeight);

        double arenaPixelWidth = gridWidth * gridSquareSize;
        double arenaPixelHeight = gridHeight * gridSquareSize;

        // Draw the arena grid lines. This may help for debugging purposes, and just generally
        // to see what's going on.
        gfx.setStroke(Color.DARKGREY);
        gfx.strokeRect(0.0, 0.0, arenaPixelWidth - 1.0, arenaPixelHeight - 1.0); // Outer edge

        for(int gridX = 1; gridX < gridWidth; gridX++) // Internal vertical grid lines
        {
            double x = (double) gridX * gridSquareSize;
            gfx.strokeLine(x, 0.0, x, arenaPixelHeight);
        }
        
        for(int gridY = 1; gridY < gridHeight; gridY++) // Internal horizontal grid lines
        {
            double y = (double) gridY * gridSquareSize;
            gfx.strokeLine(0.0, y, arenaPixelWidth, y);
        }

        //draw the citadel
        double x = getCordinate(gridWidth-1);
        double y = getCordinate(gridHeight-1);
        drawImage(gfx, citadel,x, y);

        Citadel citadel1 = new Citadel(x, y);
        citadels.add(citadel1);

        //draw the robots
        for(Robot robot : robots)
        {
            drawImage(gfx, robot1, robot.getX(), robot.getY());
            drawLabel(gfx, "Robot " + robot.getId(), robot.getX(), robot.getY());
        }

        //draw the walls on click
        for(Wall newWall : walls)
        {
            drawImage(gfx, wall, newWall.getX(), newWall.getY());
        }

        //draw the hitWalls
        for(Wall damagedWall : hitWalls)
        {
            drawImage(gfx, brokenWall, damagedWall.getX(), damagedWall.getY());
        }


        // Invoke helper methods to draw things at the current location.
        // ** You will need to adapt this to the requirements of your application. **
//        drawImage(gfx, robot1, robotX, robotY);
//        drawLabel(gfx, "Robot Name", robotX, robotY);
    }


    //a small method to calc the middle of the graph. Used to calculate the position of the citadel.
    //i have built this function incase the grap is scaled and the middle changes, this method is built to handle scalability
    private int getCordinate(double cordinate)
    {
        double cor = cordinate + 1.0;
        double result = cor/2.0;
        int lowerBound = (int) Math.floor(result);
        return lowerBound;
    }

    /*
     *
       Draw an image in a specific grid location. *Only* call this from within layoutChildren().
     *
     *  Note that the grid location can be fractional, so that (for instance), you can draw an image
     *  at location (3.5,4), and it will appear on the boundary between grid cells (3,4) and (4,4).
     *     
     *  You shouldn't need to modify this method.
     *
     */

    private void drawImage(GraphicsContext gfx, Image image, double gridX, double gridY)
    {
        // Get the pixel coordinates representing the centre of where the image is to be drawn. 
        double x = (gridX + 0.5) * gridSquareSize;
        double y = (gridY + 0.5) * gridSquareSize;
        
        // We also need to know how "big" to make the image. The image file has a natural width 
        // and height, but that's not necessarily the size we want to draw it on the screen. We 
        // do, however, want to preserve its aspect ratio.
        double fullSizePixelWidth = robot1.getWidth();
        double fullSizePixelHeight = robot1.getHeight();
        
        double displayedPixelWidth, displayedPixelHeight;
        if(fullSizePixelWidth > fullSizePixelHeight)
        {
            // Here, the image is wider than it is high, so we'll display it such that it's as 
            // wide as a full grid cell, and the height will be set to preserve the aspect 
            // ratio.
            displayedPixelWidth = gridSquareSize;
            displayedPixelHeight = gridSquareSize * fullSizePixelHeight / fullSizePixelWidth;
        }
        else
        {
            // Otherwise, it's the other way around -- full height, and width is set to 
            // preserve the aspect ratio.
            displayedPixelHeight = gridSquareSize;
            displayedPixelWidth = gridSquareSize * fullSizePixelWidth / fullSizePixelHeight;
        }

        // Actually put the image on the screen.
        gfx.drawImage(image,
            x - displayedPixelWidth / 2.0,  // Top-left pixel coordinates.
            y - displayedPixelHeight / 2.0, 
            displayedPixelWidth,              // Size of displayed image.
            displayedPixelHeight);
    }

    /**
     * Displays a string of text underneath a specific grid location. *Only* call this from within 
     * layoutChildren(). 
     *     
     * You shouldn't need to modify this method.
     */
    private void drawLabel(GraphicsContext gfx, String label, double gridX, double gridY)
    {
        gfx.setTextAlign(TextAlignment.CENTER);
        gfx.setTextBaseline(VPos.TOP);
        gfx.setStroke(Color.BLUE);
        gfx.strokeText(label, (gridX + 0.5) * gridSquareSize, (gridY + 1.0) * gridSquareSize);
    }
    
    /** 
     * Draws a (slightly clipped) line between two grid coordinates.
     *     
     * You shouldn't need to modify this method.
     */
    private void drawLine(GraphicsContext gfx, double gridX1, double gridY1, 
                                               double gridX2, double gridY2)
    {
        gfx.setStroke(Color.RED);
        
        // Recalculate the starting coordinate to be one unit closer to the destination, so that it
        // doesn't overlap with any image appearing in the starting grid cell.
        final double radius = 0.5;
        double angle = Math.atan2(gridY2 - gridY1, gridX2 - gridX1);
        double clippedGridX1 = gridX1 + Math.cos(angle) * radius;
        double clippedGridY1 = gridY1 + Math.sin(angle) * radius;
        
        gfx.strokeLine((clippedGridX1 + 0.5) * gridSquareSize, 
                       (clippedGridY1 + 0.5) * gridSquareSize, 
                       (gridX2 + 0.5) * gridSquareSize, 
                       (gridY2 + 0.5) * gridSquareSize);
    }

    public void newEventInstance(String message) {
        Platform.runLater(() -> {
            textArea.appendText(message + "\n"); // Append the message to the text area
        });
    }

}
