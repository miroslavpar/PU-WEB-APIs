package com.pu.tvshowsapi.repository;

import com.pu.tvshowsapi.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
