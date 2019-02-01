package me.kalyanramswamy.clipboardmanager;

/**
 * Created by kalyanram on 12/1/18.
 */

public class Clipboard {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Clipboard(String description) {
        this.description = description;
    }
}
