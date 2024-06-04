package com.entertainment;

import java.util.Objects;

public class Television {
    //fields
    private String brand;
    private int volume;

    //Television HAS-A Tuner (for all things related to channel changing)
    private Tuner tuner = new Tuner();

    //ctors
    //no-arg ctor
    public Television() {
        super();    //super() class ctor is always called whether we right it or not
    }

    //2-arg ctor
    public Television(String brand, int volume) {  //use setters if you have them
        setBrand(brand);
        setVolume(volume);
    }

    //business (action) methods

    public int getCurrentChannel() {
        return tuner.getChannel(); //delegate to contained Tuner object
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);  //delegate to contained Tuner object
    }

    //accessor methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    //toString()
    @Override
    public String toString() {
        return getClass().getSimpleName() + "brand: " + getBrand() + ", volume: "
                + getVolume() + ", currentChannel: " + getCurrentChannel();
    }

    @Override
    public int hashCode(){  //we HAVE to use the same fields we used in .equals() to define BUSINESS EQUALITY
        //this is a poor hash function, b/c it easily yields "hash collisions"
        //a "hash collision" is when "different" object happen to have the same hashcode (dumb luck), they ruin
        //Set optimization b/c then it has to go to .equals() if the hashCodes are the same.
        //return getBrand().length() + getVolume();
        return Objects.hash(getBrand(), getVolume());  //this is provided good hashCode() that we get from java.util.Objects
    }

    @Override
    public boolean equals(Object obj){  //this signature needs to be exactly like this b/c it overrides the free .equals() method.
        boolean result = false; //assume they aren't equal
        if( obj instanceof Television){  //check to see if the type is the same (if it's a Television in this case).  If not, method returns false.
            //downcast obj reference type to Television type (what we're passing into .equals() to compare) so we can call getName() and getAge()
            //remember- this .equals() will run inside of the object we call it on.

            Television other = (Television) obj;
            //do the checks - check fields you want to compare - referred to as "BUSINESS EQUALITY".  Sets result to be true if checks are true.
            result = Objects.equals(this.getBrand(), other.getBrand()) &&  // null-safe check
                    this.getVolume() == other.getVolume();  //no null-safe check necessary b/c primitives can't be null
        }
        return result;
    }
}
