package com.codecool.service;

import com.codecool.model.audiocollection.AudioCollection;
import com.codecool.model.track.Track;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamingService {

    private final List<AudioCollection> audioCollections;

    public StreamingService() {
        this.audioCollections = new ArrayList<>();
    }

    public void addAudioCollection(AudioCollection audioCollection) {
        audioCollections.add(audioCollection);
    }

    public List<Track> searchTrack(String trackName) {
        System.out.println("\nFound tracks by search query '" + trackName + "': ");
        return audioCollections.stream()
                .flatMap(audioCollection -> audioCollection.getTracks().stream())
                .filter(track -> track.getName().contains(trackName))
                .peek(track -> System.out.println(track.getName()))
                .toList();
    }

    public List<Track> searchTrackByAuthor (String authorName) {
        System.out.println("\nFound tracks by Author '" + authorName + "': ");
        return audioCollections.stream()
                .flatMap(audioCollection -> audioCollection.getTracks().stream())
                .filter(track -> track.getAuthor().contains(authorName))
                .peek(track -> System.out.println(track.getName()))
                .toList();
    }

    public List<Track> searchTopTracks() {
        System.out.println("\nTop 3 tracks:");
        List<Track> resultTracks = audioCollections.stream()
                .flatMap(audioCollection -> audioCollection.getTracks().stream())
                .sorted(Comparator.comparingLong((Track track) -> track.getPlays()).reversed())
                .limit(3)
                .toList();

        resultTracks.forEach(track -> System.out.println(track.getName()));

        return resultTracks;
    }
}
