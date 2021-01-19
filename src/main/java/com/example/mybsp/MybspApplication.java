package com.example.mybsp;

import com.example.mybsp.domainpojos.Book;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(Book.class)
@MapperScan("com.example.mybsp.mybatismappers")
@SpringBootApplication
public class MybspApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybspApplication.class, args);
	}

}
