package com.service;

import com.dal.BookServiceDAL;
import com.model.Book;
import java.util.List;

public class BookService {

    public List<Book> getBooksService(int pageSize, int pageNum) {
        BookServiceDAL bsd=new BookServiceDAL();
        return bsd.getBooks(pageSize,pageNum);
    }

    public void postBookService(Book book) {
        BookServiceDAL bsd=new BookServiceDAL();
        bsd.insertBooks(book);
    }

    public List<Book> getBookDetailsByIdService(String bookId) {
        BookServiceDAL bsd=new BookServiceDAL();
        return bsd.getBooksById(bookId);
    }
}
