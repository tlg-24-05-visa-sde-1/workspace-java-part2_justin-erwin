package com.duckrace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class DuckRacer implements Serializable {  //have to implements Serializable so it can be written
    private final int id;
    private String name;
    private int wins;
    private Collection<Reward> rewards = new ArrayList<>();  //can't use set b/c they don't allow duplicates

    //ctor
    public DuckRacer(int id, String name) {
        this.id = id;   //no setter so we can set id directly
        setName(name);  //call your own setter if possible
    }

    //business (action) method
    public void win(Reward reward){ //win() takes a Reward parameter
        rewards.add(reward);  //when duck wins, we give it a reward
    }

    //accessor methods

    //only getters for id so it can't be change once the object is created
    public int getId() {
        return id;
    }
    // getter and setter to be able to change wins
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //only getter b/c it's a derived field
    public int getWins() {
        return rewards.size();  //returns length of rewards list
    }
    //only getter b/c we can add onto rewards with .add();
    //currently, we're returning a DIRECT reference to this collection and client can modify it.  We need a ReadOnly
    public Collection<Reward> getRewards() {
        //return rewards
        return Collections.unmodifiableCollection(rewards);  //returns a ReadOnly wrapper around rewards that client can't alter
    }

    // toString()
    @Override
    public String toString(){
        return String.format("%s: id=%s, name=%s, wins=%s, rewards=%s",
                getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());
    }
}
