package com.example.webupdatedemo.Service;
/*
网页更新接口
 */
public interface UpdateService {
    public void createOpinionRecord(String uuid, long id, long department, long name, long object, long type,
                                    String opinionTime, String doneTime,
                                    String extension1, String extension2, String extension3) throws Exception;

    public void createReviewRecord(String uuid, long department, long name, long object, long result,
                                   String reviewTime, String extension1, String extension2,
                                   String extension3) throws Exception;

    public void modifyOpinionRecord(String uuid, String doneTime) throws Exception;
}
