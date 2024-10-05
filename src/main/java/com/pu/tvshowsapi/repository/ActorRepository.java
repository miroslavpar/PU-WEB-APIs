package com.pu.tvshowsapi.repository;

import com.pu.tvshowsapi.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
