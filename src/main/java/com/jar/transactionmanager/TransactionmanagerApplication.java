package com.jar.transactionmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class TransactionmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionmanagerApplication.class, args);
	}

}
