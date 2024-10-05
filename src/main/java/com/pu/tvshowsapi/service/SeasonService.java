package com.pu.tvshowsapi.service;

import com.pu.tvshowsapi.model.Season;
import com.pu.tvshowsapi.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    public List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }

    public Season createSeason(Season season) {
        return seasonRepository.save(season);
    }

    public Season getSeasonById(Long id) {
        Optional<Season> optionalSeason = seasonRepository.findById(id);
        return optionalSeason.orElseThrow(() -> new RuntimeException("Season not found"));
    }

    public Season updateSeason(Long id, Season season) {
        season.setId(id);
        return seasonRepository.save(season);
    }

    public void deleteSeason(Long id) {
        seasonRepository.deleteById(id);
    }
}
