package com.company;

import java.awt.*;


public class Grid {

    private Cell[][] cells = new Cell[20][20];

    private int x;
    private int y;


    public Grid(int x, int y) {

        this.x = x;
        this.y = y;

        //Does The Math Required For Making The Starting Point For All 400 Cells.
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                cells[i][j] = new Cell(x + j * 35, y + i * 35, 35, 35);
            }
        }
    }

    public void paint(Graphics g, Point mousePosition) {
        //Cell Painting Starts From Bottom Right Corner And Moves From Right To Left Through Each Row While Going Up a Row Each Time.
        //This Ensures That The Cells Are Drawn Before The Tool Tip Appears And Doesn't Cover The Tool Tip.
        for (int i = cells.length - 1; i >= 0; i--) {
            for (int j = cells[i].length - 1; j >= 0; j--) {
                Cell thisCell = cells[i][j];
                thisCell.paint(g, thisCell.contains(mousePosition), mousePosition);
            }

        }
    }
}
