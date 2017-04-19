package com.theironyard;

/**
 * Created by rickiecashwell on 3/21/17.
 */
public enum Suit {
    HEARTS("red"), CLUBS("black"), DIAMONDS("red"), SPADE("black");
    String color;

    Suit(String color) {
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }
}
