package com.example.webupdatedemo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.webupdatedemo.Service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;
/*
网页更新Controller
 */
@RestController
public class UpdateController {

    private HashMap<Long, String> map = new HashMap<Long, String>();

    private final UpdateService updateService;
    @Autowired
    public UpdateController(UpdateService updateService) {this.updateService = updateService;}

    @RequestMapping(value = "createOpinionRecord", method = RequestMethod.POST)
    public Object createOpinionRecord(long id, long department, long name, long object, long type, String opinionTime, String doneTime, String extension1, String extension2, String extension3) {
        String uuid = UUID.randomUUID().toString();
        map.put(id, uuid);
        JSONObject returnObject = new JSONObject();
        try {
            updateService.createOpinionRecord(uuid,id,department,name,object,type,opinionTime,doneTime,extension1,extension2,extension3);
            returnObject.put("updateStatus","success");
            return returnObject;
        } catch (Exception e){
            returnObject.put("updateStatus","failure");
            return returnObject;
        }
    }

    @RequestMapping(value = "createReviewRecord", method = RequestMethod.POST)
    public Object createReviewRecord(long department, long name, long object, long result, String reviewTime, String extension1, String extension2, String extension3) {
        String uuid = UUID.randomUUID().toString();
        JSONObject returnObject = new JSONObject();
        try {
            updateService.createReviewRecord(uuid, department, name, object, result,reviewTime, extension1,extension2,extension3);
            returnObject.put("updateStatus","success");
            return returnObject;
        } catch (Exception e) {
            returnObject.put("updateStatus","failure");
            return returnObject;
        }
    }

    @RequestMapping(value = "modifyOpinionRecord",method = RequestMethod.POST)
    public Object modifyOpinionRecord(long id, String doneTime) {
        String uuid = map.get(id);
        JSONObject returnObject = new JSONObject();
        try {
            updateService.modifyOpinionRecord(uuid,doneTime);
            returnObject.put("updateStatus","success");
            return returnObject;
        } catch (Exception e) {
            returnObject.put("updateStatus","failure");
            return returnObject;
        }
    }
}
