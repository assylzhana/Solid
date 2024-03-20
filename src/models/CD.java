package models;

import interfaces.Item;

public class CD implements Item {
    private String title;
    private String artist;

    public CD(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
