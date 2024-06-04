/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

//non-public class and only other classes in the same package can see it so we don't need it exposed to the "outside" world
class Tuner {
    private int channel = 3;  // default channel for cable and satellite customers

    public int getChannel() {
        return this.channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    //we don't need a ctor because we get the "free" no-arg one if we don't write one.
}