package com.pu.tvshowsapi.repository;

import com.pu.tvshowsapi.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
