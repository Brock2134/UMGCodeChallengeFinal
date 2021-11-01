package com.umgcodechallenge.umgcodechallenge.TrackFinder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codechallenge")
public class TrackFinderController {

    @GetMapping("/findtrack")
    public TrackDataUtil trackData() {
        String ISRC = "USWB11403680";
        return TrackFinder.searchTracks_Sync(ISRC);
    }
    /*
     * @GetMapping("/createTrack") public Paging<Track> TrackFinder() { return
     * TrackFinder.searchItem_Sync(); }
     */
    // @RequestParam(value = "ISRC", defaultValue = "GBAYE0601477") String ISRC
}
