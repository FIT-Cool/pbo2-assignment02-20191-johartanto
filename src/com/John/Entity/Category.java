package com.John.Entity;
/**
 * author: Johnson Hartanto
 * NRP: 1772017
 */
import javafx.scene.control.TextField;

public class Category {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

