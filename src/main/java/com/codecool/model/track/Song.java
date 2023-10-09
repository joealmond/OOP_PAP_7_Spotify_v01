package com.codecool.model.track;

import com.codecool.model.author.SongAuthor;

public class Song extends Track {
    public final String lyrics;
    public Song(String name, long lengthInSeconds, String lyrics, SongAuthor author) {
        super(name, author, lengthInSeconds);
        this.lyrics = lyrics;
    }
}