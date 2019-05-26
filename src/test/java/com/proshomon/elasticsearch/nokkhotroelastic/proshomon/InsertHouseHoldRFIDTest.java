package com.proshomon.elasticsearch.nokkhotroelastic.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.repository.HouseholdRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class InsertHouseHoldRFIDTest {

    @Autowired
    HouseholdRepository householdRepository;

    public static final String XLSX_FILE_PATH = "./190521 Final_HH_Data_Sheet-Uppercase 内码.xlsx";

    @Test
    public void readWriteFromExcel() throws Exception {

        FileInputStream file = new FileInputStream(new File(XLSX_FILE_PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.createRow(0);
        for(int i=1; i<=sheet.getLastRowNum(); i++){
            row = sheet.getRow(i);

            String id;
            if(row.getCell(0)==null){id = "0";}
            else {
                id = row.getCell(0).toString();
            }

            String cardNo;
            Cell cNo = row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (cNo != null) {
                cNo.setCellType(CellType.STRING);
                cardNo = "0" + cNo.getStringCellValue();
            }
            else {
                cardNo = null;
            }

            try {
                householdRepository.update(cardNo, id);
            } catch (Exception e){
                log.error("Inserting Data Failed: {}", e);
            }
        }
    }
}
