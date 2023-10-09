package com.codecool.model.author;

import com.codecool.model.audiocollection.Album;

import java.util.ArrayList;
import java.util.List;

public class SongAuthor extends Author {
    private final List<Album> albums;

    public SongAuthor(String name) {
        super(name);
        this.albums = new ArrayList<>();
    }
}
