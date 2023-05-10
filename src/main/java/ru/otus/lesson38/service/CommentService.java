package ru.otus.lesson38.service;

import ru.otus.lesson38.dto.CommentDto;
import ru.otus.lesson38.exception.BookNotFoundException;

import java.util.List;

public interface CommentService {

    List<CommentDto> getAllCommentsByBook(Long id) throws BookNotFoundException;

}
