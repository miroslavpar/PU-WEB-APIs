package com.pu.tvshowsapi.service;

import com.pu.tvshowsapi.model.Show;
import com.pu.tvshowsapi.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Show createShow(Show show) {
        return showRepository.save(show);
    }

    public Show getShowById(Long id) {
        Optional<Show> optionalShow = showRepository.findById(id);
        return optionalShow.orElseThrow(() -> new RuntimeException("Show not found"));
    }

    public Show updateShow(Long id, Show show) {
        show.setId(id);
        return showRepository.save(show);
    }

    public void deleteShow(Long id) {
        showRepository.deleteById(id);
    }
}
