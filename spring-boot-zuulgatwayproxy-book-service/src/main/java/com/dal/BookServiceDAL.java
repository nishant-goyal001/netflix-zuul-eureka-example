package com.dal;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.model.Book;
import com.mongodb.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class BookServiceDAL {

    public List<Book> getBooks(int pageSize, int pageNum) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoDBConfig.class);
        ctx.refresh();
        MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);

        Query query = new Query();
//        query.addCriteria(Criteria.where("age").is(24));
        if (pageSize > 0) {
            query.skip((pageNum - 1) * pageSize);
            query.limit(pageSize);
        }

        List<Book> list = mongoTemplate.find(query, Book.class, "book");
//        List<Student> list = mongoTemplate.findAll(Student.class, "student2");

        ctx.registerShutdownHook();
        ctx.close();
        return list;
    }

    public void insertBooks(Book book) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoDBConfig.class);
        ctx.refresh();
        MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);


        mongoTemplate.insert(book, "book");

        ctx.registerShutdownHook();
        ctx.close();
    }

    public List<Book> getBooksById(String bookId) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoDBConfig.class);
        ctx.refresh();
        MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);

        Query query = new Query();
        query.addCriteria(Criteria.where("bookId").is(bookId));

//        List<Book> list = mongoTemplate.find(query, Book.class, "book");
        List<Book> list = mongoTemplate.find(query,Book.class, "book");
        ctx.registerShutdownHook();
        ctx.close();
        return list;
    }

}