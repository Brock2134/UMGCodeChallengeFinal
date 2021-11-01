package com.umgcodechallenge.umgcodechallenge.Repository;

import com.umgcodechallenge.umgcodechallenge.Model.TrackData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<TrackData, Long> {

}
