package com.company;

import java.util.Random;
import java.awt.*;

public class Cell {

    //Colour Variable For Rectangle (Cell).
    private Color color;

    //Random Number Was SUed For Generating Colours.
    private Random rand;

    //Parameters For Rectangles (Cell).
    private int x;
    private int y;
    private int w;
    private int h;

    //String Used For Storing Tool Tip Of Each Rectangle (Cell).
    private String grassHeight;

    //These Variables Were Used In The Timing Of The Tool Tip Appearing And Disappearing.
    private int prevMouseX;
    private int prevMouseY;
    private int count;



    //Constructor
    public Cell(int _x, int _y, int _w, int _h) {

        setX(_x);
        setY(_y);
        setHeight(_h);
        setWidth(_w);
        setColor();
        setGrassHeight("Grass Height: " + color.getGreen()/50 + "m");
    }

    //Parameter Setters
    public void setX(int _x){

        x = _x;
    }
    public void setY(int _y){

        y = _y;
    }
    public void setHeight(int _h){

        h = _h;
    }
    public void setWidth(int _w){

        w = _w;
    }
    //Setting Color For Each Rectangle (Cell)
    public void setColor() {
        rand = new Random();
        //Setting a Minimum Variable Helped Create a Starting Point For The Ranges Of Red, Green and Blue.
        int min = 10;
        //Red Range: 5 - 20; Green Range: 90 - 255; Blue Range: 10 - 25;
        this.color = new Color(rand.nextInt(16) + min/2, rand.nextInt(166) + 9*min, rand.nextInt(16) + min);
    }
    //Setting Tool Tip Text For Each Rectangle (Cell)
    public void setGrassHeight(String _grassHeight){

        grassHeight = _grassHeight;
    }


    //Getters
    public int getX(){

        return x;
    }
    public int getY() {

        return y;
    }
    public int getWidth(){

        return w;
    }
    public int getHeight() {

        return h;
    }
    public String getGrassHeight(){

        return grassHeight;
    }



    public void paint(Graphics g, Boolean highlighted, Point mousePosition) {
        g.setColor(color);
        g.fillRect(x, y, 35, 35);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 35, 35);

        //Takes Boolean From "contains" Method And Executes If True
        if (highlighted) {
            g.setColor(Color.LIGHT_GRAY);
            g.drawRect(x, y, 35, 35);
            g.drawRect(x + 1, y + 1, 34, 34);
            g.drawRect(x + 2, y + 2, 33, 33);
            g.drawRect(x + 2, y + 2, 32, 32);

            //Previous Mouse Position Is Only Set If The Mouse Has Moved.
            //This Ensures That The Program Ignores If The Mouse Is In The Same Position.
            if(prevMouseX != mousePosition.getX() || prevMouseY != mousePosition.getY()) {
                prevMouseX = (int)mousePosition.getX();
                prevMouseY = (int)mousePosition.getY();
                count = 0;
            }

            //Increments A Counter If Mouse Hasn't Moved (i.e. Starts Counting).
            if(prevMouseX == mousePosition.getX() && prevMouseY == mousePosition.getY()){
                count++;
            }

            //Show Tool Tip Between Set Range Of Count.
            if(count > 500 && count < 1500){
                g.drawRect((int) mousePosition.getX() + 20, (int) mousePosition.getY() + 20, 120, 15);
                g.setColor(Color.YELLOW);
                g.fillRect((int) mousePosition.getX() + 20, (int) mousePosition.getY() + 20, 120, 15);
                g.setColor(Color.BLACK);
                g.drawString(this.getGrassHeight(), (int) mousePosition.getX() + 24, (int) mousePosition.getY() + 32);
            }
        }
    }

    //Takes The Mouse Position And Checks Wether It Is Within The Grid Bounds. Returns A Boolean Based On This Check.
    public boolean contains(Point target) {
        if (target == null)
            return false;
        return target.x > this.getX() && target.x < this.getX() + this.getWidth() && target.y > this.getY() && target.y < this.getY() + this.getHeight();
    }
}