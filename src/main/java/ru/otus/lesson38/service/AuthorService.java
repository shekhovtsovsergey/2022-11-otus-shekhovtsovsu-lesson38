package ru.otus.lesson38.service;

import ru.otus.lesson38.dto.AuthorDto;
import ru.otus.lesson38.exception.AuthorNotFoundException;

import java.util.List;

public interface AuthorService {

    List<AuthorDto> getAllAuthore() throws AuthorNotFoundException;

}
