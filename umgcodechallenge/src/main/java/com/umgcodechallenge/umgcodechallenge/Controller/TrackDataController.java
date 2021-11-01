package com.umgcodechallenge.umgcodechallenge.Controller;

import java.util.concurrent.atomic.AtomicLong;

import com.umgcodechallenge.umgcodechallenge.Authorization.ClientCredentialsAuthorization;
import com.umgcodechallenge.umgcodechallenge.Model.TrackData;
import com.umgcodechallenge.umgcodechallenge.Service.TrackService;
import com.umgcodechallenge.umgcodechallenge.TrackFinder.TrackDataUtil;
import com.umgcodechallenge.umgcodechallenge.TrackFinder.TrackFinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/codechallenge")
public class TrackDataController {

    @Autowired
    private TrackService trackService;

    @GetMapping("/getTracks")
    public String viewHomePage(Model model) {

        ClientCredentialsAuthorization.clientCredentials_Sync();
        model.addAttribute("listTracks", trackService.getAllTracks());
        return "index";
    }

    @GetMapping("/showNewTrackForm")
    public String showNewTrackForm(Model model) {
        TrackData track = new TrackData();
        model.addAttribute("track", track);
        return "new_track";
    }

    private static final AtomicLong counter = new AtomicLong();

    @PostMapping("/createTrack")
    public String saveTrack(@ModelAttribute("track") TrackData track,
            @RequestParam(value = "ISRC", defaultValue = "GBAYE0601477") String ISRC) {
        ClientCredentialsAuthorization.clientCredentials_Sync();
        TrackDataUtil metadata = TrackFinder.searchTracks_Sync(ISRC);
        if (metadata == null) {
            return "index";
        }
        track.setId(counter.incrementAndGet());
        track.setISRC(ISRC);
        track.setDuration_ms(metadata.getDuration_ms());
        track.setName(metadata.getName());
        track.setExplicit(metadata.isExplicit());
        trackService.saveTrack(track);
        return "redirect:/codechallenge/getTracks";
    }

}
