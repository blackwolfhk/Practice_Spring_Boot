package com.buddhist.cai_gen_tan.service;

import com.buddhist.cai_gen_tan.entity.BuddhistArticle;
import com.buddhist.cai_gen_tan.repository.BuddhistArticleRepository;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ArticleMigrationService {

    @Autowired
    private BuddhistArticleRepository articleRepository;

    public void performMigration(String excelFilePath) {
        try {
            FileInputStream file = new FileInputStream(excelFilePath);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

            List<BuddhistArticle> articleList = new ArrayList<>();

            Iterator<Row> rowIterator = sheet.iterator();
            // Skip the header row
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                BuddhistArticle article = new BuddhistArticle();
                article.setId((long) row.getCell(0).getNumericCellValue());
                article.setChiContent(row.getCell(1).getStringCellValue());
                article.setEngContent(row.getCell(2).getStringCellValue());

                articleList.add(article);
            }

            file.close();

            articleRepository.saveAll(articleList);
        } catch (IOException e) {
            // Handle any exceptions that occur during file reading or database saving
            e.printStackTrace();
        }
    }
}
