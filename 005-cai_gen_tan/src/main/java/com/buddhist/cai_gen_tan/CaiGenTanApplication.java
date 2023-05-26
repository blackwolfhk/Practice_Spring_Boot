package com.buddhist.cai_gen_tan;

import com.buddhist.cai_gen_tan.service.ArticleMigrationService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class CaiGenTanApplication {

	@Autowired
	private ArticleMigrationService articleMigrationService;

	public static void main(String[] args){
		SpringApplication.run(CaiGenTanApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// Trigger the migration process
		String filePath = "path/to/your/excel/file.xlsx";
		articleMigrationService.migrateExcelData(filePath);

		// Other application logic...
	}

//	@Autowired
//	private DataSource dataSource;

//	@PostConstruct
//	public void testDatabaseConnection(){
//		try(var connection = dataSource.getConnection()){
//			System.out.println("Connected to the database successfully!");
//		} catch (Exception e){
//			System.out.println("Failed to connect to the database: " + e.getMessage());
//		}
//	}


//	public static void main(String[] args) {
//		SpringApplication.run(CaiGenTanApplication.class, args);
//	}

}
