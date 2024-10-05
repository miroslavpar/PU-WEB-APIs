package com.pu.tvshowsapi.service;

import com.pu.tvshowsapi.model.Episode;
import com.pu.tvshowsapi.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    public List<Episode> getAllEpisodes() {
        return episodeRepository.findAll();
    }

    public Episode createEpisode(Episode episode) {
        return episodeRepository.save(episode);
    }

    public Episode getEpisodeById(Long id) {
        Optional<Episode> optionalEpisode = episodeRepository.findById(id);
        return optionalEpisode.orElseThrow(() -> new RuntimeException("Episode not found"));
    }

    public Episode updateEpisode(Long id, Episode episode) {
        episode.setId(id);
        return episodeRepository.save(episode);
    }

    public void deleteEpisode(Long id) {
        episodeRepository.deleteById(id);
    }
}
