package com.DAL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;

@Configuration
@EnableMongoRepositories(basePackages = "com.DAL")
public class MongoDBConfig {
    public String getDatabaseName() {
        return "test";
    }
    @Bean
    public MongoClient mongoClient() throws UnknownHostException {
        ServerAddress address = new ServerAddress("127.0.0.1", 27017);
        //MongoCredential credential = MongoCredential.createCredential("mdbUser", getDatabaseName(), "cp".toCharArray());
//        MongoClientOptions options = new MongoClientOptions.Builder().build();

        MongoClient client = new MongoClient(address);
        return client;
    }
    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        MongoDbFactory factory = new SimpleMongoDbFactory(mongoClient(), getDatabaseName());
        return factory;
    }
    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        MongoTemplate template = new MongoTemplate(mongoDbFactory());
        return template;
    }
}