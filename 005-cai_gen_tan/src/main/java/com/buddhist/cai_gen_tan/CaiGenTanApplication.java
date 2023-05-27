package com.buddhist.cai_gen_tan;

import com.buddhist.cai_gen_tan.service.ArticleMigrationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class CaiGenTanApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CaiGenTanApplication.class, args);

		// Get an instance of ArticleMigrationService from the application context
		ArticleMigrationService migrationService = context.getBean(ArticleMigrationService.class);

		// Specify the path to your Excel file
		String excelFilePath = new ClassPathResource("data/fo_guang_cai_gen_tan.xlsx").getPath();

		// Perform the migration
		migrationService.performMigration(excelFilePath);
	}
}
