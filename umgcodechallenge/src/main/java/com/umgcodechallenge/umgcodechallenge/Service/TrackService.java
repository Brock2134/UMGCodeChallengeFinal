package com.umgcodechallenge.umgcodechallenge.Service;

import java.util.List;

import com.umgcodechallenge.umgcodechallenge.Model.TrackData;

public interface TrackService {
    List<TrackData> getAllTracks();

    void saveTrack(TrackData track);
}
