package com.umgcodechallenge.umgcodechallenge.Service;

import java.util.List;

import com.umgcodechallenge.umgcodechallenge.Model.TrackData;
import com.umgcodechallenge.umgcodechallenge.Repository.TrackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackServiceImplementation implements TrackService {

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public List<TrackData> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public void saveTrack(TrackData track) {
        this.trackRepository.save(track);
    }
}
