package com.proshomon.elasticsearch.nokkhotroelastic.proshomon;

import com.proshomon.elasticsearch.nokkhotroelastic.model.proshomon.Medicines;
import com.proshomon.elasticsearch.nokkhotroelastic.repository.proshomon.MedicinesRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Ignore;
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
public class InsertMedicinesTest {

    @Autowired
    MedicinesRepository medicinesRepository;

    public static final String XLSX_FILE_PATH = "./drug_recipe_comp_1556793490.xlsx";

    @Test
    @Ignore
    public void readWriteFromExcel() throws Exception {

        FileInputStream file = new FileInputStream(new File(XLSX_FILE_PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row;
        for(int i=1; i<=sheet.getLastRowNum(); i++){
            row = sheet.getRow(i);

            String id;
            if(row.getCell(0)==null){id = "0";}
            else id = row.getCell(0).toString();

            String manufacturerName;
            if(row.getCell(1)==null) manufacturerName="null";
            else manufacturerName = row.getCell(1).toString();

            String brand;
            if(row.getCell(2)==null) brand="null";
            else brand = row.getCell(2).toString();

            String genericName;
            if(row.getCell(3)==null) genericName="null";
            else genericName = row.getCell(3).toString();

            String strength;
            if(row.getCell(4)==null) strength="null";
            else strength = row.getCell(4).toString();


            String medicineType;
            if(row.getCell(5)==null) medicineType="null";
            else medicineType = row.getCell(5).toString();

            String mrp;
            if(row.getCell(6)==null) mrp="null";
            else mrp = row.getCell(6).toString();

            try {
                Medicines medicines = new Medicines();
                medicines.setId(id);
                medicines.setManufacturer(manufacturerName);
                medicines.setBrand(brand);
                medicines.setGenericName(genericName);
                medicines.setStrength(strength);
                medicines.setMedicineType(medicineType);
                medicines.setMrp(mrp);
                medicinesRepository.add(medicines);
            } catch (Exception e){
                log.error("Inserting Data Failed: {}", e);
            }
        }
    }

}
