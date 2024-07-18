package com.entertainment;

import javax.print.attribute.standard.Media;
import java.util.Objects;

/*
 * Natural order is defined by 'brand' (String)
 * To be consistent with equals, whatever fields are used for equals (brand, volume)
 * MUST ALSO BE USED for compareTo
 */

public class Television implements Comparable<Television> {
    // private fields
    private String brand;
    private int volume;

    // Television HAS-A Tuner
    private Tuner tuner = new Tuner();

    // constructors
    public Television() {
    }

    public Television(String brand, int volume) {
        this.brand = brand;
        this.volume = volume;
    }

    // business / action methods
    public int getCurrentChannel() {
        return tuner.getChannel(); // delegate to contained Tuner object
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel); // delegate to contained Tuner object
    }

    // getters and setters
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Television that = (Television) obj;
        return getVolume() == that.getVolume() && Objects.equals(getBrand(), that.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }
    // Natural order is defined by brand (String) and secondarily by volume (int)
    // when tied on brand
    @Override
    public int compareTo(Television other) {
        int res = this.getBrand().compareTo(other.getBrand());
        if (res == 0) { // tied on brand, break tie by volume
            res = Integer.compare(this.getVolume(), other.getVolume());
        }
        return res;
    }


    /*
    @Override
    public int hashCode() {
        // can result in hash-collisions, poor hashCode
        // return getBrand().length() + getVolume();

        // instead use Objects.hash() to give us a scientifically correct hash function
        // it minimizes the probability of hash collisions
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        // proceed only if 'obj' IS-A Television
        if (obj instanceof Television) {
            // downcast 'obj' to more specific reference type Television, to call getName(), etc.
            Television other = (Television) obj;
            // checks sameness is defined as same brand and same volume
            // Objects.equals does a null-safe on the two arguments provided
            result = Objects.equals(this.getBrand(), other.getBrand()) &&
                    this.getVolume() == other.getVolume(); // primitives can't be null

//                    this.getBrand().equals(other.getBrand()) &&
//                     this.getVolume() == other.getVolume();
        }
        return result;
    }
*/
    // toString method

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": brand=" + getBrand() +
                ", volume=" + getVolume() + ", currentChannel=" + getCurrentChannel();
    }
}