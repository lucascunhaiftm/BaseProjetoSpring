package br.edu.iftm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) 
public class AppBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppBaseApplication.class, args);
		System.out.println("Teste");
	}

}
