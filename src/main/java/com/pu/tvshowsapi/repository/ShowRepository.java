package com.pu.tvshowsapi.repository;

import com.pu.tvshowsapi.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}
