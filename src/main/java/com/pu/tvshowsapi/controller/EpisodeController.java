package com.pu.tvshowsapi.controller;

import com.pu.tvshowsapi.model.Episode;
import com.pu.tvshowsapi.service.EpisodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {

    @Autowired
    private EpisodeService episodeService;

    @Operation(summary = "Get all episodes", description = "Retrieves a list of all episodes available in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieval of episodes")
    })
    @GetMapping
    public List<Episode> getAllEpisodes() {
        return episodeService.getAllEpisodes();
    }

    @Operation(summary = "Create a new episode", description = "Adds a new episode to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Episode created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public Episode createEpisode(
            @Parameter(description = "Episode object to be created", required = true)
            @RequestBody Episode episode) {
        return episodeService.createEpisode(episode);
    }

    @Operation(summary = "Get an episode by ID", description = "Retrieves an episode by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Episode found"),
            @ApiResponse(responseCode = "404", description = "Episode not found")
    })
    @GetMapping("/{id}")
    public Episode getEpisodeById(
            @Parameter(description = "ID of the episode to retrieve", required = true)
            @PathVariable Long id) {
        return episodeService.getEpisodeById(id);
    }

    @Operation(summary = "Update an episode", description = "Updates an existing episode in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Episode updated successfully"),
            @ApiResponse(responseCode = "404", description = "Episode not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public Episode updateEpisode(
            @Parameter(description = "ID of the episode to update", required = true)
            @PathVariable Long id,
            @RequestBody Episode episode) {
        return episodeService.updateEpisode(id, episode);
    }

    @Operation(summary = "Delete an episode", description = "Deletes an episode by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Episode deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Episode not found")
    })
    @DeleteMapping("/{id}")
    public void deleteEpisode(
            @Parameter(description = "ID of the episode to delete", required = true)
            @PathVariable Long id) {
        episodeService.deleteEpisode(id);
    }
}
