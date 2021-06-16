package com.oraen.oxygen.excelutil.component;

public class Point {

    protected int row;

    protected int line;

    private int originalRow;

    private int originalLine;

    public Point(int row, int line){
        this.line = line;
        this.row = row;
        this.originalRow = row;
        this.originalLine = line;
    }

    public Point(){
        this(0, 0);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setOrigin(int row, int line){
        this.row = row;
        this.line = line;
    }

    public void nextRow(){
        this.row ++;
    }

    public void jumpRow(int num){
        this.line += num;
    }

    public void nextLine(){
        this.line ++;
    }

    public void jumpLine(int num){
        this.line += num;
    }

    public void resetRow(){
        this.row = originalRow;
    }

    public void resetLine(){
        this.line = originalLine;
    }

    public int getOriginalRow() {
        return originalRow;
    }

    public void setOriginalRow(int originalRow) {
        this.originalRow = originalRow;
    }

    public int getOriginalLine() {
        return originalLine;
    }

    public void setOriginalLine(int originalLine) {
        this.originalLine = originalLine;
    }
}
