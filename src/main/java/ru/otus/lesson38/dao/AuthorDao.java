package ru.otus.lesson38.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.lesson38.model.Author;

public interface AuthorDao extends JpaRepository<Author, Long> {

}
