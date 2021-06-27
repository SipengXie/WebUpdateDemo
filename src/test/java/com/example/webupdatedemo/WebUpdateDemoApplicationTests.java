package com.example.webupdatedemo;

import com.example.webupdatedemo.Service.UpdateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import jxl.*;
import java.io.File;
import java.util.UUID;

@SpringBootTest
class WebUpdateDemoApplicationTests {

    private final UpdateService updateService;
    @Autowired
    public WebUpdateDemoApplicationTests(UpdateService updateService){
        this.updateService = updateService;
    }

    void functionalTest() {
        int i, st=1, ed = 300;
        String uuid;
        Sheet sheet;
        Workbook workbook;
        Cell opID,object, type, name, department, opinionTime, reviewerName, reviewDepartment, reviewTime, reviewResult;
        try {
            workbook = Workbook.getWorkbook(new File("D:\\newDevelopment\\审批记录.xls"));
            sheet = workbook.getSheet(0);
            for (i = st ; i <= ed ; ++i) {
                System.out.println("Processing No."+i+" record.");
                opID = sheet.getCell(0,i);
                object = sheet.getCell(1,i);
                type = sheet.getCell(2,i);
                name = sheet.getCell(3,i);
                department = sheet.getCell(4,i);
                opinionTime = sheet.getCell(5,i);

                reviewerName = sheet.getCell(6,i);
                reviewDepartment = sheet.getCell(7,i);
                reviewTime = sheet.getCell(8,i);
                reviewResult = sheet.getCell(9,i);

                uuid = UUID.randomUUID().toString();

                updateService.createOpinionRecord(uuid,
                        Long.parseLong(opID.getContents()),
                        Long.parseLong(department.getContents()),
                        Long.parseLong(name.getContents()),
                        Long.parseLong(object.getContents()),
                        Long.parseLong(type.getContents()),
                        opinionTime.getContents(),
                        reviewTime.getContents(),
                        "","","");


                uuid = UUID.randomUUID().toString();
                updateService.createReviewRecord(uuid,
                        Long.parseLong(reviewDepartment.getContents()),
                        Long.parseLong(reviewerName.getContents()),
                        Long.parseLong(opID.getContents()),
                        Long.parseLong(reviewResult.getContents()),
                        reviewTime.getContents(),
                        "","","");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void contextLoads() {
        functionalTest();
    }
}
