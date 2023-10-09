package com.codecool.model.track;

import com.codecool.model.author.PodcastAuthor;

public class PodcastTrack extends Track {
    private long trackNumber;
    public PodcastTrack(String name, long lengthInSeconds, PodcastAuthor author) {
        super(name, author, lengthInSeconds);
        this.trackNumber = 0;
    }

    public void setTrackNumber(long trackNumber) {
        this.trackNumber = trackNumber;
    }
}
