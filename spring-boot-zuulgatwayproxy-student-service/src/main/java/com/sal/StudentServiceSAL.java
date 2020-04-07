package com.sal;

import com.dal.StudentServiceDAL2;
import com.model.Student;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceSAL {

    public List<HttpEntity<String>> getStudentBooksService(String studentId) {
//        final String uri = "http://localhost:9001/book/";

        StudentServiceDAL2 ssd=new StudentServiceDAL2();
        List booksList=ssd.getStudentBookDetails(studentId);
        System.out.println("bookList----"+booksList);
        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(uri, String.class);
//        System.out.println("result----"+result);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        Map<String, String> params = new HashMap<String, String>();
//        params.put("msisdn", msisdn);
//        params.put("email", email);
//        params.put("clientVersion", clientVersion);
//        params.put("clientType", clientType);
//        params.put("issuerName", issuerName);
//        params.put("applicationName", applicationName);

        HttpEntity entity = new HttpEntity(headers);
        List<HttpEntity<String>> listOfBooks=new ArrayList<HttpEntity<String>>();

        //HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, params);
        for(int i=0;i<booksList.size();i++) {
            System.out.println("booksList---"+booksList.get(i));
            HttpEntity<String> book = restTemplate.exchange("http://localhost:9001/book/{id}",
                    HttpMethod.GET,
                    entity,
                    String.class,
                    booksList.get(i)
            );
            listOfBooks.add(book);
        }
        return listOfBooks;
    }

//    public static void getBooks(){
//
////        final String uri = "http://localhost:9001/book/page?pageSize=10&pageNum=1";
////
//        RestTemplate restTemplate = new RestTemplate();
////        String result = restTemplate.getForObject(uri, String.class);
////        System.out.println("result----"+result);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", "application/json");
//
//        Map<String, String> params = new HashMap<String, String>();
////        params.put("msisdn", msisdn);
////        params.put("email", email);
////        params.put("clientVersion", clientVersion);
////        params.put("clientType", clientType);
////        params.put("issuerName", issuerName);
////        params.put("applicationName", applicationName);
//
//        HttpEntity entity = new HttpEntity(headers);
//
//        //HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, params);
//        HttpEntity<String> result=restTemplate.exchange("http://localhost:9001/book/{1}",
//                HttpMethod.GET,
//                entity,
//                String.class,
//                1
//        );
//
//        System.out.println(result);
////        Quote quote = restTemplate.getForObject(
////                "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//    }
//
//    public static void main(String[] args) {
//        getBooks();
//    }
}
