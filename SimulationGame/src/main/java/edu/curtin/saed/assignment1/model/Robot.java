package edu.curtin.saed.assignment1.model;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Robot
{
    private int id;
    private static int robotCounter = 1;
    private double delay;
    private double x;
    private double y;
    private boolean isMoving;
    private long moveStartTime;
    private long moveDuration;
    private double newX;
    private double newY;

    private Timeline timeline;


    public Robot(double x, double y, int delay)
    {
        this.id = robotCounter++;
        this.delay = delay;
        this.x = x;
        this.y = y;
    }

    public void shiftTo(Robot robot, double newX, double newY)
    {
        if(isMoving)
        {
            return;
        }

        double moveDurationMS = 400.0; // 400 milliseconds
        double intervalMS = 40.0; // 40 milliseconds per frame

        int frames = (int) (moveDurationMS / intervalMS);
        double deltaX = (newX - x) / frames;
        double deltaY = (newY - y) / frames;

        timeline = new Timeline();
        timeline.setCycleCount(frames);

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(intervalMS), event -> {
                    x += deltaX;
                    y += deltaY;
                })
        );

        timeline.setOnFinished(event -> isMoving = false);

        isMoving = true;
        timeline.play();
    }


    public boolean stopMoving()
    {
        return isMoving = false;
    }

    public boolean isMoving()
    {
        return isMoving = true;

    }

    public void setIsMoving(boolean flag)
    {
        this.isMoving = flag;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getRobotCounter() {
        return robotCounter;
    }

    public static void setRobotCounter(int robotCounter) {
        Robot.robotCounter = robotCounter;
    }

    public double getDelay() {
        return delay;
    }

    public void setDelay(double delay) {
        this.delay = delay;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    public double getNewX() {
        return newX;
    }

    public void setNewX(double newX) {
        this.newX = newX;
    }

    public double getNewY() {
        return newY;
    }

    public void setNewY(double newY) {
        this.newY = newY;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public long getMoveStartTime() {
        return moveStartTime;
    }

    public void setMoveStartTime(long moveStartTime) {
        this.moveStartTime = moveStartTime;
    }





}
