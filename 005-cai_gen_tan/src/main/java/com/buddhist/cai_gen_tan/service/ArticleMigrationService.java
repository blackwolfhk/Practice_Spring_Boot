package com.buddhist.cai_gen_tan.service;

import com.buddhist.cai_gen_tan.entity.BuddhistArticle;
import com.buddhist.cai_gen_tan.repository.BuddhistArticleRepository;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.IOException;

public class ArticleMigrationService {

    @Autowired
    private BuddhistArticleRepository articleRepository;

    public void migrateExcelData(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        // Assuming the data is in the first sheet of the workbook
        Sheet sheet = workbook.getSheetAt(0);

        // Iterate over rows
        for (Row row : sheet) {
            // Assuming the data starts from the second row
            if (row.getRowNum() > 0) {
                Cell idCell = row.getCell(0);
                Cell chiContentCell = row.getCell(1);
                Cell engContentCell = row.getCell(2);

                // Extract the values from cells
                Long id = (long) idCell.getNumericCellValue();
                String chiContent = chiContentCell.getStringCellValue();
                String engContent = engContentCell.getStringCellValue();

                // Create an instance of BuddhistArticle and save it to the database
                BuddhistArticle article = new BuddhistArticle(id, chiContent, engContent);
                articleRepository.save(article);
            }
        }

        // Close the workbook and input stream
        workbook.close();
        fis.close();
    }
}
