package com.dal;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.mongodb.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class StudentServiceDAL2 {

    public void insertStudents(Student student) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoDBConfig.class);
        ctx.refresh();
        MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);


        mongoTemplate.insert(student, "student");

        ctx.registerShutdownHook();
        ctx.close();
    }

    public List<Student> getStudents(int pageSize, int pageNum) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoDBConfig.class);
        ctx.refresh();
        MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);

        Query query = new Query();
////        query.addCriteria(Criteria.where("age").is(24));
        if (pageSize > 0) {
            query.skip((pageNum - 1 ) * pageSize);
            query.limit(pageSize);
        }

        List<Student> list = mongoTemplate.find(query, Student.class, "student");
//        List<Student> list = mongoTemplate.findAll(Student.class, "student");

        ctx.registerShutdownHook();
        ctx.close();
        return list;
    }

    public List<Student> getStudentById(String studentId) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoDBConfig.class);
        ctx.refresh();
        MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);

        Query query = new Query();
        query.addCriteria(Criteria.where("studentId").is(studentId));
        List<Student> list = mongoTemplate.find(query, Student.class, "student");
//        List<Student> list = mongoTemplate.findAll(Student.class, "student");

        ctx.registerShutdownHook();
        ctx.close();
        return list;
    }

    public List<Student> getStudentByName(String name) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoDBConfig.class);
        ctx.refresh();
        MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);

        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        List<Student> list = mongoTemplate.find(query, Student.class, "student");

        ctx.registerShutdownHook();
        ctx.close();
        return list;
    }

    public void deleteStudent(int studentId) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoDBConfig.class);
        ctx.refresh();
        MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);

        Query query = new Query();
        query.addCriteria(Criteria.where("studentId").is(studentId));
        mongoTemplate.remove(query, Student.class, "student2");

        ctx.registerShutdownHook();
        ctx.close();
    }

    public void updateStudent(Student student) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoDBConfig.class);
        ctx.refresh();
        MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);

        Query query = new Query();
        query.addCriteria(Criteria.where("studentId").is(student.getStudentId()));
        Update update = new Update();
        update.set("studentId", student.getStudentId());
        update.set("name", student.getName());
        update.set("age", student.getAge());
        update.set("address", student.getAddress());
        update.set("course", student.getCourse());
        mongoTemplate.updateFirst(query, update, Student.class,"student2");
    }

    public List<Student> getStudentBetweenAges(int ageStart,int ageEnd) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoDBConfig.class);
        ctx.refresh();
        MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);

        Query query = new Query();
        query.addCriteria(Criteria.where("age").gt(ageStart).andOperator(Criteria.where("age").lt(ageEnd)));
        List<Student> list = mongoTemplate.find(query, Student.class, "student2");

        ctx.registerShutdownHook();
        ctx.close();
        return list;
    }

    public List getStudentBookDetails(String studentId) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MongoDBConfig.class);
        ctx.refresh();
        MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);

        Query query = new Query();
        query.addCriteria(Criteria.where("studentId").is(studentId));
        List<Student> list = mongoTemplate.find(query, Student.class, "student");
//        List<Student> list = mongoTemplate.findAll(Student.class, "student");
        Student std=list.get(0);
        List booksList=std.getBooks();
        ctx.registerShutdownHook();
        ctx.close();
        return booksList;
    }


}