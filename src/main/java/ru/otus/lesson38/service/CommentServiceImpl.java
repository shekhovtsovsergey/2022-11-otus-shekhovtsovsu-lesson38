package ru.otus.lesson38.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.lesson38.converter.CommentConverter;
import ru.otus.lesson38.dao.BookDao;
import ru.otus.lesson38.dto.CommentDto;
import ru.otus.lesson38.exception.BookNotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService{

    private final BookDao bookDao;
    private final CommentConverter commentConverter;

    @Override
    @Transactional
    @HystrixCommand(fallbackMethod = "getAllCommentsByBookFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
    })
    public List<CommentDto> getAllCommentsByBook(Long id) throws BookNotFoundException {
        return bookDao.findById(id).orElseThrow(() -> new BookNotFoundException(id)).getComments().stream().map(commentConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> getAllCommentsByBookFallback(Long id) {
        log.error("Error during getAllCommentsByBook for book id: {}", id);
        return Collections.emptyList();
    }
}
