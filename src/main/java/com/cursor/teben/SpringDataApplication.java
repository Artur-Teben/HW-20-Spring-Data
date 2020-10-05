package com.cursor.teben;

import com.cursor.teben.executor.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringDataApplication implements ApplicationRunner {

    private final Executor executor;

    @Autowired
    public SpringDataApplication(Executor executor) {
        this.executor = executor;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        executor.runApplication();
    }
}
