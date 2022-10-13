package com.hty.api.controller.content;

import com.alibaba.fastjson.JSONObject;
import com.hty.api.service.content.ShowContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowContentController {
    @Autowired
    private ShowContentService showContentService;

    @GetMapping("/content/show")
    public JSONObject showContent(Integer contentId){
        return showContentService.showContent(contentId);
    }
}
