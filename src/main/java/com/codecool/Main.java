package com.codecool;

import com.codecool.model.audiocollection.Album;
import com.codecool.model.MusicStyle;
import com.codecool.model.audiocollection.Podcast;
import com.codecool.model.author.Author;
import com.codecool.model.author.PodcastAuthor;
import com.codecool.model.author.SongAuthor;
import com.codecool.model.track.PodcastTrack;
import com.codecool.model.track.Song;
import com.codecool.service.StreamingService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SongAuthor songAuthor1 = new SongAuthor("songAuthor2");
        SongAuthor songAuthor2 = new SongAuthor("songAuthor2");
        PodcastAuthor podcastAuthor1 = new PodcastAuthor("podcastAuthor1");

        Song song1 = new Song("song1", 310, "...", songAuthor1);
        Song song2 = new Song("song2", 320, "...", songAuthor2);
        Song song3 = new Song("song3", 330, "...", songAuthor1);

        song1.play();
        song1.play();
        song1.play();
        song2.play();
        song3.play();
        song3.play();

        Album album1 = new Album("Album1", MusicStyle.POP, List.of(song1, song2, song3));

        PodcastTrack podcastTrack1 = new PodcastTrack("track1", 400, podcastAuthor1);
        PodcastTrack podcastTrack2 = new PodcastTrack("track2", 450, podcastAuthor1);

        podcastTrack1.play();
        podcastTrack1.play();
        podcastTrack1.play();
        podcastTrack1.play();
        podcastTrack2.play();

        Podcast podcast1 = new Podcast(1, "The Podcast");
        podcast1.addPodcastTrack(podcastTrack1);
        podcast1.addPodcastTrack(podcastTrack2);

        StreamingService spotify = new StreamingService();

        spotify.addAudioCollection(album1);
        spotify.addAudioCollection(podcast1);

        spotify.searchTrack("song");
        spotify.searchTrackByAuthor("tAuth");
        spotify.searchTopTracks();
    }
}