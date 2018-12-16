package com.iwant.api.model;

public enum Category {
    House(1,"House"),
    Electronic(2,"Electronic"),
    Pet(3,"Pet"),
    Phone(4,"Phone"),
    Book(5,"Book"),
    Vehicle(6,"Vehicle");

    private final String text;
    private final int id;

    private Category(final int id, final String text) {
        this.text = text;
        this.id = id;
    }

    public static Category get(int id) {
        for (Category status : values()) {
            if (status.getId() == id)
                return status;
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}