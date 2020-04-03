package com.model;
import java.net.UnknownHostException;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.studentservice.Student;

public class DatabaseSequence {

    public static void main(String[] args) throws UnknownHostException {

        Student user = createStudent();
        DBObject doc = createDBObject(user);

        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("test");

        DBCollection col = db.getCollection("student");

        //create user
        WriteResult result = col.insert(doc);
        System.out.println(result.getUpsertedId());
        System.out.println(result.getN());
        System.out.println(result.isUpdateOfExisting());
        System.out.println(result.getLastConcern());

        //read example
//        DBObject query = BasicDBObjectBuilder.start().add("_id", user.getId()).get();
//        DBCursor cursor = col.find(query);
        DBCursor cursor = col.find();

        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }

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
        mongo.close();
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

    private static Student createStudent() {
        Student student = new Student(7, "Susmita", "30", "West Bengal","BCA");
        return student;
    }



}