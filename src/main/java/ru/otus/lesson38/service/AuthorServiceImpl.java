package ru.otus.lesson38.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.lesson38.converter.AuthorConverter;
import ru.otus.lesson38.dao.AuthorDao;
import ru.otus.lesson38.dto.AuthorDto;
import ru.otus.lesson38.exception.AuthorNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorServiceImpl implements AuthorService{

    private final AuthorDao authorDao;
    private final AuthorConverter authorConverter;

    @Override
    @HystrixCommand(fallbackMethod = "getAuthorsFallback")
    public List<AuthorDto> getAllAuthore() throws AuthorNotFoundException {
        return authorDao.findAll().stream().map(authorConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    public List<AuthorDto> getAuthorsFallback() {
        log.error("Fallback method for `getAllAuthors`");
        List<AuthorDto> fallbackResult = new ArrayList<>();
        fallbackResult.add(new AuthorDto(1L, "unknown"));
        return fallbackResult;
    }



}
