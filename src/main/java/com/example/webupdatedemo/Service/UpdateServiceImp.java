package com.example.webupdatedemo.Service;

import ThriftClient.ThriftClientApplication;
import ThriftClient.service.ThriftUpdateService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
/*
网页更新实现
 */
@Service
public class UpdateServiceImp implements UpdateService{
    private final ThriftUpdateService serviceProvider;
    public UpdateServiceImp() throws Exception{
        serviceProvider = ThriftClientApplication.getService();
    }

    @Override
    public void createOpinionRecord(String uuid, long id, long department, long name, long object, long type, String opinionTime, String doneTime, String extension1, String extension2, String extension3) throws Exception {
        serviceProvider.createOpinionRecord(uuid, id, department, name, object, type, opinionTime, doneTime, extension1, extension2, extension3);
    }

    @Override
    public void createReviewRecord(String uuid, long department, long name, long object, long result, String reviewTime, String extension1, String extension2, String extension3) throws Exception {
        serviceProvider.createReviewRecord(uuid, department, name, object, result, reviewTime, extension1, extension2, extension3);
    }

    @Override
    public void modifyOpinionRecord(String uuid, String doneTime) throws Exception {
        serviceProvider.modifyOpinionRecord(uuid, doneTime);
    }
}
