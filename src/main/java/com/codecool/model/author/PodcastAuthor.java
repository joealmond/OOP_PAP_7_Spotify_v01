package com.codecool.model.author;

import com.codecool.model.track.PodcastTrack;

import java.util.ArrayList;
import java.util.List;

public class PodcastAuthor extends Author {

    private final List<PodcastTrack> podcastTracks;
    public PodcastAuthor(String name) {
        super(name);
        this.podcastTracks = new ArrayList<>();
    }
}
