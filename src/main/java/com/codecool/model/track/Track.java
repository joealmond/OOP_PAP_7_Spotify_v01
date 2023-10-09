package com.codecool.model.track;

import com.codecool.model.author.Author;

public class Track {
    private final String name;
    private final Author author;
    private final long lengthInSeconds;

    private long played;

    public Track(String name, Author author, long lengthInSeconds) {
        this.name = name;
        this.author = author;
        this.lengthInSeconds = lengthInSeconds;
        this.played = 0;
    }

    public void play() {
        this.played += 1;
        System.out.println(name + " played " + played + " times...");
    }

    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author.toString();
    }
    public long getPlays() {
        return played;
    }
}
