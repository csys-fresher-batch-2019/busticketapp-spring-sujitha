package com.chainsys.busticketapp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
@ServletComponentScan("com.chainsys.busticketapp.servlet")
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
