package agh.ics.oop.model;

import java.util.Objects;

public class Vector2d {

    private final int x;
    private final int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int get_x(int x){
        return x;
    }
    public int get_y(int y){
        return y;
    }
    public String toString(){
        return "(" + x + "," + y + ")";
    }
    public boolean precedes(Vector2d other){
        return x <= other.x && y <= other.y;
    }
    public boolean follows(Vector2d other){
        return x >= other.x && y >= other.y;
    }
    public Vector2d add(Vector2d other){
        return new Vector2d(x + other.x, y + other.y);
    }
    public Vector2d subtract(Vector2d other){
        return new Vector2d(x - other.x, y - other.y);
    }
    public Vector2d upperRight(Vector2d other){
        int newx,newy;
        if(x >= other.x){
            newx = x;
        }
        else {
            newx=other.x;
        }
        if (y >= other.y){
            newy=y;
        }
        else {
            newy=other.y;
        }
        return new Vector2d(newx, newy);
    }

    public Vector2d lowerLeft(Vector2d other){
        int newX,newY;
        if(x <= other.x){
            newX = x;
        }
        else {
            newX=other.x;
        }
        if (y <= other.y){
            newY = y;
        }
        else {
            newY=other.y;
        }
        return new Vector2d(newX, newY);
    }

    public Vector2d opposite(){
        return new Vector2d(-x, -y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;

        return x == that.x && y == that.y;
    }
}

