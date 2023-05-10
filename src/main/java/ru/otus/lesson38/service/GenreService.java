package ru.otus.lesson38.service;

import ru.otus.lesson38.dto.GenreDto;
import ru.otus.lesson38.exception.GenreNotFoundException;

import java.util.List;

public interface GenreService {

    List<GenreDto> getAllGenre() throws GenreNotFoundException;
    GenreDto getGenreById(Long id) throws GenreNotFoundException;


    List<GenreDto> fallback();
}
