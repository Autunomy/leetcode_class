package com.hty.api.controller.content;

import com.alibaba.fastjson.JSONObject;
import com.hty.api.service.content.GetContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetContentController {
    @Autowired
    private GetContentService getContentService;

    @GetMapping("/content/list")
    public JSONObject getList(Integer problemId){
        return getContentService.getContent(problemId);
    }
}
