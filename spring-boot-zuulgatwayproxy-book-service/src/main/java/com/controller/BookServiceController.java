package com.controller;

//import com.DAL.StudentServiceDAL;

import com.model.Book;
import com.service.BookService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookServiceController {

    @GetMapping(value = "/page")
    public List getBookDetailsByPageSize(@RequestParam int pageSize,@RequestParam int pageNum) {
        BookService bs=new BookService();
        return bs.getBooksService(pageSize, pageNum);
    }

    @PostMapping(value = "/")
    public void postBookDetails(@RequestBody Book book) {
        BookService ss=new BookService();
        ss.postBookService(book);
    }

    @GetMapping(value = "/{id}")
    public List getBookDetailsById(@PathVariable(name = "id") String bookId) {
        BookService bs=new BookService();
        List list=bs.getBookDetailsByIdService(bookId);
        return list;
    }

}

