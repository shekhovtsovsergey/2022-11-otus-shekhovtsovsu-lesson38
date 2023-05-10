package ru.otus.lesson38.converter;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.lesson38.dto.BookDto;
import ru.otus.lesson38.model.Book;

@Component
@RequiredArgsConstructor
public class BookConverter {

    public BookDto entityToDto(Book book) {
        return new BookDto(book.getId(), book.getName(),book.getAuthor().getId(),book.getGenre().getId());
    }

}
