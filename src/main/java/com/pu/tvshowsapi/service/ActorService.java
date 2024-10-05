package com.pu.tvshowsapi.service;

import com.pu.tvshowsapi.model.Actor;
import com.pu.tvshowsapi.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor getActorById(Long id) {
        Optional<Actor> optionalActor = actorRepository.findById(id);
        return optionalActor.orElseThrow(() -> new RuntimeException("Actor not found"));
    }

    public Actor updateActor(Long id, Actor actor) {
        actor.setId(id);
        return actorRepository.save(actor);
    }

    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}
