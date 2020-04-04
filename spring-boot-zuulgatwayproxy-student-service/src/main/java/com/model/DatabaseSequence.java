package com.model;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mongodb.*;
import com.studentservice.Student;

public class DatabaseSequence {

    public DBCollection getCollection() {
        DBCollection col=null;
        try {
            MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("test");
            col = db.getCollection("student");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return col;
    }

    public static void main(String[] args) throws UnknownHostException {

        Student user = createUser();
        DBObject doc = createDBObject(user);



        //create user
//        WriteResult result = col.insert(doc);
//        System.out.println(result.getUpsertedId());
//        System.out.println(result.getN());
//        System.out.println(result.isUpdateOfExisting());
//        System.out.println(result.getLastConcern());



        //update example
//        user.setName("Pankaj Kumar");
//        doc = createDBObject(user);
//        result = col.update(query, doc);
//        System.out.println(result.getUpsertedId());
//        System.out.println(result.getN());
//        System.out.println(result.isUpdateOfExisting());
//        System.out.println(result.getLastConcern());
//
//        //delete example
//        result = col.remove(query);
//        System.out.println(result.getUpsertedId());
//        System.out.println(result.getN());
//        System.out.println(result.isUpdateOfExisting());
//        System.out.println(result.getLastConcern());

        //close resources
        //mongo.close();
    }

    private static DBObject createDBObject(Student student) {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();

        docBuilder.append("id", student.getId());
        docBuilder.append("name", student.getName());
        docBuilder.append("age", student.getAge());
        docBuilder.append("address", student.getAddress());
        docBuilder.append("course", student.getCourse());
        return docBuilder.get();
    }

    private static Student createUser() {
        Student student = new Student(7, "Susmita", "30", "West Bengal","BCA");
        return student;
    }


    //read example
//        DBObject query = BasicDBObjectBuilder.start().add("_id", user.getId()).get();
//        DBCursor cursor = col.find(query);
    public List<Student> getStudents() {
        DBCursor cursor = getCollection().find();
        List<Student> students = new ArrayList<Student>();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
            Student student=new Student();
            student.setId((int)(cursor.next().get("id")));
            student.setName((String) cursor.next().get("Name"));
            student.setAge((String) cursor.next().get("age"));
            student.setAddress((String) cursor.next().get("address"));
            student.setCourse((String) cursor.next().get("course"));
            students.add(student);
            System.out.println("students list---"+students);
        }


        return students;
    }

    public void createStudent() {
        Student user = createUser();
        DBObject doc = createDBObject(user);

        WriteResult result = getCollection().insert(doc);
        System.out.println(result.getUpsertedId());
        System.out.println(result.getN());
        System.out.println(result.isUpdateOfExisting());
        System.out.println(result.getLastConcern());

    }


}