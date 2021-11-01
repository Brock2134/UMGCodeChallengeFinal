package com.umgcodechallenge.umgcodechallenge.TrackFinder;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import com.wrapper.spotify.SpotifyApi;
// import com.wrapper.spotify.enums.ModelObjectType;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;

import org.apache.hc.core5.http.ParseException;

public class TrackFinder {

    private static final AtomicLong counter = new AtomicLong();

    public static TrackDataUtil searchTracks_Sync(String ISRC) {

        String accessToken = com.umgcodechallenge.umgcodechallenge.Authorization.ClientCredentialsAuthorization
                .clientCredentials_Sync();

        final String q = "isrc:" + ISRC;

        SpotifyApi spotifyApi = new SpotifyApi.Builder().setAccessToken(accessToken).build();

        SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks(q).limit(1).offset(0).build();
        try {
            final Paging<Track> trackPaging = searchTracksRequest.execute();

            String name = trackPaging.getItems()[0].getName();
            int duration_ms = trackPaging.getItems()[0].getDurationMs();
            boolean explicit = trackPaging.getItems()[0].getIsExplicit();
            // String ISRC = "GBAYE0601477";
            TrackDataUtil metaData = new TrackDataUtil(counter.incrementAndGet(), ISRC, name, duration_ms, explicit);

            return metaData;
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

}
