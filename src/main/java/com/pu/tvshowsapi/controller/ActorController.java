package com.pu.tvshowsapi.controller;

import com.pu.tvshowsapi.model.Actor;
import com.pu.tvshowsapi.service.ActorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @Operation(summary = "Get all actors", description = "Retrieves a list of all actors available in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieval of actors")
    })
    @GetMapping
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @Operation(summary = "Create a new actor", description = "Adds a new actor to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Actor created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public Actor createActor(
            @Parameter(description = "Actor object to be created", required = true)
            @RequestBody Actor actor) {
        return actorService.createActor(actor);
    }

    @Operation(summary = "Get an actor by ID", description = "Retrieves an actor by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Actor found"),
            @ApiResponse(responseCode = "404", description = "Actor not found")
    })
    @GetMapping("/{id}")
    public Actor getActorById(
            @Parameter(description = "ID of the actor to retrieve", required = true)
            @PathVariable Long id) {
        return actorService.getActorById(id);
    }

    @Operation(summary = "Update an actor", description = "Updates an existing actor in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Actor updated successfully"),
            @ApiResponse(responseCode = "404", description = "Actor not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public Actor updateActor(
            @Parameter(description = "ID of the actor to update", required = true)
            @PathVariable Long id,
            @RequestBody Actor actor) {
        return actorService.updateActor(id, actor);
    }

    @Operation(summary = "Delete an actor", description = "Deletes an actor by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Actor deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Actor not found")
    })
    @DeleteMapping("/{id}")
    public void deleteActor(
            @Parameter(description = "ID of the actor to delete", required = true)
            @PathVariable Long id) {
        actorService.deleteActor(id);
    }
}
