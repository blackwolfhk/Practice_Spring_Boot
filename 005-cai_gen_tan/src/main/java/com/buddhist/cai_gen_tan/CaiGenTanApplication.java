package com.buddhist.cai_gen_tan;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class CaiGenTanApplication {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	public void testDatabaseConnection(){
		try(var connection = dataSource.getConnection()){
			System.out.println("Connected to the database successfully!");
		} catch (Exception e){
			System.out.println("Failed to connect to the database: " + e.getMessage());
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(CaiGenTanApplication.class, args);
	}

}
