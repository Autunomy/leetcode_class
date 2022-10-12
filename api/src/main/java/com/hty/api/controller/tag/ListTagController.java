package com.hty.api.controller.tag;

import com.alibaba.fastjson.JSONObject;
import com.hty.api.service.tag.ListTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListTagController {
    @Autowired
    private ListTagService listTagService;

    @GetMapping("/tag/list")
    public JSONObject getList(){
        return listTagService.getList();
    }
}
