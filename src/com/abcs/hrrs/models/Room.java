package com.abcs.hrrs.models;

import java.io.Serializable;

/**
 * Represents a row from the DB Table "rooms"
 *
 * @authors Katusiime Conrad, Bakunga Bronson, Opio Andrew, Nakagwe Sharifah
 */
public class Room implements Serializable {
    //Unique identifier
    private int type;

    //Room Type Name
    private String name;

    //Number of Rooms
    private int number;

    //Cost of Each Room
    private int cost;

    //Booked Rooms
    private int bookings;

    //Availlable Rooms
    private int available;


    @Override
    public String toString() {
        return type + "\t \t" +
                name + "\t \t" +
                number + "\t \t" +
                cost;
    }

    /**
     * Returns Room Type
     *
     * @return type type
     */
    public int getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Returns Room Type Name
     *
     * @return name name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the number of Rooms For a given Type
     *
     * @return number number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets number.
     *
     * @param number the number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Returns the cost of a room for a given Room Type
     *
     * @return cost cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * Sets cost.
     *
     * @param cost the cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Return the number of booked rooms
     *
     * @return bookings
     */
    public int getBookings() {
        return bookings;
    }

    /**
     * Sets bookings.
     *
     * @param bookings the bookings
     */
    public void setBookings(int bookings) {
        this.bookings = bookings;
    }

    /**
     * Returns the number of available rooms
     *
     * @return available
     */
    public int getAvailable() {
        return available;
    }

    /**
     * Sets available.
     *
     * @param available the available
     */
    public void setAvailable(int available) {
        this.available = available;
    }
}
