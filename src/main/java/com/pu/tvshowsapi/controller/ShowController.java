package com.pu.tvshowsapi.controller;

import com.pu.tvshowsapi.model.Show;
import com.pu.tvshowsapi.service.ShowService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @Operation(summary = "Get all shows", description = "Retrieves a list of all shows available in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieval of shows"),
            @ApiResponse(responseCode = "404", description = "No shows found")
    })
    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @Operation(summary = "Create a new show", description = "Adds a new show to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Show created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public Show createShow(
            @Parameter(description = "Show object to be created", required = true)
            @RequestBody Show show) {
        return showService.createShow(show);
    }

    @Operation(summary = "Get a show by ID", description = "Retrieves a show by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Show found"),
            @ApiResponse(responseCode = "404", description = "Show not found")
    })
    @GetMapping("/{id}")
    public Show getShowById(
            @Parameter(description = "ID of the show to retrieve", required = true)
            @PathVariable Long id) {
        return showService.getShowById(id);
    }

    @Operation(summary = "Update a show", description = "Updates an existing show in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Show updated successfully"),
            @ApiResponse(responseCode = "404", description = "Show not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public Show updateShow(
            @Parameter(description = "ID of the show to update", required = true)
            @PathVariable Long id,
            @RequestBody Show show) {
        return showService.updateShow(id, show);
    }

    @Operation(summary = "Delete a show", description = "Deletes a show by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Show deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Show not found")
    })
    @DeleteMapping("/{id}")
    public void deleteShow(
            @Parameter(description = "ID of the show to delete", required = true)
            @PathVariable Long id) {
        showService.deleteShow(id);
    }
}
