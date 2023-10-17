package edu.curtin.saed.assignment1.model;

public class Wall
{
    double x;
    double y;
    boolean hit;


    public Wall(double x, double y) {
        this.x = x;
        this.y = y;
        hit = false;
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

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
