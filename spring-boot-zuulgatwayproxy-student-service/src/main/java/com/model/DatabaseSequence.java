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
            Student student=new Student();
            System.out.println(cursor.curr());
            double id= (double) cursor.next().get("id");
            student.setId((int)id);
            student.setName((String) cursor.curr().get("name"));
            String age=cursor.curr().get("age").toString();
            student.setAge(age);
            student.setAddress((String) cursor.curr().get("address"));
            student.setCourse((String) cursor.curr().get("course"));
            students.add(student);
        }
        return students;
    }

    public Student getStudent(int id) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("id", id);
        DBCursor cursor = getCollection().find(whereQuery);

        Student student=new Student();
        while(cursor.hasNext()) {
            //System.out.println("Next cursor-----"+cursor.next());
            double studentId= (double) cursor.next().get("id");
            student.setId((int)studentId);
            student.setName((String) cursor.curr().get("name"));
            String age=cursor.curr().get("age").toString();
            student.setAge(age);
            student.setAddress((String) cursor.curr().get("address"));
            student.setCourse((String) cursor.curr().get("course"));
        }
        System.out.println("student-----"+student.toString());
        return student;
    }

    public Student getStudent(String name) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("name", name);
        DBCursor cursor = getCollection().find(whereQuery);

        Student student=new Student();
        while(cursor.hasNext()) {
//            System.out.println("Next cursor-----"+cursor.next());
            double studentId= (double) cursor.next().get("id");
            student.setId((int)studentId);
            student.setName((String) cursor.curr().get("name"));
            String age=cursor.curr().get("age").toString();
            student.setAge(age);
            student.setAddress((String) cursor.curr().get("address"));
            student.setCourse((String) cursor.curr().get("course"));
        }
        System.out.println("student-----"+student.toString());
        return student;
    }

    public void deleteStudent(int id) {
        //checking color working in terminal for git
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("id", id);
        getCollection().remove(whereQuery);

//        Student student=new Student();
//        while(cursor.hasNext()) {
//            //System.out.println("Next cursor-----"+cursor.next());
//            double studentId= (double) cursor.next().get("id");
//            student.setId((int)studentId);
//            student.setName((String) cursor.curr().get("name"));
//            String age=cursor.curr().get("age").toString();
//            student.setAge(age);
//            student.setAddress((String) cursor.curr().get("address"));
//            student.setCourse((String) cursor.curr().get("course"));
//        }
//        System.out.println("student-----"+student.toString());
//        return student;
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