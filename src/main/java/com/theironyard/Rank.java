package com.theironyard;

/**
 * Created by rickiecashwell on 3/21/17.
 */
public enum Rank {
    TWO(false, 2),THREE(false,3),FOUR(false,4),FIVE(false,5),SIX(false,6),
    SEVEN(false,7),EIGHT(false,8),NINE(false,9),TEN(false,10),JACK(true,11),
    KING(true,12),QUEEN(true,13),ACE(true,14);
    boolean faceValue;
    int value;

    public boolean isFaceValue() {
        return faceValue;
    }
    public void setFaceValue(boolean faceValue) {
        this.faceValue = faceValue;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    Rank(boolean face, int value) {
    this.faceValue = face;
    this.value = value;
    }

    public boolean getFaceValue() {
    return this.faceValue;
    }
}
