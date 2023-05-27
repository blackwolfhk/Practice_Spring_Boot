package com.buddhist.cai_gen_tan.service;

import com.buddhist.cai_gen_tan.entity.BuddhistArticle;
import com.buddhist.cai_gen_tan.repository.BuddhistArticleRepository;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

@Service
public class ArticleMigrationService {

    private final String EXCEL_FILE_PATH = "path/to/excel/file.xlsx";

    @Autowired
    private BuddhistArticleRepository articleRepository;

    public void migrateArticlesFromExcel() {
        try (Workbook workbook = WorkbookFactory.create(new FileInputStream(new File(EXCEL_FILE_PATH)))) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                BuddhistArticle article = new BuddhistArticle();

                Cell idCell = row.getCell(0);
                Cell chiContentCell = row.getCell(1);
                Cell engContentCell = row.getCell(2);

                long id = (long) idCell.getNumericCellValue();
                String chiContent = chiContentCell.getStringCellValue();
                String engContent = engContentCell.getStringCellValue();

                article.setId(id);
                article.setChiContent(chiContent);
                article.setEngContent(engContent);

                articleRepository.save(article);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
