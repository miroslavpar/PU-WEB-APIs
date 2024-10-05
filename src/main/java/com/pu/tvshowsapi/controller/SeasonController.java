package com.pu.tvshowsapi.controller;

import com.pu.tvshowsapi.model.Season;
import com.pu.tvshowsapi.service.SeasonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seasons")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @Operation(summary = "Get all seasons", description = "Retrieves a list of all seasons available in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieval of seasons")
    })
    @GetMapping
    public List<Season> getAllSeasons() {
        return seasonService.getAllSeasons();
    }

    @Operation(summary = "Create a new season", description = "Adds a new season to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Season created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public Season createSeason(
            @Parameter(description = "Season object to be created", required = true)
            @RequestBody Season season) {
        return seasonService.createSeason(season);
    }

    @Operation(summary = "Get a season by ID", description = "Retrieves a season by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Season found"),
            @ApiResponse(responseCode = "404", description = "Season not found")
    })
    @GetMapping("/{id}")
    public Season getSeasonById(
            @Parameter(description = "ID of the season to retrieve", required = true)
            @PathVariable Long id) {
        return seasonService.getSeasonById(id);
    }

    @Operation(summary = "Update a season", description = "Updates an existing season in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Season updated successfully"),
            @ApiResponse(responseCode = "404", description = "Season not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public Season updateSeason(
            @Parameter(description = "ID of the season to update", required = true)
            @PathVariable Long id,
            @RequestBody Season season) {
        return seasonService.updateSeason(id, season);
    }

    @Operation(summary = "Delete a season", description = "Deletes a season by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Season deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Season not found")
    })
    @DeleteMapping("/{id}")
    public void deleteSeason(
            @Parameter(description = "ID of the season to delete", required = true)
            @PathVariable Long id) {
        seasonService.deleteSeason(id);
    }
}
