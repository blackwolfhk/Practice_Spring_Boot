package com.buddhist.cai_gen_tan;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class CaiGenTanApplication {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	public void testDatabaseConnection() {
		try (Connection connection = dataSource.getConnection()) {
			System.out.println("Connected to the database successfully!");
		} catch (SQLException e) {
			System.out.println("Failed to connect to the database: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(CaiGenTanApplication.class, args);
	}
}
