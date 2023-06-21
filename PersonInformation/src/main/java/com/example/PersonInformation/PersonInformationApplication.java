package com.example.PersonInformation;

import com.example.PersonInformation.Controllers.PersonController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@ComponentScan(basePackageClasses = PersonController.class)
@ComponentScan(value = "com.example.PersonInformation.Repositories.PersonRepository")
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class PersonInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonInformationApplication.class, args);
	}

}
