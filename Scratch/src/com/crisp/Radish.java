package com.crisp;

import org.w3c.dom.ls.LSOutput;

/*
 *Natural order is defined by "size", a double.
 * That means "size" is called the "sort key"
 */
class Radish implements Comparable<Radish> {
    private String color;
    private double size;
    private double tailLength;
    private int guysOnTop;

    public Radish(String color, double size, double tailLength, int guysOnTop) {
        setColor(color);
        setSize(size);
        setTailLength(tailLength);
        setGuysOnTop(guysOnTop);
    }

    //accessor methods

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public int getGuysOnTop() {
        return guysOnTop;
    }

    public void setGuysOnTop(int guysOnTop) {
        this.guysOnTop = guysOnTop;
    }

        //'size' (double) is our sort key
    @Override //interface Comparable
    public int compareTo(Radish other) {
        return Double.compare(this.getSize(), other.getSize());  //use Double wrapper class to compare (b/c it's a primitive)
    }

    //toString()
    public String toString(){
        return getClass().getSimpleName() + " color: " + getColor() + ", size: " + getSize() + ", tailLength: "
                +getTailLength() + ", guysOnTop: " + getGuysOnTop();
    }
}
