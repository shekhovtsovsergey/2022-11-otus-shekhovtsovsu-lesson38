package ru.otus.lesson38.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.lesson38.model.Genre;

public interface GenreDao extends JpaRepository<Genre, Long> {

}