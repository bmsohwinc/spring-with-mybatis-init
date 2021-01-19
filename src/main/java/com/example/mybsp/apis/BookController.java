package com.example.mybsp.apis;

import com.example.mybsp.domainpojos.Book;
import com.example.mybsp.mybatismappers.BookMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookMapper bookMapper;

    public BookController(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @GetMapping("/allbooks")
    public List<Book> getAllBooks() {
        return bookMapper.findAll();
    }

    @GetMapping("/getonebook/{id}")
    public Book getBookById(@PathVariable(value = "id") Long id) {
        return bookMapper.findById(id);
    }

    @GetMapping("/addbook")
    public List<Book> insertNewBook(@RequestParam String name, @RequestParam String authorName) {
        int newId = bookMapper.getMaxId() + 1;
        bookMapper.insertOne(newId, name, authorName);
        return bookMapper.findAll();
    }

    @GetMapping("/updatebookauthor/{id}")
    public List<Book> updateBookAuthor(@PathVariable(value = "id") Long id, String theValue) {
        bookMapper.updateBookAuthor(id, theValue);
        return bookMapper.findAll();
    }
}
