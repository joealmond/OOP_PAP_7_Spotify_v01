package com.codecool.model.audiocollection;

import com.codecool.model.track.PodcastTrack;
import com.codecool.model.track.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Podcast extends AudioCollection {
    private int seasonNumber;
    private long trackCount;
    private final List<PodcastTrack> podcastTracks;

    public Podcast(int seasonNumber, String name) {
        super(name);
        this.seasonNumber = seasonNumber;
        this.trackCount = 0;
        this.podcastTracks = new ArrayList<>();
    }

    public void addPodcastTrack(PodcastTrack track) {
        trackCount += 1;
        track.setTrackNumber(trackCount);
        podcastTracks.add(track);
        System.out.println("Track added to podcast..");
    }
    @Override
    public List<Track> getTracks() {
        return podcastTracks.stream()
                .map(podcastTrack -> (Track)podcastTrack)
                .collect(Collectors.toList());
    }
}
