package com.theironyard;

/**
 * Created by rickiecashwell on 3/21/17.
 */
public enum Suit {
    HEARTS("red"), CLUBS("black"), DIAMONDS("red"), SPADES("black");
    String color;

    Suit(String color) {
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }
}

/***
 *    key: heart:{
         *          {
         *              Value: 3,
         *              image: "image"
         *          }
 *               },
 *          {
 *              Value: 4,
 *              image: "image"
 *          }
 *         Spades:
 *          {
 *              Value: 3,
 *              image: "image"
 *          },
 *          {
 *              Value: 4,
 *              image: "image"
 *          }
 */
