package com.codecool.model.audiocollection;

import com.codecool.model.track.Track;

import java.util.List;

public abstract class AudioCollection {
    private final String name;

    public AudioCollection(String name) {
        this.name = name;
    }

    public abstract List<Track> getTracks();
}
