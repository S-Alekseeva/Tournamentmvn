package ru.netology.notRegisteredException;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Player " + name + "Isn't exist");
    }
}
