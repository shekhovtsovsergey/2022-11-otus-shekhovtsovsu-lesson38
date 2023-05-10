package ru.otus.lesson38.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.lesson38.model.Book;
import ru.otus.lesson38.model.Comment;

public interface CommentDao extends JpaRepository<Comment, Long> {

    void deleteByBook(Book book);
}
