package edu.cse470.pokemongoapp.inventory;

import java.io.Serializable;

public class Pokemon implements Serializable {

    private String name;
    private int image;

    public Pokemon() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
