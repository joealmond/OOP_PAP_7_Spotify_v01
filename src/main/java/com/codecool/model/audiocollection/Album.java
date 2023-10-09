package com.codecool.model.audiocollection;

import com.codecool.model.MusicStyle;
import com.codecool.model.track.Song;
import com.codecool.model.track.Track;

import java.util.List;
import java.util.stream.Collectors;

public class Album extends AudioCollection {
    private final MusicStyle musicStyle;
    private final List<Song> songs;

    public Album(String name, MusicStyle musicStyle, List<Song> songs) {
        super(name);
        this.musicStyle = musicStyle;
        this.songs = songs;
    }

    @Override
    public List<Track> getTracks() {
        return songs.stream()
                .map(song -> (Track)song)
                .collect(Collectors.toList());
    }
}
