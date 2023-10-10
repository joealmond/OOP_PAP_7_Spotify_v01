package com.codecool.service;

import com.codecool.model.MusicStyle;
import com.codecool.model.audiocollection.Album;
import com.codecool.model.audiocollection.Podcast;
import com.codecool.model.author.PodcastAuthor;
import com.codecool.model.author.SongAuthor;
import com.codecool.model.track.PodcastTrack;
import com.codecool.model.track.Song;
import com.codecool.model.track.Track;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamingServiceTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void searchTopTracksTest() {
        // arrange
        SongAuthor songAuthor1 = new SongAuthor("songAuthor2");
        PodcastAuthor podcastAuthor1 = new PodcastAuthor("podcastAuthor1");

        Song song1 = new Song("song1", 310, "...", songAuthor1);
        Song song2 = new Song("song2", 320, "...", songAuthor1);

        song1.play();
        song1.play();
        song1.play();
        song2.play();

        Album album1 = new Album("Album1", MusicStyle.POP, List.of(song1, song2));

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

        // act
        List<Track> resultTracks = spotify.searchTopTracks();

        // assert
        assertEquals(resultTracks.get(0).getName(),"track1");
        assertEquals(resultTracks.get(1).getName(),"song1");
        assertEquals(resultTracks.get(2).getName(),"song2");
    }
}