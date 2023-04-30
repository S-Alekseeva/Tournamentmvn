package ru.netology.domain;


public class Player {

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
        }
    private int id;
    private String name;
    private int strength;

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

}