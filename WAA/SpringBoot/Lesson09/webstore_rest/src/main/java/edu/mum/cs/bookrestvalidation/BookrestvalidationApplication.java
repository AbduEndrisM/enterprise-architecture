package edu.mum.cs.bookrestvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.packt.webstore")
public class BookrestvalidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookrestvalidationApplication.class, args);
    }

}
