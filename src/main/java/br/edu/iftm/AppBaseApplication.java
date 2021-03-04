package br.edu.iftm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppBaseApplication.class, args);
		System.out.println("Testesa");
	}

}
