package com.codecool.service;

import com.codecool.model.audiocollection.AudioCollection;
import com.codecool.model.track.Track;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamingService {

    private final List<AudioCollection> audioCollections;

    public StreamingService() {
        this.audioCollections = new ArrayList<>();
    }

    public void addAudioCollection(AudioCollection audioCollection) {
        audioCollections.add(audioCollection);
    }

    public List<Track> searchTrack(String trackName) {
        System.out.println(" ");
        System.out.println("Found tracks by search query '" + trackName + "': ");
        List<Track> resultTracks = new ArrayList<>();
        for (AudioCollection audioCollection : audioCollections) {
            for (Track track : audioCollection.getTracks()) {
                if (track.getName().contains(trackName)) {
                    resultTracks.add(track);
                    System.out.println(track.getName());
                }
            }
        }
        return resultTracks;
    }
    public List<Track> searchTrackByAuthor (String authorName) {
        System.out.println(" ");
        System.out.println("Found tracks by Author '" + authorName + "': ");
        List<Track> resultTracks = new ArrayList<>();
        for (AudioCollection audioCollection : audioCollections) {
            for (Track track : audioCollection.getTracks()) {
                if (track.getAuthor().contains(authorName)) {
                    resultTracks.add(track);
                    System.out.println(track.getName());
                }
            }
        }
        return resultTracks;
    }

    public List<Track> searchTopTracks() {
        System.out.println(" ");
        System.out.println("Top 3 tracks:");
        List<Track> resultTracks = audioCollections.stream()
                .flatMap(audioCollection -> audioCollection.getTracks().stream())
                .sorted(Comparator.comparingLong(Track::getPlays).reversed())
                .limit(3)
                .collect(Collectors.toList());

        resultTracks.forEach(track -> System.out.println(track.getName()));

        return resultTracks;
    }

    // search for a track (song or podcast) by name
    // list songs/podcast names from an author by name
    // find the top 3 most listened to tracks
}
